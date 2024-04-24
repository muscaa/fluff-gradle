package fluff.gradle;

import org.gradle.api.Project;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.artifacts.dsl.RepositoryHandler;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.tasks.TaskContainer;

public abstract class AbstractManager {
	
	protected FluffGradle fluff;
	protected Project project;
	
	protected PluginContainer plugins;
	protected RepositoryHandler repositories;
	protected DependencyHandler dependencies;
	protected ConfigurationContainer configurations;
	protected ExtensionContainer extensions;
	protected TaskContainer tasks;
	
	protected abstract void onInit();
	
	protected void init(FluffGradle fluff) {
		this.fluff = fluff;
		this.project = fluff.gradleProject;
		
		this.plugins = project.getPlugins();
		this.repositories = project.getRepositories();
		this.dependencies = project.getDependencies();
		this.configurations = project.getConfigurations();
		this.extensions = project.getExtensions();
		this.tasks = project.getTasks();
		
		onInit();
	}
}
