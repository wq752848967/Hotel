package team.hotel.Gui;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoginFrame extends javax.swing.JFrame {
	private JPanel background;
	private JPanel mainPanel;
	private JTextField username;
	private JLabel l_password;
	private ButtonGroup group_01;
	private JPanel radiogroup;
	private JRadioButton admin_02;
	private JRadioButton admin_01;
	private JLabel l_username;
	private JTextField password;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame inst = new LoginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				background = new JPanel();
				getContentPane().add(background, BorderLayout.CENTER);
				background.setLayout(null);
				{
					mainPanel = new JPanel();
					background.add(mainPanel);
					mainPanel.setBounds(233, 64, 279, 266);
					mainPanel.setLayout(null);
					mainPanel.setBackground(new java.awt.Color(255,255,255));
					{
						username = new JTextField();
						mainPanel.add(username);
						username.setBounds(133, 122, 112, 24);
					}
					{
						password = new JTextField();
						mainPanel.add(password);
						password.setBounds(133, 192, 112, 24);
					}
					{
						l_username = new JLabel();
						mainPanel.add(l_username);
						l_username.setText("\u5e10\u53f7\uff1a");
						l_username.setBounds(51, 129, 41, 17);
					}
					{
						l_password = new JLabel();
						group_01 = new ButtonGroup();
						mainPanel.add(l_password);
						l_password.setText("\u5bc6\u7801\uff1a");
						l_password.setBounds(51, 195, 41, 17);
					}
					{
						radiogroup = new JPanel();
						mainPanel.add(radiogroup);
						radiogroup.setBounds(49, 65, 137, 34);
						radiogroup.setBorder(BorderFactory.createTitledBorder(""));
						{
							admin_01 = new JRadioButton();
							radiogroup.add(admin_01);
							group_01.add(admin_01);
							admin_01.setText("\u7ecf\u7406");
						}
						{
							admin_02 = new JRadioButton();
							group_01.add(admin_02);
							radiogroup.add(admin_02);
							admin_02.setText("\u804c\u5de5");
						}
					}
				}
			}
			pack();
			this.setSize(551, 381);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
