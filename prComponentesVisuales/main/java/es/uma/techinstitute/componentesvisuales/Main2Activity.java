package es.uma.techinstitute.componentesvisuales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    GridView provincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        provincias = (GridView) findViewById(R.id.gridView);
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
            }
        });
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button: provincias.setNumColumns(1); break;
            case R.id.button2: provincias.setNumColumns(2); break;
            case R.id.button3: provincias.setNumColumns(3); break;

        }
    }
}
