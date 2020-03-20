package testCases;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import Utilities.Execute;
import Utilities.LeerXmls1;
import Utilities.OpenHtml;
import Utilities.Step;
/** In this class the test cases are iterated and executed */
public class TC1 {
	public static void main(String[] args) throws Exception {

		// Crea una lista para guardar los pasos
		ArrayList<ArrayList> tcList;
		ArrayList<Step> stepList;

		// Crea un Objeto OpneHtml
		OpenHtml openHtml = new OpenHtml();

		// Manda el driver a element

		LeerXmls1 TC = new LeerXmls1();

		// -----------------------------------------lectura de datos del archivo
		// excel----------------------------
		// Cargamos la ruta que querramos
		javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
		jF1.setDialogTitle("Open a story");

		// aqui guardamos la ruta
		String ruta = "";
		try {
			if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
				// se guarda la ruta
				ruta = jF1.getSelectedFile().getAbsolutePath();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		tcList = TC.obtenObjetos(ruta);

		// -------------------------------------------creacion del menu paraseleccionar los test cases----------

		// este arreglo guarda los nombres de los test cases
		String[] prueba = new String[tcList.size()];

		// creamos un arreglo de radiobuttons
		JRadioButton[] radio = new JRadioButton[tcList.size()];

		// este for guardara los nombres TC en el arreglo prueba
		for (int x = 0; x < tcList.size(); x++) {
			Step nombreTestCase = (Step) tcList.get(x).get(0);

			prueba[x] = nombreTestCase.getTcName();

		}

		
		String name = "";
		// creamos la pantalla
		JPanel panel = new JPanel();

		// le damos formato
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel label = new JLabel();
		label.setText("Select Test Cases");
		panel.add(label);
		// Se le asigna una posición dentro del Jpanel
		panel.setBounds(10, 10, 375, 150);
		
		// en este for recorremos el arrego de prueba para crear los radio button con
				// los
				// nombres de los TC
				for (int u = 0; u < prueba.length; u++) {
					
					name = prueba[u];
					JRadioButton button = new JRadioButton(name);
					radio[u] = button;

					// agregamos el radiobutton al panel
					panel.add(radio[u]);

				}

				// mostramos el panel
				JOptionPane.showMessageDialog(null, panel);
		
		
				// este arreglo sera para guardar los que seleccionemos
				ArrayList<String> alCad = new ArrayList<String>();
				String[] cad = new String[radio.length];

				// este for recorre el arreglo de los radio buttons para checar quien fue
				// seleccionado
				for (int t = 0; t < radio.length; t++) {
					
					// preguntamos si fue seleccionado
					if (radio[t].isSelected()) {
						// guardamos el nombre del TC en el arreglo cad
						cad[t] = radio[t].getLabel();
						alCad.add(radio[t].getLabel());
					}
				}
				
				
		int tcasesArrayInt[] = new int[alCad.size()];		
				
		
		
		for(int i = 0; i < alCad.size(); i++) {
			for(int x = 0; x < cad.length; x++) {
				Step aaaaaaaaa = (Step) tcList.get(x).get(x);
				if (alCad.get(i).equals(  aaaaaaaaa.getTcName() )) {
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

		Execute exe = new Execute();

		exe.execute(tcList2);

		// for para abrir reportes especificos
		for (int i = 0; i < tcList2.size(); i++) {
			// (Step) tcList2.get(i).get(0);
			Step pasoPrueba = (Step) tcList2.get(i).get(i);
			// pasoPrueba.getTcName();
			System.out.println(pasoPrueba.getTcName());
			openHtml.OpenHtml(pasoPrueba.getTcName());
		}
	}



}
