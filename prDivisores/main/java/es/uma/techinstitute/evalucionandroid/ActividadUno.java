package es.uma.techinstitute.evalucionandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadUno extends AppCompatActivity {
    private Button botonCalcular;
    private Button botonLlamar;
    private TextView textoInformacion;
    private EditText informacionEntrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        botonCalcular = (Button) findViewById(R.id.botonCalcular);
        botonLlamar = (Button) findViewById(R.id.botonLlamar);
        textoInformacion = (TextView) findViewById(R.id.textoInformacion);
        informacionEntrada = (EditText) findViewById(R.id.informacionEntrada);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String cadena = extras.getString("informacionActividadDos");
            Toast toast = Toast.makeText(getApplicationContext(), cadena, Toast.LENGTH_LONG);
            toast.show();
        }

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int numeroEntrada = Integer.parseInt(informacionEntrada.getText().toString());
                    if (numeroEntrada <= 1) {
                        Toast toast = Toast.makeText(getApplicationContext(), "El número debe ser mayor que 1", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    System.out.println("El edit text vale: " + informacionEntrada.getText());
                    startActividadDos();
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Debe introducir un número obligatoriamente", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        botonLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("El edit text vale: " + informacionEntrada.getText());
                String tel = "656337783";
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                } else {
                    startActivity(i);
                }
            }
        });

    }
    public void startActividadDos() {
        Intent intent = new Intent(ActividadUno.this, ActividadDos.class);
        intent.putExtra("informacionEntrada", Integer.parseInt(informacionEntrada.getText().toString()));
        startActivity(intent);
    }
}
