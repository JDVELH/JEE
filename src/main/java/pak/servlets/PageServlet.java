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
import pak.DAOobject.PageDao;
import pak.beans.Page;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivreDao livreDao;
	PageDao pageDao;
	public PageServlet() {
		super();
	}
	public void init() {
		DAOfactory daoFactory = DAOfactory.getInstance();
		this.livreDao = daoFactory.getLivreDao();
		this.pageDao = daoFactory.getPageDao();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String titreLivre = request.getParameter("titreLivre");
		HttpSession session = request.getSession();
		session.setAttribute("pages", pageDao.listerPage(titreLivre));
		session.setAttribute("titreLivre", request.getParameter("titreLivre"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/page.jsp")
				.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		switch (action) {

			case "ajouter" :
				this.getServletContext()
						.getRequestDispatcher("/WEB-INF/pageEdit.jsp")
						.forward(request, response);
				break;

			case "editer" :
				session.setAttribute("page",
						pageDao.chercherPage(request.getParameter("nomPage")));
				this.getServletContext()
						.getRequestDispatcher("/WEB-INF/reditPage.jsp")
						.forward(request, response);
				break;

			case "modifier" :
				String nomPage = request.getParameter("nomPage");
				String imgFond = request.getParameter("imfFond");
				String contenu = request.getParameter("contenu");

				Page page = new Page();

				page.setNom(nomPage);
				page.setImage(imgFond);
				page.setContenu(contenu);
				page.setPseudo(session.getAttribute("username").toString());
				page.setSuccesseurs(null);
				page.setTitreLivre(
						session.getAttribute("titreLivre").toString());
				session.setAttribute("pages", pageDao.listerPage(
						session.getAttribute("titreLivre").toString()));
				pageDao.mettreAJourPage(page);
				this.getServletContext()
						.getRequestDispatcher("/WEB-INF/page.jsp")
						.forward(request, response);

				break;

			case "enregistrer" :
				String nomPage1 = request.getParameter("nomPage");
				String imgFond1 = request.getParameter("imfFond");
				String contenu1 = request.getParameter("contenu");

				Page page1 = new Page();

				page1.setNom(nomPage1);
				page1.setImage(imgFond1);
				page1.setContenu(contenu1);
				page1.setPseudo(session.getAttribute("username").toString());
				page1.setSuccesseurs(null);
				page1.setTitreLivre(
						session.getAttribute("titreLivre").toString());
				pageDao.ajouterPage(page1);
				session.setAttribute("pages", pageDao.listerPage(
						session.getAttribute("titreLivre").toString()));
				this.getServletContext()
						.getRequestDispatcher("/WEB-INF/page.jsp")
						.forward(request, response);
				break;

			case "supprimer" :
				Page page2 = new Page();
				page2.setNom(request.getParameter("nomPage"));
				pageDao.supprimerPage(page2);
				session.setAttribute("pages", pageDao.listerPage(
						session.getAttribute("titreLivre").toString()));
				this.getServletContext()
						.getRequestDispatcher("/WEB-INF/page.jsp")
						.forward(request, response);
		}
	}

	public void ajouterPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
