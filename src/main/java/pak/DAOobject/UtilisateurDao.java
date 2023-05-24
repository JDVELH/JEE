package pak.DAOobject;

import java.util.ArrayList;

import pak.beans.Utilisateur;

public interface UtilisateurDao {
	void ajouterUtilisateur(Utilisateur utilisateur);
	ArrayList<Utilisateur> listerUtilisateur();
	void mettreAJourUtilisateur(Utilisateur utilisateur);
	void supprimerUtilisateur(Utilisateur utilisateur);
}