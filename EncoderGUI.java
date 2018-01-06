/* File name:   EncoderGUI.java
 *
 * Written by:  Henry Hedden
 *
 * Description: Encode and decode user-entered text.
 *              
 *              
 * Challenges: 
 *
 * Time Spent: 3.5 hours
 *
 * Revision History:
 * Date:                By:      Action:
 * ---------------------------------------------------
 * 25/11/2017           HH       Created
 * 05/12/2017           HH       Added constructor
 * 05/12/2017           HH       Added main method
 * 05/12/2017           HH       Added `ClickHandler`
 * 08/12/2017           HH       Added switch for codeBox
 * 09/12/2017           HH       Added error handling for unsupported codes
 * 09/12/2017           HH       Added word wrap
 */      

package encoder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

/**
 * Driver class using GUI.
 * @author Henry Hedden
 */
public class EncoderGUI extends JFrame {
	
	private static JPanel p = new JPanel(new GridLayout(3, 1, 5, 5)), b = new JPanel();
	private static JTextArea inputArea, outputArea;
	private static JButton encodeButton, decodeButton;
	private static JComboBox<Code> codeBox = new JComboBox(Code.values());
	private static String keyStr;
	
	/**
	 * Main constructor
	 */
	public EncoderGUI() {
		super("Encode/Decode");
		inputArea    = new JTextArea("Input",  20, 10);
		outputArea   = new JTextArea("Output", 20, 10);
		inputArea.setLineWrap(true);
		outputArea.setLineWrap(true);
		inputArea.setWrapStyleWord(true);
		outputArea.setWrapStyleWord(true);
		outputArea.setEditable(false);
		encodeButton = new JButton("Encode");
		decodeButton = new JButton("Decode");
		
		b.add(codeBox);
		b.add(encodeButton);
		b.add(decodeButton);
		p.add(inputArea);
		p.add(outputArea);
		p.add(b);
		add(p);
		
		ClickHandler click = new ClickHandler();
		encodeButton.addActionListener(click);
		decodeButton.addActionListener(click);
		codeBox.addActionListener(click);
	}
	
	/**
	 * Main method.
	 * @param args the command line arguments (unused)
	 */
	public static void main(String[] args) {
		EncoderGUI e = new EncoderGUI();
		e.setSize(400, 300);
		e.setVisible(true);
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Event handler for buttons
	 */
	private class ClickHandler implements ActionListener {
		
		/**
		 * Determine wheich button was clicked, and encode/decode accordingly.
		 * @param e the event generated
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource()==encodeButton)
					switch ((Code) codeBox.getSelectedItem()) {
						case CAESAR:
							outputArea.setText(Encoder.encodeCaesar(inputArea.getText()));
							break;
						case POLYBIUS:
							outputArea.setText(Encoder.encodePolybius(inputArea.getText()));
							break;
						case TRIMETHIUS:
							outputArea.setText(Encoder.encodeTrimethius(inputArea.getText()));
							break;
						case VIGENERE:
							keyStr = JOptionPane.showInputDialog("Enter key");
							outputArea.setText(Encoder.encodeVigenere(inputArea.getText(), keyStr));
					}
				else if (e.getSource()==decodeButton)
					switch ((Code) codeBox.getSelectedItem()) {
						case CAESAR:
							outputArea.setText(Encoder.decodeCaesar(inputArea.getText()));
							break;
						case POLYBIUS:
							outputArea.setText(Encoder.decodePolybius(inputArea.getText()));
							break;
						case TRIMETHIUS:
							outputArea.setText(Encoder.decodeTrimethius(inputArea.getText()));
							break;
						case VIGENERE:
							keyStr = JOptionPane.showInputDialog("Enter key");
							outputArea.setText(Encoder.decodeVigenere(inputArea.getText(), keyStr));
					}
			} catch (UnsupportedOperationException u) {
				JOptionPane.showMessageDialog(null, String.format("Could not encode text in %s: %s",
						codeBox.getSelectedItem(), u.getMessage()),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
}
