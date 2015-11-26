package snct.ifpb.edu.br.snct;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class avaliacaoSQLHelper extends SQLiteOpenHelper {

    private static final String Nome_BD = "SNCT";
    private static final int Versao_BD = 1;

    public static final String TABLE_AVALIACAO = "Avaliacao";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME_AVALIADOR  = "nomeAvaliador";
    public static final String COLUNA_TITULO_TRABALHO = "tituloTrabalho";
    public static final String COLUNA_NOTA = "Nota";
    public static final String COLUNA_COMENTARIO = "Comentario";

    public avaliacaoSQLHelper(Context ctx) {
        super(ctx, Nome_BD, null, Versao_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(
                " CREATE TABLE " + TABLE_AVALIACAO
                        + " (" + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUNA_NOME_AVALIADOR + " TEXT NOT NULL) "
                        + COLUNA_TITULO_TRABALHO +" TEXT NOT NULL "
                        + COLUNA_NOTA + "INTEGER NOT NULL"
                        + COLUNA_COMENTARIO + "TEXT NOT NULL "
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
    }



}
