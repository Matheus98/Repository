package edu.ifpb.br.callback;

import java.util.List;

import edu.ifpb.br.entidade.Pessoa;

/**
 * Created by Matheus on 04/03/2016.
 */
public interface BuscarPessoaCallBack {

    void backBuscarNome(List<Pessoa> names);

    void errorBuscarNome(String error);

}
