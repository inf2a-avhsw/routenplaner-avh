package avh.schule; 

public class DBKANTE
{
    int kanten_ID;
    int knoten1;
    int knoten2;
    int laenge;
    
    public DBKANTE(int kanten_ID, int knoten1, int knoten2, double laenge){
        this.kanten_ID = kanten_ID;
        this.knoten1 = knoten1;
        this.knoten2 = knoten2;
        this.laenge = (int) (laenge*1000);
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
