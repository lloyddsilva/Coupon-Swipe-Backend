package couponswipe.data.dao;

import couponswipe.data.po.UserPO;

public interface IUserDAO {
	/**
	 * This method will save the information of the user into the database.
	 * 
	 * @param userPO
	 *            - User information to be saved.
	 */
	void save(UserPO userPO);

	/**
	 * This method will update the information of the user into the database.
	 * 
	 * @param userPO
	 *            - User information to be updated.
	 */
	void update(UserPO userPO);

	

	/**
	 * This method will search for a user by his userName in the database. The
	 * search performed is a case insensitive search to allow case mismatch
	 * situations.
	 * 
	 * @param userName
	 *            - User name to search for.
	 * 
	 * @return - UserPO with the user information if a match is found.
	 */
	UserPO findByEmail(String email);
	
	/**
	 * This method will search for a user by his user_id in the database 
	 */
	void deleteByEmail(String email);
	
	


}