package avh.schule; 


public class DBKNOTEN
{
    private int knoten_ID;
    private double lamda;
    private double phi;
    private double xKoordinate;
    private double yKoordinate;
    private double xKoordinate2;
    private double yKoordinate2;
    private String name;
	
    
    public DBKNOTEN(int knoten_ID, double lamda, double phi,
			double xKoordinate, double yKoordinate, double xKoordinate2,
			double yKoordinate2) {
		this.knoten_ID = knoten_ID;
		this.lamda = lamda;
		this.phi = phi;
		this.xKoordinate = xKoordinate;
		this.yKoordinate = yKoordinate;
		this.xKoordinate2 = xKoordinate2;
		this.yKoordinate2 = yKoordinate2;
		this.name = String.valueOf(knoten_ID);
	}


	public int getKnoten_ID() {
		return knoten_ID;
	}


	public void setKnoten_ID(int knoten_ID) {
		this.knoten_ID = knoten_ID;
	}


	public double getLamda() {
		return lamda;
	}


	public void setLamda(double lamda) {
		this.lamda = lamda;
	}


	public double getPhi() {
		return phi;
	}


	public void setPhi(double phi) {
		this.phi = phi;
	}


	public double getxKoordinate() {
		return xKoordinate;
	}


	public void setxKoordinate(double xKoordinate) {
		this.xKoordinate = xKoordinate;
	}


	public double getyKoordinate() {
		return yKoordinate;
	}


	public void setyKoordinate(double yKoordinate) {
		this.yKoordinate = yKoordinate;
	}


	public double getxKoordinate2() {
		return xKoordinate2;
	}


	public void setxKoordinate2(double xKoordinate2) {
		this.xKoordinate2 = xKoordinate2;
	}


	public double getyKoordinate2() {
		return yKoordinate2;
	}


	public void setyKoordinate2(double yKoordinate2) {
		this.yKoordinate2 = yKoordinate2;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
    
    


}
