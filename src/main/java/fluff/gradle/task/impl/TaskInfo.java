package fluff.gradle.task.impl;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.tasks.TaskAction;

import fluff.gradle.FluffGradle;

public abstract class TaskInfo extends DefaultTask {
	
	@TaskAction
	public void onAction() {
		Project p = getProject();
		FluffGradle fluff = FluffGradle.get(p);
		
		System.out.println("Fluff Gradle plugin installed!");
		System.out.println();
		
		System.out.println("Include:");
		MapProperty<String, String> include = fluff.extensions.main.getInclude();
		if (include.isPresent()) {
			include.get().forEach((source, dest) -> System.out.println(source + " : " + dest));
		}
		System.out.println();
	}
}
