package Routenplaner;

public class KANTE
{
    private int laenge;
    private KNOTEN knoten1;
    private KNOTEN knoten2;
    
    public int gibLaenge(){
        return laenge;
    }
    
    public KNOTEN gibKnoten1(){
        return knoten1;
    }
    
    public KNOTEN gibKnoten2(){
        return knoten2;
    }
    
    public KANTE(int l, KNOTEN k1, KNOTEN k2)
    {   laenge=l;
        knoten1=k1;
        knoten2=k2;
    }
}
