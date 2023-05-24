package pak.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pak.DAOfactory.DAOfactory;
import pak.DAOobject.LivreDao;
import pak.DAOobject.UtilisateurDao;

@WebServlet("/ChoixServlet")
public class ChoixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurDao utilisateurDao;
	LivreDao livreDao;

	public ChoixServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() {
		DAOfactory daofactory = DAOfactory.getInstance();
		this.utilisateurDao = daofactory.getUtilisateurDao();
		this.livreDao = daofactory.getLivreDao();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {

			case "creer" :
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/livre.jsp");
				dispatcher.forward(request, response);
				break;

			case "jouer" :

				break;

		}
	}
}
