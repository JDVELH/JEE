package pak.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pak.DAOfactory.DAOfactory;
import pak.DAOobject.LivreDao;
import pak.DAOobject.UtilisateurDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurDao utilisateurDao;
	LivreDao livreDao;

	public LoginServlet() {
		super();
	}
	public void init() {
		DAOfactory daofactory = DAOfactory.getInstance();
		this.utilisateurDao = daofactory.getUtilisateurDao();
		this.livreDao = daofactory.getLivreDao();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("username", username);
		session.setAttribute("livres", livreDao.listerLivreUser(username));

		for (int i = 0; i < utilisateurDao.listerUtilisateur().size(); i++) {

			if (username.equals(
					utilisateurDao.listerUtilisateur().get(i).getPseudo())
					&& password.equals(utilisateurDao.listerUtilisateur().get(i)
							.getMotDePasse())) {

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/choix.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
