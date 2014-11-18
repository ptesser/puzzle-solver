package singleton_pattern;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere come utilizzare il design pattern singleton sul costruttore
 */

public class Singleton {
    private static Singleton instance;
    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        
        return instance;
            
    }
    private Singleton(){
    
    }
    public static void main(String[] args){
        Singleton s = Singleton.getInstance();
    
    }
}
