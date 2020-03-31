package Utilities;

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
	public double numericValue;
	public boolean pass;
	public String time;
	public String destinationLocator;
	public String destinationLocatorValue;
/**Constructor to assign step variables*/
	public Step(String tcName, double step, String description, String accion, String vAccion, String locator,
			String vLocator, boolean screenshot, double numericValue, boolean pass, String time,
			String destinationLocator, String destinationLocatorValue) {
		this.tcName = tcName;
		this.step = step;
		this.description = description;
		this.action = accion;
		this.valueAction = vAccion;
		this.locator = locator;
		this.valueLocator = vLocator;
		this.screenshot = screenshot;
		this.numericValue = numericValue;
		this.pass = pass;
		this.time = time;
		this.destinationLocator = destinationLocator;
		this.destinationLocatorValue = destinationLocatorValue;

	}
/**method to print step variables*/
	@Override
	public String toString() {
		return "Step [tcName=" + tcName + ", step=" + step + ", description=" + description + ", accion=" + action
				+ ", valueAccion=" + valueAction + ", locator=" + locator + ", valueLocator=" + valueLocator
				+ ", screenshot=" + screenshot + ", numericValue=" + numericValue + ", pass=" + pass + ", time=" + time
				+ ", destinationLocator=" + destinationLocator + ", destinationLocatorValue=" + destinationLocatorValue
				+ "]";
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

	public double getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(double numericValue) {
		this.numericValue = numericValue;
	}
}
