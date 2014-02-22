package dto;

import gmusic.api.model.Song;

/**
 * Classe interne destinée a construire la Playing Queue
 * 
 * @author Jean-Vital
 *
 */
public class QueueElement {


	


		private String url;
		
		private String artist;
		private String titre;
		private long durationMillis;
		
		private QueueElement next;

		/**
		 * Unaccible constructor
		 */
		@SuppressWarnings("unused")
		private QueueElement() {
		}
		
		/**
		 * Constructeur d'un noeud membre de la playlist en cours
		 * @param track
		 */
		public QueueElement(String artist, String titre, long durationMillis, String url) {
			this.artist = artist;
			this.titre = titre;
			this.durationMillis = durationMillis;
			this.url = url;
		}
		
	
		public QueueElement(Song s) {
			this.artist = s.getArtist();
			this.titre = s.getTitle();
			this.durationMillis = s.getDurationMillis();
			this.url = s.getUrl();
		}
		

		/**
		 * @return the next
		 */
		public QueueElement getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(QueueElement next) {
			this.next = next;
		}

		/**
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}


		/**
		 * @return the artist
		 */
		public String getArtist() {
			return artist;
		}


		/**
		 * @return the titre
		 */
		public String getTitre() {
			return titre;
		}


		/**
		 * @return the durationMillis
		 */
		public long getDurationMillis() {
			return durationMillis;
		}


	}
