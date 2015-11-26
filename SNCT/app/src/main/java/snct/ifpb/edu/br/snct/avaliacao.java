package snct.ifpb.edu.br.snct;

public class avaliacao {
    private String nomeAvaliador;
    private String tituloTrabalho;
    private String nota;
    private String comentario;
    private int id;

    public String getNomeAvaliador() {
        return nomeAvaliador;
    }
    public void setNomeAvaliador(String nomeAvaliador) {
        this.nomeAvaliador = nomeAvaliador;
    }
    public String getTituloTrabalho() {
        return tituloTrabalho;
    }
    public void setTituloTrabalho(String tituloTrabalho) {
        this.tituloTrabalho = tituloTrabalho;
    }
    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setComentario (String comentario){
        this.comentario = comentario;
    }
    public String getComentario(){
        return comentario;
    }
    public double getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
