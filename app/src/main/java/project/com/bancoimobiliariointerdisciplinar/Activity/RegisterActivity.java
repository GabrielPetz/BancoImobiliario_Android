package project.com.bancoimobiliariointerdisciplinar.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import project.com.bancoimobiliariointerdisciplinar.JDBC.JogadorJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelIn.Jogador;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.JogadorOut;
import project.com.bancoimobiliariointerdisciplinar.R;

public class RegisterActivity extends Activity {

    private EditText editLogin;
    private EditText editPassword;
    private EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editLogin = (EditText) findViewById(R.id.login);
        editPassword = (EditText) findViewById(R.id.password);
        editNome = (EditText) findViewById(R.id.name);
    }


    public void doRegistrar(View v) {
        Jogador jog = new Jogador();
        JogadorJDBC jdbc = new JogadorJDBC(this);

        jog.setJognome(editNome.getText().toString());
        jog.setJogsenha(editPassword.getText().toString());
        jog.setJognick(editLogin.getText().toString());

        JogadorOut exist = jdbc.getJogador(editLogin.getText().toString());

        if (exist.getJogid() == null) {
            long i = jdbc.insertJogador(jog);

            if (i > 0) {
                Toast.makeText(this, "Usuário Cadastrado.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Usuário não Cadastrado.", Toast.LENGTH_SHORT).show();
            }
            goLogin(v);
        } else {
            Toast.makeText(this, "Usuário já está Cadastrado.", Toast.LENGTH_SHORT).show();
        }

    }


    public void goLogin(View v) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
