package com.example.thales.telalogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class segundaTela extends AppCompatActivity implements View.OnClickListener {

    private EditText editValor;
    private Button buttonFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        editValor = (EditText)findViewById(R.id.editValor);
        buttonFechar = (Button)findViewById(R.id.buttonFechar);

        buttonFechar.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("VALOR")){
            String valor = bundle.getString("VALOR");
            editValor.setText(valor);
        }
    }

    public void onClick(View view){
        finish();
    }
}
