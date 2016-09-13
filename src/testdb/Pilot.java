package testdb;
public class Pilot {    
    private String name;
    private int points;  
    private int anothertest;
    public Pilot(String name,int points) {
        this.name=name;
        this.points=points;
    }
     
    
    public void add(int test) 
    {
    	this.anothertest = test;
    }
    public int getPoints() {
        return points;
    }
    
    public void addPoints(int points) {
        this.points+=points;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return name+"/"+points;
    }
}