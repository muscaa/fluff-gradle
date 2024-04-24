package fluff.gradle;

import java.util.List;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.bundling.Jar;

public class ProjectEvaluation {
	
	public static void before(FluffGradle fluff, Project p) {
		
	}
	
	public static void after(FluffGradle fluff, Project p) {
		Jar jar = (Jar) p.getTasks().getByName("jar");
        //jar.from("src/main/java").exclude("**/*.java");
        
        Property<List<String>> includeFiles = fluff.extensions.fluff.getIncludeFiles();
        if (includeFiles.isPresent()) {
        	for (String path : includeFiles.get()) {
        		jar.from(p.file(path)).into("META-INF");
        	}
        }
        
        p.getTasks().named("build").configure(build -> build.dependsOn(jar));
	}
}
