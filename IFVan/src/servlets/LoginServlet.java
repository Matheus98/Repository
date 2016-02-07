package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PessoaDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String nomeLogin = request.getParameter("nome");
		String senhaLogin = request.getParameter("senha");

		String strErrMsg = null;
		HttpSession session = request.getSession();
		boolean isValidLogon = false;

		try {

			isValidLogon = PessoaDAO.getInstance().authenticateLogin (nomeLogin, senhaLogin);

			if(isValidLogon) {

				session.setAttribute("nome", nomeLogin);

			} else {

				strErrMsg = "Nome ou Senha incorretos. Por Favor tente novamente";

			}

		} catch(Exception e) {

			strErrMsg = "Incapaz de validar o serviço";

		}

		if(isValidLogon) {

			response.sendRedirect("index.html");

		} else {

			session.setAttribute("errorMsg", strErrMsg);

			response.sendRedirect("index.html");

		}
	}

}


