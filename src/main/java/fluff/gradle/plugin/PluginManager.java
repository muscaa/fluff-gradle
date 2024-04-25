package fluff.gradle.plugin;

import java.util.ArrayList;
import java.util.List;

import fluff.gradle.AbstractManager;
import fluff.gradle.plugin.impl.mavenpublish.MavenPublishTypes;
import fluff.gradle.plugin.impl.mavenpublish.PluginMavenPublish;

public class PluginManager extends AbstractManager {
	
	private final List<AbstractPlugin> loaded = new ArrayList<>();
	
	@Override
	protected void onInit() {
		if (fluff.properties.plugin_publish != null) load(new PluginMavenPublish(MavenPublishTypes.get(fluff.properties.plugin_publish)));
	}
	
	public void load(AbstractPlugin plugin) {
		fluff.init(plugin);
		
		loaded.add(plugin);
	}
	
	public List<AbstractPlugin> getLoaded() {
		return loaded;
	}
}
