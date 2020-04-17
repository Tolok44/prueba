package Utilities;

public class Parameter {
	public String name;
	public String value;

	@Override
	public String toString() {
		return "Parameter [Name=" + name + ", value=" + value + "]";
	}

	public Parameter(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String desription) {
		this.name = desription;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
