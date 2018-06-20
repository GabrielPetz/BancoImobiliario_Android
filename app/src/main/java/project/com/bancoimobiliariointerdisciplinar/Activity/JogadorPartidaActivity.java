package project.com.bancoimobiliariointerdisciplinar.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import project.com.bancoimobiliariointerdisciplinar.JDBC.JogadorPartidaJDBC;
import project.com.bancoimobiliariointerdisciplinar.JDBC.PartidaJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Partida;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.PartidaOut;
import project.com.bancoimobiliariointerdisciplinar.R;

public class JogadorPartidaActivity extends Activity {

    private EditText editPino;
    private Integer idpartida;
    private Integer jogadorLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        editPino = (EditText) findViewById(R.id.editPino);


        Intent cont = getIntent();

        jogadorLogado = cont.getIntExtra("jogador", 9999);

        PartidaJDBC jdbc = new PartidaJDBC(this);
        PartidaOut par = jdbc.getPartida(cont.getStringExtra("nomepartida"));
        if (par.getParid() != null) {
            idpartida = par.getParid();
        }

    }

    public void doPino(View v){

        JogadorPartidaJDBC jdbc = new JogadorPartidaJDBC(this);


    }


}
