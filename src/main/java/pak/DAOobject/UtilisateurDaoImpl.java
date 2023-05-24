package pak.DAOobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pak.DAOfactory.DAOfactory;
import pak.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	private DAOfactory daoFactory;
	/*
	 * 
	 */
	public UtilisateurDaoImpl(DAOfactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	/*
	 * 
	 */
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO utilisateur (pseudo, email, password) VALUES(?, ?, ?)";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, utilisateur.getPseudo());
			preparedStatement.setString(2, utilisateur.getEmail());
			preparedStatement.setString(3, utilisateur.getMotDePasse());
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
	/*
	 * 
	 */
	@Override
	public ArrayList<Utilisateur> listerUtilisateur() {
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat;
		String sql = "SELECT * FROM utilisateur;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				String pseudo = resultat.getString("pseudo");
				String email = resultat.getString("email");
				String password = resultat.getString("password");

				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(pseudo);
				utilisateur.setEmail(email);
				utilisateur.setMotDePasse(password);

				utilisateurs.add(utilisateur);
			}
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
		return utilisateurs;
	}
	@Override
	public void mettreAJourUtilisateur(Utilisateur utilisateur) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE utilisateur set pseudo = ?, email = ?, password = ?"
				+ " WHERE pseudo = ?";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, utilisateur.getPseudo());
			preparedStatement.setString(2, utilisateur.getEmail());
			preparedStatement.setString(3, utilisateur.getMotDePasse());
			preparedStatement.setString(1, utilisateur.getPseudo());
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
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM utilisateur WHERE pseudo = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, utilisateur.getPseudo());
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
}
