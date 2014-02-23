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

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - jv dudux
		jpHeader = new JPanel();
		jpLeftHeader = new JPanel();
		jlAppName = new JLabel();
		jpPlayButMenu = new JPanel();
		jbPrevious = new JButton();
		jbPausPlay = new JButton();
		jbNext = new JButton();
		jbRightHeader = new JPanel();
		button2 = new JButton();
		jpCenterHeader = new JPanel();
		jpPlaylistViews = new JPanel();
		jpLibViewContainer = new JPanel();
		jpLibraryContainers = new JPanel();
		jpPVBorder = new JPanel();
		jpLibsViews = new JPanel();
		jlTitleMusiques = new JButton();
		jlLibs = new JList<>();
		ViewContainer = new JPanel();
		ViewsGridLayout = new JPanel();
		jbViewSimple = new JButton();
		jbViewOneC = new JButton();
		jbViewTwoC = new JButton();
		jbviewThreeC = new JButton();
		jpPVBorder3 = new JPanel();
		jpPlaylistContainer = new JPanel();
		jpPVBorder2 = new JPanel();
		panel2 = new JPanel();
		label3 = new JLabel();
		list1 = new JList<>();
		label2 = new JLabel();
		list2 = new JList<>();
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
		jbImage = new JButton();
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
		jpCenterMain = new JPanel();
		jpFilterContainer = new JPanel();
		jpArtistlist = new JPanel();
		jpArtistHead = new JPanel();
		label8 = new JLabel();
		label9 = new JLabel();
		spArtist = new JScrollPane();
		jlArtistes = new JList();
		jpArtistResize = new JPanel();
		jpAlbums = new JPanel();
		jpAlbumHead = new JPanel();
		label10 = new JLabel();
		label11 = new JLabel();
		spAlbum = new JScrollPane();
		jlAlbums = new JList();
		jpAlbumResize = new JPanel();
		jpTrackContainer = new JPanel();
		jpSelectedTrackMenu = new JPanel();
		jpLectureMenu = new JPanel();
		jbEcoutezArtist = new JButton();
		jbEcoutezAlbum = new JButton();
		jpDisplayMenu = new JPanel();
		jspTracks = new JScrollPane();
		jtTracks = new JTable();

		//======== this ========
		setBackground(Color.white);

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new BorderLayout());

		//======== jpHeader ========
		{
			jpHeader.setPreferredSize(new Dimension(0, 60));
			jpHeader.setBackground(new Color(245, 245, 245));
			jpHeader.setBorder(new MatteBorder(0, 0, 1, 0, new Color(138, 138, 138)));
			jpHeader.setLayout(new BorderLayout());

			//======== jpLeftHeader ========
			{
				jpLeftHeader.setBackground(new Color(245, 245, 243));
				jpLeftHeader.setLayout(new HorizontalLayout());

				//---- jlAppName ----
				jlAppName.setText("Hemixos");
				jlAppName.setForeground(Color.gray);
				jlAppName.setFont(new Font("Segoe UI", Font.PLAIN, 9));
				jlAppName.setVerticalAlignment(SwingConstants.TOP);
				jlAppName.setBorder(new EmptyBorder(0, 5, 0, 10));
				jpLeftHeader.add(jlAppName);

				//======== jpPlayButMenu ========
				{
					jpPlayButMenu.setPreferredSize(new Dimension(135, 40));
					jpPlayButMenu.setBackground(new Color(245, 245, 243));
					jpPlayButMenu.setLayout(new HorizontalLayout());

					//---- jbPrevious ----
					jbPrevious.setIcon(new ImageIcon(getClass().getResource("/images/ico_previous.jpg")));
					jbPrevious.setPreferredSize(new Dimension(45, 35));
					jbPrevious.setBackground(new Color(245, 245, 243));
					jbPrevious.setContentAreaFilled(false);
					jbPrevious.setBorderPainted(false);
					jbPrevious.setBorder(null);
					jbPrevious.setFocusPainted(false);
					jpPlayButMenu.add(jbPrevious);

					//---- jbPausPlay ----
					jbPausPlay.setIcon(new ImageIcon(getClass().getResource("/images/ico_play.jpg")));
					jbPausPlay.setPreferredSize(new Dimension(45, 35));
					jbPausPlay.setBackground(new Color(245, 245, 243));
					jbPausPlay.setContentAreaFilled(false);
					jbPausPlay.setBorderPainted(false);
					jbPausPlay.setBorder(null);
					jbPausPlay.setFocusPainted(false);
					jpPlayButMenu.add(jbPausPlay);

					//---- jbNext ----
					jbNext.setPreferredSize(new Dimension(45, 35));
					jbNext.setIcon(new ImageIcon(getClass().getResource("/images/ico_next.jpg")));
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
				jbRightHeader.setLayout(new HorizontalLayout());

				//---- button2 ----
				button2.setOpaque(false);
				button2.setPreferredSize(new Dimension(38, 28));
				button2.setIcon(new ImageIcon(getClass().getResource("/images/ico_options.jpg")));
				button2.setBackground(new Color(245, 245, 243));
				button2.setBorderPainted(false);
				button2.setBorder(new EmptyBorder(0, 0, 0, 10));
				button2.setContentAreaFilled(false);
				button2.setFocusPainted(false);
				jbRightHeader.add(button2);
			}
			jpHeader.add(jbRightHeader, BorderLayout.EAST);

			//======== jpCenterHeader ========
			{
				jpCenterHeader.setBackground(new Color(245, 245, 243));
				jpCenterHeader.setLayout(new BorderLayout());
			}
			jpHeader.add(jpCenterHeader, BorderLayout.CENTER);
		}
		add(jpHeader, BorderLayout.PAGE_START);

		//======== jpPlaylistViews ========
		{
			jpPlaylistViews.setBackground(new Color(229, 229, 229));
			jpPlaylistViews.setBorder(null);
			jpPlaylistViews.setAutoscrolls(true);
			jpPlaylistViews.setPreferredSize(new Dimension(200, 311));
			jpPlaylistViews.setLayout(new BorderLayout());

			//======== jpLibViewContainer ========
			{
				jpLibViewContainer.setBackground(new Color(229, 229, 229));
				jpLibViewContainer.setLayout(new VerticalLayout());

				//======== jpLibraryContainers ========
				{
					jpLibraryContainers.setBackground(new Color(229, 229, 229));
					jpLibraryContainers.setLayout(new BorderLayout());

					//======== jpPVBorder ========
					{
						jpPVBorder.setBackground(new Color(229, 229, 229));
						jpPVBorder.setBorder(new AbstractBorder_menu());
						jpPVBorder.setPreferredSize(new Dimension(12, 12));
						jpPVBorder.setLayout(new VerticalLayout());
					}
					jpLibraryContainers.add(jpPVBorder, BorderLayout.LINE_END);

					//======== jpLibsViews ========
					{
						jpLibsViews.setBackground(new Color(229, 229, 229));
						jpLibsViews.setBorder(new EmptyBorder(0, 0, 10, 0));
						jpLibsViews.setLayout(new BorderLayout());

						//---- jlTitleMusiques ----
						jlTitleMusiques.setText("Mes musiques");
						jlTitleMusiques.setHorizontalAlignment(SwingConstants.LEFT);
						jlTitleMusiques.setBorder(new EmptyBorder(10, 15, 5, 0));
						jlTitleMusiques.setBorderPainted(false);
						jlTitleMusiques.setRequestFocusEnabled(false);
						jlTitleMusiques.setFocusable(false);
						jlTitleMusiques.setFont(new Font("Segoe UI", Font.PLAIN, 14));
						jlTitleMusiques.setForeground(new Color(75, 88, 105));
						jlTitleMusiques.setContentAreaFilled(false);
						jlTitleMusiques.setBackground(new Color(229, 229, 229));
						jpLibsViews.add(jlTitleMusiques, BorderLayout.NORTH);

						//---- jlLibs ----
						jlLibs.setBackground(new Color(229, 229, 229));
						jlLibs.setBorder(new EmptyBorder(0, 20, 5, 0));
						jlLibs.setForeground(Color.darkGray);
						jlLibs.setFont(new Font("Segoe UI", Font.PLAIN, 11));
						jlLibs.setModel(new AbstractListModel<String>() {
							String[] values = {
								"jvdurieu@gmail.com"
							};
							@Override
							public int getSize() { return values.length; }
							@Override
							public String getElementAt(int i) { return values[i]; }
						});
						jlLibs.setRequestFocusEnabled(false);
						jlLibs.setSelectionBackground(new Color(229, 229, 229));
						jlLibs.setSelectionForeground(Color.darkGray);
						jpLibsViews.add(jlLibs, BorderLayout.CENTER);
					}
					jpLibraryContainers.add(jpLibsViews, BorderLayout.CENTER);
				}
				jpLibViewContainer.add(jpLibraryContainers);

				//======== ViewContainer ========
				{
					ViewContainer.setBorder(new MatteBorder(1, 0, 1, 0, new Color(187, 187, 187)));
					ViewContainer.setBackground(new Color(229, 229, 229));
					ViewContainer.setPreferredSize(new Dimension(200, 42));
					ViewContainer.setLayout(new HorizontalLayout());

					//======== ViewsGridLayout ========
					{
						ViewsGridLayout.setBackground(new Color(229, 229, 229));
						ViewsGridLayout.setBorder(new EmptyBorder(5, 8, 5, 0));
						ViewsGridLayout.setLayout(new GridLayout());

						//---- jbViewSimple ----
						jbViewSimple.setIcon(new ImageIcon("C:\\Users\\Jean-Vital\\WorkSpace\\TestJFormDesigner\\res\\ico_simpleListSelected.jpg"));
						jbViewSimple.setBorderPainted(false);
						jbViewSimple.setFocusPainted(false);
						jbViewSimple.setBorder(null);
						jbViewSimple.setBackground(new Color(229, 229, 229));
						jbViewSimple.setMargin(new Insets(2, 0, 2, 14));
						ViewsGridLayout.add(jbViewSimple);

						//---- jbViewOneC ----
						jbViewOneC.setIcon(new ImageIcon("C:\\Users\\Jean-Vital\\WorkSpace\\TestJFormDesigner\\res\\ico_oneList.jpg"));
						jbViewOneC.setBorder(null);
						jbViewOneC.setBorderPainted(false);
						jbViewOneC.setBackground(new Color(229, 229, 229));
						jbViewOneC.setFocusPainted(false);
						ViewsGridLayout.add(jbViewOneC);

						//---- jbViewTwoC ----
						jbViewTwoC.setIcon(new ImageIcon("C:\\Users\\Jean-Vital\\WorkSpace\\TestJFormDesigner\\res\\ico_twoList.jpg"));
						jbViewTwoC.setBorder(null);
						jbViewTwoC.setBorderPainted(false);
						jbViewTwoC.setBackground(new Color(229, 229, 229));
						jbViewTwoC.setFocusPainted(false);
						ViewsGridLayout.add(jbViewTwoC);

						//---- jbviewThreeC ----
						jbviewThreeC.setIcon(new ImageIcon("C:\\Users\\Jean-Vital\\WorkSpace\\TestJFormDesigner\\res\\ico_threeList.jpg"));
						jbviewThreeC.setBorder(null);
						jbviewThreeC.setBorderPainted(false);
						jbviewThreeC.setBackground(new Color(229, 229, 229));
						jbviewThreeC.setMargin(new Insets(2, 14, 2, 0));
						jbviewThreeC.setFocusPainted(false);
						ViewsGridLayout.add(jbviewThreeC);
					}
					ViewContainer.add(ViewsGridLayout);

					//======== jpPVBorder3 ========
					{
						jpPVBorder3.setBackground(new Color(229, 229, 229));
						jpPVBorder3.setBorder(new AbstractBorder_menu());
						jpPVBorder3.setPreferredSize(new Dimension(12, 12));
						jpPVBorder3.setLayout(new VerticalLayout());
					}
					ViewContainer.add(jpPVBorder3);
				}
				jpLibViewContainer.add(ViewContainer);
			}
			jpPlaylistViews.add(jpLibViewContainer, BorderLayout.PAGE_START);

			//======== jpPlaylistContainer ========
			{
				jpPlaylistContainer.setBackground(new Color(229, 229, 229));
				jpPlaylistContainer.setLayout(new BorderLayout());

				//======== jpPVBorder2 ========
				{
					jpPVBorder2.setBackground(new Color(229, 229, 229));
					jpPVBorder2.setBorder(new AbstractBorder_menu());
					jpPVBorder2.setPreferredSize(new Dimension(12, 12));
					jpPVBorder2.setLayout(new VerticalLayout());
				}
				jpPlaylistContainer.add(jpPVBorder2, BorderLayout.EAST);

				//======== panel2 ========
				{
					panel2.setBackground(new Color(229, 229, 229));
					panel2.setLayout(new VerticalLayout(2));

					//---- label3 ----
					label3.setText("Playlist g\u00e9n\u00e9rique");
					label3.setForeground(Color.gray);
					label3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
					label3.setBackground(new Color(229, 229, 229));
					label3.setBorder(new EmptyBorder(8, 10, 8, 0));
					panel2.add(label3);

					//---- list1 ----
					list1.setBorder(new EmptyBorder(0, 15, 0, 0));
					list1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
					list1.setForeground(new Color(59, 60, 62));
					list1.setBackground(new Color(229, 229, 229));
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
					panel2.add(list1);

					//---- label2 ----
					label2.setText("Mes playlist");
					label2.setForeground(Color.gray);
					label2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
					label2.setBackground(new Color(229, 229, 229));
					label2.setBorder(new EmptyBorder(8, 10, 8, 0));
					panel2.add(label2);

					//---- list2 ----
					list2.setBorder(new EmptyBorder(0, 15, 0, 0));
					list2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
					list2.setForeground(new Color(59, 60, 62));
					list2.setBackground(new Color(229, 229, 229));
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
					panel2.add(list2);
				}
				jpPlaylistContainer.add(panel2, BorderLayout.CENTER);
			}
			jpPlaylistViews.add(jpPlaylistContainer, BorderLayout.CENTER);
		}
		add(jpPlaylistViews, BorderLayout.LINE_START);

		//======== jpPlayingInfo ========
		{
			jpPlayingInfo.setMinimumSize(new Dimension(220, 0));
			jpPlayingInfo.setPreferredSize(new Dimension(220, 0));
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

						//---- jbImage ----
						jbImage.setSelectedIcon(null);
						jbImage.setIcon(new ImageIcon(getClass().getResource("/images/td_miniature.png")));
						jbImage.setPreferredSize(new Dimension(50, 50));
						jbImage.setBorder(null);
						jbImage.setBackground(new Color(245, 245, 245));
						jbImage.setBorderPainted(false);
						jbImage.setMaximumSize(new Dimension(60, 60));
						jpImageContainer.add(jbImage, BorderLayout.CENTER);

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
							jlTitle.setForeground(new Color(83, 101, 125));
							jlTitle.setBackground(new Color(245, 245, 245));
							jpInfoListTitle.add(jlTitle);

							//---- jlArtist ----
							jlArtist.setText("Artiste");
							jlArtist.setForeground(new Color(83, 101, 125));
							jlArtist.setBackground(new Color(245, 245, 245));
							jpInfoListTitle.add(jlArtist);

							//---- jlAlbum ----
							jlAlbum.setText("Album");
							jlAlbum.setForeground(new Color(83, 101, 125));
							jlAlbum.setBackground(new Color(245, 245, 245));
							jpInfoListTitle.add(jlAlbum);

							//---- jlDuree ----
							jlDuree.setText("Dur\u00e9e");
							jlDuree.setForeground(new Color(83, 101, 125));
							jlDuree.setBackground(new Color(245, 245, 245));
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
							jlTitleValue.setForeground(new Color(83, 101, 125));
							jpInfoListValue.add(jlTitleValue);

							//---- jlArtistValue ----
							jlArtistValue.setText("Daft Punk");
							jlArtistValue.setForeground(new Color(83, 101, 125));
							jpInfoListValue.add(jlArtistValue);

							//---- jlAlbumValue ----
							jlAlbumValue.setText("Discovery");
							jlAlbumValue.setForeground(new Color(83, 101, 125));
							jpInfoListValue.add(jlAlbumValue);

							//---- jlDureeValue ----
							jlDureeValue.setText("5:20");
							jlDureeValue.setForeground(new Color(83, 101, 125));
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
		add(jpPlayingInfo, BorderLayout.LINE_END);

		//======== jpCenterMain ========
		{
			jpCenterMain.setLayout(new BorderLayout());

			//======== jpFilterContainer ========
			{
				jpFilterContainer.setBackground(Color.white);
				jpFilterContainer.setLayout(new HorizontalLayout());

				//======== jpArtistlist ========
				{
					jpArtistlist.setBackground(new Color(246, 247, 249));
					jpArtistlist.setPreferredSize(new Dimension(180, 0));
					jpArtistlist.setBorder(new MatteBorder(0, 0, 0, 1, new Color(188, 188, 188)));
					jpArtistlist.setLayout(new BorderLayout());

					//======== jpArtistHead ========
					{
						jpArtistHead.setBackground(new Color(245, 245, 245));
						jpArtistHead.setBorder(new MatteBorder(0, 0, 1, 0, new Color(205, 205, 205)));
						jpArtistHead.setPreferredSize(new Dimension(94, 31));
						jpArtistHead.setLayout(new FlowLayout(FlowLayout.LEFT));

						//---- label8 ----
						label8.setText("Artistes");
						label8.setBackground(new Color(245, 245, 245));
						label8.setFont(new Font("Segoe UI", Font.BOLD, 12));
						label8.setBorder(new EmptyBorder(2, 5, 2, 5));
						label8.setForeground(new Color(65, 72, 80));
						jpArtistHead.add(label8);

						//---- label9 ----
						label9.setText("(1236)");
						label9.setBorder(new EmptyBorder(1, 0, 0, 0));
						label9.setForeground(new Color(81, 72, 73));
						label9.setFont(new Font("Tahoma", Font.PLAIN, 10));
						jpArtistHead.add(label9);
					}
					jpArtistlist.add(jpArtistHead, BorderLayout.NORTH);

					//======== spArtist ========
					{
						spArtist.setBackground(new Color(246, 247, 249));
						spArtist.setBorder(null);

						//---- jlArtistes ----
						jlArtistes.setBackground(new Color(246, 247, 249));
						jlArtistes.setBorder(new EmptyBorder(2, 10, 0, 0));
						spArtist.setViewportView(jlArtistes);
					}
					jpArtistlist.add(spArtist, BorderLayout.CENTER);

					//======== jpArtistResize ========
					{
						jpArtistResize.setPreferredSize(new Dimension(10, 0));
						jpArtistResize.setBackground(new Color(246, 247, 249));
						jpArtistResize.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
						jpArtistResize.setLayout(new BorderLayout());
					}
					jpArtistlist.add(jpArtistResize, BorderLayout.EAST);
				}
				jpFilterContainer.add(jpArtistlist);

				//======== jpAlbums ========
				{
					jpAlbums.setBackground(new Color(246, 247, 249));
					jpAlbums.setPreferredSize(new Dimension(180, 0));
					jpAlbums.setBorder(new MatteBorder(0, 0, 0, 1, new Color(188, 188, 188)));
					jpAlbums.setLayout(new BorderLayout());

					//======== jpAlbumHead ========
					{
						jpAlbumHead.setBackground(new Color(245, 245, 245));
						jpAlbumHead.setBorder(new MatteBorder(0, 0, 1, 0, new Color(205, 205, 205)));
						jpAlbumHead.setPreferredSize(new Dimension(94, 31));
						jpAlbumHead.setLayout(new FlowLayout(FlowLayout.LEFT));

						//---- label10 ----
						label10.setText("Albums");
						label10.setBackground(new Color(245, 245, 245));
						label10.setFont(new Font("Segoe UI", Font.BOLD, 12));
						label10.setBorder(new EmptyBorder(2, 5, 2, 5));
						label10.setForeground(new Color(65, 72, 80));
						jpAlbumHead.add(label10);

						//---- label11 ----
						label11.setText("(2311)");
						label11.setBorder(new EmptyBorder(1, 0, 0, 0));
						label11.setForeground(new Color(81, 72, 73));
						label11.setFont(new Font("Tahoma", Font.PLAIN, 10));
						jpAlbumHead.add(label11);
					}
					jpAlbums.add(jpAlbumHead, BorderLayout.NORTH);

					//======== spAlbum ========
					{
						spAlbum.setBackground(new Color(246, 247, 249));
						spAlbum.setBorder(null);

						//---- jlAlbums ----
						jlAlbums.setBackground(new Color(246, 247, 249));
						jlAlbums.setBorder(new EmptyBorder(2, 10, 0, 0));
						spAlbum.setViewportView(jlAlbums);
					}
					jpAlbums.add(spAlbum, BorderLayout.CENTER);

					//======== jpAlbumResize ========
					{
						jpAlbumResize.setPreferredSize(new Dimension(10, 0));
						jpAlbumResize.setBackground(new Color(246, 247, 249));
						jpAlbumResize.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
						jpAlbumResize.setLayout(new BorderLayout());
					}
					jpAlbums.add(jpAlbumResize, BorderLayout.EAST);
				}
				jpFilterContainer.add(jpAlbums);
			}
			jpCenterMain.add(jpFilterContainer, BorderLayout.WEST);

			//======== jpTrackContainer ========
			{
				jpTrackContainer.setBackground(Color.white);
				jpTrackContainer.setPreferredSize(new Dimension(100, 0));
				jpTrackContainer.setLayout(new BorderLayout());

				//======== jpSelectedTrackMenu ========
				{
					jpSelectedTrackMenu.setPreferredSize(new Dimension(94, 31));
					jpSelectedTrackMenu.setBackground(new Color(245, 245, 245));
					jpSelectedTrackMenu.setBorder(new MatteBorder(0, 0, 1, 0, new Color(203, 203, 203)));
					jpSelectedTrackMenu.setLayout(new BorderLayout());

					//======== jpLectureMenu ========
					{
						jpLectureMenu.setBorder(new EmptyBorder(0, 25, 0, 0));
						jpLectureMenu.setBackground(new Color(245, 245, 245));
						jpLectureMenu.setLayout(new HorizontalLayout());

						//---- jbEcoutezArtist ----
						jbEcoutezArtist.setText("Ecoutez Daft Punk");
						jbEcoutezArtist.setBackground(new Color(245, 245, 245));
						jbEcoutezArtist.setBorderPainted(false);
						jbEcoutezArtist.setBorder(new EmptyBorder(0, 5, 0, 15));
						jbEcoutezArtist.setForeground(new Color(78, 94, 107));
						jbEcoutezArtist.setContentAreaFilled(false);
						jbEcoutezArtist.setFocusPainted(false);
						jpLectureMenu.add(jbEcoutezArtist);

						//---- jbEcoutezAlbum ----
						jbEcoutezAlbum.setText("Ecoutez Discovery");
						jbEcoutezAlbum.setBackground(new Color(245, 245, 245));
						jbEcoutezAlbum.setBorderPainted(false);
						jbEcoutezAlbum.setBorder(new EmptyBorder(0, 5, 0, 15));
						jbEcoutezAlbum.setForeground(new Color(78, 94, 107));
						jbEcoutezAlbum.setContentAreaFilled(false);
						jbEcoutezAlbum.setFocusPainted(false);
						jpLectureMenu.add(jbEcoutezAlbum);
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
					jspTracks.setBorder(BorderFactory.createEmptyBorder());
					jspTracks.setMinimumSize(new Dimension(300, 200));

					//---- jtTracks ----
					jtTracks.setGridColor(new Color(229, 229, 229));
					jtTracks.setRowHeight(18);
					jtTracks.setRowMargin(3);
					jtTracks.setBorder(null);
					jtTracks.setPreferredSize(new Dimension(3150, 300));
					jtTracks.setIntercellSpacing(new Dimension(10, 3));
					jspTracks.setViewportView(jtTracks);
				}
				jpTrackContainer.add(jspTracks, BorderLayout.CENTER);
			}
			jpCenterMain.add(jpTrackContainer, BorderLayout.CENTER);
		}
		add(jpCenterMain, BorderLayout.CENTER);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - jv dudux
	private JPanel jpHeader;
	private JPanel jpLeftHeader;
	private JLabel jlAppName;
	private JPanel jpPlayButMenu;
	private JButton jbPrevious;
	private JButton jbPausPlay;
	private JButton jbNext;
	private JPanel jbRightHeader;
	private JButton button2;
	private JPanel jpCenterHeader;
	private JPanel jpPlaylistViews;
	private JPanel jpLibViewContainer;
	private JPanel jpLibraryContainers;
	private JPanel jpPVBorder;
	private JPanel jpLibsViews;
	private JButton jlTitleMusiques;
	private JList<String> jlLibs;
	private JPanel ViewContainer;
	private JPanel ViewsGridLayout;
	private JButton jbViewSimple;
	private JButton jbViewOneC;
	private JButton jbViewTwoC;
	private JButton jbviewThreeC;
	private JPanel jpPVBorder3;
	private JPanel jpPlaylistContainer;
	private JPanel jpPVBorder2;
	private JPanel panel2;
	private JLabel label3;
	private JList<String> list1;
	private JLabel label2;
	private JList<String> list2;
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
	private JButton jbImage;
	private JPanel jpSpaceT;
	private JPanel jpSpaceS;
	private JPanel jpInfoTxt;
	private JPanel jpInfoListTitle;
	private JLabel jlTitle;
	private JLabel jlArtist;
	private JLabel jlAlbum;
	private JLabel jlDuree;
	private JPanel jpInfoListValue;
	private JLabel jlTitleValue;
	private JLabel jlArtistValue;
	private JLabel jlAlbumValue;
	private JLabel jlDureeValue;
	private JPanel jpCenterMain;
	private JPanel jpFilterContainer;
	private JPanel jpArtistlist;
	private JPanel jpArtistHead;
	private JLabel label8;
	private JLabel label9;
	private JScrollPane spArtist;
	private JList jlArtistes;
	private JPanel jpArtistResize;
	private JPanel jpAlbums;
	private JPanel jpAlbumHead;
	private JLabel label10;
	private JLabel label11;
	private JScrollPane spAlbum;
	private JList jlAlbums;
	private JPanel jpAlbumResize;
	private JPanel jpTrackContainer;
	private JPanel jpSelectedTrackMenu;
	private JPanel jpLectureMenu;
	private JButton jbEcoutezArtist;
	private JButton jbEcoutezAlbum;
	private JPanel jpDisplayMenu;
	private JScrollPane jspTracks;
	private JTable jtTracks;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
