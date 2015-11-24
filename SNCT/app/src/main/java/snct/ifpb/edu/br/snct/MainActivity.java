package snct.ifpb.edu.br.snct;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avaliacaoDAO avaliacaoDAO = new avaliacaoDAO(this);

        avaliacao avaliacao = new avaliacao();
        avaliacao.setNomeAvaliador("Matheus");
        avaliacaoDAO.inserir(avaliacao);

        avaliacao.setTituloTrabalho("AI a modern Approach");
        avaliacaoDAO.inserir(avaliacao);

        avaliacao.setNota(9);
        avaliacaoDAO.inserir(avaliacao);

        avaliacao.setComentario("Um excelente projeto com importantes conveitos sobre a IA");
        avaliacaoDAO.inserir(avaliacao);


    }
}
