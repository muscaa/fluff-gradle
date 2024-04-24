package fluff.gradle.task.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class TaskInfo extends DefaultTask {
	
	@TaskAction
	public void onAction() {
		System.out.println("Fluff Gradle plugin installed!");
	}
}
