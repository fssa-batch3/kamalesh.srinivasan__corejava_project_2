package needsToBeDone.services;

import java.time.LocalDate;

import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.services.UserService;

public class TestRegisterFeature {
	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2003, 8, 6);

		User user1 = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan", true, 9876543210l,
				date, 123456789012l, "trichy");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
