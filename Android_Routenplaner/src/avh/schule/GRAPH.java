package avh.schule; 

import java.util.Vector;
import java.util.Collections;
public class GRAPH
{
     private KNOTEN[] knotenliste;
     private KANTE[] kantenliste;
     
     public GRAPH(KNOTEN[] k, KANTE[] ka){
         knotenliste=k;
         kantenliste=ka;
        }
     
     public Vector<KNOTEN> dijkstra (KNOTEN s, KNOTEN e) {
        this.initialisiere(s);
        Vector<KANTE> kant = this.gibKanten(s);
        for (KANTE kan : kant) {
            int l = kan.gibLaenge();
            if(kan.gibKnoten2().gibDistanz()>l){
                kan.gibKnoten2().setzeDistanz(l);
                kan.gibKnoten2().setzeVorgaenger(s);
            }
        }
        while (!this.istJederKnotenBesucht()) {
            KNOTEN k = this.gibKnotenMitMinimalerDistanz();
            k.setzeBesucht(true);
            Vector<KANTE> kanten = this.gibKanten(k);
            for (KANTE kante : kanten) {
                int l = k.gibDistanz() + kante.gibLaenge();
                if(kante.gibKnoten2().gibDistanz()>l){
                    kante.gibKnoten2().setzeDistanz(l);
                    kante.gibKnoten2().setzeVorgaenger(k);
                }
            }
        }
        
        Vector<KNOTEN> pfad = new Vector<KNOTEN>();
        while (e != s) {
            pfad.add(e);
            e = e.gibVorgaenger();
        }
        return drehePfadUm(pfad);
    }
    
    public KNOTEN gibKnotenMitNamen(String name) {
        // FALSCHE NAMEN ÜBERGEBEN IST VERBOTEN
        for (int i = 0; i < knotenliste.length; i++) {
            if (knotenliste[i].gibName().compareTo(name) == 0) {
                return knotenliste[i];
            }
        }
        return null;
    }
                
    
    public Vector<KNOTEN> drehePfadUm(Vector<KNOTEN> pfad) {
        Collections.reverse(pfad);
        return pfad;
    }
    
    public void initialisiere(KNOTEN s){
        for(int i=0;i<knotenliste.length;i++){
            knotenliste[i].setzeDistanz(Integer.MAX_VALUE);
            knotenliste[i].setzeBesucht(false);
        }
        s.setzeDistanz(0);
        s.setzeBesucht(true);
    }
    
    public boolean istJederKnotenBesucht(){
        for(int i=0;i<knotenliste.length;i++){
            if(knotenliste[i].gibBesucht()==false){
                return false;
            }
        }
        return true;
    }
    
    public KNOTEN gibKnotenMitMinimalerDistanz(){
        KNOTEN min=null;
        for(int i=0;i<knotenliste.length;i++){
            if(knotenliste[i].gibBesucht()==false) {
                if (min == null || min.gibDistanz()>knotenliste[i].gibDistanz()) {
                    min = knotenliste[i];
                }
            }
        }
        return min;
    }
    
    public Vector<KANTE> gibKanten(KNOTEN k){
        Vector<KANTE> ergebnis=new Vector();
        for(int i=0;i<kantenliste.length;i++){
            if(kantenliste[i].gibKnoten1()==k){
                ergebnis.add(kantenliste[i]);
            }
            else if(kantenliste[i].gibKnoten2()==k){
                ergebnis.add(new KANTE(kantenliste[i].gibLaenge(),kantenliste[i].gibKnoten2(),kantenliste[i].gibKnoten1()));
            }
        }
        return ergebnis;
    }
            
                
}
