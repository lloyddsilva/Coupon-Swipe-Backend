package couponswipe.data.dao;

import couponswipe.data.po.DealPO;
import couponswipe.data.po.UserPO;

public interface IDealDAO {
	/**
	 * This method will save the information of the user into the database.
	 * 
	 * @param userPO
	 *            - User information to be saved.
	 */
	void save(DealPO dealPO);

	/**
	 * This method will update the information of the user into the database.
	 * 
	 * @param userPO
	 *            - User information to be updated.
	 */
	void update(DealPO dealPO);

	

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
	DealPO findById(String dealId);
	
	/**
	 * This method will search for a user by his user_id in the database 
	 */
	void deleteById(String dealId);
	
}
