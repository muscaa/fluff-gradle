package fluff.gradle.extension.impl;

import org.gradle.api.provider.ListProperty;

public abstract class ExtensionFluff {
	
	public abstract ListProperty<String> getInclude();
}
