package br.senac.pi.controlenotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //joaoCod
        findViewById(R.id.btnCadastrar).setOnClickListener(intentCadastrar());
        findViewById(R.id.btnPesquisar).setOnClickListener(intentPesquisar());
        //findViewById(R.id.btnSair).setOnClickListener(sair());
    }

    //joaoCod
    private View.OnClickListener intentCadastrar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CadastrarActivity.class);
                startActivity(intent);
            }
        };
    }

    //joaoCod
    private View.OnClickListener intentPesquisar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PesquisarActivity.class);
            }
        };
    }
}
