package project.com.bancoimobiliariointerdisciplinar.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import project.com.bancoimobiliariointerdisciplinar.JDBC.JogadorJDBC;
import project.com.bancoimobiliariointerdisciplinar.ModelOut.JogadorOut;
import project.com.bancoimobiliariointerdisciplinar.R;

public class LoginActivity extends Activity {

    private EditText editLogin;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLogin = (EditText) findViewById(R.id.login);
        editPassword = (EditText) findViewById(R.id.password);
    }


    public void doLogin(View v){
        String login = editLogin.getText().toString() ;
        String senha = editPassword.getText().toString() ;


        JogadorJDBC jdbc = new JogadorJDBC(this);

        JogadorOut jog = jdbc.doLogin(login,senha);
        System.out.println(jog);

        if( jog.getJogid() != null){
            Toast.makeText(this, "Usuário Logado com Sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
            intent.putExtra("ID_USUARIO",jog.getJogid());
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Usuário não Cadastrado.", Toast.LENGTH_SHORT).show();
        }

    }

    public  void  goRegistrar(View v){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);

    }


}
