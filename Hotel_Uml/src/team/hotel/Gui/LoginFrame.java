package team.hotel.Gui;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import team.hotel.action.ReceptionistAction;
import team.hotel.bean.Admin;


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
	private JButton canel_button;
	private JButton login_button;
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
					{
						login_button = new JButton();
						mainPanel.add(login_button);
						login_button.setText("jButton1");
						login_button.setBounds(51, 231, 62, 24);
						login_button.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								//JOptionPane.showMessageDialog(null, "请输入用户名！");
								//System.out.println("login_button.mouseClicked, event="+evt);
								//TODO add your code for login_button.mouseClicked
							/*
							 * 登陆相关
							 * 
							 * */
								Admin admin = new Admin();
								
								if(admin_01.isSelected())
								{
									admin.setAdminType(0);
								}
								else if(admin_02.isSelected())
								{
									admin.setAdminType(1);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "请选择登陆类型！");
									return;
								}
								if ((username.getText()) == null
										|| (username.getText().trim()).equals("")) {
									JOptionPane.showMessageDialog(null, "请输入用户名！");
									return;
								}else
								{
									admin.setAdminName(username.getText().toString());
								}

								if ((password.getText()) == null
										|| password.getText().trim().equals("")) {
									JOptionPane.showMessageDialog(null, "请输入密码！");
									return;
								}else
								{
									admin.setPassword(password.getText().toString());
								}
								
								if(admin.getAdminType()==1)
								{
									admin = new ReceptionistAction().ReceptionistLoginView(admin);
								}
								else
								{
									JOptionPane.showMessageDialog(null, "暂未开通");
									//admin = new ReceptionistAction().ReceptionistLoginView(admin);
								}
								
								
								if(admin.getPassword()!=null)
								{
									JOptionPane.showMessageDialog(null, "登陆成功");
								}

								
								
								

								
							}
						});
						login_button.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								try {
									finalize();
								} catch (Throwable e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("login_button.keyReleased, event="+evt);
								//TODO add your code for login_button.keyReleased
							}
						});
					}
					{
						canel_button = new JButton();
						mainPanel.add(canel_button);
						canel_button.setText("jButton1");
						canel_button.setBounds(176, 231, 62, 24);
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
