package fluff.gradle.extension;

import fluff.gradle.AbstractManager;
import fluff.gradle.extension.extensions.ExtensionFluff;

public class ExtensionManager extends AbstractManager {
	
	public ExtensionFluff fluff;
	
	@Override
	protected void onInit() {
		fluff = extensions.create("fluff", ExtensionFluff.class);
	}
}
