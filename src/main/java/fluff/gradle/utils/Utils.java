package fluff.gradle.utils;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.bundling.Jar;

import fluff.gradle.FluffGradle;

public class Utils {
	
	public static void addIncludes(FluffGradle fluff, Project p) {
		Jar jar = (Jar) p.getTasks().getByName("jar");
        //jar.from("src/main/java").exclude("**/*.java");
        
        ListProperty<String> include = fluff.extensions.getMain().getInclude();
        if (include.isPresent()) {
        	for (String path : include.get()) {
        		jar.from(p.file(path), spec -> spec.into("META-INF"));
        	}
        }
        
        p.getTasks().named("build").configure(build -> build.dependsOn(jar));
	}
	
	public static void includeSourcesAndDocs(Project project) {
		project.afterEvaluate(p -> {
			p.getExtensions().configure(JavaPluginExtension.class, ext -> {
	            ext.withSourcesJar();
	            ext.withJavadocJar();
	        });
		});
	}
}
