package util;

public class Puissance {

    /**
     * Attributes
     */
    private int pui;
    
    /**
     * Constructor
     * @param n the number for the power
     */
    public Puissance(int n){
        this.pui=n;
    }

    /**
     * this function tell if the number given in parameter is a power of the attributes pui
     * @param n the number to check
     * @return true if it's a power of, else false
     */
    public boolean puissance(int n){
        if (n ==0){
            return false;
        }
        while(n!=1){
            if (n%this.pui!=0 && n !=1){
                return false;
            }
            n = n/this.pui;
        }
        return true;
    }
    
}
