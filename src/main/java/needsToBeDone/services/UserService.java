package needsToBeDone.services;

import needsToBeDone.DAO.UserDAO;
import needsToBeDone.DAO.exceptions.DAOException;
import needsToBeDone.model.User;
import needsToBeDone.services.exceptions.ServiceException;
import needsToBeDone.validation.UserValidator;
import needsToBeDone.validation.exceptions.InvalidUserException;

public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				System.out.println(user.getUsername() + " Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			if (userDAO.checkUserLogin(user.getEmail(), user.getPassword())) {
				System.out.println(user.getEmail() + " Successfully Logged In!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
