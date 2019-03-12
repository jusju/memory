package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DgHighScore extends JDialog {
    
	private JTextArea txArea = new JTextArea();
	private JButton btSulje = new JButton("Sulje");
	private JDialog tama = this;
	private FrMuistipeli omistaja = null;
	private JTextArea textArea = new JTextArea("1. Jukka 10\n2. Pekka 20\n3. Joni 30\n4. Jaana 40");
	
	public DgHighScore(FrMuistipeli omistaja, String otsikko, boolean modal) {
		super(omistaja, otsikko, modal);
		this.omistaja = omistaja;
        setTitle("Highscores");
        setLocation(300, 300);
        setSize(100, 200);
    	Container sisalto = this.getContentPane();
		sisalto.setLayout(new FlowLayout());
		sisalto.add(textArea);
		sisalto.add(btSulje);
		btSulje.addActionListener(new AlsSulje());
    }
	
	class AlsSulje implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Sulje painettu!");
			omistaja.setDgNaytetty(false);
			tama.setVisible(false);

		}
		
	}

}
