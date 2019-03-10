package GUI;
import model.*;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
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
public class ChangeUsernamePanel extends JPanel {
   
   //Properties
   private JFrame topFrame;
   private JTextField usernameField;
   private JPasswordField passwordField;
   private boolean addedLblThisUsernameHas;
   private boolean addedLblWrongPassword;
   private boolean addedLblEmptyError;
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public ChangeUsernamePanel(JFrame frame) {
      
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
      
      JLabel lblChangePassword = new JLabel("> Change Username");
      lblChangePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
      lblChangePassword.setBounds(332, 45, 236, 31);
      add(lblChangePassword);
      
      JLabel lblNewLabel = new JLabel("New Username");
      lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewLabel.setBounds(231, 322, 114, 16);
      add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("Password");
      lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewLabel_1.setBounds(272, 382, 87, 16);
      add(lblNewLabel_1);
      
      //create prompting labels
      JLabel lblThisUsernameHas = new JLabel("This username has been taken before!");
      lblThisUsernameHas.setForeground(new Color(255, 0, 0));
      lblThisUsernameHas.setBounds(400, 290, 300, 16);
      addedLblThisUsernameHas = false;
      
      JLabel lblWrongPassword = new JLabel("You entered wrong password!");
      lblWrongPassword.setForeground(new Color(255, 0, 0));
      lblWrongPassword.setBounds(400, 355, 300, 16);
      addedLblWrongPassword = false;
      
      JLabel lblEmptyError = new JLabel("User name and password can not be empty!");
      lblEmptyError.setForeground(new Color(255, 0, 0));
      lblEmptyError.setBounds(400, 290, 300, 16);
      addedLblEmptyError = false;
      
      JLabel lblSuccessfulChange = new JLabel("Your username has been changed successfully!");
      lblSuccessfulChange.setForeground(Color.GREEN);
      lblSuccessfulChange.setBounds(400, 290, 300, 16);
      
      //create text field and password field
      usernameField = new JTextField();
      usernameField.setBounds(400, 316, 200, 30);
      add(usernameField);
      usernameField.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setBounds(400, 377, 200, 30);
      add(passwordField);
      
      
      //create change user name button and add listener to it
      JButton btnChangeUsername = new JButton("Change Username");
      btnChangeUsername.setBounds(321, 455, 149, 29);
      btnChangeUsername.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            boolean checkEmpty = ( ( usernameField.getText().length() == 0 ) || ( passwordField.getText().length() == 0 ) );
            System.out.println(checkEmpty);
            //check if the username and password fields are empty or not 
            if( !checkEmpty ) {
               
               boolean checkUsername = ((ExternalInvestors)topFrame).getAccountContainer().checkIfUsernameExist( usernameField.getText() );
               boolean checkPassword = ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().checkPassword(passwordField.getText());
               
               //if empty error is added, remove it
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
               //if password is wrong, then warn the user
               if( !checkPassword )  {
                  add(lblWrongPassword);
                  addedLblWrongPassword = true;
               }
               else if( addedLblThisUsernameHas ) {
                  remove(lblWrongPassword);
                  addedLblWrongPassword = false;
               }
               //if every condition is satisfied then change password and inform the user
               if( !checkUsername && checkPassword ) {
                  ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().setUserName(usernameField.getText());
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
      add(btnChangeUsername);
      
      //Create back button add add it a listener that turns into previous page
      JButton btnBack = new JButton("Back");
      btnBack.setBounds(24, 130, 95, 21);
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
