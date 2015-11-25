package snct.ifpb.edu.br.snct;

public class avaliacao {
    private String nomeAvaliador;
    private String tituloTrabalho;
    private int nota;
    private String comentario;

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
    public double getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario (String comentario){
        this.comentario = comentario;
    }
    public String getComentario(){
        return comentario;
    }


}
