package gui_music_manager;

import gui_generic_components.ListenerFrameResize;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JWindow;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import properties.AbstractImages;
import properties.AbstractValues;

import com.Hemixos.Model;
import com.Hemixos.Model_window;


/**
 * Cette classe génère la fenêtre principale de l'interface
 * 
 * @author Jean-Vital
 *
 */
public class Gmm_Window extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;


	// Model
	private Model model;
	
	// Window Model
	private Model_window mw;
	

	
	/*
	 * Components
	 */
	private JPanel playerTop;
	private JPanel mainMenuLeft;
	private JPanel optionRight;
	private JPanel mainContentCenter;
	
	
	
	/**
	 * Constructeur
	 * @param model
	 */
	public Gmm_Window(Model model) {
	
		this.model = model;
		this.mw = model.getMw();
		this.model.getMw().addChangeListener(this);
		this.model.getMc().regJfFrame(this);

		mw.setFrame(this);

		// Frame config
		configFrame();

		// Init content element
		initElements();
		
		// Listeners
		this.addComponentListener(new ListenerFrameResize(model));
		this.setVisible(true);
		
	}


	private void configFrame() {
		
		this.setSize(new Dimension(model.getMw().getFrameWidth(), model.getMw().getFrameHeight()));
		//this.setUndecorated(true);
		//this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(AbstractValues.FRAME_MIN_WIDTH, AbstractValues.FRAME_MIN_HEIGHT));
		this.setResizable(true);
		
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				super.windowClosing(e);
				model.getMw().actionExit();
			}
		});

		// set frame icon
		final Image icon = AbstractImages.instance.ICON_COIN_GAUCHE.getImage();
		this.setIconImage(icon);
		this.setName(model.getMw().getAppName());
		this.setTitle(model.getMw().getAppName());	
		
	}



	private void initElements() {

		// player top
		this.playerTop = new Gmm_Player(model);
		
		// menu left
		this.mainMenuLeft = new Gmm_Menu(model);
		
		// content center
		this.mainContentCenter = new Gmm_Container(model);
		
		// option right
		this.optionRight = new Gmm_OptionList(model);
		
		// Add elements
		this.add(playerTop, BorderLayout.NORTH);
		this.add(mainMenuLeft, BorderLayout.WEST);
		this.add(optionRight, BorderLayout.EAST);
		this.add(mainContentCenter, BorderLayout.CENTER);

	}


	@Override
	public void stateChanged(ChangeEvent e) {
		revalidate();
	}
	
	
}
