package fluff.gradle.project.plugin;

import org.gradle.plugin.devel.GradlePluginDevelopmentExtension;

import fluff.gradle.project.AbstractProject;
import fluff.gradle.utils.PropUtils;

public class ProjectPlugin extends AbstractProject {
	
	public GradlePluginDevelopmentExtension gradlePlugin;
	
	@Override
	protected void onInit() {
		plugins.apply("java-gradle-plugin");
	}
	
	@Override
	protected void onPostInit() {
		ExtensionPlugin main = fluff.extensions.main.plugin;
		
		final String name = PropUtils.required(main.getName(), "name");
		final String id = PropUtils.required(main.getId(), "id");
		final String implClass = PropUtils.required(main.getImplClass(), "implClass");
		final String displayName = PropUtils.optional(main.getDisplayName(), null);
		final String description = PropUtils.optional(main.getDescription(), null);
		
		gradlePlugin = extensions.getByType(GradlePluginDevelopmentExtension.class);
		gradlePlugin.plugins(plugins -> {
			plugins.create(name, plugin -> {
        		plugin.setId(id);
        		plugin.setImplementationClass(implClass);
        		if (displayName != null) plugin.setDisplayName(displayName);
        		if (description != null) plugin.setDescription(description);
        	});
		});
	}
}
