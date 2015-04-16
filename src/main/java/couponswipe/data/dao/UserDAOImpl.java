package couponswipe.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import couponswipe.data.po.UserPO;
import couponswipe.data.util.SQL;

public class UserDAOImpl extends BaseDAOImpl implements IUserDAO {

    @Override
    public void save(UserPO userPO) {
        // TODO Auto-generated method stub
        if (userPO == null) {
            return;
        }

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_USER);
            stmt.setString(1, userPO.getFirstName());
            stmt.setString(2, userPO.getLastName());
            stmt.setString(3, userPO.getEmail());
            stmt.setString(4, userPO.getPhoneNumber());
            stmt.setString(5, userPO.getPassword());
            stmt.setInt(6, userPO.getPrefDistance());
            stmt.setString(7, userPO.getPrefCategories());

            int rowCount = stmt.executeUpdate();
           
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } finally {
        }

    }

    @Override
    public void update(UserPO userPO) {
        // TODO Auto-generated method stub
        if (userPO == null) {
            return;
        }

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_USER);
            stmt.setString(1, userPO.getFirstName());
            stmt.setString(2, userPO.getLastName());
            stmt.setString(3, userPO.getPhoneNumber());
            stmt.setString(4, userPO.getPassword());
            stmt.setInt(5, userPO.getPrefDistance());
            stmt.setString(6, userPO.getPrefCategories());
            stmt.setString(7,  userPO.getEmail());

            int rowCount = stmt.executeUpdate();
           
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } finally {
        }
    }

    @Override
    public UserPO findByEmail(String email) {
        if (email == null) {
            return null;
        }
        
        Connection conn;
        UserPO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.FIND_USER_BY_EMAIL);
            stmt.setString(1, email.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                po = new UserPO();
                po.setFirstName(rs.getString(1));
                po.setLastName(rs.getString(2));
                po.setEmail(rs.getString(3));
                po.setPhoneNumber(rs.getString(4));
                po.setPassword(rs.getString(5));
                po.setPrefDistance(rs.getInt(6));
                po.setPrefCategories(rs.getString(7));
            }
            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 

        return po;
    }

    @Override
    public void deleteByEmail(String email) {
        // TODO Auto-generated method stub
        if (email == null) {
            return;
        }
        
        Connection conn;
        UserPO po = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_USER_BY_EMAIL);
            stmt.setString(1, email.toUpperCase());
            
            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            handleException(e);
        } 

        return;
    }

}
