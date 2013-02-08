package avh.schule;

import java.util.Vector;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Attribute für Navigation
	private LocationManager locationManager;
	private boolean locationListenerAktiv;
	private DBKNOTEN[] dbknoten;
	Vector<KNOTEN> weg = null;
	private double lambdaAlt;
	private double phiAlt;
	private static final double lambdaNull = 10;
	private String letzterKnoten;
	private String aktuellerKnoten;
	private int zaehler;

	// GUI-Objekte
	private Spinner spinZiel;
	private Button btnNavigationStarten;
	private ImageView imageView;

	// von ursprünglicher VIEW kopiert
	private Vector<String> knotenliste;
	private String startwert;
	private String zielwert;

	private boolean startwertGefunden;
	private STEUERUNG steuerung;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Steuerung erzeugen und sich selbst übergeben
		// Steuerung ruft initialisiere von MainActivity auf
		STEUERUNG s = new STEUERUNG(this);
		s.initialisiere();
	}

	public void initialisieren(Vector<String> liste, STEUERUNG steuerung) {
		locationManager = (LocationManager) this
				.getSystemService(LOCATION_SERVICE);
		locationListenerAktiv = false;

		// View-Elemente initialisieren
		spinZiel = (Spinner) findViewById(R.id.spinZiel);
		btnNavigationStarten = (Button) findViewById(R.id.btnNavigationStarten);
		imageView = (ImageView) findViewById(R.id.imageView);

		knotenliste = null;
		startwert = null;
		zielwert = null;
		dbknoten = steuerung.gibDBKNOTEN();
		weg = null;
		letzterKnoten = null;
		aktuellerKnoten = null;
		startwertGefunden = false;
		zaehler = 1;
		this.steuerung = steuerung;

		knotenliste = liste;
		// Zielspinner mit Hilfe der Knotenliste initialisieren
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, knotenliste);
		spinZiel.setAdapter(adapter);

		// Listener für Zielspinner initialisieren
		spinZiel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				zielwert = spinZiel.getSelectedItem().toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// nichts tun
			}
		});

		// Listener für btnNavigationStarten initialisieren
		btnNavigationStarten.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (!locationListenerAktiv) {
					LocationListener listener = new LocationListener() {

						@Override
						public void onStatusChanged(String provider,
								int status, Bundle extras) {

						}

						@Override
						public void onProviderEnabled(String provider) {

						}

						@Override
						public void onProviderDisabled(String provider) {
							// Falls GPS deaktiviert wird, wird der Nutzer über
							// einen
							// AlertDialog aufgefordert es zu aktivieren
							if (provider.equals(LocationManager.GPS_PROVIDER)) {
								showGPSDialog();
							}
						}

						@Override
						public void onLocationChanged(Location location) {
							updateRoute(location);
						}
					};
					locationManager.requestLocationUpdates(
							LocationManager.GPS_PROVIDER, 10000, 5, listener);
					locationListenerAktiv = true;
				}
			}
		});

	}

	private void updateRoute(Location location) {
		double lambdaAktuell = location.getLongitude() * Math.PI / 180;
		double phiAktuell = location.getLatitude() * Math.PI / 180;
		
		if (!startwertGefunden) {
			startwert = "-1";
			double entfernungLetzterKnoten = 999999999;
			// Startwert wird nun gefunden, indem nähester Knoten gesucht wird
			for (int i = 0; i < dbknoten.length; i++) {
				double lambdaKnoten = dbknoten[i].getLamda() * Math.PI / 180;
				double phiKnoten = dbknoten[i].getPhi() * Math.PI / 180;
				// Berechnung der Entfernung zwischen aktueller Position und
				// Knoten in km
				double entfernungAktuell = 6378.137 * Math.acos((Math
						.sin(phiAktuell) * Math.sin(phiKnoten))
						+ (Math.cos(phiAktuell) * Math.cos(phiKnoten) * Math
								.cos(lambdaKnoten - lambdaAktuell)));
				if (entfernungAktuell < entfernungLetzterKnoten) {
					startwert = dbknoten[i].getName();
				}
				entfernungLetzterKnoten = entfernungAktuell;
			}
			startwertGefunden = true;
			// Da der Startwert gefunden ist kann die Route nun berechnet werden
			weg = steuerung.routeBerechnen(startwert, zielwert);
			// Für die folgende Routenführung wird der Startwert als letzter
			// Knoten und der nächste Knoten als aktuellerKnoten gespeichert
			letzterKnoten = startwert;
			aktuellerKnoten = weg.get(1).gibName();
			// Als letztes wird noch die aktuelle position als letzte Position
			// gespeichert
			lambdaAlt = lambdaAktuell;
			phiAlt = phiAktuell;
		}else{
		// Die Route ist berechnet und die Routenführung kann beginnen
		

		// Falls der Nutzer weniger als 2 Meter vom nächsten Knoten entfernt ist
		// wird dieser als erreicht angesehen und als letzterKnoten eingetragen
		//Für den aktuellen Knoten wird dann der nächste Knoten der Route  eingetragen
		double lambdaKnoten = dbknoten[zaehler].getLamda() * Math.PI / 180;
		double phiKnoten = dbknoten[zaehler].getPhi() * Math.PI / 180;
		double entfernungAktuell = 6378.137 * Math
				.acos((Math.sin(phiAktuell) * Math.sin(phiKnoten))
						+ (Math.cos(phiAktuell) * Math.cos(phiKnoten) * Math
								.cos(lambdaKnoten - lambdaAktuell)));
		if(entfernungAktuell <= 0.002){
			if(aktuellerKnoten.equals(weg.lastElement().gibName())){
				zielErreicht();
			}else{
			letzterKnoten = aktuellerKnoten;
			aktuellerKnoten = weg.get(zaehler).gibName();
			zaehler++;
			}
		}
		// Um die momentane Laufrichtung zu ermitteln wird aus aktueller und
		// letzter Postion mit Hilfe der Mercator-Projektion ein Vektor
		// aufgestellt
		// Dieser wird dann mit einem Vektor, erstellt aus den beiden Knoten,
		// zwischen denen man sich befindet, verglichen und so auf die
		// Laufrichtung geschlossen
		double x2 = lambdaAktuell - lambdaNull;
		double x1 = lambdaAlt - lambdaNull;
		double y2 = Math.asin(Math.tan(phiAktuell * Math.PI / 180));
		double y1 = Math.asin(Math.tan(phiAlt * Math.PI / 180));

		double[] vektorLaufrichtung = new double[2];
		vektorLaufrichtung[0] = x2 - x1;
		vektorLaufrichtung[1] = y2 - y1;

		x2 = dbknoten[Integer.parseInt(aktuellerKnoten)].getxKoordinate();
		x1 = dbknoten[Integer.parseInt(letzterKnoten)].getxKoordinate();
		y2 = dbknoten[Integer.parseInt(aktuellerKnoten)].getyKoordinate();
		y1 = dbknoten[Integer.parseInt(letzterKnoten)].getyKoordinate();

		double[] vektorRoutenrichtung = new double[2];
		vektorRoutenrichtung[0] = x2 - x1;
		vektorRoutenrichtung[1] = y2 - y1;
		
		//Winkelberechnung zwischen den beiden Vektoren
		double skalarprodukt = (vektorLaufrichtung[0] * vektorRoutenrichtung[0]) + (vektorLaufrichtung[1] * vektorRoutenrichtung[1]);
		double betragVektorLaufrichtung = vektorLaufrichtung[0]*vektorLaufrichtung[0]+vektorLaufrichtung[1]*vektorLaufrichtung[1];
		double betragVektorRoutenrichtung = vektorRoutenrichtung[0]*vektorRoutenrichtung[0]+vektorRoutenrichtung[1]*vektorRoutenrichtung[1];
		double betragsprodukt = (Math.sqrt(betragVektorLaufrichtung))*(betragVektorRoutenrichtung);
		double winkel = Math.acos(skalarprodukt/betragsprodukt)*(180/Math.PI);
		
		//Berechnung der Richtungsanweisung
		if((vektorLaufrichtung[0]>0 && vektorRoutenrichtung[0]<=0) || (vektorLaufrichtung[0]<=0 && vektorRoutenrichtung[0]>0)){
			bitteWenden();
		}else if(vektorLaufrichtung[0]>0 && vektorRoutenrichtung[0]>0){
			if((vektorLaufrichtung[1]-vektorRoutenrichtung[1]) > 0){
				if(winkel > 15){
					rechtsAbbiegen();
				}
				else{ 
					geradeaus();
				}
			}else if((vektorLaufrichtung[1]-vektorRoutenrichtung[1]) < 0){
				if(winkel > 15){
					linksAbbiegen();
				}
				else{ 
					geradeaus();
				}
			}
		}else if(vektorLaufrichtung[0]<0 && vektorRoutenrichtung[0]<0){
			if((vektorLaufrichtung[1]-vektorRoutenrichtung[1]) > 0){
				if(winkel > 15){
					linksAbbiegen();
				}
				else{ 
					geradeaus();
				}
			}else if((vektorLaufrichtung[1]-vektorRoutenrichtung[1]) < 0){
				if(winkel > 15){
					rechtsAbbiegen();
				}
				else{ 
					geradeaus();
				}
			}
		}
		}
	}

	private void showGPSDialog() {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder.setTitle(R.string.dialogGPS);
		dialogBuilder.setPositiveButton(R.string.dialogGPSPositiveButton,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// GPS Menü aufrufen
						enableGPS();
					}
				});
		dialogBuilder.setNegativeButton(R.string.dialogGPSNegativeButton,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Activity schließen
						finish();
					}
				});

		dialogBuilder.create().show();
	}

	private void enableGPS() {
		Intent settingsIntent = new Intent(
				Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivity(settingsIntent);
	}
	
	private void bitteWenden(){
		imageView.setImageResource(R.drawable.wenden);
	}
	
	private void rechtsAbbiegen(){
		imageView.setImageResource(R.drawable.rechts);
	}
	
	private void linksAbbiegen(){
		imageView.setImageResource(R.drawable.links);
	}
	
	private void geradeaus(){
		imageView.setImageResource(R.drawable.geradeaus);
	}
	
	private void zielErreicht(){
		Toast toast = new Toast(this);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setText(R.string.zielErreicht);
		toast.show();
	}
}