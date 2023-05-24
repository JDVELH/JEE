package pak.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pak.DAOfactory.DAOfactory;
import pak.DAOobject.LivreDao;
import pak.beans.Livre;

@WebServlet("/Livre")
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;

	public LivreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() throws ServletException {
		DAOfactory daoFactory = DAOfactory.getInstance();
		this.livreDao = daoFactory.getLivreDao();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("livres", livreDao
				.listerLivreUser(session.getAttribute("username").toString()));
		this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp")
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("titreLivre", request.getParameter("titreLivre"));
		String action = request.getParameter("action");

		switch (action) {

			case "ajouter" :
				ajouterLivre(request, response);
				break;

			case "supprimer" :
				supprimLivre(request, response);
				break;

			case "mettre à jour" :

		}
	}
	/*
	 * 
	 */
	private void ajouterLivre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Livre livre = new Livre();
		livre.setTitreLivre(request.getParameter("titreLivre"));
		livre.setAuteur(session.getAttribute("username").toString());
		String titreLivre = request.getParameter("titreLivre");

		if (!titreLivre.isEmpty()) {
			livreDao.ajouterLivre(livre);
			session.setAttribute("livres",
					livreDao.listerLivreUser(livre.getAuteur()));
			this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp")
					.forward(request, response);
		}
	}
	/*
	 * 
	 */
	private void supprimLivre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Livre livre = new Livre();
		livre.setTitreLivre(request.getParameter("titreLivre"));
		livre.setAuteur(session.getAttribute("username").toString());

		if (!request.getParameter("titreLivre").isEmpty()) {
			livreDao.supprimerLivre(livre);
			session.setAttribute("livres",
					livreDao.listerLivreUser(livre.getAuteur()));
			this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp")
					.forward(request, response);
		}
	}
}
