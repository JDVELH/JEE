package pak.beans;

import java.util.ArrayList;

public class Livre {
	private String titreLivre;
	private String auteur;
	private ArrayList<Page> pages;
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
	/**
	 * @return the pages
	 */
	public ArrayList<Page> getPages() {
		return pages;
	}
	/**
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur
	 *            the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
