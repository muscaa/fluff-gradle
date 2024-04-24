package fluff.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import fluff.gradle.configuration.ConfigurationManager;
import fluff.gradle.dependency.DependencyManager;
import fluff.gradle.extension.ExtensionManager;
import fluff.gradle.plugin.PluginManager;
import fluff.gradle.project.ProjectManager;
import fluff.gradle.property.PropertyManager;
import fluff.gradle.task.TaskManager;

public class FluffGradle implements Plugin<Project> {
	
	public final PropertyManager properties = new PropertyManager();
	public final PluginManager plugins = new PluginManager();
	public final ExtensionManager extensions = new ExtensionManager();
	public final ConfigurationManager configurations = new ConfigurationManager();
	public final DependencyManager dependencies = new DependencyManager();
	public final TaskManager tasks = new TaskManager();
	public final ProjectManager project = new ProjectManager();
	
	Project gradleProject;
	
	@Override
	public void apply(Project gradleProject) {
		this.gradleProject = gradleProject;
		
		init(properties);
		init(plugins);
		init(extensions);
		init(configurations);
		init(dependencies);
		init(tasks);
		init(project);
	}
	
	public void init(AbstractManager manager) {
		manager.init(this);
	}
	
	public static FluffGradle get(Project project) {
		return project.getPlugins().getPlugin(FluffGradle.class);
	}
}
