package couponswipe.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import couponswipe.data.po.DealPO;
import couponswipe.data.po.UserPO;
import couponswipe.data.util.SQL;

public class DealDAOImpl extends BaseDAOImpl implements IDealDAO{
    
    public void save(DealPO dealPO){
        if (dealPO == null) {
            return;
        }

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEAL);
            stmt.setString(1, dealPO.getDealUuid());
            stmt.setString(2, dealPO.getDealTitle());
            stmt.setString(3, dealPO.getDealDescription());
            stmt.setString(4, dealPO.getDealLocation());
            stmt.setString(5, dealPO.getDealLatitude());
            stmt.setString(6, dealPO.getDealLongitude());
            stmt.setString(7, dealPO.getDealAmount());
            stmt.setString(8, dealPO.getDealCurrency());
            stmt.setString(9, dealPO.getDealStartDate());
            stmt.setString(10, dealPO.getDealExpiryDate());
            stmt.setString(11, dealPO.getDealCategory());
            stmt.setString(12, dealPO.getSmallImageUrl());
            stmt.setString(13, dealPO.getMediumImageUrl());
            stmt.setString(14, dealPO.getLargeImageUrl());
            stmt.setString(15, dealPO.getMerchantUuid());
            stmt.setString(16,  dealPO.getMerchantName());
            stmt.setString(17, dealPO.getMerchantUrl());
            stmt.setString(18, dealPO.getDealBuyUrl());

            int rowCount = stmt.executeUpdate();
           
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } finally {
        }
    }

    /**
     * This method will update the information of the user into the database.
     * 
     * @param userPO
     *            - User information to be updated.
     */
    public void update(DealPO dealPO){
     // TODO Auto-generated method stub
        if (dealPO == null) {
            return;
        }

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_DEAL);
            stmt.setString(1, dealPO.getDealTitle());
            stmt.setString(2, dealPO.getDealDescription());
            stmt.setString(3, dealPO.getDealLocation());
            stmt.setString(4, dealPO.getDealLatitude());
            stmt.setString(5, dealPO.getDealLongitude());
            stmt.setString(6, dealPO.getDealAmount());
            stmt.setString(7, dealPO.getDealCurrency());
            stmt.setString(8, dealPO.getDealStartDate());
            stmt.setString(9, dealPO.getDealExpiryDate());
            stmt.setString(10, dealPO.getDealCategory());
            stmt.setString(11, dealPO.getSmallImageUrl());
            stmt.setString(12, dealPO.getMediumImageUrl());
            stmt.setString(13, dealPO.getLargeImageUrl());
            stmt.setString(14, dealPO.getMerchantUuid());
            stmt.setString(15,  dealPO.getMerchantName());
            stmt.setString(16, dealPO.getMerchantUrl());
            stmt.setString(17, dealPO.getDealBuyUrl());
            stmt.setString(18, dealPO.getDealUuid());

            int rowCount = stmt.executeUpdate();
           
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } finally {
        }
    }

    

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
    public DealPO findById(String dealId){
        if (dealId == null) {
            return null;
        }
        
        Connection conn;
        DealPO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.FIND_DEAL_BY_ID);
            stmt.setString(1, dealId.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                po = new DealPO();
                po.setDealUuid(rs.getString(1));
                po.setDealTitle(rs.getString(2));
                po.setDealDescription(rs.getString(3));
                po.setDealLocation(rs.getString(4));
                po.setDealLatitude(rs.getString(5));
                po.setDealLongitude(rs.getString(6));
                po.setDealAmount(rs.getString(7));
                po.setDealCurrency(rs.getString(8));
                po.setDealStartDate(rs.getString(9));
                po.setDealExpiryDate(rs.getString(10));
                po.setDealCategory(rs.getString(11));
                po.setSmallImageUrl(rs.getString(12));
                po.setMediumImageUrl(rs.getString(13));
                po.setLargeImageUrl(rs.getString(14));
                po.setMerchantUuid(rs.getString(15));
                po.setMerchantName(rs.getString(16));
                po.setMerchantUrl(rs.getString(17));
                po.setDealBuyUrl(rs.getString(18));
            }
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 

        return po;
    }
    
    /**
     * This method will search for a user by his user_id in the database 
     */
    public void deleteById(String dealId){
        if (dealId == null) {
            return;
        }
        
        Connection conn;
        UserPO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_DEAL_BY_ID);
            stmt.setString(1, dealId.toUpperCase());
            
            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 

        return;
    }
    
}
