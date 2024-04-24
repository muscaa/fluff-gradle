package fluff.gradle.plugin;

import fluff.gradle.AbstractManager;

public class PluginManager extends AbstractManager {
	
	@Override
	protected void onInit() {
		if (fluff.properties.publish) Plugins.addMavenPublish(project);
		if (fluff.properties.source) Plugins.includeSources(project);
	}
}
