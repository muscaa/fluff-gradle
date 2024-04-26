package fluff.gradle.project.application;

import org.gradle.api.plugins.ExtensionAware;
import org.gradle.api.provider.Property;

public abstract class ExtensionApplication implements ExtensionAware {
	
	public abstract Property<String> getMainClass();
}
