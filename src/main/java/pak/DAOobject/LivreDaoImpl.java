package pak.DAOobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pak.DAOfactory.DAOfactory;
import pak.beans.Livre;

public class LivreDaoImpl implements LivreDao {
	private DAOfactory daoFactory;

	public LivreDaoImpl(DAOfactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public void ajouterLivre(Livre livre) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO livre (titreLivre, auteur) VALUES (?, ?);";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.setString(2, livre.getAuteur());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Livre> listerLivreJeu() {
		ArrayList<Livre> livres = new ArrayList<Livre>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		String sql = "SELECT * FROM livre;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				String titreLivre = resultat.getString("titreLivre");
				String auteur = resultat.getString("auteur");

				Livre livre = new Livre();
				livre.setTitreLivre(titreLivre);
				livre.setAuteur(auteur);

				livres.add(livre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return livres;
	}

	@Override
	public void mettreAJourLivre(Livre livre) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE livre set titreLivre = ?, auteur = ?"
				+ " WHERE titreLivre = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.setString(2, livre.getAuteur());
			preparedStatement.setString(3, livre.getTitreLivre());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void supprimerLivre(Livre livre) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM livre WHERE titreLivre = ? AND auteur = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, livre.getTitreLivre());
			preparedStatement.setString(2, livre.getAuteur());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public ArrayList<Livre> listerLivreUser(String username) {
		ArrayList<Livre> livres = new ArrayList<Livre>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		String sql = "SELECT * FROM livre WHERE auteur = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				String titreLivre = resultat.getString("titreLivre");
				String auteur = resultat.getString("auteur");

				Livre livre = new Livre();
				livre.setTitreLivre(titreLivre);
				livre.setAuteur(auteur);

				livres.add(livre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return livres;
	}
}
