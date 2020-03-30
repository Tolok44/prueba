package testCases;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import Utilities.Execute;
import Utilities.OpenHtml;
import Utilities.ReadXmls;
import Utilities.Step; 

/** In this class the test cases are iterated and executed */
public class TestCaseRunner {
	public static void main(String[] args) throws Exception {
		ArrayList<ArrayList> tcList; 
		ArrayList<Step> stepList;
		/** Creates an OpenHtml object */
		OpenHtml openHtml = new OpenHtml();
		ReadXmls reader = new ReadXmls();
		/** Reading excels files */
		/** Selects the destination */
		javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
		jF1.setDialogTitle("Open a story");
		/** Here we save the destination */
		String rute = "";
		try {
			if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
				rute = jF1.getSelectedFile().getAbsolutePath();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		/**sets tcList */
		tcList = reader.getTestCases(rute);
		/**
		 * Menu creation for test case selection.
		 */

		/** This array saves the name of the test cases */
		String[] prueba = new String[tcList.size()];

		/** creates an array of radio buttons */
		JRadioButton[] radio = new JRadioButton[tcList.size()];

		/** this for saves the name of test cases */
		for (int x = 0; x < tcList.size(); x++) {
			Step testCasename = (Step) tcList.get(x).get(0);

			prueba[x] = testCasename.getTcName();

		}
		String name = "";
		/** we create the template */
		JPanel panel = new JPanel();
		/** we gave the format */
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel label = new JLabel();
		label.setText("Select Test Cases");
		panel.add(label);
		/** a position is assigned to Jpanel */
		panel.setBounds(10, 10, 375, 150);
		/** in thus for we create the radio buttons whit the test cases names */
		for (int u = 0; u < prueba.length; u++) {

			name = prueba[u];
			JRadioButton button = new JRadioButton(name);
			radio[u] = button;

			/** we add the radio button to the panel */
			panel.add(radio[u]);

		}

		/** we show the panel */
		JOptionPane.showMessageDialog(null, panel);
		/** in this array we save the selected test cases */
		ArrayList<String> alCad = new ArrayList<String>();
		String[] cad = new String[radio.length];

		/** in this for we save the selected test cases */
		for (int t = 0; t < radio.length; t++) {

			/** we ask if it was selected */
			if (radio[t].isSelected()) {
				/** we save the name of the test case */
				cad[t] = radio[t].getLabel();
				alCad.add(radio[t].getLabel());
			}
		}
		/**here we save the tests cases selected in a list called tclist*/
		int tcasesArrayInt[] = new int[alCad.size()];
		for (int i = 0; i < alCad.size(); i++) {
			for (int x = 0; x < cad.length; x++) {
				Step step = (Step) tcList.get(x).get(2);
				if (alCad.get(i).equals(step.getTcName())) {
					tcasesArrayInt[i] = x;
				}
			}
		}
		ArrayList<ArrayList> tcList2 = new ArrayList();
		int x = 0;
		for (int i = 0; i < tcasesArrayInt.length; i++) {
			x = tcasesArrayInt[i];
			tcList2.add(tcList.get(x));
		}
		/**
		 * We create an execute object and send it the list of test cases.
		 */
		Execute exe = new Execute();
		try {
			exe.execute(tcList2);
		} catch (Exception e) {
			/** if there is an exception error a message is printed */
			System.out.println(" ups something went wrong in the test case.");
		}
		/** Here we open the created reports */
		for (int i = 0; i < tcList2.size(); i++) {
			Step pasoPrueba = (Step) tcList2.get(i).get(i);
			System.out.println(pasoPrueba.getTcName());
			openHtml.OpenHtml(pasoPrueba.getTcName());
		}
	}
}
