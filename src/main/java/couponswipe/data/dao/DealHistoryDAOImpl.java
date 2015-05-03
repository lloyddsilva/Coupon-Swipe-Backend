package couponswipe.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import couponswipe.data.po.DealHistoryPO;
import couponswipe.data.po.UserPO;
import couponswipe.data.util.SQL;
import couponswipe.dto.DealHistoryDTO;
import couponswipe.dto.DealHistoryListDTO;
import couponswipe.dto.UserDealsDTO;

public class DealHistoryDAOImpl extends BaseDAOImpl implements IDealHistoryDAO{

    @Override
    public void save(DealHistoryPO dealHistoryPO) {
        // TODO Auto-generated method stub
        if (dealHistoryPO == null) {
            return;
        }

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEAL_HISTORY);
            stmt.setString(1, dealHistoryPO.getEmail());
            stmt.setString(2, dealHistoryPO.getDealUuid());
            stmt.setString(3, dealHistoryPO.getAction());
            stmt.setString(4, dealHistoryPO.getCreatedAt());
            stmt.setString(5, dealHistoryPO.getUpdatedAt());
            

            int rowCount = stmt.executeUpdate();
           
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } finally {
        }
    }

    @Override
    public void update(DealHistoryPO dealHistoryPO) {
        if (dealHistoryPO == null) {
            return;
        }

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_DEAL_HISTORY);
            stmt.setString(1, dealHistoryPO.getAction());
            stmt.setString(2, dealHistoryPO.getCreatedAt());
            stmt.setString(3, dealHistoryPO.getUpdatedAt());
            
            stmt.setString(4, dealHistoryPO.getEmail());
            stmt.setString(5, dealHistoryPO.getDealUuid());

            int rowCount = stmt.executeUpdate();
           
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } finally {
        } 
    }

    @Override
    public DealHistoryPO findById(String dealId, String email) {
        if (email == null) {
            return null;
        }
        
        Connection conn;
        DealHistoryPO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.FIND_HISTORY_BY_ID);
            stmt.setString(1, email.toUpperCase());
            stmt.setString(2, dealId.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                po = new DealHistoryPO();
                po.setEmail(rs.getString(1));
                po.setDealUuid(rs.getString(2));
                po.setAction(rs.getString(3));
                po.setCreatedAt(rs.getString(4));
                po.setUpdatedAt(rs.getString(5)); 
            }
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 
        
        return po;
    }

    @Override
    public void deleteById(String dealId, String email) {
        // TODO Auto-generated method stub
        if (email == null) {
            return;
        }
        
        Connection conn;
        DealHistoryPO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_HISTORY_BY_ID);
            stmt.setString(1, email.toUpperCase());
            stmt.setString(2, dealId.toUpperCase());
            
            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 

        return;
    }

    @Override
    public DealHistoryListDTO findHistoryByMail(String email) {
        // TODO Auto-generated method stub
        if (email == null) {
            return null;
        }
        
        DealHistoryListDTO list = new DealHistoryListDTO();
        Connection conn;
        UserDealsDTO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.FIND_HISTORY_BY_EMAIL);
            stmt.setString(1, email.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                po = new UserDealsDTO();
                po.setDealId(rs.getString(1));
                po.setDealTitle(rs.getString(2));
                po.setDealAmount(rs.getString(3));
                po.setDealBuyUrl(rs.getString(4));
                po.setDealMediumUrl(rs.getString(5));
                po.setDealLargeUrl(rs.getString(6));
                list.add(po);
            }
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 
        
        return list;
    }

}
