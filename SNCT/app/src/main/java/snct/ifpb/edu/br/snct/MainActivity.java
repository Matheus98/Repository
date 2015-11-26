package snct.ifpb.edu.br.snct;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
    private avaliacao avaliacao = new avaliacao();
    private Button avaliar;
    private Button contaAvaliacoes;
    private EditText nomeAval;
    private EditText tituloTrab;
    private EditText Nota;
    private EditText Comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avaliar = (Button) findViewById(R.id.Avaliar);
        contaAvaliacoes = (Button) findViewById(R.id.contarAvaliacoes);

        avaliar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                nomeAval = (EditText) findViewById(R.id.EditNomeAvaliador);
                tituloTrab = (EditText) findViewById(R.id.EditTituloTrabalho);
                Nota = (EditText) findViewById(R.id.EditNotaTrabalho);
                Comentario = (EditText) findViewById(R.id.EditComentarioTrabalho);

                avaliacao.setNomeAvaliador(nomeAval.getText().toString());
                avaliacao.setTituloTrabalho(tituloTrab.getText().toString());
                avaliacao.setNota(Nota.getText().toString());
                avaliacao.setComentario(Comentario.getText().toString());

                avaliacaoDAO avaliacaobd = new avaliacaoDAO(MainActivity.this);
                avaliacaobd.inserir(avaliacao);

            }
        });

        contaAvaliacoes.setOnClickListener(new NotificationOnClickListener());


    }
}






