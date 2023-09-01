package needsToBeDone.services;

import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.services.UserService;

public class TestLoginFeature {

	public static void main(String[] args) {

		User user1 = new User("kikamakles@gmail.com", "Kamal@123");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
