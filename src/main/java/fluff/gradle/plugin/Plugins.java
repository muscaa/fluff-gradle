package fluff.gradle.plugin;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.publish.PublishingExtension;
import org.gradle.api.publish.maven.MavenPublication;

public class Plugins {
	
	public static void addMavenPublish(Project project) {
		project.getPlugins().apply("maven-publish");
		
		project.afterEvaluate(p -> {
			p.getExtensions().configure(PublishingExtension.class, publishing -> {
				publishing.publications(publications -> {
					publications.create("maven", MavenPublication.class, publication -> {
						publication.from(p.getComponents().getByName("java"));
					});
				});
	    	});
		});
	}
	
	public static void includeSources(Project project) {
		project.afterEvaluate(p -> {
			p.getExtensions().configure(JavaPluginExtension.class, ext -> {
	            ext.withSourcesJar();
	            ext.withJavadocJar();
	        });
		});
	}
}
