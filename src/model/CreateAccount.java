package model;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class CreateAccount extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CreateAccount() {
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(306, 250, 281, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(306, 298, 281, 31);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(306, 345, 281, 30);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(306, 431, 281, 30);
		add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox questionBox = new JComboBox();
		questionBox.setModel(new DefaultComboBoxModel(new String[] {"question7", "gdsgdg"}));
		questionBox.setBackground(new Color(47, 79, 79));
		questionBox.setBounds(306, 388, 281, 30);
		add(questionBox);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameLabel.setBounds(196, 252, 98, 16);
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(196, 303, 98, 19);
		add(passwordLabel);
		
		JLabel checkPasswordLabel = new JLabel("Password");
		checkPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkPasswordLabel.setBounds(196, 351, 98, 16);
		add(checkPasswordLabel);
		
		JLabel questionLabel = new JLabel("Question");
		questionLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		questionLabel.setBounds(204, 394, 76, 16);
		add(questionLabel);
		
		JLabel answerLabel = new JLabel("Answer");
		answerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		answerLabel.setBounds(215, 437, 65, 16);
		add(answerLabel);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignUp.setBounds(350, 482, 97, 25);
		add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("Create An Account");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 31));
		lblNewLabel.setBounds(243, 152, 344, 64);
		add(lblNewLabel);

	}
}
