package JFormDesigner;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import javax.swing.border.EmptyBorder;
import gui_generic_components.*;
import gui_music_manager.*;
import org.jdesktop.swingx.*;

/*
 * Created by JFormDesigner on Sun Feb 23 11:55:24 CET 2014
 */



/**
 * @author jv dudux
 */
public class ContentContainerMain extends JPanel {
	
	public ContentContainerMain() {
		initComponents();
	}

	public JPanel getJpHBMain() {
		return jpHBMain;
	}

	public JPanel getJpCenterHeader() {
		return jpCenterHeader;
	}

	public JPanel getJpHeaderSpacerLeft() {
		return jpHeaderSpacerLeft;
	}

	public JPanel getJpHeaderSpacerRight() {
		return jpHeaderSpacerRight;
	}

	public JXList getJlArtistes() {
		return jlArtistes;
	}

	public JTable getJtTracks() {
		return jtTracks;
	}

	public JButton getJbPrevious() {
		return jbPrevious;
	}

	public JButton getJbPausPlay() {
		return jbPausPlay;
	}

	public JButton getJbNext() {
		return jbNext;
	}

	public JButton getJbRandom() {
		return jbRandom;
	}

	public JButton getJbRepeat() {
		return jbRepeat;
	}

	public JXList getJlAlbums() {
		return jlAlbums;
	}

	public JButton getJbViewSimple() {
		return jbViewSimple;
	}

	public JButton getJbViewOneC() {
		return jbViewOneC;
	}

	public JButton getJbViewTwoC() {
		return jbViewTwoC;
	}

	public JButton getJbviewThreeC() {
		return jbviewThreeC;
	}

	public JPanel getJpAlbumslist() {
		return jpAlbumslist;
	}

	public JPanel getJpArtistlist() {
		return jpArtistlist;
	}

	public JButton getJbArtistsAll() {
		return jbArtistsAll;
	}

	public JButton getJbalbumAll() {
		return jbalbumAll;
	}

	public JScrollPane getSpArtist() {
		return spArtist;
	}

	public JScrollPane getSpPlaylistView() {
		return spPlaylistView;
	}

	public JScrollPane getSpAlbum() {
		return spAlbum;
	}

	public JScrollPane getJspTracks() {
		return jspTracks;
	}

	public JButton getJbPisteImage() {
		return jbPisteImage;
	}

	public JLabel getJlTitleValue() {
		return jlTitleValue;
	}

	public JLabel getJlArtistValue() {
		return jlArtistValue;
	}

	public JLabel getJlAlbumValue() {
		return jlAlbumValue;
	}

	public JLabel getJlDureeValue() {
		return jlDureeValue;
	}

	public JPanel getJpPlayingInfo() {
		return jpPlayingInfo;
	}

	public JPanel getJpOptions() {
		return jpOptions;
	}

	public JButton getJbOptions() {
		return jbOptions;
	}

	public JButton getJbVolet() {
		return jbVolet;
	}

	public JPanel getJpPlaylistListContainer() {
		return jpPlaylistListContainer;
	}

	public JButton getJbPlAdd() {
		return jbPlAdd;
	}

	public JPanel getJpPVBorder() {
		return jpPVBorder;
	}

	public JPanel getJpPVBorder3() {
		return jpPVBorder3;
	}

	public JPanel getJpPVBorder2() {
		return jpPVBorder2;
	}

	public JPanel getJpArtistResize() {
		return jpArtistResize;
	}

	public JPanel getJpPlaylistBorder() {
		return jpPlaylistBorder;
	}

	public JPanel getJpInfoPSBorder() {
		return jpInfoPSBorder;
	}

	public JPanel getJpAlbumResize() {
		return jpAlbumResize;
	}

	public JPanel getJpPlaylistViews() {
		return jpPlaylistViews;
	}

	public JPanel getJpTrackContainer() {
		return jpTrackContainer;
	}

	public JButton getJbAddSelectedArtist() {
		return jbAddSelectedArtist;
	}

	public JButton getJbAddSelectedAlbum() {
		return jbAddSelectedAlbum;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Dx jv
		jpHeader = new JPanel();
		jpLeftHeader = new JPanel();
		jlAppName = new JLabel();
		jpPlayButMenu = new JPanel();
		jbPrevious = new JButton();
		jbPausPlay = new JButton();
		jbNext = new JButton();
		jbRightHeader = new JPanel();
		jbOptions = new JButton();
		jpCenterHeader = new JPanel();
		jpHeaderSpacerLeft = new JPanel();
		jpHeaderSpacerRight = new JPanel();
		jpHeaderBoard = new JPanel();
		jpHBLectureOptions = new JPanel();
		jbRandom = new JButton();
		jbRepeat = new JButton();
		jpHBCustomOptions = new JPanel();
		jbVolet = new JButton();
		jbPlAdd = new JButton();
		jpHBMain = new JPanel();
		spPlaylistView = new JScrollPane();
		jpPlaylistViews = new JPanel();
		jpLibViewContainer = new JPanel();
		jpLibraryContainers = new JPanel();
		jpPVBorder = new JPanel();
		jpLibsViews = new JPanel();
		jlTitleMusiques = new JButton();
		jlLibs = new JList<>();
		jpViewsContainer = new JPanel();
		jpPVBorder3 = new JPanel();
		ViewsGridLayout = new JPanel();
		jbViewSimple = new JButton();
		jbViewOneC = new JButton();
		jbViewTwoC = new JButton();
		jbviewThreeC = new JButton();
		jpPlaylistContainer = new JPanel();
		jpPVBorder2 = new JPanel();
		panel2 = new JPanel();
		label3 = new JLabel();
		list1 = new JList<>();
		label2 = new JLabel();
		list2 = new JList<>();
		jpInfoOptionEast = new JPanel();
		jpPlayingInfo = new JPanel();
		jpPlaylistList = new JPanel();
		panel3 = new JPanel();
		jpPlaylistListContainer = new JPanel();
		PlayingListElement = new JPanel();
		jpPlaylistElementBorder = new JPanel();
		label5 = new JLabel();
		label4 = new JLabel();
		PlayingListElement2 = new JPanel();
		jpPlaylistElementBorder2 = new JPanel();
		label6 = new JLabel();
		label7 = new JLabel();
		jpPlaylistListSpacer = new JPanel();
		jpPlaylistBorder = new JPanel();
		jpInfoPlayingSong = new JPanel();
		jpInfoPSBorder = new JPanel();
		jpInfoPSContainer = new JPanel();
		jpImageContainer = new JPanel();
		jbPisteImage = new JButton();
		jpSpaceT = new JPanel();
		jpSpaceS = new JPanel();
		jpInfoTxt = new JPanel();
		jpInfoListTitle = new JPanel();
		jlTitle = new JLabel();
		jlArtist = new JLabel();
		jlAlbum = new JLabel();
		jlDuree = new JLabel();
		jpInfoListValue = new JPanel();
		jlTitleValue = new JLabel();
		jlArtistValue = new JLabel();
		jlAlbumValue = new JLabel();
		jlDureeValue = new JLabel();
		jpOptions = new JPanel();
		jpOptionHeader = new JPanel();
		jpOHBorder = new JPanel();
		jlOptionTitle = new JLabel();
		jpOptionBody = new JPanel();
		jpOBBorder = new JPanel();
		jpOBContent = new JPanel();
		jpOBSpacer = new JPanel();
		jpOBLine = new JPanel();
		jlOLine1 = new JLabel();
		cbOLine1 = new JCheckBox();
		panel1 = new JPanel();
		jpCenterMain = new JPanel();
		jpFilterContainer = new JPanel();
		jpArtistlist = new JPanel();
		jpArtistHead = new JPanel();
		jbArtistsAll = new JButton();
		label9 = new JLabel();
		spArtist = new JScrollPane();
		jlArtistes = new JXList();
		jpArtistResize = new JPanel();
		jpAlbumslist = new JPanel();
		jpAlbumHead = new JPanel();
		jbalbumAll = new JButton();
		label11 = new JLabel();
		spAlbum = new JScrollPane();
		jlAlbums = new JXList();
		jpAlbumResize = new JPanel();
		jpTrackContainer = new JPanel();
		jpSelectedTrackMenu = new JPanel();
		jpLectureMenu = new JPanel();
		jbAddSelectedArtist = new JButton();
		jbAddSelectedAlbum = new JButton();
		jpDisplayMenu = new JPanel();
		jspTracks = new JScrollPane();
		jtTracks = new JTable();

		//======== this ========
		setBackground(Color.white);

		setLayout(new BorderLayout());

		//======== jpHeader ========
		{
			jpHeader.setPreferredSize(new Dimension(0, 80));
			jpHeader.setBackground(new Color(52, 56, 59));
			jpHeader.setBorder(null);
			jpHeader.setLayout(new BorderLayout());

			//======== jpLeftHeader ========
			{
				jpLeftHeader.setBackground(new Color(52, 56, 59));
				jpLeftHeader.setOpaque(false);
				jpLeftHeader.setLayout(new HorizontalLayout());

				//---- jlAppName ----
				jlAppName.setText("Hemixos");
				jlAppName.setForeground(new Color(230, 230, 230));
				jlAppName.setFont(new Font("Segoe UI", Font.PLAIN, 9));
				jlAppName.setVerticalAlignment(SwingConstants.TOP);
				jlAppName.setBorder(new EmptyBorder(0, 5, 0, 10));
				jlAppName.setPreferredSize(new Dimension(50, 13));
				jlAppName.setBackground(new Color(52, 56, 59));
				jpLeftHeader.add(jlAppName);

				//======== jpPlayButMenu ========
				{
					jpPlayButMenu.setPreferredSize(new Dimension(150, 40));
					jpPlayButMenu.setBackground(new Color(245, 245, 243));
					jpPlayButMenu.setOpaque(false);
					jpPlayButMenu.setLayout(new HorizontalLayout());

					//---- jbPrevious ----
					jbPrevious.setIcon(new ImageIcon(getClass().getResource("/images/ico_prev48.png")));
					jbPrevious.setPreferredSize(new Dimension(25, 35));
					jbPrevious.setBackground(new Color(52, 56, 59));
					jbPrevious.setContentAreaFilled(false);
					jbPrevious.setBorderPainted(false);
					jbPrevious.setBorder(null);
					jbPrevious.setFocusPainted(false);
					jpPlayButMenu.add(jbPrevious);

					//---- jbPausPlay ----
					jbPausPlay.setIcon(new ImageIcon(getClass().getResource("/images/ico_play.png")));
					jbPausPlay.setPreferredSize(new Dimension(100, 35));
					jbPausPlay.setBackground(new Color(245, 245, 243));
					jbPausPlay.setContentAreaFilled(false);
					jbPausPlay.setBorderPainted(false);
					jbPausPlay.setBorder(null);
					jbPausPlay.setFocusPainted(false);
					jpPlayButMenu.add(jbPausPlay);

					//---- jbNext ----
					jbNext.setPreferredSize(new Dimension(25, 35));
					jbNext.setIcon(new ImageIcon(getClass().getResource("/images/ico_next48.png")));
					jbNext.setBackground(new Color(245, 245, 243));
					jbNext.setContentAreaFilled(false);
					jbNext.setBorderPainted(false);
					jbNext.setBorder(null);
					jbNext.setFocusPainted(false);
					jpPlayButMenu.add(jbNext);
				}
				jpLeftHeader.add(jpPlayButMenu);
			}
			jpHeader.add(jpLeftHeader, BorderLayout.WEST);

			//======== jbRightHeader ========
			{
				jbRightHeader.setBackground(new Color(245, 245, 243));
				jbRightHeader.setOpaque(false);
				jbRightHeader.setLayout(new HorizontalLayout());

				//---- jbOptions ----
				jbOptions.setOpaque(false);
				jbOptions.setPreferredSize(new Dimension(38, 28));
				jbOptions.setIcon(new ImageIcon(getClass().getResource("/images/ico_option32.png")));
				jbOptions.setBackground(new Color(245, 245, 243));
				jbOptions.setBorderPainted(false);
				jbOptions.setBorder(new EmptyBorder(0, 0, 0, 10));
				jbOptions.setContentAreaFilled(false);
				jbOptions.setFocusPainted(false);
				jbRightHeader.add(jbOptions);
			}
			jpHeader.add(jbRightHeader, BorderLayout.EAST);

			//======== jpCenterHeader ========
			{
				jpCenterHeader.setBackground(new Color(245, 245, 243));
				jpCenterHeader.setOpaque(false);
				jpCenterHeader.setLayout(new BorderLayout());

				//======== jpHeaderSpacerLeft ========
				{
					jpHeaderSpacerLeft.setBackground(new Color(245, 245, 243));
					jpHeaderSpacerLeft.setOpaque(false);
					jpHeaderSpacerLeft.setLayout(new BorderLayout());
				}
				jpCenterHeader.add(jpHeaderSpacerLeft, BorderLayout.WEST);

				//======== jpHeaderSpacerRight ========
				{
					jpHeaderSpacerRight.setBackground(new Color(245, 245, 243));
					jpHeaderSpacerRight.setBorder(new EmptyBorder(0, 0, 0, 100));
					jpHeaderSpacerRight.setPreferredSize(new Dimension(147, 0));
					jpHeaderSpacerRight.setOpaque(false);
					jpHeaderSpacerRight.setLayout(new BorderLayout());
				}
				jpCenterHeader.add(jpHeaderSpacerRight, BorderLayout.EAST);

				//======== jpHeaderBoard ========
				{
					jpHeaderBoard.setBackground(new Color(245, 245, 243));
					jpHeaderBoard.setOpaque(false);
					jpHeaderBoard.setLayout(new BorderLayout());

					//======== jpHBLectureOptions ========
					{
						jpHBLectureOptions.setBackground(new Color(245, 245, 243));
						jpHBLectureOptions.setOpaque(false);
						jpHBLectureOptions.setLayout(new HorizontalLayout());

						//---- jbRandom ----
						jbRandom.setIcon(new ImageIcon(getClass().getResource("/images/ico_random32.png")));
						jbRandom.setBackground(new Color(245, 245, 243));
						jbRandom.setBorderPainted(false);
						jbRandom.setBorder(new EmptyBorder(0, 5, 0, 5));
						jbRandom.setContentAreaFilled(false);
						jbRandom.setFocusPainted(false);
						jpHBLectureOptions.add(jbRandom);

						//---- jbRepeat ----
						jbRepeat.setIcon(new ImageIcon(getClass().getResource("/images/ico_repeat32.png")));
						jbRepeat.setBackground(new Color(245, 245, 243));
						jbRepeat.setBorderPainted(false);
						jbRepeat.setBorder(new EmptyBorder(0, 5, 0, 20));
						jbRepeat.setContentAreaFilled(false);
						jbRepeat.setFocusPainted(false);
						jpHBLectureOptions.add(jbRepeat);
					}
					jpHeaderBoard.add(jpHBLectureOptions, BorderLayout.WEST);

					//======== jpHBCustomOptions ========
					{
						jpHBCustomOptions.setBackground(new Color(245, 245, 243));
						jpHBCustomOptions.setOpaque(false);
						jpHBCustomOptions.setLayout(new HorizontalLayout());

						//---- jbVolet ----
						jbVolet.setIcon(new ImageIcon(getClass().getResource("/images/ico_volet32_selected.png")));
						jbVolet.setBorderPainted(false);
						jbVolet.setBorder(new EmptyBorder(0, 20, 0, 5));
						jbVolet.setContentAreaFilled(false);
						jbVolet.setFocusPainted(false);
						jpHBCustomOptions.add(jbVolet);

						//---- jbPlAdd ----
						jbPlAdd.setIcon(new ImageIcon(getClass().getResource("/images/ico_ajout32.png")));
						jbPlAdd.setBorderPainted(false);
						jbPlAdd.setBorder(new EmptyBorder(0, 5, 0, 5));
						jbPlAdd.setContentAreaFilled(false);
						jbPlAdd.setFocusPainted(false);
						jpHBCustomOptions.add(jbPlAdd);
					}
					jpHeaderBoard.add(jpHBCustomOptions, BorderLayout.EAST);

					//======== jpHBMain ========
					{
						jpHBMain.setBackground(new Color(245, 245, 243));
						jpHBMain.setOpaque(false);
						jpHBMain.setLayout(new BorderLayout());
					}
					jpHeaderBoard.add(jpHBMain, BorderLayout.CENTER);
				}
				jpCenterHeader.add(jpHeaderBoard, BorderLayout.CENTER);
			}
			jpHeader.add(jpCenterHeader, BorderLayout.CENTER);
		}
		add(jpHeader, BorderLayout.NORTH);

		//======== spPlaylistView ========
		{
			spPlaylistView.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			spPlaylistView.setBackground(new Color(45, 77, 100));
			spPlaylistView.setBorder(BorderFactory.createEmptyBorder());
			spPlaylistView.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spPlaylistView.setRequestFocusEnabled(false);
			spPlaylistView.setPreferredSize(new Dimension(270, 311));
			spPlaylistView.setOpaque(false);

			//======== jpPlaylistViews ========
			{
				jpPlaylistViews.setBackground(new Color(45, 77, 100));
				jpPlaylistViews.setBorder(null);
				jpPlaylistViews.setAutoscrolls(true);
				jpPlaylistViews.setPreferredSize(new Dimension(200, 311));
				jpPlaylistViews.setLayout(new BorderLayout());

				//======== jpLibViewContainer ========
				{
					jpLibViewContainer.setBackground(new Color(229, 229, 229));
					jpLibViewContainer.setOpaque(false);
					jpLibViewContainer.setLayout(new VerticalLayout());

					//======== jpLibraryContainers ========
					{
						jpLibraryContainers.setBackground(new Color(229, 229, 229));
						jpLibraryContainers.setOpaque(false);
						jpLibraryContainers.setLayout(new BorderLayout());

						//======== jpPVBorder ========
						{
							jpPVBorder.setBackground(new Color(229, 229, 229));
							jpPVBorder.setBorder(null);
							jpPVBorder.setPreferredSize(new Dimension(12, 12));
							jpPVBorder.setOpaque(false);
							jpPVBorder.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
							jpPVBorder.setLayout(new VerticalLayout());
						}
						jpLibraryContainers.add(jpPVBorder, BorderLayout.LINE_END);

						//======== jpLibsViews ========
						{
							jpLibsViews.setBackground(new Color(229, 229, 229));
							jpLibsViews.setBorder(new EmptyBorder(0, 0, 10, 0));
							jpLibsViews.setOpaque(false);
							jpLibsViews.setLayout(new BorderLayout());

							//---- jlTitleMusiques ----
							jlTitleMusiques.setText("Library");
							jlTitleMusiques.setHorizontalAlignment(SwingConstants.LEFT);
							jlTitleMusiques.setBorder(new EmptyBorder(10, 25, 5, 0));
							jlTitleMusiques.setBorderPainted(false);
							jlTitleMusiques.setRequestFocusEnabled(false);
							jlTitleMusiques.setFocusable(false);
							jlTitleMusiques.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
							jlTitleMusiques.setForeground(new Color(136, 184, 218));
							jlTitleMusiques.setContentAreaFilled(false);
							jlTitleMusiques.setBackground(new Color(229, 229, 229));
							jpLibsViews.add(jlTitleMusiques, BorderLayout.NORTH);

							//---- jlLibs ----
							jlLibs.setBackground(new Color(45, 77, 100));
							jlLibs.setBorder(new EmptyBorder(0, 40, 5, 0));
							jlLibs.setForeground(new Color(230, 230, 230));
							jlLibs.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
							jlLibs.setModel(new AbstractListModel<String>() {
								String[] values = {
									"All your music",
									"Google music",
									"Cloud music",
									"Local music"
								};
								@Override
								public int getSize() { return values.length; }
								@Override
								public String getElementAt(int i) { return values[i]; }
							});
							jlLibs.setRequestFocusEnabled(false);
							jlLibs.setSelectionBackground(new Color(229, 229, 229));
							jlLibs.setSelectionForeground(Color.darkGray);
							jlLibs.setOpaque(false);
							jpLibsViews.add(jlLibs, BorderLayout.CENTER);
						}
						jpLibraryContainers.add(jpLibsViews, BorderLayout.CENTER);
					}
					jpLibViewContainer.add(jpLibraryContainers);

					//======== jpViewsContainer ========
					{
						jpViewsContainer.setOpaque(false);
						jpViewsContainer.setLayout(new BorderLayout());

						//======== jpPVBorder3 ========
						{
							jpPVBorder3.setBackground(new Color(229, 229, 229));
							jpPVBorder3.setBorder(null);
							jpPVBorder3.setPreferredSize(new Dimension(12, 12));
							jpPVBorder3.setOpaque(false);
							jpPVBorder3.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
							jpPVBorder3.setLayout(new VerticalLayout());
						}
						jpViewsContainer.add(jpPVBorder3, BorderLayout.LINE_END);

						//======== ViewsGridLayout ========
						{
							ViewsGridLayout.setBackground(new Color(229, 229, 229));
							ViewsGridLayout.setBorder(new EmptyBorder(5, 8, 5, 0));
							ViewsGridLayout.setOpaque(false);
							ViewsGridLayout.setLayout(new GridLayout());

							//---- jbViewSimple ----
							jbViewSimple.setIcon(new ImageIcon(getClass().getResource("/images/vue1_48.png")));
							jbViewSimple.setBorderPainted(false);
							jbViewSimple.setFocusPainted(false);
							jbViewSimple.setBorder(null);
							jbViewSimple.setBackground(new Color(229, 229, 229));
							jbViewSimple.setMargin(new Insets(2, 0, 2, 14));
							jbViewSimple.setOpaque(false);
							jbViewSimple.setContentAreaFilled(false);
							ViewsGridLayout.add(jbViewSimple);

							//---- jbViewOneC ----
							jbViewOneC.setIcon(new ImageIcon(getClass().getResource("/images/vue2_selected_48.png")));
							jbViewOneC.setBorder(null);
							jbViewOneC.setBorderPainted(false);
							jbViewOneC.setBackground(new Color(229, 229, 229));
							jbViewOneC.setFocusPainted(false);
							jbViewOneC.setOpaque(false);
							jbViewOneC.setContentAreaFilled(false);
							ViewsGridLayout.add(jbViewOneC);

							//---- jbViewTwoC ----
							jbViewTwoC.setIcon(new ImageIcon(getClass().getResource("/images/vue3_48.png")));
							jbViewTwoC.setBorder(null);
							jbViewTwoC.setBorderPainted(false);
							jbViewTwoC.setBackground(new Color(229, 229, 229));
							jbViewTwoC.setFocusPainted(false);
							jbViewTwoC.setOpaque(false);
							jbViewTwoC.setContentAreaFilled(false);
							ViewsGridLayout.add(jbViewTwoC);

							//---- jbviewThreeC ----
							jbviewThreeC.setIcon(new ImageIcon(getClass().getResource("/images/vue4_48.png")));
							jbviewThreeC.setBorder(null);
							jbviewThreeC.setBorderPainted(false);
							jbviewThreeC.setBackground(new Color(229, 229, 229));
							jbviewThreeC.setMargin(new Insets(2, 14, 2, 0));
							jbviewThreeC.setFocusPainted(false);
							jbviewThreeC.setOpaque(false);
							jbviewThreeC.setContentAreaFilled(false);
							ViewsGridLayout.add(jbviewThreeC);
						}
						jpViewsContainer.add(ViewsGridLayout, BorderLayout.CENTER);
					}
					jpLibViewContainer.add(jpViewsContainer);
				}
				jpPlaylistViews.add(jpLibViewContainer, BorderLayout.PAGE_START);

				//======== jpPlaylistContainer ========
				{
					jpPlaylistContainer.setBackground(new Color(229, 229, 229));
					jpPlaylistContainer.setOpaque(false);
					jpPlaylistContainer.setLayout(new BorderLayout());

					//======== jpPVBorder2 ========
					{
						jpPVBorder2.setBackground(new Color(45, 77, 100));
						jpPVBorder2.setBorder(null);
						jpPVBorder2.setPreferredSize(new Dimension(12, 12));
						jpPVBorder2.setOpaque(false);
						jpPVBorder2.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
						jpPVBorder2.setLayout(new VerticalLayout());
					}
					jpPlaylistContainer.add(jpPVBorder2, BorderLayout.EAST);

					//======== panel2 ========
					{
						panel2.setBackground(new Color(229, 229, 229));
						panel2.setOpaque(false);
						panel2.setLayout(new VerticalLayout(2));

						//---- label3 ----
						label3.setText("Playlist g\u00e9n\u00e9rique");
						label3.setForeground(new Color(136, 184, 218));
						label3.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
						label3.setBackground(new Color(229, 229, 229));
						label3.setBorder(new EmptyBorder(10, 25, 5, 0));
						panel2.add(label3);

						//---- list1 ----
						list1.setBorder(new EmptyBorder(0, 40, 0, 0));
						list1.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
						list1.setForeground(new Color(230, 230, 230));
						list1.setBackground(new Color(45, 77, 100));
						list1.setModel(new AbstractListModel<String>() {
							String[] values = {
								"Tr\u00e8s bien not\u00e9",
								"Derniers titres ajout\u00e9s",
								"Les plus \u00e9cout\u00e9s"
							};
							@Override
							public int getSize() { return values.length; }
							@Override
							public String getElementAt(int i) { return values[i]; }
						});
						list1.setRequestFocusEnabled(false);
						list1.setSelectionBackground(new Color(229, 229, 229));
						list1.setSelectionForeground(new Color(0, 102, 153));
						list1.setOpaque(false);
						list1.setFixedCellHeight(20);
						panel2.add(list1);

						//---- label2 ----
						label2.setText("Mes playlist");
						label2.setForeground(new Color(136, 184, 218));
						label2.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
						label2.setBackground(new Color(229, 229, 229));
						label2.setBorder(new EmptyBorder(10, 25, 5, 0));
						panel2.add(label2);

						//---- list2 ----
						list2.setBorder(new EmptyBorder(0, 40, 0, 0));
						list2.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
						list2.setForeground(new Color(230, 230, 230));
						list2.setBackground(new Color(45, 77, 100));
						list2.setModel(new AbstractListModel<String>() {
							String[] values = {
								"Super patate",
								"Ca pulse",
								"Tranquillou",
								"Pos\u00e9",
								"Electro patate",
								"Electro pos\u00e9",
								"House",
								"California Dreamin"
							};
							@Override
							public int getSize() { return values.length; }
							@Override
							public String getElementAt(int i) { return values[i]; }
						});
						list2.setRequestFocusEnabled(false);
						list2.setSelectionBackground(new Color(229, 229, 229));
						list2.setSelectionForeground(new Color(0, 102, 153));
						list2.setOpaque(false);
						list2.setFixedCellHeight(20);
						panel2.add(list2);
					}
					jpPlaylistContainer.add(panel2, BorderLayout.CENTER);
				}
				jpPlaylistViews.add(jpPlaylistContainer, BorderLayout.CENTER);
			}
			spPlaylistView.setViewportView(jpPlaylistViews);
		}
		add(spPlaylistView, BorderLayout.WEST);

		//======== jpInfoOptionEast ========
		{
			jpInfoOptionEast.setLayout(new HorizontalLayout());

			//======== jpPlayingInfo ========
			{
				jpPlayingInfo.setMinimumSize(new Dimension(200, 0));
				jpPlayingInfo.setPreferredSize(new Dimension(260, 0));
				jpPlayingInfo.setBackground(new Color(245, 245, 245));
				jpPlayingInfo.setMaximumSize(new Dimension(450, 2147483647));
				jpPlayingInfo.setLayout(new BorderLayout());

				//======== jpPlaylistList ========
				{
					jpPlaylistList.setLayout(new BorderLayout());

					//======== panel3 ========
					{
						panel3.setLayout(new BorderLayout());

						//======== jpPlaylistListContainer ========
						{
							jpPlaylistListContainer.setAutoscrolls(true);
							jpPlaylistListContainer.setBackground(new Color(245, 245, 245));
							jpPlaylistListContainer.setLayout(new VerticalLayout());

							//======== PlayingListElement ========
							{
								PlayingListElement.setBackground(new Color(245, 245, 245));
								PlayingListElement.setBorder(new MatteBorder(1, 0, 1, 0, new Color(230, 230, 230)));
								PlayingListElement.setLayout(new BorderLayout());

								//======== jpPlaylistElementBorder ========
								{
									jpPlaylistElementBorder.setPreferredSize(new Dimension(12, 0));
									jpPlaylistElementBorder.setBorder(new AbstractBorder_playlist());
									jpPlaylistElementBorder.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
									jpPlaylistElementBorder.setLayout(new BorderLayout());
								}
								PlayingListElement.add(jpPlaylistElementBorder, BorderLayout.WEST);

								//---- label5 ----
								label5.setText("Daft Punk - One more time");
								label5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
								label5.setForeground(new Color(0, 11, 42));
								PlayingListElement.add(label5, BorderLayout.CENTER);

								//---- label4 ----
								label4.setText("5:20");
								label4.setBorder(new EmptyBorder(5, 10, 5, 10));
								label4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
								label4.setForeground(new Color(0, 11, 42));
								PlayingListElement.add(label4, BorderLayout.EAST);
							}
							jpPlaylistListContainer.add(PlayingListElement);

							//======== PlayingListElement2 ========
							{
								PlayingListElement2.setBackground(new Color(245, 245, 245));
								PlayingListElement2.setBorder(new MatteBorder(1, 0, 1, 0, new Color(230, 230, 230)));
								PlayingListElement2.setPreferredSize(new Dimension(200, 27));
								PlayingListElement2.setLayout(new BorderLayout());

								//======== jpPlaylistElementBorder2 ========
								{
									jpPlaylistElementBorder2.setPreferredSize(new Dimension(12, 0));
									jpPlaylistElementBorder2.setBorder(new AbstractBorder_playlist());
									jpPlaylistElementBorder2.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
									jpPlaylistElementBorder2.setLayout(new BorderLayout());
								}
								PlayingListElement2.add(jpPlaylistElementBorder2, BorderLayout.WEST);

								//---- label6 ----
								label6.setText("3:32");
								label6.setBorder(new EmptyBorder(5, 10, 5, 10));
								label6.setFont(new Font("Segoe UI", Font.PLAIN, 11));
								label6.setForeground(new Color(0, 11, 42));
								PlayingListElement2.add(label6, BorderLayout.EAST);

								//---- label7 ----
								label7.setText("Daft Punk - Aerodynamic");
								label7.setFont(new Font("Segoe UI", Font.PLAIN, 11));
								label7.setForeground(new Color(0, 11, 42));
								PlayingListElement2.add(label7, BorderLayout.CENTER);
							}
							jpPlaylistListContainer.add(PlayingListElement2);
						}
						panel3.add(jpPlaylistListContainer, BorderLayout.CENTER);
					}
					jpPlaylistList.add(panel3, BorderLayout.NORTH);

					//======== jpPlaylistListSpacer ========
					{
						jpPlaylistListSpacer.setBackground(new Color(245, 245, 245));
						jpPlaylistListSpacer.setLayout(new BorderLayout());

						//======== jpPlaylistBorder ========
						{
							jpPlaylistBorder.setPreferredSize(new Dimension(12, 0));
							jpPlaylistBorder.setBorder(new AbstractBorder_playlist());
							jpPlaylistBorder.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
							jpPlaylistBorder.setLayout(new BorderLayout());
						}
						jpPlaylistListSpacer.add(jpPlaylistBorder, BorderLayout.WEST);
					}
					jpPlaylistList.add(jpPlaylistListSpacer, BorderLayout.CENTER);
				}
				jpPlayingInfo.add(jpPlaylistList, BorderLayout.CENTER);

				//======== jpInfoPlayingSong ========
				{
					jpInfoPlayingSong.setPreferredSize(new Dimension(0, 120));
					jpInfoPlayingSong.setBackground(new Color(245, 245, 245));
					jpInfoPlayingSong.setBorder(new MatteBorder(1, 0, 0, 0, new Color(204, 204, 204)));
					jpInfoPlayingSong.setFocusable(false);
					jpInfoPlayingSong.setRequestFocusEnabled(false);
					jpInfoPlayingSong.setLayout(new BorderLayout());

					//======== jpInfoPSBorder ========
					{
						jpInfoPSBorder.setPreferredSize(new Dimension(12, 0));
						jpInfoPSBorder.setBorder(new AbstractBorder_playlist());
						jpInfoPSBorder.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
						jpInfoPSBorder.setLayout(new BorderLayout());
					}
					jpInfoPlayingSong.add(jpInfoPSBorder, BorderLayout.WEST);

					//======== jpInfoPSContainer ========
					{
						jpInfoPSContainer.setLayout(new BorderLayout());

						//======== jpImageContainer ========
						{
							jpImageContainer.setPreferredSize(new Dimension(80, 45));
							jpImageContainer.setBackground(new Color(245, 245, 245));
							jpImageContainer.setLayout(new BorderLayout());

							//---- jbPisteImage ----
							jbPisteImage.setSelectedIcon(null);
							jbPisteImage.setIcon(new ImageIcon(getClass().getResource("/images/td_miniature.png")));
							jbPisteImage.setPreferredSize(new Dimension(50, 50));
							jbPisteImage.setBorder(null);
							jbPisteImage.setBackground(new Color(245, 245, 245));
							jbPisteImage.setBorderPainted(false);
							jbPisteImage.setMaximumSize(new Dimension(60, 60));
							jpImageContainer.add(jbPisteImage, BorderLayout.CENTER);

							//======== jpSpaceT ========
							{
								jpSpaceT.setPreferredSize(new Dimension(0, 20));
								jpSpaceT.setBackground(new Color(245, 245, 245));
								jpSpaceT.setLayout(new BorderLayout());
							}
							jpImageContainer.add(jpSpaceT, BorderLayout.NORTH);

							//======== jpSpaceS ========
							{
								jpSpaceS.setPreferredSize(new Dimension(0, 20));
								jpSpaceS.setBackground(new Color(245, 245, 245));
								jpSpaceS.setLayout(new BorderLayout());
							}
							jpImageContainer.add(jpSpaceS, BorderLayout.SOUTH);
						}
						jpInfoPSContainer.add(jpImageContainer, BorderLayout.WEST);

						//======== jpInfoTxt ========
						{
							jpInfoTxt.setBackground(new Color(245, 245, 245));
							jpInfoTxt.setLayout(new HorizontalLayout());

							//======== jpInfoListTitle ========
							{
								jpInfoListTitle.setBorder(new EmptyBorder(30, 10, 25, 5));
								jpInfoListTitle.setBackground(new Color(245, 245, 245));
								jpInfoListTitle.setLayout(new VerticalLayout());

								//---- jlTitle ----
								jlTitle.setText("Titre");
								jlTitle.setForeground(new Color(71, 94, 124));
								jlTitle.setBackground(new Color(245, 245, 245));
								jlTitle.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListTitle.add(jlTitle);

								//---- jlArtist ----
								jlArtist.setText("Artiste");
								jlArtist.setForeground(new Color(71, 94, 124));
								jlArtist.setBackground(new Color(245, 245, 245));
								jlArtist.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListTitle.add(jlArtist);

								//---- jlAlbum ----
								jlAlbum.setText("Album");
								jlAlbum.setForeground(new Color(71, 94, 124));
								jlAlbum.setBackground(new Color(245, 245, 245));
								jlAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListTitle.add(jlAlbum);

								//---- jlDuree ----
								jlDuree.setText("Dur\u00e9e");
								jlDuree.setForeground(new Color(71, 94, 124));
								jlDuree.setBackground(new Color(245, 245, 245));
								jlDuree.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListTitle.add(jlDuree);
							}
							jpInfoTxt.add(jpInfoListTitle);

							//======== jpInfoListValue ========
							{
								jpInfoListValue.setBorder(new EmptyBorder(30, 0, 25, 0));
								jpInfoListValue.setBackground(new Color(245, 245, 245));
								jpInfoListValue.setLayout(new VerticalLayout());

								//---- jlTitleValue ----
								jlTitleValue.setText("One more time");
								jlTitleValue.setForeground(new Color(71, 94, 124));
								jlTitleValue.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListValue.add(jlTitleValue);

								//---- jlArtistValue ----
								jlArtistValue.setText("Daft Punk");
								jlArtistValue.setForeground(new Color(71, 94, 124));
								jlArtistValue.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListValue.add(jlArtistValue);

								//---- jlAlbumValue ----
								jlAlbumValue.setText("Discovery");
								jlAlbumValue.setForeground(new Color(71, 94, 124));
								jlAlbumValue.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListValue.add(jlAlbumValue);

								//---- jlDureeValue ----
								jlDureeValue.setText("5:20");
								jlDureeValue.setForeground(new Color(71, 94, 124));
								jlDureeValue.setFont(new Font("Segoe UI", Font.PLAIN, 10));
								jpInfoListValue.add(jlDureeValue);
							}
							jpInfoTxt.add(jpInfoListValue);
						}
						jpInfoPSContainer.add(jpInfoTxt, BorderLayout.CENTER);
					}
					jpInfoPlayingSong.add(jpInfoPSContainer, BorderLayout.CENTER);
				}
				jpPlayingInfo.add(jpInfoPlayingSong, BorderLayout.SOUTH);
			}
			jpInfoOptionEast.add(jpPlayingInfo);

			//======== jpOptions ========
			{
				jpOptions.setPreferredSize(new Dimension(0, 0));
				jpOptions.setBackground(new Color(51, 51, 51));
				jpOptions.setBorder(new AbstractBorder_options());
				jpOptions.setLayout(new VerticalLayout());

				//======== jpOptionHeader ========
				{
					jpOptionHeader.setBackground(new Color(51, 51, 51));
					jpOptionHeader.setPreferredSize(new Dimension(0, 50));
					jpOptionHeader.setBorder(new MatteBorder(0, 0, 1, 0, new Color(42, 42, 42)));
					jpOptionHeader.setLayout(new BorderLayout());

					//======== jpOHBorder ========
					{
						jpOHBorder.setBackground(new Color(51, 51, 51));
						jpOHBorder.setBorder(new AbstractBorder_options());
						jpOHBorder.setPreferredSize(new Dimension(13, 0));
						jpOHBorder.setLayout(new BorderLayout());
					}
					jpOptionHeader.add(jpOHBorder, BorderLayout.WEST);

					//---- jlOptionTitle ----
					jlOptionTitle.setText("Settings");
					jlOptionTitle.setForeground(Color.white);
					jlOptionTitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
					jlOptionTitle.setBorder(new EmptyBorder(0, 10, 0, 0));
					jpOptionHeader.add(jlOptionTitle, BorderLayout.CENTER);
				}
				jpOptions.add(jpOptionHeader);

				//======== jpOptionBody ========
				{
					jpOptionBody.setBackground(new Color(51, 51, 51));
					jpOptionBody.setBorder(null);
					jpOptionBody.setLayout(new BorderLayout());

					//======== jpOBBorder ========
					{
						jpOBBorder.setPreferredSize(new Dimension(13, 0));
						jpOBBorder.setBorder(new AbstractBorder_options());
						jpOBBorder.setBackground(new Color(51, 51, 51));
						jpOBBorder.setLayout(new BorderLayout());
					}
					jpOptionBody.add(jpOBBorder, BorderLayout.WEST);

					//======== jpOBContent ========
					{
						jpOBContent.setBackground(new Color(51, 51, 51));
						jpOBContent.setBorder(new EmptyBorder(5, 25, 5, 35));
						jpOBContent.setLayout(new VerticalLayout());

						//======== jpOBSpacer ========
						{
							jpOBSpacer.setBackground(new Color(51, 51, 51));
							jpOBSpacer.setPreferredSize(new Dimension(0, 15));
							jpOBSpacer.setLayout(new BorderLayout());
						}
						jpOBContent.add(jpOBSpacer);

						//======== jpOBLine ========
						{
							jpOBLine.setBackground(new Color(51, 51, 51));
							jpOBLine.setLayout(new BorderLayout());

							//---- jlOLine1 ----
							jlOLine1.setText("Autosave");
							jlOLine1.setForeground(Color.white);
							jlOLine1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
							jpOBLine.add(jlOLine1, BorderLayout.WEST);

							//---- cbOLine1 ----
							cbOLine1.setBackground(new Color(51, 51, 51));
							cbOLine1.setBorder(null);
							jpOBLine.add(cbOLine1, BorderLayout.EAST);
						}
						jpOBContent.add(jpOBLine);
					}
					jpOptionBody.add(jpOBContent, BorderLayout.CENTER);
				}
				jpOptions.add(jpOptionBody);
			}
			jpInfoOptionEast.add(jpOptions);
		}
		add(jpInfoOptionEast, BorderLayout.EAST);

		//======== panel1 ========
		{
			panel1.setLayout(new BorderLayout());

			//======== jpCenterMain ========
			{
				jpCenterMain.setBackground(Color.white);
				jpCenterMain.setLayout(new BorderLayout());

				//======== jpFilterContainer ========
				{
					jpFilterContainer.setBackground(Color.white);
					jpFilterContainer.setOpaque(false);
					jpFilterContainer.setLayout(new HorizontalLayout());

					//======== jpArtistlist ========
					{
						jpArtistlist.setBackground(new Color(246, 247, 249));
						jpArtistlist.setPreferredSize(new Dimension(220, 0));
						jpArtistlist.setBorder(new MatteBorder(0, 0, 0, 1, new Color(188, 188, 188)));
						jpArtistlist.setLayout(new BorderLayout());

						//======== jpArtistHead ========
						{
							jpArtistHead.setBackground(new Color(245, 245, 245));
							jpArtistHead.setBorder(new MatteBorder(0, 0, 1, 0, new Color(205, 205, 205)));
							jpArtistHead.setPreferredSize(new Dimension(100, 35));
							jpArtistHead.setMinimumSize(new Dimension(80, 33));
							jpArtistHead.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 3));

							//---- jbArtistsAll ----
							jbArtistsAll.setText("Artistes");
							jbArtistsAll.setBackground(new Color(245, 245, 245));
							jbArtistsAll.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
							jbArtistsAll.setBorder(new EmptyBorder(2, 20, 2, 5));
							jbArtistsAll.setForeground(new Color(65, 72, 80));
							jbArtistsAll.setBorderPainted(false);
							jbArtistsAll.setContentAreaFilled(false);
							jbArtistsAll.setFocusPainted(false);
							jpArtistHead.add(jbArtistsAll);

							//---- label9 ----
							label9.setText("(1236)");
							label9.setBorder(new EmptyBorder(1, 0, 0, 0));
							label9.setForeground(new Color(81, 72, 73));
							label9.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
							jpArtistHead.add(label9);
						}
						jpArtistlist.add(jpArtistHead, BorderLayout.NORTH);

						//======== spArtist ========
						{
							spArtist.setBackground(new Color(246, 247, 249));
							spArtist.setBorder(new EmptyBorder(0, 10, 0, 0));

							//---- jlArtistes ----
							jlArtistes.setBackground(new Color(245, 245, 245));
							jlArtistes.setBorder(new EmptyBorder(2, 0, 0, 0));
							jlArtistes.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
							jlArtistes.setFixedCellHeight(20);
							spArtist.setViewportView(jlArtistes);
						}
						jpArtistlist.add(spArtist, BorderLayout.CENTER);

						//======== jpArtistResize ========
						{
							jpArtistResize.setPreferredSize(new Dimension(3, 0));
							jpArtistResize.setBackground(new Color(246, 247, 249));
							jpArtistResize.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
							jpArtistResize.setLayout(new BorderLayout());
						}
						jpArtistlist.add(jpArtistResize, BorderLayout.EAST);
					}
					jpFilterContainer.add(jpArtistlist);

					//======== jpAlbumslist ========
					{
						jpAlbumslist.setBackground(new Color(246, 247, 249));
						jpAlbumslist.setPreferredSize(new Dimension(220, 0));
						jpAlbumslist.setBorder(new MatteBorder(0, 0, 0, 1, new Color(188, 188, 188)));
						jpAlbumslist.setLayout(new BorderLayout());

						//======== jpAlbumHead ========
						{
							jpAlbumHead.setBackground(new Color(245, 245, 245));
							jpAlbumHead.setBorder(new MatteBorder(0, 0, 1, 0, new Color(205, 205, 205)));
							jpAlbumHead.setPreferredSize(new Dimension(100, 35));
							jpAlbumHead.setMinimumSize(new Dimension(80, 35));
							jpAlbumHead.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 3));

							//---- jbalbumAll ----
							jbalbumAll.setText("Albums");
							jbalbumAll.setBackground(new Color(245, 245, 245));
							jbalbumAll.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
							jbalbumAll.setBorder(new EmptyBorder(2, 20, 2, 5));
							jbalbumAll.setForeground(new Color(65, 72, 80));
							jbalbumAll.setBorderPainted(false);
							jbalbumAll.setContentAreaFilled(false);
							jbalbumAll.setFocusPainted(false);
							jpAlbumHead.add(jbalbumAll);

							//---- label11 ----
							label11.setText("(2311)");
							label11.setBorder(new EmptyBorder(1, 0, 0, 0));
							label11.setForeground(new Color(81, 72, 73));
							label11.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
							jpAlbumHead.add(label11);
						}
						jpAlbumslist.add(jpAlbumHead, BorderLayout.NORTH);

						//======== spAlbum ========
						{
							spAlbum.setBackground(new Color(246, 247, 249));
							spAlbum.setBorder(new EmptyBorder(0, 10, 0, 0));

							//---- jlAlbums ----
							jlAlbums.setBackground(new Color(245, 245, 245));
							jlAlbums.setBorder(new EmptyBorder(2, 0, 0, 0));
							jlAlbums.setFixedCellHeight(20);
							jlAlbums.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
							spAlbum.setViewportView(jlAlbums);
						}
						jpAlbumslist.add(spAlbum, BorderLayout.CENTER);

						//======== jpAlbumResize ========
						{
							jpAlbumResize.setPreferredSize(new Dimension(3, 0));
							jpAlbumResize.setBackground(new Color(246, 247, 249));
							jpAlbumResize.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
							jpAlbumResize.setLayout(new BorderLayout());
						}
						jpAlbumslist.add(jpAlbumResize, BorderLayout.EAST);
					}
					jpFilterContainer.add(jpAlbumslist);
				}
				jpCenterMain.add(jpFilterContainer, BorderLayout.WEST);

				//======== jpTrackContainer ========
				{
					jpTrackContainer.setBackground(Color.white);
					jpTrackContainer.setPreferredSize(new Dimension(100, 0));
					jpTrackContainer.setOpaque(false);
					jpTrackContainer.setLayout(new BorderLayout());

					//======== jpSelectedTrackMenu ========
					{
						jpSelectedTrackMenu.setPreferredSize(new Dimension(94, 35));
						jpSelectedTrackMenu.setBackground(new Color(245, 245, 245));
						jpSelectedTrackMenu.setBorder(new MatteBorder(0, 0, 1, 0, new Color(203, 203, 203)));
						jpSelectedTrackMenu.setLayout(new BorderLayout());

						//======== jpLectureMenu ========
						{
							jpLectureMenu.setBorder(new EmptyBorder(0, 25, 0, 0));
							jpLectureMenu.setBackground(new Color(245, 245, 245));
							jpLectureMenu.setLayout(new HorizontalLayout());

							//---- jbAddSelectedArtist ----
							jbAddSelectedArtist.setBackground(new Color(245, 245, 245));
							jbAddSelectedArtist.setBorderPainted(false);
							jbAddSelectedArtist.setBorder(new EmptyBorder(0, 5, 0, 15));
							jbAddSelectedArtist.setForeground(new Color(65, 72, 80));
							jbAddSelectedArtist.setContentAreaFilled(false);
							jbAddSelectedArtist.setFocusPainted(false);
							jbAddSelectedArtist.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
							jbAddSelectedArtist.setMargin(new Insets(0, 14, 2, 14));
							jbAddSelectedArtist.setPreferredSize(new Dimension(150, 20));
							jbAddSelectedArtist.setMaximumSize(new Dimension(300, 20));
							jbAddSelectedArtist.setMinimumSize(new Dimension(100, 20));
							jpLectureMenu.add(jbAddSelectedArtist);

							//---- jbAddSelectedAlbum ----
							jbAddSelectedAlbum.setBackground(new Color(245, 245, 245));
							jbAddSelectedAlbum.setBorderPainted(false);
							jbAddSelectedAlbum.setBorder(new EmptyBorder(0, 5, 0, 15));
							jbAddSelectedAlbum.setForeground(new Color(65, 72, 80));
							jbAddSelectedAlbum.setContentAreaFilled(false);
							jbAddSelectedAlbum.setFocusPainted(false);
							jbAddSelectedAlbum.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
							jbAddSelectedAlbum.setMaximumSize(new Dimension(200, 20));
							jbAddSelectedAlbum.setMinimumSize(new Dimension(100, 20));
							jbAddSelectedAlbum.setPreferredSize(new Dimension(150, 20));
							jbAddSelectedAlbum.setMargin(new Insets(0, 14, 2, 14));
							jpLectureMenu.add(jbAddSelectedAlbum);
						}
						jpSelectedTrackMenu.add(jpLectureMenu, BorderLayout.WEST);

						//======== jpDisplayMenu ========
						{
							jpDisplayMenu.setLayout(new HorizontalLayout());
						}
						jpSelectedTrackMenu.add(jpDisplayMenu, BorderLayout.EAST);
					}
					jpTrackContainer.add(jpSelectedTrackMenu, BorderLayout.NORTH);

					//======== jspTracks ========
					{
						jspTracks.setBackground(Color.white);
						jspTracks.setBorder(new EmptyBorder(0, 0, 0, 3));
						jspTracks.setMinimumSize(new Dimension(0, 0));
						jspTracks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
						jspTracks.setViewportBorder(new MatteBorder(0, 8, 0, 0, Color.white));
						jspTracks.setOpaque(false);

						//---- jtTracks ----
						jtTracks.setGridColor(new Color(230, 230, 230));
						jtTracks.setRowHeight(22);
						jtTracks.setRowMargin(3);
						jtTracks.setBorder(null);
						jtTracks.setIntercellSpacing(new Dimension(0, 0));
						jtTracks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jtTracks.setPreferredScrollableViewportSize(new Dimension(0, 0));
						jtTracks.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
						jtTracks.setShowHorizontalLines(false);
						jtTracks.setFillsViewportHeight(true);
						jtTracks.setShowVerticalLines(false);
						jtTracks.setAutoCreateRowSorter(true);
						jtTracks.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						jspTracks.setViewportView(jtTracks);
					}
					jpTrackContainer.add(jspTracks, BorderLayout.CENTER);
				}
				jpCenterMain.add(jpTrackContainer, BorderLayout.CENTER);
			}
			panel1.add(jpCenterMain, BorderLayout.CENTER);
		}
		add(panel1, BorderLayout.CENTER);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Dx jv
	private JPanel jpHeader;
	private JPanel jpLeftHeader;
	private JLabel jlAppName;
	private JPanel jpPlayButMenu;
	private JButton jbPrevious;
	public JButton jbPausPlay;
	private JButton jbNext;
	private JPanel jbRightHeader;
	private JButton jbOptions;
	public JPanel jpCenterHeader;
	public JPanel jpHeaderSpacerLeft;
	public JPanel jpHeaderSpacerRight;
	private JPanel jpHeaderBoard;
	private JPanel jpHBLectureOptions;
	public JButton jbRandom;
	public JButton jbRepeat;
	private JPanel jpHBCustomOptions;
	private JButton jbVolet;
	private JButton jbPlAdd;
	public JPanel jpHBMain;
	private JScrollPane spPlaylistView;
	private JPanel jpPlaylistViews;
	private JPanel jpLibViewContainer;
	private JPanel jpLibraryContainers;
	private JPanel jpPVBorder;
	private JPanel jpLibsViews;
	private JButton jlTitleMusiques;
	private JList<String> jlLibs;
	private JPanel jpViewsContainer;
	private JPanel jpPVBorder3;
	private JPanel ViewsGridLayout;
	public JButton jbViewSimple;
	public JButton jbViewOneC;
	public JButton jbViewTwoC;
	public JButton jbviewThreeC;
	private JPanel jpPlaylistContainer;
	private JPanel jpPVBorder2;
	private JPanel panel2;
	private JLabel label3;
	private JList<String> list1;
	private JLabel label2;
	private JList<String> list2;
	private JPanel jpInfoOptionEast;
	private JPanel jpPlayingInfo;
	private JPanel jpPlaylistList;
	private JPanel panel3;
	private JPanel jpPlaylistListContainer;
	private JPanel PlayingListElement;
	private JPanel jpPlaylistElementBorder;
	private JLabel label5;
	private JLabel label4;
	private JPanel PlayingListElement2;
	private JPanel jpPlaylistElementBorder2;
	private JLabel label6;
	private JLabel label7;
	private JPanel jpPlaylistListSpacer;
	private JPanel jpPlaylistBorder;
	private JPanel jpInfoPlayingSong;
	private JPanel jpInfoPSBorder;
	private JPanel jpInfoPSContainer;
	private JPanel jpImageContainer;
	public JButton jbPisteImage;
	private JPanel jpSpaceT;
	private JPanel jpSpaceS;
	private JPanel jpInfoTxt;
	private JPanel jpInfoListTitle;
	private JLabel jlTitle;
	private JLabel jlArtist;
	private JLabel jlAlbum;
	private JLabel jlDuree;
	private JPanel jpInfoListValue;
	public JLabel jlTitleValue;
	public JLabel jlArtistValue;
	public JLabel jlAlbumValue;
	public JLabel jlDureeValue;
	private JPanel jpOptions;
	private JPanel jpOptionHeader;
	private JPanel jpOHBorder;
	private JLabel jlOptionTitle;
	private JPanel jpOptionBody;
	private JPanel jpOBBorder;
	private JPanel jpOBContent;
	private JPanel jpOBSpacer;
	private JPanel jpOBLine;
	private JLabel jlOLine1;
	private JCheckBox cbOLine1;
	private JPanel panel1;
	private JPanel jpCenterMain;
	private JPanel jpFilterContainer;
	private JPanel jpArtistlist;
	private JPanel jpArtistHead;
	private JButton jbArtistsAll;
	private JLabel label9;
	private JScrollPane spArtist;
	public JXList jlArtistes;
	private JPanel jpArtistResize;
	private JPanel jpAlbumslist;
	private JPanel jpAlbumHead;
	private JButton jbalbumAll;
	private JLabel label11;
	private JScrollPane spAlbum;
	public JXList jlAlbums;
	private JPanel jpAlbumResize;
	private JPanel jpTrackContainer;
	private JPanel jpSelectedTrackMenu;
	private JPanel jpLectureMenu;
	private JButton jbAddSelectedArtist;
	private JButton jbAddSelectedAlbum;
	private JPanel jpDisplayMenu;
	private JScrollPane jspTracks;
	public JTable jtTracks;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
