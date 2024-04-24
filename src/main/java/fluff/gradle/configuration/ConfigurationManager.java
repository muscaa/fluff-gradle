package fluff.gradle.configuration;

import org.gradle.api.artifacts.Configuration;

import fluff.gradle.AbstractManager;

public class ConfigurationManager extends AbstractManager {
	
	public Configuration implementation;
	public Configuration api;
	
	@Override
	protected void onInit() {
		implementation = configurations.getByName("implementation");
		api = configurations.getByName("api");
	}
}
