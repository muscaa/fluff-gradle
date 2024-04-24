package fluff.gradle.project;

import org.gradle.api.Project;

import fluff.gradle.AbstractManager;

public abstract class AbstractProject extends AbstractManager {
	
	protected void onPreInit(Project p) {}
	
	protected void onPostInit() {} // after plugins have been initialised
}
