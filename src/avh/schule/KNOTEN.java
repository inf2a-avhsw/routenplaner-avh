package avh.schule; 

public class KNOTEN
{
    private String name;
    private int distanz;
    private KNOTEN vorgaenger;
    private boolean istBesucht;
    
    public KNOTEN(String n)
    {
        name=n;
        distanz=0;
        vorgaenger=null;
        istBesucht=false;
    }
    
    public String gibName() {
        return name;
    }
    
    public void setzeBesucht(boolean x){
        istBesucht=x;
    }
    
    public boolean gibBesucht(){
        return istBesucht;
    }
    
    public void setzeDistanz(int x){
        distanz=x;
    }
    
    public int gibDistanz(){
        return distanz;
    }
    
    public void setzeVorgaenger(KNOTEN k){
        vorgaenger=k;
    }
    
    public KNOTEN gibVorgaenger(){
        return vorgaenger;
    }
    
    
}
