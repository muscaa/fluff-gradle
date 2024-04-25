package fluff.gradle.plugin;

import org.gradle.api.Project;

import fluff.gradle.FluffBase;
import fluff.gradle.FluffGradle;

public abstract class AbstractPlugin extends FluffBase {
	
	public abstract void onLoad();
	
	protected void onPreLoad(Project p) {}
	
	protected void onPostLoad() {}
	
	@Override
	protected void init(FluffGradle fluff) {
		super.init(fluff);
		
		onLoad();
		
		project.beforeEvaluate(this::onPreLoad);
		project.afterEvaluate(p -> onPostLoad());
	}
}
