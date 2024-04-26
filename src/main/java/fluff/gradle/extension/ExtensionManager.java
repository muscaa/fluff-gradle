package fluff.gradle.extension;

import fluff.gradle.AbstractManager;
import fluff.gradle.extension.impl.ExtensionMain;

public class ExtensionManager extends AbstractManager {
	
	public ExtensionMain main;
	
	@Override
	protected void onInit() {
		main = extensions.create("fluff", ExtensionMain.class);
	}
}
