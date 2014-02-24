package com.Hemixos;

import gmusic.api.model.Song;
import gui_actionUpdater.ListUpdater;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JList;

import layer_manager.ApiManager;
import dto.DTO_Album;
import dto.DTO_Artist;
import dto.Library;
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
	private Vector<String> listArtist; 		// liste avec tous les nom artistes
	private Vector<String> listArtistKey;	// liste avec toute les clés associées

	private int selectedArtist; // L'artiste selectionné

	private Vector<String> listeAlbums;		// liste avec tous les nom d'albums
	private Vector<String> listAlbumKey;	// liste avec toute les clés associées

	private int selectedAlbum; // Album selectionné

	
	/**
	 * Constructeur
	 * @param model model principal
	 */
	public Model_data(Model model) {

		this.model = model;
		
		selectedArtist = -1;
		selectedAlbum = -1;
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
	public Vector getListePisteData() {
		
		Vector<Vector> v = new Vector<Vector>();

		Song song = null;
		String ar = null;
		String al = null;
		
		Iterator<Song> itt = lib.getMapSongs().values().iterator();
		
		if (selectedArtist > -1) {
			JList<String> listeArtist = model.getMc().jlArtistes;
			ar = listeArtist.getModel().getElementAt(listeArtist.getSelectedIndex());
		}

		if (selectedAlbum > -1) {
			JList<String> listeAlbum = model.getMc().jlAlbums;
			al = listeAlbum.getModel().getElementAt(listeAlbum.getSelectedIndex());
		}
		
		while (itt.hasNext()) {

			song = (Song) itt.next();
			
			if (selectedArtist > -1) {
						
				if (selectedAlbum > -1) {
					if (ar.equals(song.getArtist()) && al.equals(song.getAlbum())) {
						Vector<String> vt = new Vector<>();
						vt.add(song.getTitle());
						vt.add(song.getArtist());
						vt.add(song.getAlbum());
						vt.add(song.getId());						
						v.add(vt);						
					}
					
				} else {
					if (ar.equals(song.getArtist())) {
						Vector<String> vt = new Vector<>();
						vt.add(song.getTitle());
						vt.add(song.getArtist());
						vt.add(song.getAlbum());
						vt.add(song.getId());						
						v.add(vt);						
					}
				}
				
			} else {

				if (selectedAlbum > -1) {
					if (al.equals(song.getAlbum())) {
						Vector<String> vt = new Vector<>();
						vt.add(song.getTitle());
						vt.add(song.getArtist());
						vt.add(song.getAlbum());
						vt.add(song.getId());						
						v.add(vt);						
					}
					
				} else {
					Vector<String> vt = new Vector<>();
					vt.add(song.getTitle());
					vt.add(song.getArtist());
					vt.add(song.getAlbum());
					vt.add(song.getId());						
					v.add(vt);	
				}
			}
		}
		
		return v;
	}


	
	
	
	
	/*
	 * GETTERS and SETTERS
	 */
	
	/**
	 * @return the selectedArtist
	 */
	public int getSelectedArtist() {
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

	
	// TODO mettre doc
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




	public Vector<String> getArtistVector() {
		if (listArtist == null) {
			setArtistVector();
		}
		return listArtist;
	}
	
	


	public Vector<String> getAlbumVector() {
		setAlbumsVector();
		return listeAlbums;
	}



	private void setAlbumsVector() {
		listeAlbums = new Vector<>();
		listAlbumKey = new Vector<>();
		
		Iterator<Entry<String, DTO_Album>> ita = lib.getMapAlbums().entrySet().iterator();
				
		boolean filtre = false;
		String selectedArtistName = null;
		
		if (model.getMd().getSelectedArtist() > -1) {
			selectedArtistName  = (String) model.getMc().jlArtistes.getModel().getElementAt(model.getMc().jlArtistes.getSelectedIndex());
			System.out.println("selectedArtist: " + selectedArtist);
			filtre = true;
		}
		
		
		if (filtre) {
			
			while (ita.hasNext()) {
				Entry<String, DTO_Album> nx = ita.next();
				if (nx.getValue().getArtist().getArtistName().equals(selectedArtistName)) {
					listAlbumKey.add(nx.getKey());
					listeAlbums.add(nx.getValue().getAlbumName());
				}
			}
			
		} else {
			
			while (ita.hasNext()) {
				Entry<String, DTO_Album> nx = ita.next();
					listAlbumKey.add(nx.getKey());
					listeAlbums.add(nx.getValue().getAlbumName());
			}
		}
		
		
		
		
		
		
		 Collections.sort(listArtist);				
	}

	private void setArtistVector() {
		
		listArtist = new Vector<>();
		listArtistKey = new Vector<>();
		
		Iterator<Entry<String, DTO_Artist>> ita = 	lib.getMapArtist().entrySet().iterator();
				
		while (ita.hasNext()) {
			Entry<String, DTO_Artist> nx = ita.next();
			
			listArtistKey.add(nx.getKey());
			listArtist.add(nx.getValue().getArtistName());
		}
		
		 Collections.sort(listArtist);		
	}




	public void setSelectedArtist(int selectedIndex) {		
		
		// nouvel artist
		selectedArtist = selectedIndex;
		
		// On filtre les albums
		try {
			ListUpdater.refreshAlbumList(model);
		} catch (UnselectedLibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// On filtre les pistes
		ListUpdater.refreshTrackTable(model);
	}

	/**
	 * @return the selectedAlbum
	 */
	public int getSelectedAlbum() {
		return selectedAlbum;
	}


	/**
	 * @param selectedAlbum the selectedAlbum to set
	 */
	public void setSelectedAlbum(int selectedAlbum) {
		this.selectedAlbum = selectedAlbum;
		
		// On filtre les pistes
		ListUpdater.refreshTrackTable(model);
	}


	/**
	 * @return the listeAlbums
	 */
	public Vector<String> getListeAlbums() {
		return listeAlbums;
	}



}

























