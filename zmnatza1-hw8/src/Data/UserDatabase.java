package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import Beans.User;

/**
 * Mock user database. Basis for functions like getting a user and getting the
 * hard coded default users.
 */
public class UserDatabase {
	private static Collection<User> users = Arrays.asList(new User("a1234",
			"James", "Gosling", -20), new User("a1235", "Jesse James",
			"Garrett", 30), new User("a1236", "John", "Smith", -4), new User(
			"a1237", "Bob", "Roberts", 50));
	private static final String DEFAULT_FIRST_NAME = "Undefined";
	private static final String DEFAULT_LAST_NAME = "Undefined";
	private static final double DEFAULT_BALANCE = 0;

	/**
	 * Loads a user based on the userId
	 * @param userId The user ID of the customer
	 * @return The user object
	 */
	public static User getUser(String userId) {
		for (User user : users)
			if (user.getUserId().equals(userId.trim()))
				return user;
		return null;
	}

	/**
	 * Loads a user based on the userID or a blank user if not found
	 * @param userId The user ID of the customer
	 * @return The user object
	 */
	public static User getUserOrBlank(String userId) {
		User user = getUser(userId);
		if (user == null)
			user = new User(userId, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME,
					DEFAULT_BALANCE);
		return user;
	}

	/**
	 * Loads a list of users
	 * @param userIds The user IDs of the customers
	 * @return The list of user objects
	 */
	public static List<User> getUsers(String... userIds) {
		List<User> users = new ArrayList<User>();
		if(userIds!=null)
			for (String userId : userIds)
				users.add(UserDatabase.getUserOrBlank(userId));
		return users;
	}
	
	/**
	 * @return The list of users hardcoded into the system
	 */
	public static Collection<User> getUsers() {
		return users;
	}
}
