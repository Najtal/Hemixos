package gui_generic_components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 * 
 * Cette classe crée des instances de JScrollBarUI custom
 * 
 * @author Jean-Vital
 * 
 */
public class CustomJScrollBar extends MetalScrollBarUI {

	
	
	private static final int SCROLL_BAR_ALPHA_ROLLOVER = 150;
	private static final int SCROLL_BAR_ALPHA = 100;
	private static final int THUMB_BORDER_SIZE = 2;
	private static final int THUMB_SIZE = 8;
	private static final Color THUMB_COLOR = Color.BLACK;
	
	private Color cBackground;
	
	private int dh = 0;


	// sb.setUI(new MyScrollbarUI());

	private Image imageThumb, imageTrack;

	public CustomJScrollBar(Color cb) {
		//this.cBackground = new Color(cb.getRed(), cb.getGreen(), cb.getBlue(), 0);
		this.cBackground = cb;
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c,
			Rectangle thumbBounds) {

		int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER
				: SCROLL_BAR_ALPHA;

		int orientation = scrollbar.getOrientation();
		int arc = THUMB_SIZE;
		int x = thumbBounds.x + THUMB_BORDER_SIZE;
		int y = thumbBounds.y + THUMB_BORDER_SIZE;

		int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE
				: thumbBounds.width - (THUMB_BORDER_SIZE * 2);
		width = Math.max(width, THUMB_SIZE);

		int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height
				- (THUMB_BORDER_SIZE * 2)
				: THUMB_SIZE;
		height = Math.max(height, THUMB_SIZE);

		Graphics2D graphics2D = (Graphics2D) g.create();
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR
				.getGreen(), THUMB_COLOR.getBlue(), alpha));
		if (orientation == JScrollBar.VERTICAL)
			height += dh;

		graphics2D.fillRoundRect(x, y, width, height, arc, arc);
		graphics2D.dispose();
	}

	
	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new MyScrollBarButton();
	}// ======================================

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return new MyScrollBarButton();
	}// ======================================

	@Override
	protected void paintTrack(Graphics g, JComponent c,
			Rectangle trackBounds) {

		g.setColor(cBackground);
		g.translate(trackBounds.x, trackBounds.y);
		g.fillRect(0, 0, trackBounds.width, trackBounds.height);
		g.translate(-trackBounds.x, -trackBounds.y);
	}
	
	private static class MyScrollBarButton extends JButton {
		private MyScrollBarButton() {
			setOpaque(false);
			setFocusable(false);
			setFocusPainted(false);
			setBorderPainted(false);
			setBorder(BorderFactory.createEmptyBorder());
		}
	}
	
	
}
