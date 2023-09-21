package com.fssa.needstobedone.services;

import com.fssa.needstobedone.dao.UserDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.utils.PasswordUtil;
import com.fssa.needstobedone.validation.UserValidator;

/**
 * The UserService class provides user-related operations such as registration
 * and login.
 */
public class UserService {

	/**
	 * Registers a new user.
	 *
	 * @param user The user to be registered.
	 * @return true if the user is registered successfully, false otherwise.
	 * @throws ServiceException If there is an issue registering the user.
	 */
	public boolean registerUser(User user) throws ServiceException {
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		try {
			userValidator.validateUser(user);
			String newPassword = PasswordUtil.hashPassword(user.getPassword());
			user.setPassword(newPassword);
			userDAO.createUser(user);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Logs in a user.
	 *
	 * @param user The user to be logged in.
	 * @return The logged-in user if login is successful.
	 * @throws ServiceException If there is an issue with the login process.
	 */
	public User logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			User gettedUser = userDAO.getUserByEmail(user.getEmail());
			if (gettedUser == null) {
				throw new DAOException("User is not registered");
			}
			if (!PasswordUtil.checkPassword(user.getPassword(), gettedUser.getPassword())) {
				throw new ServiceException("Login Failed - password mismatch");
			}
			return gettedUser;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
