package gui_music_manager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import properties.AbstractColors;
import properties.AbstractValues;
import util.StringTransform;

import com.Hemixos.Model;

public class Gmm_PlayerInfoLecture extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Model model;
	private int width;

	
	public Gmm_PlayerInfoLecture(Model model) {
		
		this.model = model;
		this.model.getMc().regJpInfo(this);
		
		//this.setBackground(AbstractColors.GUI_PL_BACKGROUND);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw Rectangle
		//g.setColor(AbstractColors.GUI_INFO_BORDER);
		//g.drawRoundRect(20, 15, model.getMw().getInfoWidth(), this.getHeight()-30, 8, 8);

		int playerWidth = 15+this.getHeight()-40;
		
		g.setColor(AbstractColors.GUI_INFO_NOT_PLAYED);
		g.fillRect(0, playerWidth, model.getMw().getInfoWidth()+2, 3);
		
		int infoWidth = model.getMw().getInfoWidth();
		
		/*
		 * length = 210000 (ms)
		 * played =  60000 (ms)
		 */
		long length = 	model.getMp().getTrackLength(); 
		long pos = 		model.getMp().getTrackLengthPlayed();
		
		if (length < 1) {
			length = 1;
			pos = 0;
		}
		int playedWidth = (int) ((int) (infoWidth*pos)/length);

		g.setColor(AbstractColors.GUI_INFO_PLAYED);
		g.fillRect(0, playerWidth, playedWidth, 3);
			
		
		if (!model.getMp().isEnLecture() && model.getMp().isBuffering()) {
			
			Font fTitle = new Font("Segoe UI Light", Font.BOLD, 18);
			String txt = "Buffering " + model.getMp().buffered();
			
			g.setFont(fTitle);
			g.setColor(AbstractColors.GUI_PL_INFO_TITLE);
			g.drawString(txt, infoWidth/2-txt.length()*3-40, 34);
			
		} else if (model.getMp().getPlayingSong() != null) {
			String title = model.getMp().getPlayingSong().getTitle();
			String artist = model.getMp().getPlayingSong().getArtist().getArtistName();
			
			String name = artist + " - " + title;
			
			Font fTitle = new Font("Segoe UI Light", Font.BOLD, 18);
			Font fTime = new Font("Segoe UI Light", 0, 12);

			g.setFont(fTitle);
			g.setColor(AbstractColors.GUI_PL_INFO_TITLE);
			g.drawString(name, infoWidth/2-name.length()*3-40, 34);
			
			if (model.getMp().isEnLecture()) {
				g.setFont(fTime);
				g.setColor(AbstractColors.GUI_PL_INFO_TIME);
				g.drawString(StringTransform.milliSecToString(model.getMp().getTrackLengthPlayed()), model.getMw().getBorderTampon()/4-20, 50);
				g.drawString(StringTransform.milliSecToString(model.getMp().getTrackLength()), infoWidth-model.getMw().getBorderTampon()/5-20, 50);			
			}
		}
		
		
		
		
	}
	

	

	

}
