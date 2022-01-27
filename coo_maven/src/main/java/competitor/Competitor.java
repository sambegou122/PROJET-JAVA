package competitor;

public class Competitor {
    
    /**
    Attributs
    */
    protected String name;
    protected int point ;

    /**
     * Create a competitor who is playing a competition
     * @param name (string) Competitor's name
     */
    public Competitor (String name){
        this.point = 0;
        this.name = name;
    }

    /**
     * @return Competitor's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Rename a competitor
     * @param newName (String) 
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * @return Competitor's point
     */
    public int getPoint(){
        return this.point;
    }

    /**
     * add or remove point
     * @param n (int) newPoint
     */
    public void setPoint(int n){
        this.point = n;
    }

    /**
     * Add one point
     */
    public void addPoint(int n){
        this.point += n;
    }

    /**
     * 
     * @param o (Object)
     * @return True if they have the same name && number of point
     */
    public Boolean Equals(Object o){
        if(o instanceof Competitor){
            Competitor other = (Competitor) o;
            return other.getName().equals(this.name) && other.getPoint()==this.point;
        }
        return false;
    }

    /**
     * @return give the information of the competitor
     */
    public String toString(){
        return this.name+" - "+this.point;
    }
}