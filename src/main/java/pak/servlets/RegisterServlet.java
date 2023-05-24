package pak.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pak.DAOfactory.DAOfactory;
import pak.DAOobject.UtilisateurDao;
import pak.beans.Utilisateur;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurDao utilisateurDao;
	public RegisterServlet() {
		super();
	}
	public void init() {
		DAOfactory daofactory = DAOfactory.getInstance();
		this.utilisateurDao = daofactory.getUtilisateurDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo(username);
		utilisateur.setEmail(password);
		utilisateur.setMotDePasse(password);
		utilisateurDao.ajouterUtilisateur(utilisateur);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);

	}
}
