package br.senac.pi.controlenotas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.pi.controlenotas.domain.InstituicaoDB;

public class CadastraInstituicaoActivity extends AppCompatActivity {
    //codJoao
    private SQLiteDatabase db;
    private InstituicaoDB instituicaoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_instituicao);

        instituicaoDB = new InstituicaoDB(this);
        //joaoCod
        findViewById(R.id.btnCadInstituicao).setOnClickListener(cadastrarInstituicao());
        findViewById(R.id.btnListaInstituicao).setOnClickListener(intentListarInstituicao());
    }

    //joaoCod
    private View.OnClickListener cadastrarInstituicao(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = instituicaoDB.getWritableDatabase();
                ContentValues valores = new ContentValues();
                EditText edtInstituicao = (EditText) findViewById(R.id.edtInstituicao);
                valores.put("instituicao", edtInstituicao.getText().toString());
                long id = db.insert("instituicoes", null, valores);

                if (id != 0){
                    Toast.makeText(getApplicationContext(), getString(R.string.cad_sucesso), Toast.LENGTH_LONG).show();
                    edtInstituicao.setText("");
                    edtInstituicao.requestFocus();
                }else {
                    Toast.makeText(getApplicationContext(), getString(R.string.cad_erro), Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    //joaoCod
    private View.OnClickListener intentListarInstituicao(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastraInstituicaoActivity.this, ListaInstituicaoActivity.class);
                startActivity(intent);
            }
        };
    }
}
