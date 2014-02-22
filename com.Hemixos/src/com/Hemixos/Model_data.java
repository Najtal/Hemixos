package com.Hemixos;

import gmusic.api.model.Song;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JList;

import layer_manager.ApiManager;
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
	
	
	
	/**
	 * Constructeur
	 * @param model model principal
	 */
	public Model_data(Model model) {

		this.model = model;
		
		selectedArtist = -1;
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
		String an = null;
		
		Iterator<Song> itt = lib.getMapSongs().values().iterator();
		
		if (selectedArtist > -1) {
			
			JList<String> liste = model.getMc().listeArtiste;
			an = liste.getModel().getElementAt(liste.getSelectedIndex());

		}
		
		while (itt.hasNext()) {

			song = (Song) itt.next();
			
			if (selectedArtist > -1) {
								
				if (an.equals(song.getArtist())) {
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
			setArtistvector();
		}

		return listArtist;
		
	}




	private void setArtistvector() {
		
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
		
		selectedArtist = selectedIndex;
		
	}


}

























