package fluff.gradle.extension;

import fluff.gradle.AbstractManager;
import fluff.gradle.extension.impl.ExtensionMain;

public class ExtensionManager extends AbstractManager {
	
	private ExtensionMain main;
	
	@Override
	protected void onInit() {
		
	}
	
	public void setMain(Class<? extends ExtensionMain> type) {
		main = extensions.create("fluff", type);
	}
	
	public <V extends ExtensionMain> V getMain() {
		return (V) main;
	}
}
