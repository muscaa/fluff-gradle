package fluff.gradle.task.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import fluff.gradle.FluffGradle;

public class TaskInfo extends DefaultTask {
	
	@TaskAction
	public void onAction() {
		Project p = getProject();
		FluffGradle fluff = FluffGradle.get(p);
		
		System.out.println("Fluff Gradle plugin installed!");
		System.out.println("Configurations:");
		
		p.getConfigurations().forEach(c -> {
			System.out.println(c.getName());
		});
	}
}
