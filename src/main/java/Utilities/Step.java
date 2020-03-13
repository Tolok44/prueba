package Utilities;


public class Step {
	public String tcName;
	public double step;
	public String description;
	public String accion;
	public String valueAccion;
	public String locator;
	public String valueLocator;
	public boolean screenshot;
	public double waitTime;
	

	public Step(String tcName,double step, String description,String accion,String vAccion, String locator, String vLocator,boolean screenshot,double waitTime) {
		this.tcName=tcName;
		this.step=step;
		this.description=description;
		this.accion=accion;
		this.valueAccion=vAccion;
		this.locator=locator;
		this.valueLocator=vLocator;
		this.screenshot=screenshot;
		this.waitTime=waitTime;
		
		
	}



	@Override
	public String toString() {
		return "Step [tcName=" + tcName + ", step=" + step + ", description=" + description + ", accion=" + accion
				+ ", valueAccion=" + valueAccion + ", locator=" + locator + ", valueLocator=" + valueLocator
				+ ", screenshot=" + screenshot + ", waitTime=" + waitTime + "]";
	}



	public double getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public String getAccion() {
		return accion;
	}


	public void setAccion(String accion) {
		this.accion = accion;
	}


	public String getValueAccion() {
		return valueAccion;
	}


	public void setValueAccion(String valueAccion) {
		this.valueAccion = valueAccion;
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

	public double getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(double waitTime) {
		this.waitTime = waitTime;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}
	
	
	
	
}
