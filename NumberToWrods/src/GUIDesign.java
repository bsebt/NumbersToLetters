import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUIDesign {

	public static void main(String... args) {

		NumberToWords.DefaultProcessor processor = new NumberToWords.DefaultProcessor();

		JFrame frame = new JFrame("Convertor");
		JPanel panel = new JPanel(null);
		JTextField input = new JTextField("");
		JTextArea output = new JTextArea("");
		JTextField inputLabel = new JTextField("Input number:");
		JTextField outputlabel = new JTextField("English Representation:");
		JTextField banner = new JTextField("Converting Number to Words");
		JButton exitb = new JButton("Exit");
		JButton write = new JButton("Write in English");
		Font font1 = new Font("SansSerif", Font.BOLD, 24);
		Font font2 = new Font("SansSerif", Font.PLAIN, 16);
		Font font3 = new Font("SansSerif", Font.PLAIN, 19);
		banner.setFont(font1);
		inputLabel.setFont(font2);
		outputlabel.setFont(font2);
		input.setFont(font3);
		output.setFont(font3);
		
		frame.setSize(400, 350);
		frame.setResizable(false);

		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(input.getText().length() == 1 && input.getText() == ".") {
						output.setText("no numbers");
					} else if (input.getText().contains(".")) {
						String s = input.getText().substring(input.getText().indexOf('.') + 1,
								input.getText().length());
						if (s.contains(".")) {
							JOptionPane.showMessageDialog(frame,
									"You have entered more than one decimal points \n "
											+ "please make sure your number contains only one \".\"",
									"Too Many dots", JOptionPane.WARNING_MESSAGE);
							input.setText("");
							output.setText("");
						}else if (s.length() == 1) {
							s = s + "0";
							output.setText(processor.getName(input.getText().substring(0, input.getText().indexOf('.')))
									+ " dollars " + "and " + processor.getName(s) + " cents ");
						} else {
							output.setText(processor.getName(input.getText().substring(0, input.getText().indexOf('.')))
									+ " dollars " + "and " + processor.getName(s) + " cents ");
						}
					} else if (input.getText().isEmpty())
						output.setText("");
					else
						output.setText(processor.getName(input.getText()) + " dollars ");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(frame,
							"You have entered letters in the input box \n please make sure you ONLY user numbers and \".\"",
							"letters in input", JOptionPane.WARNING_MESSAGE);
					input.setText("");
					output.setText("");
				}
			}
		});
		
		
		panel.setSize(400, 400);
		input.setBounds(5, 90, 390, 50);
		output.setEditable(false);
		output.setBounds(5, 170, 390, 100);
		inputLabel.setEditable(false);
		inputLabel.setBounds(5, 65, 390, 30);
		inputLabel.setBackground(Color.black);
		inputLabel.setForeground(Color.green);
		outputlabel.setBounds(5, 125, 390, 60);
		outputlabel.setBackground(Color.black);
		outputlabel.setForeground(Color.cyan);
		outputlabel.setEditable(false);
		inputLabel.setEditable(false);
		output.setLineWrap(true);
		banner.setBackground(Color.black);
		banner.setForeground(Color.yellow);
		banner.setEditable(false);
		banner.setBounds(12, 10, 400, 50);
		exitb.setBounds(30, 275, 100, 50);
		write.setBounds(180, 275, 200, 50);
		// banner.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(input);
		panel.add(output);
		panel.add(inputLabel);
		panel.add(outputlabel);
		panel.add(banner);
		panel.add(exitb);
		panel.add(write);
		frame.add(panel);
		panel.setBackground(Color.black);
		frame.setVisible(true);

	}

}
