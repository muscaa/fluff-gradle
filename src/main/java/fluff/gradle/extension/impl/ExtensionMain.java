package fluff.gradle.extension.impl;

import org.gradle.api.Action;
import org.gradle.api.plugins.ExtensionAware;
import org.gradle.api.provider.ListProperty;

import fluff.gradle.project.application.ExtensionApplication;
import fluff.gradle.project.library.ExtensionLibrary;
import fluff.gradle.project.plugin.ExtensionPlugin;

public abstract class ExtensionMain implements ExtensionAware {
	
	public ExtensionApplication application;
	public ExtensionLibrary library;
	public ExtensionPlugin plugin;
	
	public ExtensionMain() {
		application = getExtensions().create("application", ExtensionApplication.class);
		library = getExtensions().create("library", ExtensionLibrary.class);
		plugin = getExtensions().create("plugin", ExtensionPlugin.class);
	}
	
	public abstract ListProperty<String> getInclude();
	
	public void application(Action<? super ExtensionApplication> action) {
		action.execute(application);
	}
	
	public void library(Action<? super ExtensionLibrary> action) {
		action.execute(library);
	}
	
	public void plugin(Action<? super ExtensionPlugin> action) {
		action.execute(plugin);
	}
}
