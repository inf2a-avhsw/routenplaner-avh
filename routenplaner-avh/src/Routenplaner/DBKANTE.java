package Routenplaner;

public class DBKANTE
{
    int knoten_ID;
    int knoten1;
    int knoten2;
    int laenge;
    
    public DBKANTE(int knoten_ID, int knoten1, int knoten2, int laenge){
        this.knoten_ID = knoten_ID;
        this.knoten1 = knoten1;
        this.knoten2 = knoten2;
        this.laenge = laenge;
    }
    
    public int getLaenge() {
        return laenge;
    }
    public int getKnoten1() {
        return knoten1;
    }
    public int getKnoten2() {
        return knoten2;
    }
}
