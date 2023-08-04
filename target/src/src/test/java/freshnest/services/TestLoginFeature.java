package freshnest.services;

import freshnest.model.User;

public class TestLoginFeature {

	public static void main(String[] args) {

		User user1 = new User("rajalakshmi@gmail.com", "susi123@SM");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
