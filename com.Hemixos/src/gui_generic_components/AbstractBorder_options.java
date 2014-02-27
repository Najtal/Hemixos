package gui_generic_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

import properties.AbstractColors;

public class AbstractBorder_options implements Border {

	
	private int epaisseur = 13;
	private Color bg_color = AbstractColors.GUI_OPTION_BACKGROUND;
	private Color bg_color_limit = AbstractColors.GUI_OPTION_BORDER_LEFT;


	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	    int i;
	    g.setColor(bg_color);
	    
	    for (i = 1; i < epaisseur; i++) {
		    
	    	g.setColor(new Color(bg_color.getRed()-2*i, bg_color.getGreen()-2*i, bg_color.getBlue()-2*i));
		    g.drawLine(x+epaisseur-i, y, x+epaisseur-i, y+height);
	      
	    }
	    
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
	   * Returns the color of the border.
	   */
	  public Color getLineColor() {
	    return bg_color;
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
