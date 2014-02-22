package gui_generic_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

import properties.AbstractColors;

public class AbstractBorder_vues implements Border {

	@Override
	public Insets getBorderInsets(Component c) {
		return null;
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

	    g.setColor(AbstractColors.GUI_OP_BORDER_LEFT);
		g.drawLine(x, y, x+width-1, y);
	
		
	}

	
	
}
