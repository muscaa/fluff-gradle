package fluff.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import fluff.gradle.configuration.ConfigurationManager;
import fluff.gradle.dependency.DependencyManager;
import fluff.gradle.extension.ExtensionManager;
import fluff.gradle.task.TaskManager;

public class FluffGradle implements Plugin<Project> {
	
	public final ExtensionManager extensions = new ExtensionManager();
	public final ConfigurationManager configurations = new ConfigurationManager();
	public final DependencyManager dependencies = new DependencyManager();
	public final TaskManager tasks = new TaskManager();
	
	public Project project;
	
	@Override
	public void apply(Project project) {
		this.project = project;
		
		extensions.init(this);
		configurations.init(this);
		dependencies.init(this);
		tasks.init(this);
		
		project.beforeEvaluate(p -> ProjectEvaluation.before(this, p));
		project.afterEvaluate(p -> ProjectEvaluation.after(this, p));
	}
	
	public static FluffGradle get(Project project) {
		return project.getPlugins().getPlugin(FluffGradle.class);
	}
}
