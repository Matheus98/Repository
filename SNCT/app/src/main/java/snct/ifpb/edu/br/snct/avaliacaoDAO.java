package snct.ifpb.edu.br.snct;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class avaliacaoDAO {

    private avaliacaoSQLHelper helper;

    public avaliacaoDAO (Context ctx){
        helper = new avaliacaoSQLHelper(ctx);

    }

    public void inserir(avaliacao avaliacao) {
            SQLiteDatabase bd = helper.getWritableDatabase();

            ContentValues valor = new ContentValues();

            valor.put(avaliacaoSQLHelper.COLUNA_NOME_AVALIADOR,avaliacao.getNomeAvaliador());
            valor.put(avaliacaoSQLHelper.COLUNA_TITULO_TRABALHO,avaliacao.getTituloTrabalho());
            valor.put(avaliacaoSQLHelper.COLUNA_NOTA,avaliacao.getNota());
            valor.put(avaliacaoSQLHelper.COLUNA_COMENTARIO,avaliacao.getComentario());

            bd.insert(avaliacaoSQLHelper.TABLE_AVALIACAO, null, valor);

            bd.close();
        }
    }


