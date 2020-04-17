package Utilities;

import java.util.ArrayList;

/** In this class there are all the characteristics of an step */
public class Step {
	public String tcName;
	public double step;
	public String description;
	public String action;
	public String valueAction;
	public String locator;
	public String valueLocator;
	public boolean screenshot;
	public boolean pass;
	public String time;
	public String destinationLocator;
	public String destinationLocatorValue;
	public ArrayList<Parameter> parameters;
	public ArrayList<Object> objects;
/**Constructor to assign step variables*/
	
/**method to print step variables*/
	
	


public Step(String tcName, double step, String description, String action, String valueAction, String locator,
		String valueLocator, boolean screenshot, boolean pass, String time, String destinationLocator,
		String destinationLocatorValue, ArrayList<Parameter> parameters, ArrayList<Object> objects) {
	super();
	this.tcName = tcName;
	this.step = step;
	this.description = description;
	this.action = action;
	this.valueAction = valueAction;
	this.locator = locator;
	this.valueLocator = valueLocator;
	this.screenshot = screenshot;
	this.pass = pass;
	this.time = time;
	this.destinationLocator = destinationLocator;
	this.destinationLocatorValue = destinationLocatorValue;
	this.parameters = parameters;
	this.objects = objects;
}



@Override
public String toString() {
	return "Step [tcName=" + tcName + ", step=" + step + ", description=" + description + ", action=" + action
			+ ", valueAction=" + valueAction + ", locator=" + locator + ", valueLocator=" + valueLocator
			+ ", screenshot=" + screenshot + ", pass=" + pass + ", time=" + time + ", destinationLocator="
			+ destinationLocator + ", destinationLocatorValue=" + destinationLocatorValue + ", parameters=" + parameters
			+ ", objects=" + objects + "]";
}



/**Getters and setters for step variables*/
	public double getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String accion) {
		this.action = accion;
	}

	public String getValueAction() {
		return valueAction;
	}

	public void setValueAction(String valueAccion) {
		this.valueAction = valueAccion;
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

	public void setvLocator(String vLocator) {
		this.valueLocator = vLocator;
	}

	public boolean getScreenshoot() {
		return screenshot;
	}

	public void setScreenshoot(boolean screenshot) {
		this.screenshot = screenshot;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public String getDestinationLocator() {
		return destinationLocator;
	}

	public void setDestinationLocator(String destinationLocator) {
		this.destinationLocator = destinationLocator;
	}

	public String getDestinationLocatorValue() {
		return destinationLocatorValue;
	}

	public void setDestinationLocatorValue(String destinationLocatorValue) {
		this.destinationLocatorValue = destinationLocatorValue;
	}

	public ArrayList getParameters() {
		return parameters;
	}
	public void setParameters(ArrayList parameters) {
		this.parameters = parameters;
	}
	public ArrayList<Object> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<Object> objects) {
		this.objects = objects;
	}
	
}
