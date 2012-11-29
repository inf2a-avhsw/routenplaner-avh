package avh.schule; 


public class DBKNOTEN
{
    int knoten_ID;
    String name;
    
    public DBKNOTEN(int knoten_ID, String name){
        this.knoten_ID = knoten_ID;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
