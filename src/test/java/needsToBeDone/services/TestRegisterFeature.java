package needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import needsToBeDone.model.User;
import needsToBeDone.services.exceptions.ServiceException;

public class TestRegisterFeature {
	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2003, 8, 6);

		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan", true,
				9876543210l, date, 123456789012l, "trichy");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	

}
