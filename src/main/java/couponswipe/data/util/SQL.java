package couponswipe.data.util;

public class SQL {
	
	public static final String FIND_USER_BY_EMAIL = "select * from users where UPPER(email) = UPPER(?)";
	
	public static final String DELETE_USER_BY_EMAIL = "delete from users where UPPER(email) = UPPER(?)";
	
	public static final String INSERT_USER = "insert into users values (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String UPDATE_USER = "update users set first_name=?, last_name=?, phone_number=? where email =?";

	public static final String FIND_DEAL_BY_ID = "select * from deals where UPPER(dealid) = UPPER(?)";

    public static final String DELETE_DEAL_BY_ID = "delete from deals where UPPER(dealid) = UPPER(?)";

    public static final String INSERT_DEAL = "insert into deals values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String UPDATE_DEAL = "update deals set dealtitle=?, description=?, location=?, latitude=?, longitude=?, amount=?, currency=?, startdate=?, expirydate=?, category=?, small_url=?, mid_url=?, large_url=?, merch_id=?, merch_name=?, merch_url=?, buy_deal_url=? where dealid=?";

    public static final String FIND_HISTORY_BY_ID = "select * from deal_history where UPPER(email)= UPPER(?) and UPPER(dealid)= UPPER(?)";

    public static final String DELETE_HISTORY_BY_ID = "update deal_history set action='deleted' where UPPER(email)= UPPER(?) and UPPER(dealid)= UPPER(?)";

    public static final String INSERT_DEAL_HISTORY = "insert into deal_history values (?,?,?,?,?)";

    public static final String UPDATE_DEAL_HISTORY = "update deal_history set action=?, created_at=?, updated_at=? where email=? and dealid=?";

    public static final String FIND_HISTORY_BY_EMAIL = "select a.dealid, a.dealtitle, a.amount, a.buy_deal_url, a.mid_url, a.large_url from deals a, deal_history b where UPPER(b.email)= UPPER(?) and a.dealid = b.dealid and b.action='shortlisted'";
    
}
