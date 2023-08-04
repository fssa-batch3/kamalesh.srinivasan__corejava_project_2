package needsToBeDone.services.exceptions;

public class ServiceException extends Exception {


	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e);
	}

}
