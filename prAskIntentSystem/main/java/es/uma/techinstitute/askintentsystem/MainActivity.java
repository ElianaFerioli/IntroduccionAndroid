package es.uma.techinstitute.askintentsystem;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button http;
    private Button view;
    private List<ResolveInfo> lista;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        http = (Button)findViewById(R.id.http);
        view = (Button)findViewById(R.id.view);
        textview = (TextView)findViewById(R.id.textView);

        http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String link = "http://www.uma.es";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                recuperarInformacion(i);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_VIEW);
                recuperarInformacion(i);
            }
        });

    }

    private void recuperarInformacion(Intent i) {
        lista = resolver(i);
        String cadena  ="";
        if(!isVacio(lista)){
            int num = lista.size();
            cadena = "Hemos encontrado " + num + " actividades:\n";
            for(ResolveInfo info : lista){
                cadena += info.activityInfo.name + "\n";
            }
            System.out.println(cadena);
            textview.setText(cadena);
        } else {
            cadena = "No se han encontrado actividades";
            System.out.println(cadena);
            textview.setText(cadena);
        }
        Toast toast = Toast.makeText(getApplicationContext(), cadena, Toast.LENGTH_LONG);
        toast.show();
    }

    public boolean isVacio( List<ResolveInfo> resolveInfo){
        return lista.isEmpty();
    }

    private List<ResolveInfo> resolver(Intent intent){
        final PackageManager packageManager = getPackageManager();
        return packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
    }
}
