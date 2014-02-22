package gui_launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import properties.AbstractColors;
import properties.AbstractPropKey;
import properties.AbstractValues;

import com.Hemixos.Model;

public class NewLib extends JPanel implements ActionListener {

	
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

	private Main_guiLauncher gui_parent;

	
	
	/**
	 * Creates a JPanel with the needed input fields to register a new library
	 * @param model
	 * @param main_guiLauncher 
	 */
	public NewLib(Model model, Main_guiLauncher main_guiLauncher) {
		
		this.model = model;
		this.gui_parent = main_guiLauncher;
		
		/*
		 *  MAIN CONTAINER
		 */
		JPanel container = new JPanel(new BorderLayout());
		container.setBorder(BorderFactory.createEmptyBorder(AbstractValues.CONTAINER_BORDER, 
				AbstractValues.CONTAINER_BORDER, 0, 
				AbstractValues.CONTAINER_BORDER));
		
		
		// Title
		jladdLibrary = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_TITLE));
		jladdLibrary.setFont(new Font("Segoe UI", Font.BOLD, AbstractValues.OPTION_FRAME_TITLE_SIZE));
		jladdLibrary.setForeground(AbstractColors.MAIN_TITLE);

		container.add(jladdLibrary, BorderLayout.NORTH);
		
		
		/*
		 *  INPUT CONTAINER
		 */
		JPanel jpInput = new JPanel(new GridLayout(3, 1, 20, 10));
		jpInput.setBorder(BorderFactory.createEmptyBorder(AbstractValues.CONTAINER_BORDER, 0, 0, 0));
		
		// Name
		JPanel jpName = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		jlName = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_NAME));
		jtfName = new JTextField();
		jtfName.setPreferredSize(new Dimension(150, 20));

		
		jpName.add(jlName);
		jpName.add(jtfName);
		jpInput.add(jpName);
		
		
		// Username
		JPanel jpUser = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		jlUserName = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_USERNAME));
		jtfUserName = new JTextField("@gmail.com");
		jtfUserName.setPreferredSize(new Dimension(150, 20));
		
		jpUser.add(jlUserName);
		jpUser.add(jtfUserName);
		jpInput.add(jpUser);

		
		
		// PAssword
		JPanel jpPwd = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		jlPassword = new JLabel(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_PASSWORD));
		jtfPassword = new JPasswordField();
		jtfPassword.setPreferredSize(new Dimension(150, 20));
		
		jpPwd.add(jlPassword);
		jpPwd.add(jtfPassword);
		jpInput.add(jpPwd);
		
		
		container.add(jpInput, BorderLayout.CENTER);
		
		
		// Buttons
		JPanel jpButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 15));
		
		jbConnexion = new JButton(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_CONNEXION));
		jpButtons.add(jbConnexion);
		jbConnexion.addActionListener(this);	

		jbCancel = new JButton(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_CANCEL));
		jpButtons.add(jbCancel);
		jbCancel.addActionListener(this);

		container.add(jpButtons, BorderLayout.SOUTH);
		
		this.add(container);
		
		
		// log message
		logMessage = new JLabel();
		logMessage.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 12));
		logMessage.setForeground(AbstractColors.LAUNCHER_NEW_LIB_INFO);
		this.add(logMessage, BorderLayout.SOUTH);
		
	}


	
	
	/**
	 * Lorsqu'un bouton est appelé
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jbConnexion) {
			loadMyLib();			
		} else {
			System.exit(1);
		}
		
	}


	
	
	/**
	 * Methode appelee lorsqu'on veut se connecter
	 */
	private void loadMyLib() {

		logMessage.setText("");
		this.repaint();
		
		String nom = jtfName.getText();
		String un = jtfUserName.getText();
		String mdp = new String(jtfPassword.getPassword());
		
		if (nom.length() < 1 || un.length() < 10 || mdp.length() < 3) {
			logMessage.setText(model.getMw().getLangProperty(AbstractPropKey.NEW_LIBRARY_WRONG_VALUE));
			gui_parent.repaint();
			return;
		}
		
		gui_parent.createNewLib(nom, un, mdp);

	}



	

	
}
