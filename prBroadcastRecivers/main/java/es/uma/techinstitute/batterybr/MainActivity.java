package es.uma.techinstitute.batterybr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mensajeSalida;
    ReceptorIntent bateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creo un objeto de la clase que he creado abajo
        bateria = new ReceptorIntent();
        //Le digo al sistema que quiero informacion de los intet que el propio sistema manda
        IntentFilter filterCargador = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);//Le digo a la aplicación el intent que me interesa conocer
        //Tengo que registrar ese intent diciendole cuál es la clase encgargada de recibir esa informacion y qué filtro va asociada a esa clase
        registerReceiver(bateria, filterCargador);
        mensajeSalida = (TextView)findViewById(R.id.mensajeSalida);
    }
    //Tengo que llamar a este étodo para que cuando la actividad se destruya, también se destruya el receptor
    //Si no se hace esto, se realentizaría el teléfono porque el sistema estaría buscando constantemente el reciver
    //Esto se podría poner tambien en onResume o en onPause para cuando se va a segundo plano
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(bateria);
    }
    //Creo una clase que hereda de BrtoadCast reciver
    private class ReceptorIntent extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Si nos vamos al "batteryManager" de la api podemos ver toda la información que nos puede mandar ese evento
            //El -1 es el valor que se mandartía en caso de que no se pueda encontrar el valor asignado a esa clave
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            if(status==BatteryManager.BATTERY_STATUS_CHARGING){
                mensajeSalida.setText("Movil cargado.");
                if(chargePlug==BatteryManager.BATTERY_PLUGGED_AC){
                    mensajeSalida.setText("Movil cargado con corriente alterna. Nivel de bateria: " + level);
                } else {
                    if(chargePlug==BatteryManager.BATTERY_PLUGGED_USB){
                        mensajeSalida.setText("Movil cargado con USB. Nivel de bateria: " + level);
                    }
                }
            } else {
                mensajeSalida.setText("Movil no está cargando. Nivel de bateria: " + level);
            }
        }

    }
}

