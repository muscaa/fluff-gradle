package fluff.gradle.utils;

import org.gradle.api.provider.Property;

public class PropUtils {
	
	public static <V> V optional(Property<V> prop, V value) {
		return prop.isPresent() ? prop.get() : value;
	}
	
	public static <V> V required(Property<V> prop, String propName) {
		if (!prop.isPresent()) throw new IllegalStateException(propName + " property is missing!");
		return prop.get();
	}
}
