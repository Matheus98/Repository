package entidades;

public class Pessoa {

	private int id;

	private String nome;

	private String endereco;

	private String tipoPassagem;

	private String senha;
	
	private double precoPassagem;

	public Pessoa(int id, String nome, String senha, String endereco, String tipoPassagem, 
			double precoPassagem){

		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.endereco = endereco;
		this.tipoPassagem = tipoPassagem;
		this.precoPassagem = precoPassagem;

	}

	public Pessoa(){}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipoPassagem() {
		return tipoPassagem;
	}

	public void setTipoPassagem(String tipoPassagem) {
		this.tipoPassagem = tipoPassagem;
	}
	
	public double getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(double precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

}
