package fluff.gradle.utils;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.bundling.Jar;

import fluff.gradle.FluffGradle;

public class Utils {
	
	private static void addIncludes(FluffGradle fluff, Project p, Jar task) {
        ListProperty<String> include = fluff.extensions.getMain().getInclude();
        if (!include.isPresent()) return;
        
        //task.from("src/main/java").exclude("**/*.java");
    	for (String path : include.get()) {
    		task.from(p.file(path), spec -> spec.into("META-INF"));
    	}
        
        p.getTasks().named("build").configure(build -> build.dependsOn(task));
	}
	
	public static void addIncludes(FluffGradle fluff, Project p) {
		addIncludes(fluff, p, (Jar) p.getTasks().getByName("jar"));
		addIncludes(fluff, p, (Jar) p.getTasks().getByName("sourcesJar"));
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
