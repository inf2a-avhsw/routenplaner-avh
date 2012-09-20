package Routenplaner;

import java.util.ArrayList;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DATENBANK{
    
    Connection connection;
    Statement statement;
    public DATENBANK(/*String url, String benutzer, String passwort*/){
        String url = "jdbc:mysql://10.16.100.51/schule";
        String benutzer = "q11";
        String passwort = "q11";
        
        //Laden des Datenbanktreibers    
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    
        //Aufbauen der Datenbankverbindung
        try{
            connection = DriverManager.getConnection(url, benutzer, passwort);
        }catch(SQLException e){
            e.printStackTrace();
        }  
    
        //Statement erzeugen um SQL-Befehle auszufuehren
        try{ 
            statement = connection.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



public DBKANTE[] getDBKanten (){

//Auslesen der Daten aus der Datenbank und Speichern in ein ResultSet
ResultSet kantenRS = null; 
try{
    kantenRS = statement.executeQuery("SELECT * FROM Kanten");
}catch(SQLException e){
    e.printStackTrace();
}


//"Umwandeln" des ResultSet in eine ArrayList
ArrayList<DBKANTE> kantenListe = new ArrayList<DBKANTE>();
try{
while(kantenRS.next() == true){
    kantenListe.add(new DBKANTE(kantenRS.getInt(1),kantenRS.getInt(2),kantenRS.getInt(3),kantenRS.getInt(4)));
}
}catch(SQLException e){
    e.printStackTrace();
}

//Schließen des ResultSet
try{
kantenRS.close();
}catch(SQLException e){
    e.printStackTrace();
}


//"Umwandeln" der ArrayList in ein Array
DBKANTE[] kanten = kantenListe.toArray(new DBKANTE[0]);


return kanten;
}





public DBKNOTEN[] getDBKnoten(){
//Auslesen der Daten aus der Datenbank und Speichern in ein ResultSet
ResultSet knotenRS = null; 
try{
    knotenRS = statement.executeQuery("SELECT * FROM Knoten");
}catch(SQLException e){
    e.printStackTrace();
}


//"Umwandeln" des ResultSet in eine ArrayList
ArrayList<DBKNOTEN> knotenListe = new ArrayList<DBKNOTEN>();
try{
while(knotenRS.next() == true){
    knotenListe.add(new DBKNOTEN(knotenRS.getInt(1),knotenRS.getString(2)));
}
}catch(SQLException e){
    e.printStackTrace();
}

//Schließen des ResultSet
try{
knotenRS.close();
}catch(SQLException e){
    e.printStackTrace();
}

//"Umwandeln" der ArrayList in ein Array
DBKNOTEN[] knoten = knotenListe.toArray(new DBKNOTEN[0]);

return knoten;
}



public void schliessen(){
    try{
        statement.close();
        connection.close();
    }
    catch(SQLException e){
        e.printStackTrace();
    }
}
}
