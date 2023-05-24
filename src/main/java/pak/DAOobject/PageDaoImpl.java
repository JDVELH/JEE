package pak.DAOobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pak.DAOfactory.DAOfactory;
import pak.beans.Page;

public class PageDaoImpl implements PageDao {
	private DAOfactory daoFactory;

	public PageDaoImpl(DAOfactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouterPage(Page page) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO page (nomPage, imgFond, contenu, titreLivre, auteur)"
				+ " VALUES (?, ?, ?, ?, ?);";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, page.getNom());
			preparedStatement.setString(2, page.getImage());
			preparedStatement.setString(3, page.getContenu());
			preparedStatement.setString(4, page.getTitreLivre());
			preparedStatement.setString(5, page.getPseudo());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Page> listerPage(String titreLivre) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat;
		String sql = "SELECT * FROM page WHERE titreLivre = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, titreLivre);
			resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				String nomPage = resultat.getString("nomPage");
				String image = resultat.getString("imgFond");
				String contenu = resultat.getString("contenu");
				String titre = resultat.getString("titreLivre");
				String pseudo = resultat.getString("auteur");
				Page page = new Page();
				page.setNom(nomPage);
				page.setImage(image);
				page.setContenu(contenu);
				page.setTitreLivre(titre);
				page.setPseudo(pseudo);

				pages.add(page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

	@Override
	public void mettreAJourPage(Page page) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE page SET nomPage = ?, imgFond = ?, contenu = ?"
				+ "titreLivre = ?, auteur = ? WHERE nomPage = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, page.getNom());
			preparedStatement.setString(2, page.getImage());
			preparedStatement.setString(3, page.getContenu());
			preparedStatement.setString(4, page.getTitreLivre());
			preparedStatement.setString(5, page.getPseudo());
			preparedStatement.setString(6, page.getNom());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void supprimerPage(Page page) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM page WHERE nomPage = ? ;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, page.getNom());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Page> listerSuccesseur(Page page) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM successeur WHERE nomPage = ? AND titreLivre = ? AND auteur = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, page.getNom());
			preparedStatement.setString(2, page.getTitreLivre());
			preparedStatement.setString(3, page.getPseudo());
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				String nomPage = resultat.getString("nomPage");
				String titreLivre = resultat.getString("titreLivre");
				String auteur = resultat.getString("auteur");

				Page page2 = new Page();
				page2.setNom(nomPage);
				page2.setTitreLivre(titreLivre);
				page2.setPseudo(auteur);

				pages.add(page2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}

	@Override
	public Page chercherPage(String nomPage) {
		Page page = new Page();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM page WHERE nomPage = ?;";

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nomPage);
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				String nom = resultat.getString("nomPage");
				String image = resultat.getString("imgFond");
				String contenu = resultat.getString("contenu");
				String titre = resultat.getString("titreLivre");
				String pseudo = resultat.getString("auteur");

				page.setNom(nom);
				page.setImage(image);
				page.setContenu(contenu);
				page.setTitreLivre(titre);
				page.setPseudo(pseudo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
}
