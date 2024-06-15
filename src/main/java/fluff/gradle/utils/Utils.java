package fluff.gradle.utils;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.tasks.bundling.Jar;

import fluff.gradle.FluffGradle;

public class Utils {
	
	private static void addIncludes(FluffGradle fluff, Project p, Jar task) {
        MapProperty<String, String> include = fluff.extensions.main.getInclude();
        if (!include.isPresent()) return;
        
        include.get().forEach((source, dest) -> {
        	int lastSlash = dest.lastIndexOf('/');
        	String destDir = lastSlash != -1 ? dest.substring(0, lastSlash) : "";
        	String destName = lastSlash != -1 ? dest.substring(lastSlash + 1, dest.length()) : dest;
        	
        	task.from(p.file(source), spec -> {
        		spec.into(destDir);
        		spec.rename(name -> destName);
        	});
        });
        
        //task.from("src/main/java").exclude("**/*.java");
        
        p.getTasks().named("build").configure(build -> build.dependsOn(task));
	}
	
	public static void addIncludes(FluffGradle fluff, Project p) {
		addIncludes(fluff, p, (Jar) p.getTasks().getByName("jar"));
	}
	
	public static void includeSourcesAndDocs(FluffGradle fluff, Project project) {
		project.afterEvaluate(p -> {
			p.getExtensions().configure(JavaPluginExtension.class, ext -> {
	            ext.withSourcesJar();
	            ext.withJavadocJar();
	        });
			
			addIncludes(fluff, p, (Jar) p.getTasks().getByName("sourcesJar"));
			addIncludes(fluff, p, (Jar) p.getTasks().getByName("javadocJar"));
		});
	}
}
