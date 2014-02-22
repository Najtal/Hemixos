package properties;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import exceptions.FatalException;

public class AbstractImages {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Instance
	 */
	public static AbstractImages instance;

	
	/*
	 * Images
	 */
	public Icon ICON_ERROR;
	public ImageIcon ICON_COIN_GAUCHE;
	public ImageIcon iNew;
	
	public Icon GUI_PLAYER_PREVIOUS;
	public Icon GUI_PLAYER_NEXT;
	public Icon GUI_PLAYER_PLAY;
	public Icon GUI_PLAYER_PAUSE;

	public Icon GUI_PLAYER_W_MIN;
	public Icon GUI_PLAYER_W_MAX;
	public Icon GUI_PLAYER_W_ESCAPE;
	public Icon GUI_PLAYER_TOUCH;
	public Icon GUI_PLAYER_OPTION;
	
	public Icon GUI_PLAYER_RANDOM;
	public Icon GUI_PLAYER_REPEAT;
	public Icon GUI_PLAYER_RANDOM_SELECTED;
	public Icon GUI_PLAYER_REPEAT_SELECTED;
	
	public Icon GUI_PLAYER_VOLET;
	public Icon GUI_PLAYER_VOLET_SELECTED;
	public Icon GUI_PLAYER_ADDPLAYLIST;
	public Icon GUI_PLAYER_ADDPLAYLIST_SELECTED;

	public Icon GUI_VIEW_SIMPLE_LIST;
	public Icon GUI_VIEW_ONE_LIST;
	public Icon GUI_VIEW_TWO_LIST;
	public Icon GUI_VIEW_THREE_LIST;
	public Icon GUI_VIEW_SIMPLE_LIST_SELECTED;
	public Icon GUI_VIEW_ONE_LIST_SELECTED;
	public Icon GUI_VIEW_TWO_LIST_SELECTED;
	public Icon GUI_VIEW_THREE_LIST_SELECTED;


	
	
	/**
	 * Initializer
	 */
	public static void initialize() {
		instance = new AbstractImages();
	}


	/**
	 * Constructor
	 * Init the Images
	 */
	private AbstractImages() {
		try {
			
			ICON_ERROR = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_error.png")));
			
			ICON_COIN_GAUCHE = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_coinGauche.png")));
			
			
			
			GUI_PLAYER_PREVIOUS = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_previous.jpg")));
			
			GUI_PLAYER_NEXT = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_next.jpg")));
			
			GUI_PLAYER_PLAY = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_play.jpg")));
			
			GUI_PLAYER_PAUSE = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_pause.jpg")));
			
			
			
			GUI_PLAYER_W_MIN = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_w_min.jpg")));
			
			GUI_PLAYER_W_MAX = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_w_max.jpg")));
			
			GUI_PLAYER_W_ESCAPE = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_w_escape.jpg")));
			
			GUI_PLAYER_TOUCH = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_touch.jpg")));
			
			GUI_PLAYER_OPTION = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_options.jpg")));

			
			
			GUI_PLAYER_RANDOM = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_random.jpg")));
			
			GUI_PLAYER_REPEAT = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_repeat.jpg")));
			
			GUI_PLAYER_RANDOM_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_randomSelected.jpg")));
			
			GUI_PLAYER_REPEAT_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_repeatSelected.jpg")));
			
			
			
			GUI_PLAYER_VOLET = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_volet.jpg")));
			
			GUI_PLAYER_VOLET_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_volet_selected.jpg")));
			
			GUI_PLAYER_ADDPLAYLIST = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_addplaylist.jpg")));
			
			GUI_PLAYER_ADDPLAYLIST_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_addplaylist_selected.jpg")));
			
			
			
			GUI_VIEW_SIMPLE_LIST = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_simpleList.jpg")));
			
			GUI_VIEW_ONE_LIST = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_oneList.jpg")));
			
			GUI_VIEW_TWO_LIST = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_twoList.jpg")));
			
			GUI_VIEW_THREE_LIST = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_threeList.jpg")));
			
			GUI_VIEW_SIMPLE_LIST_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_simpleListSelected.jpg")));
			
			GUI_VIEW_ONE_LIST_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_oneListSelected.jpg")));
			
			GUI_VIEW_TWO_LIST_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_twoListSelected.jpg")));
			
			GUI_VIEW_THREE_LIST_SELECTED = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/ico_threeListSelected.jpg")));
			
			
			
			/*
			iNew = new ImageIcon(ImageIO.read(this.getClass()
					.getResourceAsStream("/images/icon_New.png")));
			iNew = new ImageIcon(iNew.getImage().getScaledInstance(
					30,	30,	java.awt.Image.SCALE_SMOOTH));*/

		} catch (IOException e) {
			throw new FatalException("Loading the images have failed");
		}
	}

	
	
	

	
}
