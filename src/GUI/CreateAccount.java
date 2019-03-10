package GUI;
import model.*;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

/**
 * A panel for creating a account
 * 
 * @author Irem Ecem Yelkanat & Duygu Nur Yaldiz
 * @version 16/12/2018
 */
public class CreateAccount extends JPanel {
   
   //Properties
   private JFrame topFrame;
   private JTextField usernameField;
   private JTextField passwordField1;
   private JTextField passwordField2;
   private JTextField answerField;
   private boolean addedLblPasswordsDoNot;
   private boolean addedLblThisUsernameHas;
   private boolean addedLblEmptyError;
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public CreateAccount( JFrame frame ) {
      
      // Initialize
      topFrame = frame;
      
      //set panel's properties
      setBackground(SystemColor.control);
      setPreferredSize (new Dimension (1062,750));
      setMaximumSize( new Dimension (1062,750) );
      setLayout(null);
      
      //Create labels
      JLabel lblNewLabel = new JLabel("Create An Account");
      lblNewLabel.setForeground(Color.BLUE);
      lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
      lblNewLabel.setBounds(381, 157, 273, 64);
      add(lblNewLabel);
      
      JLabel usernameLabel = new JLabel("Username");
      usernameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
      usernameLabel.setBounds(321, 258, 98, 16);
      add(usernameLabel);
      
      JLabel passwordLabel = new JLabel("Password");
      passwordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
      passwordLabel.setBounds(321, 309, 98, 19);
      add(passwordLabel);
      
      JLabel checkPasswordLabel = new JLabel("Password");
      checkPasswordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
      checkPasswordLabel.setBounds(321, 357, 98, 16);
      add(checkPasswordLabel);
      
      JLabel questionLabel = new JLabel("Question");
      questionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
      questionLabel.setBounds(321, 400, 76, 16);
      add(questionLabel);
      
      JLabel answerLabel = new JLabel("Answer");
      answerLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
      answerLabel.setBounds(334, 443, 65, 16);
      add(answerLabel);
      
      //Create warning labels
      JLabel lblPasswordsDoNot = new JLabel("Passwords do not match!");
      lblPasswordsDoNot.setForeground(new Color(255, 0, 0));
      lblPasswordsDoNot.setBounds(735, 358, 154, 16);
      addedLblPasswordsDoNot = false;
      
      JLabel lblThisUsernameHas = new JLabel("This username has been taken before!");
      lblThisUsernameHas.setForeground(new Color(255, 0, 0));
      lblThisUsernameHas.setBounds(735, 263, 250, 16);
      addedLblThisUsernameHas = false;
      
      JLabel lblEmptyError = new JLabel("User name and password can not be empty!");
      lblThisUsernameHas.setForeground(new Color(255, 0, 0));
      lblThisUsernameHas.setBounds(0, 0, 250, 16);
      addedLblEmptyError = false;
      
      //Create text fields and password fields
      usernameField = new JTextField();
      usernameField.setBounds(431, 256, 281, 30);
      add(usernameField);
      usernameField.setColumns(10);
      
      passwordField1 = new JPasswordField();
      passwordField1.setBounds(431, 304, 281, 31);
      add(passwordField1);
      passwordField1.setColumns(10);
      
      passwordField2 = new JPasswordField();
      passwordField2.setBounds(431, 351, 281, 30);
      add(passwordField2);
      passwordField2.setColumns(10);
      
      answerField = new JTextField();
      answerField.setBounds(431, 437, 281, 30);
      add(answerField);
      answerField.setColumns(10);
      
      //Create question combo box and add questions
      JComboBox<String> questionBox = new JComboBox<String>();
      
      questionBox.setBackground(Color.LIGHT_GRAY);
      questionBox.setBounds(431, 394, 281, 30);
      questionBox.addItem("What is your dogs name ?");
      questionBox.addItem("Your favourite food");
      questionBox.addItem("Your favourite series");
      questionBox.addItem("Your favourite film character");
      add(questionBox);
      
      //Create sign up button and add listener to it
      JButton btnSignUp = new JButton("Sign Up");
      btnSignUp.setFont(new Font("Lucida Grande", Font.BOLD, 14));
      btnSignUp.setBounds(523, 480, 97, 25);
      btnSignUp.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            boolean checkEmpty = ( ( usernameField.getText().length() == 0  ) || ( passwordField1.getText().length() == 0 ) || ( passwordField2.getText().length() == 0 ) || (answerField.getText().length() == 0 )  );
            System.out.println(checkEmpty);
            //check if there is any empty place, if yes prompt user
            if( !checkEmpty ) {
               
               boolean checkUsername = ((ExternalInvestors)topFrame).getAccountContainer().checkIfUsernameExist( usernameField.getText() );
               boolean checkPassword = passwordField1.getText().equals( passwordField2.getText() );
               
               //if empty error is added remove it
               if( addedLblEmptyError) {
                  remove(lblEmptyError);
                  addedLblEmptyError = false;
               }
               //check if the written username has been taken before, if yes prompt user
               if( checkUsername )  {
                  add(lblThisUsernameHas);
                  addedLblThisUsernameHas = true;
               }
               else if( addedLblThisUsernameHas ) {
                  remove(lblThisUsernameHas);
                  addedLblThisUsernameHas = false;
               }
               //check passwords are the same, if not prompt user
               if( !checkPassword ) {
                  add(lblPasswordsDoNot);
                  addedLblPasswordsDoNot = true;
               }
               else {
                  remove(lblPasswordsDoNot);
                  addedLblPasswordsDoNot = false;
               }
               //if every condition is satisfied then create account and open the welcome page
               if( !checkUsername && checkPassword) {
                  Question question = new Question( ((String)questionBox.getSelectedItem()), answerField.getText()); 
                  ((ExternalInvestors)topFrame).getAccountContainer().addAccount( usernameField.getText(), passwordField1.getText(), question);
                  ((ExternalInvestors)topFrame).getAccountContainer().setActiveUser(usernameField.getText(), passwordField1.getText());
                  ((ExternalInvestors)topFrame).changeMainPanel(14);
                  ((ExternalInvestors)topFrame).changeSidePanel(0);
               }
               
            }
            else {
               add(lblEmptyError);
               addedLblEmptyError = true;
            }
            
            revalidate();
            repaint();
         }
      });
      add(btnSignUp);
      
      //Create back button add add it a listener that turns into previous page
      JButton backButton = new JButton("BACK");
      backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
      backButton.setForeground(new Color(240, 248, 255));
      backButton.setBackground(new Color(0, 0, 128));
      backButton.setBounds(33, 37, 98, 37);
      backButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ((ExternalInvestors)topFrame).changeMainPanel(6);
         }
      });
      add(backButton);   
   }
}
