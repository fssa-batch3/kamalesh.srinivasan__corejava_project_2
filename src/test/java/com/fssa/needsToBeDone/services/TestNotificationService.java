package com.fssa.needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Notification;
import com.fssa.needstobedone.services.NotificationService;

public class TestNotificationService {
	private static NotificationService notificationService;
	private static Notification notification;
	@BeforeEach
	void setUp() {
		notificationService = new NotificationService();
		notification = new Notification();
	}
	
	@Test
	public void testCreateNotificationValid() {
		notification.setJobId("b2674d8f-9a2d-49ab-9aed-979bf0d493b5");
		notification.setApplierId(3);
		notification.setStatus("Completed");
	    assertDoesNotThrow(() -> notificationService.createNotification(notification));
	}

	@Test
	public void testUpdateNotificationValid() {
		notification.setNotificationId(10);
		notification.setStatus("Completed");
	    assertDoesNotThrow(() -> notificationService.updateNotification(notification));
	}
	@Test
	public void testGetNotificationsByApplierIdValid() {
	    int validApplierId = 3;
	    assertDoesNotThrow(() -> notificationService.getNotificationsByApplierId(validApplierId));
	}
	@Test
	public void testGetNotificationsByUserIdValid() {
	    int validUserId = 1;
	    assertDoesNotThrow(() -> notificationService.getNotificationsByUserId(validUserId));
	}
	@Test
	public void testGetNotificationsByIdValid() {
	    int validNotificationId = 10;
	    assertDoesNotThrow(() -> notificationService.getNotificationsById(validNotificationId));
	}
	@Test
	public void testCreateNotificationInvalid() {
	    Notification invalidNotification = new Notification(/* invalid data */);
	    assertThrows(ServiceException.class, () -> notificationService.createNotification(invalidNotification));
	}

	@Test
	public void testUpdateNotificationInvalid() {
	    Notification invalidNotification = new Notification();
	    notification.setNotificationId(0);
	    notification.setStatus(null);
	    assertThrows(ServiceException.class, () -> notificationService.updateNotification(invalidNotification));
	}
	@Test
	public void testGetNotificationsByApplierIdInvalid() {
	    int invalidApplierId = 54242;
	    assertThrows(ServiceException.class, () -> notificationService.getNotificationsByApplierId(invalidApplierId));
	}
	@Test
	public void testGetNotificationsByUserIdInvalid() {
	    int invalidUserId = 234253;
	    assertThrows(ServiceException.class, () -> notificationService.getNotificationsByUserId(invalidUserId));
	}
	@Test
	public void testGetNotificationsByIdInvalid() {
	    int invalidNotificationId = 45253;
	    assertThrows(ServiceException.class, () -> notificationService.getNotificationsById(invalidNotificationId));
	}

}
