package com.fssa.needstobedone.services;

import java.util.List;

import com.fssa.needstobedone.dao.NotificationDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.AllModal;
import com.fssa.needstobedone.model.Notification;

public class NotificationService {
	NotificationDAO notificationDAO = new NotificationDAO();

	public boolean createNotification(Notification notification) throws ServiceException {
		try {
			notificationDAO.createNotification(notification);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public boolean updateNotification(Notification notification) throws ServiceException {
		try {
			notificationDAO.updateNotificationStatus(notification);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}


	public List<AllModal> getNotificationsByApplierId(int applierId) throws ServiceException {
		try {
			return notificationDAO.getNotificationsByApplierId(applierId);
		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve notifications by applier ID: " + e.getMessage());
		}
	}
	
	public List<AllModal> getNotificationsByUserId(int userId) throws ServiceException {
		try {
			return notificationDAO.getNotificationsByUserId(userId);
		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve notifications by user ID: " + e.getMessage());
		}
	}
	
	
	public Notification getNotificationsById(int Id) throws ServiceException {
		try {
			return notificationDAO.getNotificationById(Id);
		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve notifications by notification ID: " + e.getMessage());
		}
	}
}
