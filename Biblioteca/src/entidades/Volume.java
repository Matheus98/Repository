package entidades;

public class Volume {
	private String titulo;
	private String autores;
	private String descricao;
	private String tipoVolume;
	private String paginas;
	private String anoPublicacao;
	private String editora;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autores;
	}
	public void setAutor(String autores) {
		this.autores = autores;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipoVolume;
	}
	public void setTipo(String tipo) {
		this.tipoVolume = tipo;
	}
	public String getNum_pag() {
		return paginas;
	}
	public void setNum_pag(String paginas) {
		this.paginas = paginas;
	}
	public String getAno_public() {
		return anoPublicacao;
	}
	public void setAno_public(String ano_publicacao) {
		this.anoPublicacao = ano_publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}

}
