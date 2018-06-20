package project.com.bancoimobiliariointerdisciplinar.Activity;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import project.com.bancoimobiliariointerdisciplinar.JDBC.JogadorJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Jogador;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Partida;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.JogadorOut;
import project.com.bancoimobiliariointerdisciplinar.R;

public class HomePageActivity extends Activity {

    public static JogadorOut jogadorLogado;
    private static TextView jogadorNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent cont = getIntent();

        jogadorNome = (TextView) findViewById(R.id.jogadorLogado);

        JogadorJDBC jdbc = new JogadorJDBC(this);

        Integer id = cont.getIntExtra("ID_USUARIO", 99999);

        jogadorLogado = jdbc.getJogador(id);

        System.out.println("On Create :   ------   " + id);
        System.out.println("On Create :   ------   " + jogadorLogado.toString());

        jogadorNome.setText("Olá " + jogadorLogado.getJognick());

    }

    public  void  goPartida(View v){
        Intent intent = new Intent(HomePageActivity.this, PartidaActivity.class);
        intent.putExtra("jogador", jogadorLogado.getJogid());
        startActivity(intent);

    }

    public void eraseData(View v){
        JogadorJDBC jdbc = new JogadorJDBC(this);

        Integer i = jdbc.eraseData();

        Toast.makeText(this, i.toString() , Toast.LENGTH_SHORT).show();

    }



}
