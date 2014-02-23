package gui_generic_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

import properties.AbstractColors;

public class AbstractBorder_InfoPanel implements Border {

	
	private int epaisseur = 1;
	private Color bg_color_limit = AbstractColors.GUI_MN_BORDER_RIGHT;


	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	    g.setColor(bg_color_limit);
	    
	    g.setColor(Color.red);
	    //g.drawLine(x, y-1, x+width, y-1);
	    
	    g.drawLine(x, y+1, x+width, y+1);

	  }
	
	
	  public Insets getBorderInsets(Component c) {
	    return new Insets(0, 0, epaisseur, 0);
	  }
	  
	  
	  public Insets getBorderInsets(Component c, Insets insets) {
	    insets.left = 0;
	    insets.top = 0;
	    insets.right = epaisseur;
	    insets.bottom = 0;
	    return insets;
	  }
	  
	   
	  
	  /**
	   * Returns the thickness of the border.
	   */
	  public int getThickness() {
	    return epaisseur;
	  }
	  
	  
	  /**
	   * Returns whether or not the border is opaque.
	   */
	  public boolean isBorderOpaque() {
	    return false;
	  }
	  
	  
	  public int getGap() {
	    return epaisseur;
	  }
	  
	  
	}
