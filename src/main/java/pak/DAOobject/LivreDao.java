package pak.DAOobject;

import java.util.ArrayList;

import pak.beans.Livre;

public interface LivreDao {
	void ajouterLivre(Livre livre);
	ArrayList<Livre> listerLivreJeu();
	ArrayList<Livre> listerLivreUser(String username);
	void mettreAJourLivre(Livre livre);
	void supprimerLivre(Livre livre);
}