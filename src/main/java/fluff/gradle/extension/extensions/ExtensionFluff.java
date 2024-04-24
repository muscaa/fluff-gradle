package fluff.gradle.extension.extensions;

import java.util.List;

import org.gradle.api.provider.Property;

public abstract class ExtensionFluff {
	
	public abstract Property<List<String>> getIncludeFiles();
}
