package fluff.gradle.project;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.gradle.api.Project;

import fluff.gradle.AbstractManager;
import fluff.gradle.project.application.ProjectApplication;
import fluff.gradle.project.library.ProjectLibrary;
import fluff.gradle.utils.Utils;

public class ProjectManager extends AbstractManager {
	
	private final Map<String, Supplier<AbstractProject>> reg = new HashMap<>();
	
	private AbstractProject theProject;
	
	public ProjectManager() {
		reg.put("application", ProjectApplication::new);
		reg.put("library", ProjectLibrary::new);
	}
	
	@Override
	protected void onInit() {
		String propType = fluff.properties.type;
		if (!reg.containsKey(propType)) throw new IllegalStateException("Project type doesn't exist! Accepted values are: " + reg.keySet());
		
		theProject = reg.get(propType).get();
		fluff.init(theProject);
		
		project.beforeEvaluate(this::preInit);
		project.afterEvaluate(this::postInit);
	}
	
	private void preInit(Project p) {
		theProject.onPreInit(p);
	}
	
	private void postInit(Project p) {
		theProject.onPostInit();
		
		Utils.addIncludes(fluff, p);
		if (fluff.properties.sourcedocs) Utils.includeSourcesAndDocs(fluff, p);
	}
	
	public AbstractProject get() {
		return theProject;
	}
}
