package GUI;


import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * A panel for performing change password actions
 * 
 * @author Irem Ecem Yelkanat
 * @version 17/12/2018
 */
public class ChangePasswordPanel extends JPanel {
   
   
   //Properties
   private JFrame topFrame;
   private JTextField answerField;
   private JPasswordField passwordField1;
   private JPasswordField passwordField2;
   private boolean addedQuestionWarning;
   private boolean addedLblPasswordsDoNot;
   private boolean addedLblEmptyError;
   
   /**
    * Create the panel.
    */
   public ChangePasswordPanel(JFrame frame) {
      
      // Initialize
      topFrame = frame;
      
      //set panel's properties
      setPreferredSize (new Dimension(850, 700));
      setLayout(null);
      
      //create labels
      JLabel profileLabel = new JLabel("Profile");
      profileLabel.setForeground(Color.BLUE);
      profileLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
      profileLabel.setBounds(45, 45, 74, 31);
      add(profileLabel);
      
      JLabel generalInformationLabel = new JLabel("> Profile Options");
      generalInformationLabel.setForeground(UIManager.getColor("Button.light"));
      generalInformationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
      generalInformationLabel.setBounds(131, 45, 196, 31);
      add(generalInformationLabel);
      
      JLabel lblChangePassword = new JLabel("> Change Password");
      lblChangePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
      lblChangePassword.setBounds(332, 45, 236, 31);
      add(lblChangePassword);
      
      JLabel lblQuestion = new JLabel("Question");
      lblQuestion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblQuestion.setBounds(276, 213, 69, 25);
      add(lblQuestion);
      
      JLabel lblAnswer = new JLabel("Answer");
      lblAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblAnswer.setBounds(284, 282, 53, 16);
      add(lblAnswer);
      
      JLabel lblNewPassword = new JLabel("New Password");
      lblNewPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewPassword.setBounds(237, 342, 108, 25);
      add(lblNewPassword);
      
      JLabel lblNewPassword_1 = new JLabel("New Password");
      lblNewPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewPassword_1.setBounds(237, 406, 108, 25);
      add(lblNewPassword_1);
      
      //create warning labels
      JLabel lblQuestionAndAnswer = new JLabel("Question and answer didn't match!");
      lblQuestionAndAnswer.setForeground(new Color(220, 20, 60));
      lblQuestionAndAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
      lblQuestionAndAnswer.setBounds(385, 250, 231, 16);
      addedQuestionWarning = false;
      
      JLabel lblPasswordsDoNot = new JLabel("Passwords do not match!");
      lblPasswordsDoNot.setForeground(new Color(255, 0, 0));
      lblPasswordsDoNot.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
      lblPasswordsDoNot.setBounds(386, 385, 154, 16);
      addedLblPasswordsDoNot = false;
      
      JLabel lblEmptyError = new JLabel("Answer and passwords can not be empty!");
      lblEmptyError.setForeground(new Color(255, 0, 0));
      lblEmptyError.setBounds(385, 195, 250, 16);
      addedLblEmptyError = false;
      
      JLabel lblSuccessfulChange = new JLabel("Your password has been changed successfully!");
      lblSuccessfulChange.setForeground( Color.GREEN );
      lblSuccessfulChange.setBounds(385, 195, 300, 16);
      
      //Create question box and add questions to it
      JComboBox<String> questionBox = new JComboBox<String>();
      questionBox.setBounds(384, 212, 232, 30);
      questionBox.addItem("What is your dogs name ?");
      questionBox.addItem("Your favourite food");
      questionBox.addItem("Your favourite series");
      questionBox.addItem("Your favourite film character");
      add(questionBox);
      
      //create text fields and password fields
      answerField = new JTextField();
      answerField.setBounds(386, 276, 230, 30);
      add(answerField);
      answerField.setColumns(10);
      
      passwordField1 = new JPasswordField();
      passwordField1.setBounds(386, 340, 230, 30);
      add(passwordField1);
      
      passwordField2 = new JPasswordField();
      passwordField2.setBounds(386, 404, 230, 30);
      add(passwordField2);
      
      //create change password button and add listener to it
      JButton btnNewButton = new JButton("Change Password");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            boolean checkEmpty = ( ( answerField.getText().length() == 0  ) || ( passwordField1.getText().length() == 0 ) || ( passwordField2.getText().length() == 0 ));
            System.out.println(checkEmpty);
            if( !checkEmpty ) {
               
               boolean checkQuestion = (((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().getQuestion().equals((String)questionBox.getSelectedItem()));
               boolean checkPassword = passwordField1.getText().equals( passwordField2.getText() );
               boolean checkAnswer = ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().checkQuestion(answerField.getText());
               
               //if empty error is added, remove it
               if( addedLblEmptyError) {
                  remove(lblEmptyError);
                  addedLblEmptyError = false;
               }
               //check if the question and answer matches
               if( !checkQuestion || !checkAnswer) {
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
               //if every condition is satisfied then change password and inform the user
               if( checkQuestion && checkAnswer && checkPassword ) {
                  ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().setPassword(passwordField1.getText());
                  add(lblSuccessfulChange);
               }
            }
            else {
               add(lblEmptyError);
               addedLblEmptyError = true;
            }
            
            revalidate();
            //repaint();
         }
      });
      btnNewButton.setBounds(297, 495, 163, 29);
      add(btnNewButton);
      
      //Create back button add add it a listener that turns into previous page
      
      JButton btnBack = new JButton("Back");
      btnBack.setBounds(20, 130, 95, 21);
      btnBack.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ((ExternalInvestors)topFrame).changeMainPanel(9);
            
         }
      });
      add(btnBack);
      
      repaint();
      
   }
   
   /* Paints the components
    * @param g the default swing parameter
    */
   public void paintComponent(Graphics g) {
      
      //super.paintComponent(g);
      g.drawLine(30, 100, 800, 100);
   }
}
