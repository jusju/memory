package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DgHighScore extends JDialog {
    
	private JTextArea txArea = new JTextArea();
	private JButton btSulje = new JButton("Sulje");
	private JDialog tama = this;
	private JFrame omistaja = null;
	
	public DgHighScore(JFrame omistaja, String otsikko, boolean modal) {
		super(omistaja, otsikko, modal);
		this.omistaja = omistaja;
        setTitle("Highscores");
        setLocation(300, 300);
        setSize(500, 300);
    	Container sisalto = this.getContentPane();
		sisalto.setLayout(new FlowLayout());
		sisalto.add(btSulje);
		btSulje.addActionListener(new AlsSulje());
    }
	
	class AlsSulje implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tama.setVisible(false);
			
		}
		
	}

}
