package gui_music_manager;

import gui_generic_components.AbstractBorder_playlist;
import gui_generic_components.ListenerJpSlider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdesktop.swingx.VerticalLayout;

import util.StringTransform;
import util.TimeUtil;
import library.Song;

import com.Hemixos.Model;

public class Gmm_Playlist extends JPanel {

	private static final long serialVersionUID = 1L;

	private Model model;
	private JPanel plContainer;

	/**
	 * Constructor
	 * @param model
	 */
	public Gmm_Playlist(Model model, JPanel playlistContainer) {
		this.model = model;
		this.plContainer = playlistContainer;
	}
	
	
	public void update() {
		
		plContainer.removeAll();
		
		
		/*
		 *  Add recap
		 */
		JPanel PlayingListRecap = new JPanel();
		JPanel jpPlaylistRecapBorder = new JPanel();
		JPanel jpContent = new JPanel(new VerticalLayout());
		Label label1 = new Label();
		Label label2 = new Label();
		
		//======== PlayingListElement ========
		PlayingListRecap.setBackground(new Color(245, 245, 245));
		PlayingListRecap.setBorder(new MatteBorder(1, 0, 2, 0, new Color(230, 230, 230)));
		PlayingListRecap.setLayout(new BorderLayout());

		//======== jpPlaylistElementBorder ========
		
		jpPlaylistRecapBorder.setPreferredSize(new Dimension(12, 50));
		jpPlaylistRecapBorder.setBorder(new AbstractBorder_playlist());
		jpPlaylistRecapBorder.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		jpPlaylistRecapBorder.setLayout(new BorderLayout());
		
		jpPlaylistRecapBorder.addMouseListener(new ListenerJpSlider(model));
		jpPlaylistRecapBorder.addMouseMotionListener(new ListenerJpSlider(model));
		
		PlayingListRecap.add(jpPlaylistRecapBorder, BorderLayout.WEST);

		//---- label 1 ----
		label1.setText("Total tracks : " + model.getMp().getQueue().sizeQueue());
		label1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label1.setForeground(new Color(0, 11, 42));
		jpContent.add(label1);
		
		//---- label 2 ----
		label2.setText("Total time : " + model.getMp().getQueue().getTotalTime());
		label2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label2.setForeground(new Color(0, 11, 42));
		jpContent.add(label2);
		
		jpContent.setBackground(new Color(245, 245, 245));
		PlayingListRecap.add(jpContent);
		
		plContainer.add(PlayingListRecap);	
		
		
		/*
		 *  Add all songs		
		 */
		for (Song s : model.getMp().getQueue().getQueue()) {
		
			JPanel PlayingListElement = new JPanel();
			JPanel jpPlaylistElementBorder = new JPanel();
			Label label5 = new Label();
			Label label4 = new Label();
			
			//======== PlayingListElement ========
			PlayingListElement.setBackground(new Color(245, 245, 245));
			PlayingListElement.setBorder(new MatteBorder(1, 0, 1, 0, new Color(230, 230, 230)));
			PlayingListElement.setLayout(new BorderLayout());
	
			//======== jpPlaylistElementBorder ========
			
			jpPlaylistElementBorder.setPreferredSize(new Dimension(12, 35));
			jpPlaylistElementBorder.setBorder(new AbstractBorder_playlist());
			jpPlaylistElementBorder.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
			jpPlaylistElementBorder.setLayout(new BorderLayout());
			
			jpPlaylistElementBorder.addMouseListener(new ListenerJpSlider(model));
			jpPlaylistElementBorder.addMouseMotionListener(new ListenerJpSlider(model));
			
			PlayingListElement.add(jpPlaylistElementBorder, BorderLayout.WEST);
	
			//---- label5 ----
			label5.setText(s.getArtist().getArtistName() + " - " + s.getTitle());
			if (model.getMp().getPlayingSong() != null && s.getId() == model.getMp().getPlayingSong().getId()) {
				label5.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
			} else {
				label5.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
			}
			label5.setForeground(new Color(0, 11, 42));
			PlayingListElement.add(label5, BorderLayout.CENTER);
	
			//---- label4 ----
			label4.setText(StringTransform.milliSecToString(s.getDurationMillis()));
			//label4.setBorder(new EmptyBorder(5, 10, 5, 10));
			label4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			label4.setForeground(new Color(0, 11, 42));
			PlayingListElement.add(label4, BorderLayout.EAST);
			
			plContainer.add(PlayingListElement);	

		}
		
		plContainer.revalidate();
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.orange);  
		
		System.out.println("Nbr pistes : " + model.getMp().getQueue().sizeQueue());
		g.drawString("Nbr pistes : " + model.getMp().getQueue().sizeQueue(), 5, 5);
		
	}
	
}
