package fluff.gradle.extension;

import fluff.gradle.AbstractManager;
import fluff.gradle.extension.impl.ExtensionFluff;

public class ExtensionManager extends AbstractManager {
	
	private ExtensionFluff main;
	
	@Override
	protected void onInit() {
		
	}
	
	public void setMain(Class<? extends ExtensionFluff> type) {
		main = extensions.create("fluff", type);
	}
	
	public <V extends ExtensionFluff> V getMain() {
		return (V) main;
	}
}
