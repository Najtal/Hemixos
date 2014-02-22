/*******************************************************************************
 * Copyright (c) 2012 Jens Kristian Villadsen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Jens Kristian Villadsen - initial API and implementation
 ******************************************************************************/
package layer_manager;

import gmusic.api.comm.ApacheConnector;
import gmusic.api.comm.JSON;
import gmusic.api.comm.Util;
import gmusic.api.impl.GoogleMusicAPI;
import gmusic.api.impl.GoogleSkyJamAPI;
import gmusic.api.impl.InvalidCredentialsException;
import gmusic.api.interfaces.IGoogleMusicAPI;
import gmusic.api.model.Playlist;
import gmusic.api.model.Playlists;
import gmusic.api.model.Song;
import gmusic.api.skyjam.model.AlbumArtRef;
import gmusic.api.skyjam.model.Track;
import gmusic.api.skyjam.model.TrackFeed;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Collection;

import javax.print.URIException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.datatype.Artwork;
import org.jaudiotagger.tag.id3.ID3v24Tag;

import com.google.common.io.Closeables;



/**
 * 
 * Classe qui test les perf de la cnx, la récup et la lecture de fichiers sur google music
 * 
 * @author Jean-Vital
 *
 */

public class ApiManager {
	
	private GoogleMusicAPI GMapi;
	
	
	private GoogleSkyJamAPI api;
	private GoogleMusicAPI aa;
	
	private String password;
	private String username;
	
	/**
	 * Constructor
	 * @param username google account name 
	 * @param password google account password 
	 */
	public ApiManager(String username, String password) {
		
		this.username = username;
		this.password = password;

		
		/*
		 * Connexion
		 */
        
		aa = new GoogleMusicAPI();
        // IGoogleMusicAPI api = new GoogleSkyJamAPI();
        // GoogleSkyJamAPI api = new GoogleSkyJamAPI(new ApacheConnector(), new JSON(), new File("."));
        // GoogleMusicAPI aa = new GoogleMusicAPI(new ApacheConnector(), new JSON(), new File("."));

        try {
                api = new GoogleSkyJamAPI();
                api.login(username, password);
                new GoogleMusicAPI().login(username, password);
        } catch(Exception e) {
                e.printStackTrace();
        }

        try {
			aa.login(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	
	/*public GoogleSkyJamAPI getGsjApiSource() {
		return api;
	}*/
	
	public GoogleMusicAPI getGmApiSource() {
		return aa;
	}



	/*
	 * Récupère toute les pistes de GM
	 * @return a collection of tracks
	 * @throws Exception 
	 
	public Collection<Track> getAllTrack() throws Exception {
		
		Collection<Track> tracks;
		try {
			tracks = api.getAllTracks();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new Exception();
		}
		
		return tracks;
	}*/
	
	public Collection<Song> getAllSongs() throws Exception {
		
		Collection<Song> songs;
		try {
			songs = aa.getAllSongs();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new Exception();
		}
		
		return songs;
	}
		
	
	/**
	 * Get all the playlists from the API
	 * @return all the API
	 */
	public Playlists getAllplaylist() {
		Playlists playlists = null;
		
		try {
			playlists = api.getAllPlaylists();
	
			if (playlists.getMagicPlaylists() != null) {
				for (Playlist list : playlists.getMagicPlaylists()) {
					System.out.println("--- " + list.getTitle() + " "
							+ list.getPlaylistId() + " ---");
					for (Song song : list.getPlaylist()) {
						System.out.println(song.getName() + " "
								+ song.getArtist());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return playlists;
	}


	/**
	 * Return the URI of a track
	 * @param t The track
	 * @return the URI of the track
	 * @throws Exception 
	 */
	public URI getTrackURL(Song s) throws Exception {
		try {
						
			api.getSongURL(s);			
			
			return api.getSongURL(s);
		} catch (URISyntaxException | IOException e) {
			throw new Exception();
		}
	}

	
	/**
	 * Return the Sky Jam Playlists
	 * @return the Sky Jam Playlists
	 */
	public gmusic.api.skyjam.model.Playlists getSJPlaylists() {
		try {
			return api.getAllSkyJamPlaylists();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * Populate a empty file with the tags and the content of a song
	 * @param file the empty file
	 * @param song the song
	 * @throws IOException in case of an error with the file
	 */
	private static void populateFileWithTuneTags(File file, Song song) throws IOException {
		try {
			AudioFile f = AudioFileIO.read(file);
			Tag tag = f.getTag();
			if (tag == null) {
				tag = new ID3v24Tag();
			}
			tag.setField(FieldKey.ALBUM, song.getAlbum());
			tag.setField(FieldKey.ALBUM_ARTIST, song.getAlbumArtist());
			tag.setField(FieldKey.ARTIST, song.getArtist());
			tag.setField(FieldKey.COMPOSER, song.getComposer());
			tag.setField(FieldKey.DISC_NO, String.valueOf(song.getDisc()));
			tag.setField(FieldKey.DISC_TOTAL,
					String.valueOf(song.getTotalDiscs()));
			tag.setField(FieldKey.GENRE, song.getGenre());
			tag.setField(FieldKey.TITLE, song.getTitle());
			tag.setField(FieldKey.TRACK, String.valueOf(song.getTrack()));
			tag.setField(FieldKey.TRACK_TOTAL,
					String.valueOf(song.getTotalTracks()));
			tag.setField(FieldKey.YEAR, String.valueOf(song.getYear()));

			if (song.getAlbumArtUrl() != null) {
				Artwork artwork = new Artwork();
				File imageFile = new File(new File(".")
						+ System.getProperty("path.separator") + song.getId()
						+ ".im");
				ByteBuffer buffer = Util
						.uriTobuffer(song.getAlbumArtUrlAsURI());
				FileOutputStream fos = new FileOutputStream(imageFile);
				fos.write(buffer.array());
				Closeables.close(fos, true);
				// FileUtils.copyURLToFile(song.getAlbumArtUrlAsURI().toURL(),
				// imageFile);
				artwork.setFromFile(imageFile);
				tag.addField(artwork);
			}

			f.setTag(tag);
			AudioFileIO.write(f);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	
	/**
	 * Populate a empty file with the tags and the content of a Track
	 * @param file the empty file
	 * @param track the track
	 * @throws IOException in case of an error with the file
	 */
	private static void populateFileWithTuneTags(File file, Track track) throws IOException {
		try {
			AudioFile f = AudioFileIO.read(file);
			Tag tag = f.getTag();
			if (tag == null) {
				tag = new ID3v24Tag();
			}
			tag.setField(FieldKey.ALBUM, track.getAlbum());
			tag.setField(FieldKey.ALBUM_ARTIST, track.getAlbumArtist());
			tag.setField(FieldKey.ARTIST, track.getArtist());
			tag.setField(FieldKey.COMPOSER, track.getComposer());
			tag.setField(FieldKey.DISC_NO,
					String.valueOf(track.getDiscNumber()));
			tag.setField(FieldKey.DISC_TOTAL,
					String.valueOf(track.getTotalDiscCount()));
			tag.setField(FieldKey.GENRE, track.getGenre());
			tag.setField(FieldKey.TITLE, track.getTitle());
			tag.setField(FieldKey.TRACK, String.valueOf(track.getTrackNumber()));
			tag.setField(FieldKey.TRACK_TOTAL,
					String.valueOf(track.getTotalTrackCount()));
			tag.setField(FieldKey.YEAR, String.valueOf(track.getYear()));

			if (track.getAlbumArtRef() != null
					&& !track.getAlbumArtRef().isEmpty()) {
				AlbumArtRef[] array = track.getAlbumArtRef().toArray(
						new AlbumArtRef[track.getAlbumArtRef().size()]);
				for (int i = 0; i < array.length; i++) {
					Artwork artwork = new Artwork();
					File imageFile = new File(new File(".")
							+ System.getProperty("path.separator")
							+ track.getId() + ".im" + i);
					ByteBuffer buffer = Util
							.uriTobuffer(array[i].getUrlAsURI());
					FileOutputStream fos = new FileOutputStream(imageFile);
					fos.write(buffer.array());
					Closeables.close(fos, true);

					artwork.setFromFile(imageFile);
					tag.addField(artwork);
				}
			}

			f.setTag(tag);
			AudioFileIO.write(f);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}



}
