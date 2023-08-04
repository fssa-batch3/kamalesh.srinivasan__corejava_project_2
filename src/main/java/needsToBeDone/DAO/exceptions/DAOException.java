package needsToBeDone.DAO.exceptions;

public class DAOException extends Exception {

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable e) {
		super(e);
	}

}
