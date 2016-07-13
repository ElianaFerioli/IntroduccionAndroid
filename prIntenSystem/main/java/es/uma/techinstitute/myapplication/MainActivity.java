package es.uma.techinstitute.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button filtro;
    private Button noFiltro;
    private TextView salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filtro = (Button)findViewById(R.id.filtro);
        noFiltro = (Button)findViewById(R.id.noFiltro);
        salida = (TextView)findViewById(R.id.textView);

        if(Intent.ACTION_MAIN.equals(getIntent().getAction())){
            salida.setText("Llamado desde Home.");
        } else{
            salida.setText("Llamado desde intent implícito.");
        }
        noFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
                startActivity(i);
            }
        });
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uma.es/techinstitute"));
                startActivity(i);
            }
        });

    }

}
