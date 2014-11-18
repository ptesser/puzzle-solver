package swap;

/**
 * @author  Paolo Tesser
 * @version  0.1
 *
 */
public class Swap {
    /**
     *
     * @param x Object array that it should invert the first two elements
     * @return the x Object array with the two first elements swapped
     */
    public static Object[] doSwap(Object[] x){
        Object tmp = x[0];
        x[0] = x[1];
        x[1] = tmp;
        return x;
    }
    public static void main(String[] args){
        Integer x = new Integer(2);
        Integer y = new Integer(3);

        Object[] num = {x,y};
        System.out.println(num[0] + " - " + num[1]);
        num = doSwap(num);
        System.out.println(num[0] + " - " + num[1]);

    }
}
