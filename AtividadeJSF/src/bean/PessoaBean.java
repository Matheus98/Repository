package bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import database.PessoaDAO;
import entidades.Pessoa;

@ManagedBean(name="PessoaBean", eager = true)
@RequestScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();

	public List<Pessoa> getPessoas() {
		return new PessoaDAO().getAll();
	}

	public void registrar() {
		new PessoaDAO().inserir(pessoa);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("usuarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


}
