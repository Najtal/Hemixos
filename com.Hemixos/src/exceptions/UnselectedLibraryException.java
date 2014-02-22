package exceptions;

public class UnselectedLibraryException extends Exception {

	/**
	 * Constructeur d'exception
	 */
	public UnselectedLibraryException() {
		super();
	}

	/**
	 * Constructeur d'exception avec paramètres
	 * 
	 * @param s
	 *            Message de l'exception
	 */
	public UnselectedLibraryException(final String s) {
		super(s);
	}

	/**
	 * Constructeur avec un paramètre Throwable
	 * 
	 * @param e
	 *            De type Throwable
	 */
	public UnselectedLibraryException(final Throwable e) {
		super(e);
	}
	
	
}
