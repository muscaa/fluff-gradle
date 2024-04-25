package fluff.gradle.project.application;

import org.gradle.api.provider.Property;

import fluff.gradle.extension.impl.ExtensionMain;

public abstract class ExtensionApplication extends ExtensionMain {
	
	public abstract Property<String> getMainClass();
}
