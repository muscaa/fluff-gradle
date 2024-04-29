package fluff.gradle.project.application;

import org.gradle.api.java.archives.Attributes;
import org.gradle.api.plugins.JavaApplication;
import org.gradle.api.tasks.bundling.Jar;

import fluff.gradle.project.AbstractProject;
import fluff.gradle.utils.PropUtils;

public class ProjectApplication extends AbstractProject {
	
	public JavaApplication javaApp;
	
	@Override
	protected void onInit() {
		plugins.apply("application");
	}
	
	@Override
	protected void onPostInit() {
		ExtensionApplication main = fluff.extensions.main.application;
		
		final String mainClass = PropUtils.required(main.getMainClass(), "mainClass");
		
		javaApp = extensions.getByType(JavaApplication.class);
		javaApp.getMainClass().set(mainClass);
		
        project.getTasks().withType(Jar.class, jar -> {
        	Attributes a = jar.getManifest().getAttributes();
            a.put("Main-Class", mainClass);
        });
	}
}
