package fluff.gradle.project.library;

import fluff.gradle.project.AbstractProject;

public class ProjectLibrary extends AbstractProject {
	
	@Override
	protected void onInit() {
		plugins.apply("java-library");
		
		fluff.extensions.setMain(ExtensionLibrary.class);
	}
}
