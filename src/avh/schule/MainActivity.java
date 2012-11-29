package avh.schule;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//GUI-Objekte
	private Spinner spinStart, spinZiel;
	private Button btnRouteBerechnen;
	
	private STEUERUNG steuerung;
   //von ursprünglicher VIEW kopiert
	private Vector<String> knotenliste;
    private String startwert;
    private String zielwert;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //View-Elemente initialisieren
        spinStart = (Spinner) findViewById(R.id.spinStart);
        spinZiel = (Spinner) findViewById(R.id.spinZiel);
        btnRouteBerechnen = (Button) findViewById(R.id.btnRouteBerechnen);
        
        knotenliste = null;
        startwert=null;
        zielwert=null;
        
        //Steuerung erzeugen und sich selbst übergeben
        //Steuerung ruft initialisiere von MainActivity auf
        STEUERUNG s = new STEUERUNG(this);
        s.initialisiere();
    }

    
	public void initialisieren(Vector<String> liste,
			STEUERUNG steuerung) {
		knotenliste = liste;
        this.steuerung = steuerung;
        
        //Start- und Zielspinner mit Hilfe der Knotenliste initialisieren
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, knotenliste);
        spinStart.setAdapter(adapter);
        spinZiel.setAdapter(adapter);
        
        //Listener für Start- und Zielspinner initialisieren
        spinStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				startwert = spinStart.getSelectedItem().toString();				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				//nichts tun
			}
		});
        spinZiel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				zielwert = spinZiel.getSelectedItem().toString();				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				//nichts tun
			}
		});
        
        //Listener für btnRouteBerechnen initialisieren
        btnRouteBerechnen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//Falls startwert oder zielwert noch nicht vom nutzer angegeben wird eine er 
				//in Form eines Toast dazu aufgefordert
				if(startwert == null || zielwert == null){
					Toast t = Toast.makeText(v.getContext(), R.string.kein_start_zielwert, Toast.LENGTH_SHORT);
				}else{
				routeBerechnen(startwert, zielwert);
				}
			}
		});
        
	}
	
	private void routeBerechnen(String Apunkt, String Epunkt){
		steuerung.routeBerechnen(Apunkt, Epunkt);
	}

    //Anzeigen der Route und der Distanz in gesonderter Activity
	public void routeAusgeben(Vector<String> liste, int gibDistanz) {
		Intent intent = new Intent(getApplicationContext(), RouteAnzeigenActivity.class);
		ArrayList<String> zwischenspeicher = new ArrayList<String>(liste);
		zwischenspeicher.add(Integer.toString(gibDistanz));
		String[] anzeigeListe = zwischenspeicher.toArray(new String[0]);
		intent.putExtra("anzeigeListe", anzeigeListe);
		startActivity(intent);
	}
	
}