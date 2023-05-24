package pak.DAOfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pak.DAOobject.LivreDao;
import pak.DAOobject.LivreDaoImpl;
import pak.DAOobject.PageDao;
import pak.DAOobject.PageDaoImpl;
import pak.DAOobject.UtilisateurDao;
import pak.DAOobject.UtilisateurDaoImpl;

public class DAOfactory {
	private String user = "root";
	private String password = "";
	private String database = "ppe";
	DAOfactory(String database, String user, String password) {
		this.database = database;
		this.password = password;
		this.user = user;
	}
	/*
	 * 
	 */
	public static DAOfactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DAOfactory instance = new DAOfactory(
				"jdbc:mysql://localhost:3306/ppe?useSSL=false&serverTimezone=UTC",
				"root", "");
		return instance;
	}
	/*
	 * 
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(database, user, password);
	}
	/*
	 * 
	 */
	public UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoImpl(this);
	}
	public PageDao getPageDao() {
		return new PageDaoImpl(this);
	}
	public LivreDao getLivreDao() {
		return new LivreDaoImpl(this);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
}