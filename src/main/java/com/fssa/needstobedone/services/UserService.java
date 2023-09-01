package com.fssa.needstobedone.services;

import com.fssa.needstobedone.dao.UserDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.validation.UserValidator;

public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			userDAO.createUser(user);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public User logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {

			User gettedUser = userDAO.getUserByEmail(user.getEmail());
			if (gettedUser == null)
				throw new ServiceException("User is not registered");
			if (!user.getPassword().equals(gettedUser.getPassword())) {
				throw new ServiceException("Login Faild - password mismatch");
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return user;

	}

}
