package couponswipe.data.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.sql.*;



public class PropertyUtils {
	/**
	 * Database Connection URL.
	 */
	public static String DB_CONN_URL ="jdbc:mysql://localhost:3306/test";

	/**
	 * User name used to connect to the database.
	 */
	public static String DB_USERNAME ="root";

	/**
	 * Password to connect to the database.
	 */
	public static String DB_PASSWORD = "password";

	/**
	 * Database connection Pool size parameter used by HikariCP, to maintain a
	 * pool of connections that all DAOs making database requests will use.
	 */
	public static int DB_CONNECTION_POOL_SIZE =20;;

	/**
	 * List of invalid names
	 */
	public static Set<String> INVALID_NAMES = new HashSet<String>();

	/**
	 * Admin code that will be provided by a user, to authenticate as an admin.
	 */
	public static String ADMIN_CODE = "5830";


}