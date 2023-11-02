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
			boolean result = notificationDAO.updateNotificationStatus(notification);
			
			if(!result) {
				throw new ServiceException("Unable to update Notification");
			}
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}


	public List<AllModal> getNotificationsByApplierId(int applierId) throws ServiceException {
		try {
			List<AllModal> result = notificationDAO.getNotificationsByApplierId(applierId);
			if(result.isEmpty()) {
				throw new ServiceException("No Notififcation Found");
			}
			return result;
		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve notifications by applier ID: " + e.getMessage());
		}
	}
	
	public List<AllModal> getNotificationsByUserId(int userId) throws ServiceException {
		try {
			List<AllModal> result = notificationDAO.getNotificationsByUserId(userId);
			if(result.isEmpty()) {
				throw new ServiceException("No Notifications Found");
			}
			return result;
		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve notifications by user ID: " + e.getMessage());
		}
	}
	
	
	public Notification getNotificationsById(int Id) throws ServiceException {
		try {
			Notification result = notificationDAO.getNotificationById(Id);
			if(result == null) {
				throw new ServiceException("No Notifications Found");
			}
			return result;

		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve notifications by notification ID: " + e.getMessage());
		}
	}
}
