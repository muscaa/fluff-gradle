package fluff.gradle.plugin.impl.mavenpublish;

import java.util.HashMap;
import java.util.Map;

import org.gradle.api.Project;
import org.gradle.api.publish.PublishingExtension;
import org.gradle.api.publish.maven.MavenPublication;

public class MavenPublishTypes {
	
	public static final IPublishType MAVEN = new IPublishType() {
		
		@Override
		public void apply(Project p, PublishingExtension publishing) {
			publishing.publications(publications -> {
				publications.create("maven", MavenPublication.class, publication -> {
					publication.from(p.getComponents().getByName("java"));
				});
			});
		}
	};
	public static final IPublishType LOCAL = new IPublishType() {
		
		@Override
		public void apply(Project p, PublishingExtension publishing) {
			publishing.repositories(repos -> {
				repos.maven(repo -> {
					repo.setUrl(p.getLayout().getBuildDirectory().dir("repo").get().getAsFile().toURI());
				});
			});
		}
	};
	
	private static final Map<String, IPublishType> REG = new HashMap<>();
	static {
		REG.put("maven", MAVEN);
		REG.put("local", LOCAL);
	}
	
	public static IPublishType get(String name) {
		if (!REG.containsKey(name)) throw new RuntimeException(name + " is not a valid publishing type!");
		
		return REG.get(name);
	}
}
