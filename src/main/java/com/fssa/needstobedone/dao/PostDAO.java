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
		String query = "INSERT INTO posts (title, user_id) VALUES (?, ?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, post.getTitle());
			statement.setInt(2, post.getUser().getUserId());
			int rows = statement.executeUpdate();

			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException(e);

		}

	}

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		String query = "SELECT * FROM posts";
		try(Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);){
			ResultSet resultSet = statement.executeQuery();
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
