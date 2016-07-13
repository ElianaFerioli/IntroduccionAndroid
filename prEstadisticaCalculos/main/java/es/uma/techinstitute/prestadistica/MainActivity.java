package es.uma.techinstitute.prestadistica;
import java.util.Random;

import es.uma.techinstitute.prestadistica.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
public class MainActivity extends Activity {
    TextView Salida;
    /**************************
     * Aquí comienza el Programa, sería como el main en Java
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarSalida();
        EjemploUso();
    }

    /*****************
     * Método utilizado para inicializar las variables visuales.
     * Todas las variables que usamos en XML las capturamos aquí
     * para usarlas en Java.
     */
    private void inicializarSalida(){
        Salida = (TextView)this.findViewById(R.id.Salida);
        Salida.setText("");

    }

    /******
     * Método EjemploUso:
     *
     * Aquí irá el código que teníamos antes en el main
     */
    private void EjemploUso (){
        Estadistica est = new Estadistica();
        Random ran = new Random();
        for (int i = 0; i < 100000 ; i++) {
            est.agrega(ran.nextGaussian());
        }

        EjemploUsoLog(est); //Salidas en LogEjemploUsoVisual(est); //Salidas Visuales
        EjemploUsoVisual(est);
    }

    /**************
     * Aquí mostramos los valores en el Log.
     * Podemos mantener la salida que teníamos antes en Java y
     * además usando un método nuevo de Android Log.
     * @param est
     */

    private void EjemploUsoLog (Estadistica est){

        double media;
        double desvT;

        media= est.media();



        desvT=est.desviacionTipica();

        System.out.println("Media = "+media);

        System.out.println("Desviación típica = "+desvT);


        Log.d("Execucion","Media = "+media);
        Log.d("Execucion","Desviación típica = "+desvT);
    }

    /**********************************
     * Mostramos la información en el teléfono
     * @param est
     */

    private void EjemploUsoVisual (Estadistica est){

        long  tiempoMediaIni = System.nanoTime();
        println("Media = "+est.media());
        long  tiempoMediaFin = System.nanoTime();
        long tiempoMedia = tiempoMediaFin - tiempoMediaIni;
        println("Calculado en: " + tiempoMedia + " nanosegundos.");
        long tiempoDesIni = System.nanoTime();
        println("Desviación típica = "+est.desviacionTipica());
        long tiempoDesFin = System.nanoTime();
        long tiempoDes = tiempoDesFin - tiempoDesIni;
        println("Calculado en: " + tiempoDes + " nanosegundos.");

    }

    /************************
     * Método que muestra una salida en el teléfono
     * @param salida
     */

    private void println (String salida){

        CharSequence salidaText=Salida.getText();
        if(salidaText!=null){
            if(salidaText.length()==0){
                Salida.setText(salida);
            }
            else{
                Salida.append("\n"+salida);
            }
        }
    }
}