package needsToBeDone.validation.exceptions;

public class InvalidJobException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidJobException(String msg) {
		super(msg);
	}

	public InvalidJobException(Throwable e) {
		super(e);
	}
}
