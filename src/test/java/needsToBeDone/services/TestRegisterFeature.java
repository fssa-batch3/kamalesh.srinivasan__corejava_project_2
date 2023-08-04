package needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import needsToBeDone.model.User;
import needsToBeDone.services.exceptions.ServiceException;

public class TestRegisterFeature {
	public static void main(String[] args) {

		
		LocalDate date = LocalDate.now();

		User user1 = new User("kikamakles@gmail.com", "Kamal_kamal", "Kamal@123", "Kamalesh", "Srinivasan", true, 9876543210l,date,123456789012l,"trichy");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testRegistrationSuccess() {
		LocalDate date = LocalDate.now();

		UserService userService = new UserService();
		User user1 = new User("kikamakles@gmail.com", "Kamal_kamal", "Kamal@123", "Kamalesh", "Srinivasan", true, 9876543210l,date,123456789012l,"trichy");
		try {

			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidPassword() {
		LocalDate date = LocalDate.now();

		UserService userService = new UserService();
		User user1 = new User("kidfadfza@gmail.com", "Kamalkkk", "Kamal123k", "Kamalesh", "Srinivasan",true,9876543210l,date,123456789012l,"trichy");
//		try {
//			assertFalse(userService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		 assertEquals(InvalidUserException(), null);
//		}
		ServiceException exception = assertThrows(ServiceException.class, () -> userService.registerUser(user1));
		assertEquals("Rethrown with a new message", exception.getMessage());
	}

//	@Test
//	public void testUserNull() {
//
//		UserService userService = new UserService();
//		User user1 = null;
//		try {
//			assertFalse(userService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//
//		}
//
//	}

}
