package avh.schule;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DATENBANK {


		
		SQLiteDatabase myDatabase;
		AssetDatabaseOpenHelper helper;
		
		public DATENBANK(Context context){
			//TODO mit Hilfe von AssetDatabaseOpenHelper Datenbank von Assets in Systemspeicher kopieren
			helper = new AssetDatabaseOpenHelper(context);
			myDatabase = helper.openDatabase();
		}

		public DBKANTE[] getDBKanten(){
		//Auslesen der Daten aus der DatabaseHelper und Speichern in ein ResultSet
		Cursor kantenCursor = null; 
		try{
			String[] s = {"Kanten_ID", "Knoten1", "Knoten2", "Laenge"};
		    kantenCursor = myDatabase.query("Kanten", s, null, null, null, null, null);
		}catch(SQLException e){
		    e.printStackTrace();
		}


		//"Umwandeln" des ResultSet in eine ArrayList
		ArrayList<DBKANTE> kantenListe = new ArrayList<DBKANTE>();
		try{
		while(kantenCursor.moveToNext() == true){
		    kantenListe.add(new DBKANTE(kantenCursor.getInt(0),kantenCursor.getInt(1),kantenCursor.getInt(2),kantenCursor.getInt(3)));
		}
		}catch(SQLException e){
		    e.printStackTrace();
		}

		//Schlieﬂen des Cursor
		try{
			kantenCursor.close();
		}catch(SQLException e){
		    e.printStackTrace();
		}


		//"Umwandeln" der ArrayList in ein Array
		DBKANTE[] kanten = kantenListe.toArray(new DBKANTE[0]);


		return kanten;
		}
	
	
	
	public DBKNOTEN[] getDBKnoten(){
		//Auslesen der Daten aus der DatabaseHelper und Speichern in ein ResultSet
		Cursor knotenCursor = null; 
		try{
			String[] s = {"Knoten_ID", "Name"};
		    knotenCursor = myDatabase.query("Knoten", s, null, null, null, null, null);
		}catch(SQLException e){
		    e.printStackTrace();
		}

		//"Umwandeln" des ResultSet in eine ArrayList
		ArrayList<DBKNOTEN> knotenListe = new ArrayList<DBKNOTEN>();
		try{
		while(knotenCursor.moveToNext() == true){
		    knotenListe.add(new DBKNOTEN(knotenCursor.getInt(0),knotenCursor.getString(1)));
		}
		}catch(SQLException e){
		    e.printStackTrace();
		}

		//Schlieﬂen des Cursor
		try{
			knotenCursor.close();
		}catch(SQLException e){
		    e.printStackTrace();
		}

		//"Umwandeln" der ArrayList in ein Array
		DBKNOTEN[] knoten = knotenListe.toArray(new DBKNOTEN[0]);

		return knoten;
		}
	
	public void datenbankSchliessen(){
		myDatabase.close();
	}
}

