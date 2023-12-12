package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource jds = null;

	private ComboPooledDataSource ds = null;
	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

	private JDBCDataSource() {

		try {

			ds = new ComboPooledDataSource();

			ds.setDriverClass(rb.getString("driver"));

			ds.setJdbcUrl(rb.getString("url"));

			ds.setUser(rb.getString("username"));

			ds.setPassword(rb.getString("password"));

			ds.setInitialPoolSize(Integer.parseInt(rb.getString("intialPoolSize")));

			ds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));

			ds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));

		} catch (PropertyVetoException e) {

			e.printStackTrace();
		}
	}

	public static JDBCDataSource getInstance() {

		if (jds == null) {

			jds = new JDBCDataSource();

		}

		return jds;

	}

	public static Connection getConnection() {

		try {
			return getInstance().ds.getConnection();

		} catch (SQLException e) {
			return null;
		}
	}
}
