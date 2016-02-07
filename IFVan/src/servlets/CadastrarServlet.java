package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entidades.*;

@WebServlet("/CadastrarServlet")
public class CadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try{
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(request.getParameter("nome"));
			pessoa.setSenha(request.getParameter("senha"));
			
			Integer id = PessoaDAO.getInstance().insert(pessoa);
			pessoa.setId(id);
			
			request.setAttribute("pessoa", pessoa);

			RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
			rq.forward(request, response);
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
	}

}
