package exceptions;

public class UndefineGoogleManagerAPI extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur d'exception
	 */
	public UndefineGoogleManagerAPI() {
		super();
	}

	/**
	 * Constructeur d'exception avec paramètres
	 * 
	 * @param s Message de l'exception
	 */
	public UndefineGoogleManagerAPI(final String s) {
		super(s);
	}

	/**
	 * Constructeur avec un paramètre Throwable
	 * 
	 * @param e De type Throwable
	 */
	public UndefineGoogleManagerAPI(final Throwable e) {
		super(e);
	}
}
