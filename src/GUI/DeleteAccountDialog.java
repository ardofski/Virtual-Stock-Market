/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import model.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteAccountDialog.
 */
public class DeleteAccountDialog extends JDialog {

	/** The content panel. */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			DeleteAccountDialog dialog = new DeleteAccountDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteAccountDialog() {
		setBounds(100, 100, 250, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYourAcoountWill = new JLabel("Your account will be deleted");
			lblYourAcoountWill.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblYourAcoountWill.setBounds(30, 18, 214, 38);
			contentPanel.add(lblYourAcoountWill);
		}
		{
			JLabel lblAreYouSure = new JLabel("Are you sure?");
			lblAreYouSure.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblAreYouSure.setBounds(78, 55, 109, 38);
			contentPanel.add(lblAreYouSure);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
