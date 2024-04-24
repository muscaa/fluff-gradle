package fluff.gradle.project.application;

import org.gradle.api.provider.Property;

import fluff.gradle.extension.impl.ExtensionFluff;

public abstract class ExtensionApplication extends ExtensionFluff {
	
	public abstract Property<String> getMainClass();
}
