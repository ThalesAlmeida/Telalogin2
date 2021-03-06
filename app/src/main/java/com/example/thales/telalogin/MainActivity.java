package com.example.thales.telalogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //public final int valor = 123;
    private EditText login;
    private EditText senha;
    private Button buttonOk;
    private Button buttonescrita;
    private Button buttonleitura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText)findViewById(R.id.editValor);
        senha = (EditText)findViewById(R.id.editValor2);
        buttonOk = (Button)findViewById(R.id.buttonOk);
        buttonescrita = (Button)findViewById(R.id.buttonescrita);
        buttonleitura = (Button)findViewById(R.id.buttonleitura);

        buttonOk.setOnClickListener(this);
        //buttonescrita.setOnClickListener(this);
        //buttonleitura.setOnClickListener(this);
    }

    public void mensagem (String m){
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }


    public void onClick(View view){

        if((login.getText().toString().equals("thales")) && senha.getText().toString().equals("123")){

            Bundle bundle = new Bundle();
            Intent intent = new Intent(this,segundaTela.class);
            intent.putExtra("VALOR", login.getText().toString());
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,MainActivity.class);

            mensagem("Login ou senha incorretos");
        }

    }

    public void escrita(View view){

        SharedPreferences vrshared = getSharedPreferences("login", MODE_PRIVATE);

        SharedPreferences.Editor vrEditor = vrshared.edit();
        vrEditor.putString("senha", senha.getText().toString());
        vrEditor.commit(); //Salvar
    }

    public void leitura(View view){
        SharedPreferences vrshared = getSharedPreferences("login", MODE_PRIVATE);

        String v = vrshared.getString("senha", Integer.toString(RESULT_CANCELED));
    }
}
