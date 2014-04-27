package gui_launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.VerticalLayout;

import com.Hemixos.Model;

public class InitProgram {

	private static ArrayList<JLabel> alMenu;
	private static JPanel jpMenu;
	private static JPanel jpContent;
	
	private static Color bg = new Color(52, 56, 59);
	static Color contentBgColor = new Color(45, 77, 100);
	private static Color buttonColor = new Color(90, 154, 200);
	private static JDialog d;
	
	private static JFrame pFrame;
	private static Model pModel;
	private static Main_guiLauncher pMgl;
	private static int menuPosition;
	static Color colorContentText = new Color(245, 245, 245);

	public static void showSimpleDialog(JFrame frame, Model model, Main_guiLauncher mgl) {
		
		pFrame = frame;
		pModel = model;
		pMgl = mgl;
		
		// INIT
		d = new JDialog(frame, "Configuration", true);
		d.setSize(800, 600);
		d.getContentPane().setLayout(new BorderLayout());
		d.getContentPane().setBackground(contentBgColor);
		
		jpMenu = new JPanel(new VerticalLayout(10));
		jpMenu.setBackground(bg);
		jpMenu.setPreferredSize(new Dimension(200, 100));
		jpMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		jpContent = new JPanel(new BorderLayout());
		jpContent.setBackground(contentBgColor);
				
		newMenuItem("Welcome");
		newMenuItem("Google Music");
		
		menuPosition = 0;
		repMenu(menuPosition);

		d.add(jpMenu, BorderLayout.WEST);
		d.add(jpContent, BorderLayout.CENTER);

		initWelcome();
		
		d.setLocationRelativeTo(null);
		d.setVisible(true);
				
	}

	
	
	/*
	 * MENU
	 */	
	
	protected static void initWelcome() {
		
		jpContent.removeAll();
		jpContent.add(JPContent_Welcome.DrawMe());
		
		JPanel mn = InitProgram.getBottomMenu();
		JButton jbNext = InitProgram.addButtonToMenuJP(mn, "Next");
		
		jbNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repMenu(++menuPosition);
				InitProgram.initGoogleMusic();
			}
		});

		jpContent.add(mn, BorderLayout.SOUTH);
		
		
		jpContent.revalidate();
		jpContent.repaint();

	}


	protected static void initGoogleMusic() {

		jpContent.removeAll();
		final JPContent_GoogleMusic jpConnectGMContent = new JPContent_GoogleMusic(pModel, pMgl);
		jpContent.add(jpConnectGMContent);
		
		JPanel mn = InitProgram.getBottomMenu();
		JButton jbBack = InitProgram.addButtonToMenuJP(mn, "Back");
		jbBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repMenu(--menuPosition);
				InitProgram.initWelcome();
			}
		});
		
		JButton jbConnectToGM = InitProgram.addButtonToMenuJP(mn, "Connect and dowload Google Music library");
		jbConnectToGM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//repMenu(++menuPosition);
				if(jpConnectGMContent.loadMyLib())
					close();
			}
		});
		
		jpContent.add(mn, BorderLayout.SOUTH);
		
		jpContent.revalidate();
		jpContent.repaint();
		
	}
	
	
	/*
	 * UTILS
	 */
	
	static JPanel getBottomMenu() {

		JPanel jptr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jptr.setBackground(contentBgColor);
		jptr.setPreferredSize(new Dimension(100, 80));
		jptr.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 50));
		
		return jptr;
	}

	
	static JButton addButtonToMenuJP(JPanel jp, String text) {
		
		JButton jbtr = new JButton(text);
		jbtr.setForeground(Color.WHITE);
		jbtr.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jbtr.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
		jbtr.setBackground(buttonColor);
		
		jp.add(jbtr);
		
		return jbtr;
		
	}
	
	
	private static void newMenuItem(String text) {

		if (alMenu == null) {
			alMenu = new ArrayList<JLabel>();
		}

		JLabel jlm = new JLabel(text);
		jlm.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		jlm.setForeground(colorContentText);

		alMenu.add(jlm);
		jpMenu.add(jlm);

	}
	
	protected static void repMenu(int menuPosition) {
		int i = 0;
		for (JLabel jli : alMenu) {
			if (i == menuPosition) {
				jli.setFont(new Font("Segoe UI", Font.BOLD, 13));
			} else {
				jli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			}
			i++;
		}
		
		jpMenu.revalidate();
		jpMenu.repaint();
		
	}
	
	
	static void close() {
		// Close window
		d.setVisible(false);
		d.dispose();
	}

}
