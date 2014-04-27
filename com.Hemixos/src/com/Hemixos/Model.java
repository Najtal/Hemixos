package com.Hemixos;

import library.Song;

public class Model {

	// Models
	private Model_window mw;
	
	private Model_data md;
	
	private Model_player mp;

	private Model_comp mc;
	
	private static Model model;
	
	/**
	 * Constructor
	 */
	public Model() {

		// Cree un nouveau modèle de fenetre
		this.mw = new Model_window(this);
		
		// Cree un nouveau modèle de données
		this.md = new Model_data(this);
		
		// Crée un nouveau modèle pour le lecteur multimedia
		this.mp = new Model_player(this);
		
		this.mc = new Model_comp(this);
	
		model = this;
	}


	
	
	/*
	 * GETTERS and SETTERS
	 */
	
	/**
	 * Model window getter : data labout the window
	 * @return the model_window
	 */
	public Model_window getMw() {
		return mw;
	}

	
	/**
	 * Model data getter : The libraries and user datas
	 * @return the model_data
	 */
	public Model_data getMd() {
		return md;
	}

	
	/**
	 * Model player getter : What needed to play music and other
	 * @return the model_player
	 */
	public Model_player getMp() {
		return mp;
	}

	
	/**
	 * @return the mc
	 */
	public Model_comp getMc() {
		return mc;
	}
	

	public static Model getInstance() {
		if (model != null) {
			return model;
		} else {
			return null;
		}
	}

	
	
}
