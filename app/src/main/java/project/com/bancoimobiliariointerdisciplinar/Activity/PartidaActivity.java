package project.com.bancoimobiliariointerdisciplinar.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import project.com.bancoimobiliariointerdisciplinar.JDBC.PartidaJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.JogadorPartida;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Partida;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.PartidaOut;
import project.com.bancoimobiliariointerdisciplinar.R;

public class PartidaActivity extends Activity {

    private Integer jogadorLogado;
    private EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        editNome = (EditText) findViewById(R.id.editNome);

        Intent intent = getIntent();

        jogadorLogado = intent.getIntExtra("jogador", 9999);
    }

    public void doPartida(View v){
        PartidaJDBC jdbc = new PartidaJDBC(this);
        String nomePartida = editNome.getText().toString();

        Partida partida = new Partida();

        partida.setParnome(nomePartida);
        partida.setPardata(new Date());

        PartidaOut sqlres = jdbc.getPartida(nomePartida);

        if(sqlres.getParid() == null) {
            long res = jdbc.insertPartida(partida);
            if (res > 0) {
                Intent i = new Intent(PartidaActivity.this, JogadorPartidaActivity.class);
                i.putExtra("nomepartida", nomePartida);
                i.putExtra("jogador", jogadorLogado);
                startActivity(i);
            } else {
                Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Já existe uma partida com esse nome!", Toast.LENGTH_SHORT).show();

        }

    }

    public void voltar(View v){
        Intent intent = new Intent(PartidaActivity.this, HomePageActivity.class);
        startActivity(intent);
    }




}
