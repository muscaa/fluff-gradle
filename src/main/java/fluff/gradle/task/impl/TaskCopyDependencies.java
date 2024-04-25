package fluff.gradle.task.impl;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.Console;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;

public abstract class TaskCopyDependencies extends DefaultTask {
	
	@Console
	public abstract String getTo();
	
	@Option(option = "to", description = "Destination directory")
	public abstract void setTo(String to);
	
	@TaskAction
	public void onAction() {
		if (getTo() == null) throw new IllegalStateException("Destination not specified!");
		
		Project p = getProject();
		
		p.copy(copy -> {
			copy.from(p.getConfigurations().getByName("runtimeClasspath"));
			copy.into(getTo());
		});
	}
}
