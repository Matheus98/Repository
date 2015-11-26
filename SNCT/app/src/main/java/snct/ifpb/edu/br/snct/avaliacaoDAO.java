package snct.ifpb.edu.br.snct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class avaliacaoDAO {

    private SQLiteDatabase bd;

    public avaliacaoDAO (Context ctx){
        avaliacaoSQLHelper helper = new avaliacaoSQLHelper(ctx);
        bd = helper.getWritableDatabase();
    }


    public void inserir(avaliacao avaliacao) {


            ContentValues valor = new ContentValues();

            valor.put(avaliacaoSQLHelper.COLUNA_NOME_AVALIADOR,avaliacao.getNomeAvaliador());
            valor.put(avaliacaoSQLHelper.COLUNA_TITULO_TRABALHO,avaliacao.getTituloTrabalho());
            valor.put(avaliacaoSQLHelper.COLUNA_NOTA,avaliacao.getNota());
            valor.put(avaliacaoSQLHelper.COLUNA_COMENTARIO, avaliacao.getComentario());

            bd.insert(avaliacaoSQLHelper.TABLE_AVALIACAO, null, valor);


        }
    public int buscar(){
        String colunas [] = new String[]{"id"};
        Cursor cursor = bd.query("Avaliacao", colunas, null, null, null, null, "id");
        int nAcessos = cursor.getCount();
        return nAcessos;

    }
    }


