package couponswipe.data.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {

	public static final Connection getConnection() throws SQLException {
		IConnectionPool cp = ConnectionPoolFactory.getInstance()
				.getConnectionPool();
		return cp.getConnection();
	}

}
