package es.uma.techinstitute.evalucionandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActividadDos extends AppCompatActivity {
    private Button botonVolver;
    private TextView textoDatoActividadUno;
    private TextView textoDivisores;
    private List<Integer> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        botonVolver = (Button)findViewById(R.id.botonVolver);
        textoDatoActividadUno = (TextView)findViewById(R.id.textoDatoActividadUno);
        textoDivisores = (TextView)findViewById(R.id.textoDivisores);
        Bundle extras = getIntent().getExtras();
        int dato = extras.getInt("informacionEntrada");
        textoDatoActividadUno.setText("" + dato);
        lista = calculaDivisores(Integer.parseInt(textoDatoActividadUno.getText().toString()));
        System.out.println("la lista es: " + lista.toString());
        textoDivisores.setText(lista.toString());

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActividadUno();
            }
        });

    }
    public List<Integer> calculaDivisores(int x) {
        List<Integer> lista = new ArrayList<>();
        for(int i = 1; i <= x; i++){
            if((x%i)==0){
                lista.add(i);
            }
        }
        return lista;
    }
    public void startActividadUno() {
        Intent intent = new Intent(ActividadDos.this, ActividadUno.class);
        if(lista.size()<=2){
            intent.putExtra("informacionActividadDos", "El número " + textoDatoActividadUno.getText() + " es primo.");
        } else {
            intent.putExtra("informacionActividadDos", "El número " + textoDatoActividadUno.getText() + " tiene " + lista.size() + " divisores.");
        }
        startActivity(intent);
    }

}
