package exceptions;

/**
 * Classe qui gère les FatalException
 * 
 */
public class ConnexionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur d'exception
	 */
	public ConnexionException() {
		super();
	}

	/**
	 * Constructeur d'exception avec paramètres
	 * 
	 * @param s  Message de l'exception
	 */
	public ConnexionException(final String s) {
		super(s);
	}

	/**
	 * Constructeur avec un paramètre Throwable
	 * 
	 * @param e De type Throwable
	 */
	public ConnexionException(final Throwable e) {
		super(e);
	}
}
