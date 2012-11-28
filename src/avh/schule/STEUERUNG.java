package avh.schule; 

import java.util.Vector;

public class STEUERUNG
{

MainActivity sicht;
GRAPH graph;
Vector<String> knotennamenliste;

public STEUERUNG(MainActivity sicht) {
    // GRAPH INITIALISIEREN
    DATENBANK db = new DATENBANK(sicht.getApplicationContext()); // stellt dbknoten[]/dbkanten[] bereit, muss ausgelesen werden
    DBKNOTEN[] dbknoten = db.getDBKnoten();
    DBKANTE[] dbkanten = db.getDBKanten();
    db.datenbankSchliessen();
    KNOTEN[] k = new KNOTEN[dbknoten.length];
    for (int i = 0; i < dbknoten.length; i++) {
        k[i] = new KNOTEN(dbknoten[i].getName());
    }
    KANTE[] ka = new KANTE[dbkanten.length];
    for (int i = 0; i < dbkanten.length; i++) {
        ka[i] = new KANTE(dbkanten[i].getLaenge(), k[dbkanten[i].getKnoten1()-1], k[dbkanten[i].getKnoten2()-1]);
    }
    graph = new GRAPH(k, ka);

    

    
    //KNOTENNAMENLISTE ....
    knotennamenliste = new Vector<String>();
    for (int i = 0; i < dbknoten.length; i++) {
        knotennamenliste.add(dbknoten[i].getName());
    }      
    
    // SICHT INITIALISIEREN
    this.sicht = sicht;

}

public void routeBerechnen(String Apunkt, String Epunkt) { // Die Namen von Start- und Endknoten, aufgerufen durch VIEW
    
    Vector<String> knotennamenlist= new Vector<String>();
    KNOTEN anfang = graph.gibKnotenMitNamen(Apunkt);
    KNOTEN ende = graph.gibKnotenMitNamen(Epunkt);
    Vector<KNOTEN> weg = graph.dijkstra(anfang, ende);
    for (KNOTEN k : weg) {
        knotennamenlist.add(k.gibName());
    }
    
    sicht.routeAusgeben(knotennamenlist, ende.gibDistanz());
}

public void initialisiere() {
    sicht.initialisieren(knotennamenliste, this);

}
}
