package couponswipe.data.dao;


public class DAOFactory {
	private static DAOFactory instance;

	/**
	 * Singleton instance access method to get the instance of the class to
	 * request a specific DAO implementation.
	 * 
	 * @return - DAOFactory instance
	 */
	public static final DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}

		return instance;
	}

	/**
	 * Method to get a new object implementing IUserDAO
	 * 
	 * @return - Object implementing IUserDAO
	 */
	public IUserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	
	public IDealDAO getDealDAO(){
	    return new DealDAOImpl();
	}
	/**
	 * Method to get a new object implementing IShareStatusDAO
	 * 
	 * @return - Object implementing IShareStatusDAO
	 */

    public IDealHistoryDAO getDealHistoryDAO() {
        // TODO Auto-generated method stub
        return new DealHistoryDAOImpl();
    }

    

}
