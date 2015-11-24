package snct.ifpb.edu.br.snct;

import java.io.Serializable;

/**
 * Created by Delberto on 23/11/2015.
 */
public class avaliacao  implements Serializable {
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
    public void setTituloTrabalho(String nome) {
        this.tituloTrabalho = tituloTrabalho;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


}
