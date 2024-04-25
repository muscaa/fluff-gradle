package fluff.gradle.plugin.impl.mavenpublish;

import org.gradle.api.Project;
import org.gradle.api.publish.PublishingExtension;

public interface IPublishType {
	
	void apply(Project p, PublishingExtension publishing);
}
