package pak.beans;

import java.util.ArrayList;

public class Page {
	private String nom;
	private String image;
	private String contenu;
	private String pseudo;
	private String titreLivre;
	private ArrayList<Page> successeurs;
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/**
	 * @param contenu
	 *            the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	/**
	 * @return the successeurs
	 */
	public ArrayList<Page> getSuccesseurs() {
		return successeurs;
	}
	/**
	 * @param successeurs
	 *            the successeurs to set
	 */
	public void setSuccesseurs(ArrayList<Page> successeurs) {
		this.successeurs = successeurs;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return the titreLivre
	 */
	public String getTitreLivre() {
		return titreLivre;
	}
	/**
	 * @param titreLivre
	 *            the titreLivre to set
	 */
	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}
}
