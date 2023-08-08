package needsToBeDone.validation.exceptions;

public class InvalidJobException extends Exception {
	public InvalidJobException(String msg) {
		super(msg);
	}

	public InvalidJobException(Throwable e) {
		super(e);
	}
}
