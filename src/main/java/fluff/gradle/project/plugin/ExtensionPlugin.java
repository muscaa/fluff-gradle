package fluff.gradle.project.plugin;

import org.gradle.api.plugins.ExtensionAware;
import org.gradle.api.provider.Property;

public abstract class ExtensionPlugin implements ExtensionAware {
	
	public abstract Property<String> getName();
	
	public abstract Property<String> getId();
	
	public abstract Property<String> getImplClass();
	
	public abstract Property<String> getDisplayName();
	
	public abstract Property<String> getDescription();
}
