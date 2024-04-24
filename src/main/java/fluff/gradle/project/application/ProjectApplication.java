package fluff.gradle.project.application;

import org.gradle.api.java.archives.Attributes;
import org.gradle.api.plugins.JavaApplication;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.bundling.Jar;

import fluff.gradle.project.AbstractProject;

public class ProjectApplication extends AbstractProject {
	
	public JavaApplication javaApp;
	
	@Override
	protected void onInit() {
		plugins.apply("application");
		
		fluff.extensions.setMain(ExtensionApplication.class);
	}
	
	@Override
	protected void onPostInit() {
		ExtensionApplication main = fluff.extensions.getMain();
		Property<String> propMainClass = main.getMainClass();
		if (!propMainClass.isPresent()) throw new IllegalStateException("Main class property missing!");
		
		javaApp = extensions.getByType(JavaApplication.class);
		javaApp.getMainClass().set(propMainClass.get());
		
        project.getTasks().withType(Jar.class, jar -> {
        	jar.manifest(manifest -> {
        		Attributes attr = manifest.getAttributes();
                attr.put("Main-Class", propMainClass.get());
        	});
        });
	}
}
