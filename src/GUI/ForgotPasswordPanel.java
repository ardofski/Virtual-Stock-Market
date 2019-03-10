package GUI;

import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * A panel for performing forgot password actions
 * 
 * @author Irem Ecem Yelkanat & Duygu Nur Yaldiz
 * @version 17/12/2018
 */
public class ForgotPasswordPanel extends JPanel {
   
   //Properties
   private JFrame topFrame;
   private JTextField usernameField;
   private JPasswordField passwordField;
   private JPasswordField passwordField2;
   private boolean addedQuestionWarning;
   private boolean addedUsenameWarning;
   private boolean addedLblPasswordsDoNot;
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public ForgotPasswordPanel(JFrame frame) {
      
      // Initialize
	   
      topFrame = frame;
      
      //set panel's properties
      setPreferredSize(new Dimension (950,700));
      setLayout(null);
      
      //Create Labels
      JLabel lblForgotMyPassword = new JLabel("FORGOT MY PASSWORD");
      lblForgotMyPassword.setForeground(Color.BLUE);
      lblForgotMyPassword.setFont(new Font("Lucida Grande", Font.BOLD, 30));
      lblForgotMyPassword.setBounds(321, 170, 382, 61);
      add(lblForgotMyPassword);
      
      JLabel lblNewLabel = new JLabel("Username:");
      lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewLabel.setBounds(303, 289, 78, 16);
      add(lblNewLabel);
      
      JLabel lblQuestion = new JLabel("Question:");
      lblQuestion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblQuestion.setBounds(311, 332, 70, 16);
      add(lblQuestion);
      
      JLabel lblAnswer = new JLabel("Answer:");
      lblAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblAnswer.setBounds(322, 375, 59, 16);
      add(lblAnswer);
      
      JLabel lblNewPassword = new JLabel("New password:");
      lblNewPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewPassword.setBounds(271, 420, 117, 16);
      add(lblNewPassword);
      
      JLabel lblNewPassword2 = new JLabel("New Password:");
      lblNewPassword2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewPassword2.setBounds(271, 461, 110, 16);
      add(lblNewPassword2);
      
      //create informative labels
      JLabel lblQuestionAndAnswer = new JLabel("Question and answer didn't match!");
      lblQuestionAndAnswer.setForeground(new Color(220, 20, 60));
      lblQuestionAndAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
      lblQuestionAndAnswer.setBounds(422, 256, 231, 16);
      addedQuestionWarning = false;
      
      JLabel lblUsernameFault = new JLabel("Username does not exist!");
      lblUsernameFault.setForeground(new Color(220, 20, 60));
      lblUsernameFault.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
      lblUsernameFault.setBounds(445, 256, 231, 16);
      addedUsenameWarning = false;
      
      JLabel lblPasswordsDoNot = new JLabel("Passwords do not match!");
      lblPasswordsDoNot.setForeground(new Color(255, 0, 0));
      lblPasswordsDoNot.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
      lblPasswordsDoNot.setBounds(690, 440, 154, 16);
      addedLblPasswordsDoNot = false;
      
      //Create text fields
      usernameField = new JTextField();
      usernameField.setBounds(405, 285, 276, 32);
      add(usernameField);
      usernameField.setColumns(10);
      
      //create combo box for questions
      JComboBox<String> comboBox = new JComboBox<String>();
      comboBox.setBounds(405, 325, 276, 35);
      add(comboBox);
      comboBox.addItem("What is your dogs name ?");
      comboBox.addItem("Your favourite food");
      comboBox.addItem("Your favourite series");
      comboBox.addItem("Your favourite film character");
      
      //create text fields and password fields
      JTextField answerField = new JTextField();
      answerField.setBounds(405, 369, 276, 30);
      add(answerField);
      answerField.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setBounds(405, 411, 276, 32);
      add(passwordField);
      
      passwordField2 = new JPasswordField();
      passwordField2.setBounds(405, 453, 276, 32);
      add(passwordField2);
      
      //create reset password button and add listener to it
      JButton btnResetPassword = new JButton("Reset Password");
      btnResetPassword.setBounds(445, 506, 141, 29);
      btnResetPassword.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            boolean checkEmpty = ( ( usernameField.getText().length() == 0  ) || ( passwordField.getText().length() == 0 ) || ( passwordField2.getText().length() == 0 ) || (answerField.getText().length() == 0)  );
            System.out.println(checkEmpty);
            if( !checkEmpty ) {
               
               int i = ((ExternalInvestors)topFrame).getAccountContainer().setActiveUser( usernameField.getText(), ((String)comboBox.getSelectedItem()), answerField.getText() );
               boolean checkPassword = passwordField.getText().equals( passwordField2.getText() );
               
               //check if an account with given username exist
               if( i == 3 ) { //if the method returns 3, it means that the username does not exist
                  add(lblUsernameFault);
                  addedUsenameWarning = true;
               }
               else if (addedUsenameWarning){
                  remove(lblUsernameFault);
                  addedUsenameWarning = false;
               }
               //check if the question and answer matches
               if( i == 1 || i == 2) { //if the method returns 1, the question is wrong, if it is 2 then the answer is wrong. 0 if everything is correct
                  add(lblQuestionAndAnswer);
                  addedQuestionWarning = true;
               }
               else if( addedQuestionWarning ) {
                  remove(lblQuestionAndAnswer);
                  addedQuestionWarning = false;
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
               //if all the conditions are satisfied then reset password and change main panel ti in and out panel and side panel to SidePanel
               if( i == 0  && checkPassword){
                  ((ExternalInvestors)topFrame).getAccountContainer().getAccount(usernameField.getText()).setPassword(passwordField.getText());
                  ((ExternalInvestors)topFrame).changeSidePanel(0);
                  ((ExternalInvestors)topFrame).changeMainPanel(4);
               }
            }
            revalidate();
         }
      });
      add(btnResetPassword);
      
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