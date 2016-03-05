package edu.ifpb.br.entidade;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Matheus on 04/03/2016.
 */
public class Pessoa implements Serializable{

    //Construtor Vazio(Correção)
    public Pessoa (){}

    public Pessoa (String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;

    }

    @SerializedName("id")
    private int id;

    @SerializedName("fullName")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("typeInscription")
    private String descricao;

    @SerializedName("isDelivered")
    private boolean entregue;

    public String getDescricao() {

        return descricao;

    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public boolean isEntregue() {

        return entregue;

    }

    public void setEntregue(boolean entregue) {

        this.entregue = entregue;

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    @Override
    public String toString() {

        return "[fullName: " + nome + "; email: " + email + "]";

    }

}

