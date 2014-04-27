package com.Hemixos;

import gui_actionUpdater.AlbumComparator;
import gui_actionUpdater.ArtistComparator;
import gui_actionUpdater.ListUpdater;

import java.awt.Dimension;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTable;

import layer_manager.ApiManager;
import library.Album;
import library.Artist;
import library.Library;
import library.Song;
import exceptions.UndefineGoogleManagerAPI;
import exceptions.UnselectedLibraryException;

public class Model_data {

	
	// Main model
	private Model model;
	
	// Libraries
	private ArrayList<Library> libs;

	// Current library
	private Library lib;
	
	// Google music
	private ApiManager gm;	
	
	// Artists
	private Vector<Artist> listArtist; // liste avec tous les nom artistes
	private Artist selectedArtist; // L'artiste selectionné

	// Album
	private Vector<Album> listeAlbums; // liste avec tous les nom d'albums
	private Album selectedAlbum; // Album selectionné
	
	// Song
	private Vector<Song> listSong; // liste des songs displayed dans la JTable

	private JTable jtTable;

	
	/**
	 * Constructeur
	 * @param model model principal
	 */
	public Model_data(Model model) {

		this.model = model;
		
		selectedArtist = null;
		selectedAlbum = null;
			
		this.libs = new ArrayList<Library>();
	}
	
	/**
	 * Connect the library to the google account
	 * @throws ConnectException 
	 */
	public void connectToGM() throws ConnectException {
		try {			
			this.gm = new ApiManager(lib.getUserName(), lib.getPassword());
		} catch (Exception e) {
			throw new ConnectException();
		}
		return;
	}
	
	/**
	 * Récupère les pistes de la librairie et renvoie un vecteur y de vecteurs avec toute les données des pistes de la librairie en cours
	 * @return un vecteur de vecteur de data pistes
	 */
	public Vector<Song> getListePisteData() {
		
		Vector<Song> v = new Vector<Song>();

		Iterator<Song> itt;
		
		// Si un album est sélectionné
		if (selectedAlbum != null) {
			itt = selectedAlbum.getMapSongs().values().iterator();
		// Si pas d'album sélectionné
		} else {
			// Si un artist est sélectionné
			if (selectedArtist != null) {	
				itt = selectedArtist.getMapAllSong().values().iterator();
			// Si pas d'artist sélectionné
			} else {
				itt = model.getMd().lib.getMapSongs().values().iterator();
			}
		}
		
		while (itt.hasNext()) {
			v.add(itt.next());
		}
		
		listSong = v;
		return v;
	}

	
	/*
	 * GETTERS and SETTERS
	 */
	
	/**
	 * @return the selectedArtist
	 */
	public Artist getSelectedArtist() {
		return selectedArtist;
	}

	/**
	 * Set the current library
	 * @param lib The Current library, has to be part of the libs
	 * @return true if the library has been successfully set
	 */
	public boolean setCurrentLibrary(Library lib) {
		
		if (!libs.contains(lib))
			return false;
		
		this.lib = lib;
		return true;
	}
	
	
	public Library getLib() throws UnselectedLibraryException {
		if (lib != null) {
			return lib;
		}
		
		throw new UnselectedLibraryException();
	}

	/**
	 * Renvoie l'entête de la JTable principale
	 * @return
	 */
	public Vector<String> getListePisteCN() {

		Vector<String> c = new Vector<>();
		c.add("Titre");
		c.add("Artiste");
		c.add("album");
		c.add("ID");
		return c;

	}


	public void addLib(Library l) {
		if (!libs.contains(l)) {
			this.libs.add(l);
			this.lib = l;
		}
	}
	
	/**
	 * Getter pour GoogleMusic Manager : ApiManager
	 * @return Google music manager
	 * @throws UndefineGoogleManagerAPI 
	 */
	public ApiManager getGm() throws UndefineGoogleManagerAPI {
		if (gm == null) {
			throw new UndefineGoogleManagerAPI();
		}
		return gm;
	}
	
	
	public void setGm(ApiManager gm) {
		this.gm = gm;
	}

	/**
	 * @return the libs
	 */
	public ArrayList<Library> getLibs() {
		return libs;
	}

	/**
	 * Renvoie le vecteur des artistes pour la JList d'artist
	 * @return
	 */
	public Vector<Artist> getArtistVector() {
		if (listArtist == null) {
			setArtistVector();
		}
		return listArtist;
	}
	
	/**
	 * Renvoie le vecteur d'albums pour la JList d'albums
	 * @return
	 */
	public Vector<Album> getAlbumVector() {
		setAlbumsVector();
		return listeAlbums;
	}


	private void setAlbumsVector() {
		listeAlbums = new Vector<>();
		
		Iterator<Entry<String, Album>> ita;
						
		// Si un artist est sélectionné
		if (selectedArtist != null) {	
			ita = selectedArtist.getMapAlbum().entrySet().iterator();
		// Si pas d'artist sélectionné
		} else {
			ita = model.getMd().lib.getMapAlbums().entrySet().iterator();
		}
		
		Vector<Album> tmpv = new Vector<>();
		while (ita.hasNext()) {
			tmpv.add(ita.next().getValue());
		}
		
		Album[] array = new Album[tmpv.size()];   
		tmpv.copyInto(array);   

		AlbumComparator ac = new AlbumComparator();
	    Arrays.sort(array, ac );

	    for (int i=0; i<array.length ; i++) {
	    	listeAlbums.insertElementAt(array[i], i);
		}
				
		 //Collections.sort(listeAlbums);				
	}

	
	private void setArtistVector() {
		listArtist = new Vector<>();
		
		Iterator<Entry<String, Artist>> ita = 	lib.getMapArtist().entrySet().iterator();
				
		Vector<Artist> tmpa = new Vector<>();
		while (ita.hasNext()) {
			Entry<String, Artist> am = ita.next();
			tmpa.add(am.getValue());
		}
		
		Artist[] array = new Artist[tmpa.size()];   
		tmpa.copyInto(array);   

		ArtistComparator ac = new ArtistComparator();
	    Arrays.sort(array, ac );

	    for (int i=0; i<array.length ; i++) {
	    	listArtist.insertElementAt(array[i], i);
		}
	
	}


	public void setSelectedArtist(int selectedIndex) {		
		
		if (selectedIndex == -1) {
			selectedArtist = null;
			model.getMc().jbAddSelectedArtist.setVisible(false);
			model.getMc().jbAddSelectedAlbum.setVisible(false);
		} else {
			selectedArtist = listArtist.get(selectedIndex);
		}
		
		// On filtre les albums
		try {
			ListUpdater.refreshAlbumList(model);
		} catch (UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// On filtre les pistes
		ListUpdater.refreshTrackTable(model);
		
		// On rafraichi les boutons
		if (selectedArtist != null) {
			model.getMc().jbAddSelectedArtist.setText("Play all " + selectedArtist.getArtistName());
			model.getMc().jbAddSelectedArtist.setVisible(true);
			model.getMc().jbAddSelectedAlbum.setVisible(false);
			model.getMc().jbAddSelectedArtist.setPreferredSize(new Dimension(selectedArtist.getArtistName().length()*8+90, 20));
		}

	}

	/**
	 * @return the selectedAlbum
	 */
	public Album getSelectedAlbum() {
		return selectedAlbum;
	}

	/**
	 * @param selectedAlbum the selectedAlbum to set
	 */
	public void setSelectedAlbum(int selectedAlbum) {
		//this.selectedAlbum = selectedAlbum;
		if (selectedAlbum == -1) {
			this.selectedAlbum = null;
			model.getMc().jbAddSelectedAlbum.setVisible(false);
			
		} else {
			this.selectedAlbum = listeAlbums.get(selectedAlbum);
		}
		
		// On filtre les pistes
		ListUpdater.refreshTrackTable(model);
		
		// On rafraichi les boutons
		if (this.selectedAlbum != null) {
			model.getMc().jbAddSelectedArtist.setText("Play all " + this.selectedAlbum.getArtist().getArtistName());
			model.getMc().jbAddSelectedArtist.setVisible(true);
			model.getMc().jbAddSelectedArtist.setPreferredSize(new Dimension(this.selectedAlbum.getArtist().getArtistName().length()*8+90, 20));

			model.getMc().jbAddSelectedAlbum.setText("Play " + this.selectedAlbum.getName());
			model.getMc().jbAddSelectedAlbum.setVisible(true);
			model.getMc().jbAddSelectedAlbum.setPreferredSize(new Dimension(this.selectedAlbum.getName().length()*9+60, 20));
		} else {
			model.getMc().jbAddSelectedAlbum.setVisible(false);
			model.getMc().jbAddSelectedArtist.setVisible(false);

		}

	}

	/**
	 * @return the listeAlbums
	 */
	public Vector<Album> getListeAlbums() {
		return listeAlbums;
	}

	/**
	 * @return the listSong
	 */
	public Vector<Song> getListSong() {
		return listSong;
	}

	public void setTableTrack(JTable jtTable) {
		this.jtTable = jtTable;
	}
	
	public JTable getTableTrack() {
		return jtTable;
	}

}

























