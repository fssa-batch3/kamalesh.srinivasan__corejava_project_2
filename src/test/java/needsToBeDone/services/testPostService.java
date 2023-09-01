package needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Post;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.services.PostService;

public class testPostService {

	@Test
	void testCreatPostSuccess() {
		LocalDate date = LocalDate.of(2003, 8, 6);
		User user = new User("kikamakles@gmail.com", "Kamalesh@1234", "Kamalesh", "Srinivasan", true, 9876543210l, date,
				123456789012l, "trichy");
		Post post = new Post("postman", user);
		try {
			assertTrue(PostService.createPost(post));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
