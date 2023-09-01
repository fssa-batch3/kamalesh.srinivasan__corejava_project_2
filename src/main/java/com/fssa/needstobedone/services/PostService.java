package com.fssa.needstobedone.services;

import com.fssa.needstobedone.dao.PostDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Post;

public class PostService {

	public static boolean createPost(Post post) throws ServiceException {
		PostDAO postDAO = new PostDAO();
		try {
			if (post == null) {
				throw new ServiceException("Post cannot be null");
			}
//			PostValidator.validatePost(post);
			if (postDAO.createPost(post)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
