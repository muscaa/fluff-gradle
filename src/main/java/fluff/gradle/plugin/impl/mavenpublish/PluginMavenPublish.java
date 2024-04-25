package fluff.gradle.plugin.impl.mavenpublish;

import org.gradle.api.publish.PublishingExtension;

import fluff.gradle.plugin.AbstractPlugin;

public class PluginMavenPublish extends AbstractPlugin {
	
	private final IPublishType type;
	
	public PluginMavenPublish(IPublishType type) {
		this.type = type;
	}
	
	@Override
	public void onLoad() {
		project.getPlugins().apply("maven-publish");
	}
	
	@Override
	protected void onPostLoad() {
		project.getExtensions().configure(PublishingExtension.class, publishing -> {
			type.apply(project, publishing);
    	});
	}
}
