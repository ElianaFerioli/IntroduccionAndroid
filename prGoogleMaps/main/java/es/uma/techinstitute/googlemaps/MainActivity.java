package es.uma.techinstitute.googlemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback {
    final int MY_PERMISSIONS_REQUEST_MAPS=1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment)
                getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"SIN permisos",Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_MAPS);
        }
        else {
            Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onMapReady(GoogleMap map) {

        LatLng greenRay = new LatLng(36.71853911463124,-4.496980905532837);
        // map.setMyLocationEnabled(true);
        int zoom = 17;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(greenRay, zoom));
        map.addMarker(new MarkerOptions()
                .title("The Green Ray")
                .snippet("SamsunTech.")
                .position(greenRay));
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_MAPS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"Permisos concedidos",
                            Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,
                            "SIN permisos",Toast.LENGTH_LONG).show();

            }
        }
    }
}
