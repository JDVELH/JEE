package pak.DAOobject;

import java.util.ArrayList;

import pak.beans.Page;

public interface PageDao {
	void ajouterPage(Page page);
	ArrayList<Page> listerPage(String titreLivre);
	void mettreAJourPage(Page page);
	void supprimerPage(Page page);
	ArrayList<Page> listerSuccesseur(Page page);
	Page chercherPage(String page);
}