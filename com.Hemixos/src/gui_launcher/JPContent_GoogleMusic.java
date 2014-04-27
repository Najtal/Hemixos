package gui_launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import layer_manager.ApiManager;

import org.jdesktop.swingx.VerticalLayout;

import properties.AbstractColors;
import properties.AbstractImages;
import properties.AbstractPropKey;
import properties.AbstractValues;

import com.Hemixos.Model;

public class JPContent_GoogleMusic extends JPanel {

	
	private Model model;

	
	private JLabel jladdLibrary;
	
	private JLabel jlUserName;
	private JTextField jtfUserName;
	
	private JLabel jlPassword;
	private JPasswordField jtfPassword;
	
	private JLabel jlName;
	private JTextField jtfName;
	
	private JButton jbConnexion;
	private JButton jbCancel;

	JLabel logMessage;

	private Main_guiLauncher mgl;

	private JPanel container;
	private JLabel jlInfotext;

	
	/**
	 * Creates a JPanel with the needed input fields to register a new library
	 * @param model
	 * @param main_guiLauncher 
	 */
	public JPContent_GoogleMusic(Model model, Main_guiLauncher mgl) {
		
		this.model = model;
		this.mgl = mgl;
		
		this.setBackground(InitProgram.contentBgColor);
		
		/*
		 *  MAIN CONTAINER
		 */
		this.setBackground(InitProgram.contentBgColor);
		container = new JPanel(new VerticalLayout(15));
		container.setBackground(InitProgram.contentBgColor);
		container.setBorder(BorderFactory.createEmptyBorder(AbstractValues.CONTAINER_BORDER, 
				AbstractValues.CONTAINER_BORDER, AbstractValues.CONTAINER_BORDER, 
				AbstractValues.CONTAINER_BORDER));
		
		
		// Title
		jladdLibrary = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_TITLE));
		jladdLibrary.setFont(new Font("Segoe UI", Font.BOLD, AbstractValues.OPTION_FRAME_TITLE_SIZE));
		jladdLibrary.setForeground(Color.WHITE);

		container.add(jladdLibrary);
		
		
		/*
		 *  INPUT CONTAINER
		 */
		
		// Name
		JPanel jpName = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		jpName.setBackground(InitProgram.contentBgColor);
		jlName = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_NAME));
		jlName.setForeground(InitProgram.colorContentText);
		jtfName = new JTextField();
		jtfName.setPreferredSize(new Dimension(300, 40));
		jtfName.setBorder(null);
		
		container.add(jlName);
		container.add(jtfName);
		container.add(new JLabel());
		
		// Username
		JPanel jpUser = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		jpUser.setBackground(InitProgram.contentBgColor);
		jlUserName = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_USERNAME));
		jlUserName.setForeground(InitProgram.colorContentText);
		jtfUserName = new JTextField("@gmail.com");
		jtfUserName.setPreferredSize(new Dimension(300, 40));
		jtfUserName.setBorder(null);
		
		container.add(jlUserName);
		container.add(jtfUserName);
		container.add(new JLabel());

		
		// Password
		JPanel jpPwd = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		jpPwd.setBackground(InitProgram.contentBgColor);
		jlPassword = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_PASSWORD));
		jlPassword.setForeground(InitProgram.colorContentText);
		jtfPassword = new JPasswordField();
		jtfPassword.setPreferredSize(new Dimension(300, 40));
		jtfPassword.setBorder(null);
		
		container.add(jlPassword);
		container.add(jtfPassword);

		container.add(new JLabel());
		jlInfotext = new JLabel("");
		jlInfotext.setForeground(new Color(255, 200, 0));
		jlInfotext.setFont(new Font("Segoe UI", Font.BOLD, 16));
        container.add(jlInfotext);

		
		this.add(container, BorderLayout.WEST);
		
		// Buttons
		/*JPanel jpButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 15));
		
		jbConnexion = new JButton(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_CONNEXION));
		jpButtons.add(jbConnexion);
		jbConnexion.addActionListener(this);	

		jbCancel = new JButton(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_CANCEL));
		jpButtons.add(jbCancel);
		jbCancel.addActionListener(this);

		container.add(jpButtons, BorderLayout.SOUTH);
		
		this.add(container);
		*/
		
		// log message
		/*logMessage = new JLabel();
		logMessage.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 12));
		logMessage.setForeground(AbstractColors.LAUNCHER_NEW_LIB_INFO);
		this.add(logMessage, BorderLayout.SOUTH);*/
		
	}
	
	void message(String txt) {
				
		this.jlInfotext.setText(txt);
		this.repaint();
		this.revalidate();
	}


	
	
	/*
	 * Lorsqu'un bouton est appelé
	 *
	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbConnexion) {
			loadMyLib();			
		} else {
			System.exit(1);
		}
		
	}*/


	
	
	/**
	 * Methode appelee lorsqu'on veut se connecter
	 */
	boolean loadMyLib() {
		
		jtfName.setEnabled(false);
		jtfUserName.setEnabled(false);
		jtfPassword.setEnabled(false);
		
		String nom = jtfName.getText();
		String un = jtfUserName.getText();
		String mdp = new String(jtfPassword.getPassword());
		
		if (nom.length() < 1 || un.length() < 10 || mdp.length() < 3) {
			message(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_WRONG_VALUE));
			return false;
		}
		
		// On se connecte
		try {
			message("Test connection...");
			ApiManager a = new ApiManager(un, mdp);
			model.getMd().setGm(a);
			message("Connection succeeded !");
		} catch (Exception e) {
			message("Unable to connect to your account.");
			jtfName.setEnabled(true);
			jtfUserName.setEnabled(true);
			jtfPassword.setEnabled(true);
			return false;
		}
		
		//InitProgram.close();
		
		mgl.newLibraryConnected(nom, un, mdp);
		
		return true;
	}
	
	
	
	

}
