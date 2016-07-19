package es.uma.techinstitute.componentesvisuales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner provincia;
    ListView provincias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adaptador por defecto de android
        String [] viaje = new String[]{"New york", "Lisboa", "Madrid"};
        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, viaje);
        provincia = (Spinner)findViewById(R.id.spinner);
        //Hay que establecerle un adaptador para decirle como va a funcionar
        provincia.setAdapter(adaptador);
        //Otra opcion para asignarle los datos es <string-array name="provincias"><item>New Yor</item>....</string-array>
        //hacer esto en el xml de values y colocar eso en el recurso del spinner
        //en vez de crear el adaptador ponemos ArrayAdapter<charsequence> adaptador = ArrayAdapter.crateFromResource(this, R.array.opcionesVacaciones, android.R.layout.simple_....
        //Esto se hace solo si pones provincia.setOnIt... luego parentesis y new OnItemSelect....
        provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Nos vamos a: " + adapterView.getItemAtPosition(i), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        provincias = (ListView)findViewById(R.id.listViewProvincias);
        String[] values = new String[]{"dsdsd", "asdasdasd", "dasdasdasd"};
        final ArrayList<String> list = new ArrayList<>();
        for(int x = 0; x < values.length; x++){
            list.add(values[x]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        provincias.setAdapter(adapter);
        provincias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Pulsada la opcion " + i + " provincia", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onRadioButton (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String ciudad = "";
        if(checked) {
            switch (view.getId()) {
                case R.id.radioButton:
                    ciudad = "New York";
                    break;
                case R.id.radioButton2:
                    ciudad = "Lisboa";
                    break;
                case R.id.radioButton3:
                    ciudad = "Málaga";
                    break;
            }
        }
        Log.d("RadioButton", ciudad);
        Toast.makeText(this, ciudad, Toast.LENGTH_LONG).show();
    }
    public void checkBox (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        StringBuffer comida = new StringBuffer();
            switch (view.getId()) {
                case R.id.checkBox:
                    comida.append("lechuga");
                    break;
                case R.id.checkBox2:
                    comida.append("bacon");
                    break;
                case R.id.checkBox3:
                    comida.append("tomate");
                    break;
            }
        if(checked){
            comida.insert(0, "Añade ");
        } else {
            comida.insert(0, "quita ");
        }
        Log.d("debug", comida.toString());
        Toast.makeText(this, comida, Toast.LENGTH_LONG).show();
    }



}
