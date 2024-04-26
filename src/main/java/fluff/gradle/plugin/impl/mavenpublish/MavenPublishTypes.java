package fluff.gradle.plugin.impl.mavenpublish;

import java.util.HashMap;
import java.util.Map;

import org.gradle.api.publish.maven.MavenPublication;

public class MavenPublishTypes {
	
	public static final IPublishType MAVEN = (p, publishing) -> {
		publishing.publications(publications -> {
			publications.create("maven", MavenPublication.class, publication -> {
				publication.from(p.getComponents().getByName("java"));
			});
		});
	};
	public static final IPublishType LOCAL = (p, publishing) -> {
		publishing.repositories(repos -> {
			repos.maven(repo -> {
				repo.setUrl(p.uri(p.getLayout().getBuildDirectory().dir("repo")));
			});
		});
	};
	
	private static final Map<String, IPublishType> REG = new HashMap<>();
	static {
		register("maven", MAVEN);
		register("local", LOCAL);
	}
	
	public static IPublishType get(String name) {
		if (!REG.containsKey(name)) throw new RuntimeException(name + " is not a valid publishing type!");
		
		return REG.get(name);
	}
	
	public static void register(String name, IPublishType type) {
		REG.put(name, type);
	}
}
