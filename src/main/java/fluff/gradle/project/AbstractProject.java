package fluff.gradle.project;

import org.gradle.api.Project;

import fluff.gradle.FluffBase;
import fluff.gradle.FluffGradle;

public abstract class AbstractProject extends FluffBase {
	
	protected abstract void onInit();
	
	protected void onPreInit(Project p) {}
	
	protected void onPostInit() {}
	
	@Override
	protected void init(FluffGradle fluff) {
		super.init(fluff);
		
		onInit();
	}
}
