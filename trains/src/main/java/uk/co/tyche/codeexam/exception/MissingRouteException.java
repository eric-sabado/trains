package uk.co.tyche.codeexam.exception;

public class MissingRouteException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

	public MissingRouteException() {
		super(NO_SUCH_ROUTE);
	}

	public MissingRouteException(String message) {
		super(message);
	}

	public MissingRouteException(Throwable cause) {
		super(cause);
	}

	public MissingRouteException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingRouteException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
