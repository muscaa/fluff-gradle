package fluff.gradle.property;

import fluff.gradle.AbstractManager;

public class PropertyManager extends AbstractManager {
	
	public String type;
	public boolean publish;
	public boolean source;
	
	@Override
	protected void onInit() {
		type = getString("fluff.type");
		publish = getBoolean("fluff.publish", false);
		source = getBoolean("fluff.source", false);
	}
	
	public boolean has(String name) {
		return project.hasProperty(name);
	}
	
	public void set(String name, Object value) {
		project.setProperty(name, value);
	}
	
	public String getString(String name) {
		if (!has(name)) throw new IllegalStateException(name + " property not found in gradle.properties!");
		
		return (String) project.findProperty(name);
	}
	
	public String getString(String name, String value) {
		return has(name) ? getString(name) : value;
	}
	
	public boolean getBoolean(String name) {
		return Boolean.parseBoolean(getString(name));
	}
	
	public boolean getBoolean(String name, boolean value) {
		return Boolean.parseBoolean(getString(name, String.valueOf(value)));
	}
	
	public int getInt(String name) {
		return Integer.parseInt(getString(name));
	}
	
	public int getInt(String name, int value) {
		return Integer.parseInt(getString(name, String.valueOf(value)));
	}
}
