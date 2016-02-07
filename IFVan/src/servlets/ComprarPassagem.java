package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import entidades.Pessoa;

@WebServlet("/ComprarPassagem")
public class ComprarPassagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String idoso = "idoso";
		String estudante = "estudante";
		String inteira = "inteira";

		try{

			Pessoa pessoa = new Pessoa();

			pessoa.setEndereco(request.getParameter("endereco"));
			pessoa.setTipoPassagem(request.getParameter("tipoPassagem"));

			
			if(pessoa.getTipoPassagem().equals(idoso)){
				
				pessoa.setPrecoPassagem(0);
				
			}else if(pessoa.getTipoPassagem().equals(estudante)){
				
				pessoa.setPrecoPassagem(12.50);
				
			}else if(pessoa.getTipoPassagem().equals(inteira)){
				
				pessoa.setPrecoPassagem(25);
				
			}
			
			Integer id = PessoaDAO.getInstance().insert(pessoa);
			pessoa.setId(id);

			request.setAttribute("pessoa", pessoa);

			RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
			rq.forward(request, response);

		}catch (SQLException e){

			e.printStackTrace();

		}

	}

}
