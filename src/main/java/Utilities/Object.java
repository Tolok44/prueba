package Utilities;

public class Object {
	public String name;
	public String description;
	public String locator;
	public String valueLocator;
	
	@Override
	public String toString() {
		return "Object [name=" + name + ", description=" + description + ", locator=" + locator + ", valueLocator="
				+ valueLocator + "]";
	}
	
	public Object(String name, String description, String locator, String valueLocator) {
		super();
		this.name = name;
		this.description = description;
		this.locator = locator;
		this.valueLocator = valueLocator;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocator() {
		return locator;
	}
	public void setLocator(String locator) {
		this.locator = locator;
	}
	public String getValueLocator() {
		return valueLocator;
	}
	public void setValueLocator(String valueLocator) {
		this.valueLocator = valueLocator;
	}
	
}
