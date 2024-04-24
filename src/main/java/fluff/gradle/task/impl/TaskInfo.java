package fluff.gradle.task.impl;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.TaskAction;

import fluff.gradle.FluffGradle;

public class TaskInfo extends DefaultTask {
	
	@TaskAction
	public void onAction() {
		Project p = getProject();
		FluffGradle fluff = FluffGradle.get(p);
		
		System.out.println("Fluff Gradle plugin installed!");
		System.out.println();
		
		System.out.println("Includes:");
		ListProperty<String> includeFiles = fluff.extensions.getMain().getInclude();
		if (includeFiles.isPresent()) {
			includeFiles.get().forEach(System.out::println);
		}
		System.out.println();
		
		System.out.println("Configurations:");
		p.getConfigurations().forEach(c -> {
			System.out.println(c.getName());
		});
		System.out.println();
		
		Task tasks = p.getTasks().getByName("tasks");
		System.out.println(tasks.getClass());
	}
}
