package com.fssa.needstobedone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.model.Post;
import com.fssa.needstobedone.model.User;
import com.fssa.needstobedone.utils.ConnectionUtil;

public class PostDAO {

	public boolean createPost(Post post) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();) {
			String query = "INSERT INTO posts (title, user_id) VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setInt(2, post.getUser().getUserId());
			int rows = preparedStatement.executeUpdate();

			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException(e);

		}

	}

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM posts";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Post post = new Post();
				post.setPostId(resultSet.getInt("post_id"));
				post.setTitle(resultSet.getString("title"));

				User user = new User();
				post.setUser(user);

				posts.add(post);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}

}
