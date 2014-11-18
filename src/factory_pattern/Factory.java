package factory_pattern;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere come utilizzare il design pattern factory sul costruttore
 */

public class Factory {
    private int fieldInt;

    private Factory(int fieldInt){ this.fieldInt = fieldInt; }

    public static Factory create(int fieldInt){
        return new Factory( fieldInt) ;
    }

    public int getFieldInt(){ return this.fieldInt; }

    public static void main(String[] args){
        Factory obj = Factory.create(10);
        System.out.println( obj.getFieldInt() );
    }
}
