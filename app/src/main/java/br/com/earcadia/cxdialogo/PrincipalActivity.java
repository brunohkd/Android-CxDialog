package br.com.earcadia.cxdialogo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class PrincipalActivity extends ActionBarActivity {

    AlertDialog alertDialog;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imageButton = (ImageButton) findViewById(R.id.idBtnImageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                alertaLayoutCustomisado();
            }
        });
    }


    public void alertaTresBoroes(View view) {

        AlertDialog.Builder alertaBuilder = new AlertDialog.Builder(this);
        alertaBuilder.setTitle("Faça sua Escolha");
        alertaBuilder.setMessage("Qual o caminho a seguir?");

        alertaBuilder.setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(PrincipalActivity.this, "Voltar= " + arg1, Toast.LENGTH_SHORT).show();
            }
        });

        alertaBuilder.setNegativeButton("Seguir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(PrincipalActivity.this, "Seguir= " + arg1, Toast.LENGTH_SHORT).show();
            }
        });

        alertaBuilder.setNeutralButton("Nada", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(PrincipalActivity.this, "Nada= " + arg1, Toast.LENGTH_SHORT).show();
               // alertDialog.dismiss();
            }
        });

        alertDialog = alertaBuilder.create();
        alertDialog.show();
    }


    public void alertaVariasOpcUmaEscolha(View view) {

        ArrayList<String> itens = new ArrayList<>();
        itens.add("Ruim");
        itens.add("Mediano");
        itens.add("Bom");
        itens.add("Ótimo");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(PrincipalActivity.this, R.layout.item_alerta, R.id.idItem_alertaTextView, itens);
        AlertDialog.Builder alertaBuilder = new AlertDialog.Builder(this);
        alertaBuilder.setTitle("Qualifique este software:");

        alertaBuilder.setSingleChoiceItems(arrayAdapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(PrincipalActivity.this, "posição selecionada=" + arg1, Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        alertDialog = alertaBuilder.create();
        alertDialog.show();
    }


    private void alertaLayoutCustomisado() {

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.alerta, null);
        view.findViewById(R.id.idBtnAlertaCustomizado).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Toast.makeText(PrincipalActivity.this, getText(R.string.vai_fechar),
                                Toast.LENGTH_SHORT).show();
                       alertDialog.dismiss();
                    }
                });

        AlertDialog.Builder alertaBuilder = new AlertDialog.Builder(this);
        alertaBuilder.setTitle("Titulo");
        alertaBuilder.setView(view);
        alertDialog = alertaBuilder.create();
        alertDialog.show();
    }


    public void alertaMultiOpcoes(View view) {
        CharSequence[] charSequences = new CharSequence[]{"Sopa", "Churrasco", "Pão com opa"};
        final boolean[] checados = new boolean[charSequences.length];
        AlertDialog.Builder alertaBuilder = new AlertDialog.Builder(this);
        alertaBuilder.setTitle("O que você gosta?");
        alertaBuilder.setMultiChoiceItems(charSequences, checados, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface arg0, int idx, boolean vlr) {
                checados[idx] = vlr;
            }
        });
        alertaBuilder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                StringBuilder texto = new StringBuilder("Checados: ");
                for (boolean ch : checados) {
                    texto.append(ch).append("; ");
                }
                Toast.makeText(PrincipalActivity.this, texto.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = alertaBuilder.create();
        alertDialog.show();
    }















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
