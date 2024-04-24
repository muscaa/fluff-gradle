package fluff.gradle.task;

import fluff.gradle.AbstractManager;
import fluff.gradle.task.tasks.TaskInfo;

public class TaskManager extends AbstractManager {
	
	@Override
	protected void onInit() {
		tasks.register("info", TaskInfo.class);
	}
}