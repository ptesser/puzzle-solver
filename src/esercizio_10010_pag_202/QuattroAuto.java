package esercizio_10010_pag_202;

class Rotatoria{
    private boolean fromNord = false;
    private boolean fromEst = false;
    private boolean fromSud = false;
    private boolean fromOvest = false;

    private void setFrom(int dir, boolean cond){
        switch (dir){
            case 0: fromNord = cond; break;
            case 1: fromEst = cond; break;
            case 2: fromSud = cond; break;
            case 3: fromOvest = cond; break;
        }
    }

    private boolean getFrom(int dir){
        boolean val = false;
        switch (dir){
            case 0: val = fromEst; break;
            case 1: val = fromSud; break;
            case 2: val = fromOvest; break;
            case 3: val = fromNord; break;
        }
        return val;
    }

    public synchronized void entraRotatoria(int dir){
        while (getFrom(dir)){
            try {
                wait();
            } catch (InterruptedException e){ }
        }
        setFrom(dir, true);
        System.out.println("Macchina proveniente da " + dir + " entrata in rotatoria");
    }

    public synchronized void esciRotatoria(int dir){
        setFrom(dir, false);
        notifyAll();
        System.out.println("Macchina proveniente da " + dir + " uscita dalla rotatoria");
    }
}

class Auto extends Thread{
    private int distanza;
    private Rotatoria r;
    private int direzione;

    Auto(int d, Rotatoria rr, int dir){
        distanza = d; r = rr; direzione = dir;
    }

    public void run(){
        try {
            while(distanza > 0){
                distanza--;
                sleep(((int) Math.random())*50);
            }
            r.entraRotatoria(direzione);
            sleep(((int) Math.random())*70);
            r.esciRotatoria(direzione);

        } catch (InterruptedException e){ }

    }
}

public class QuattroAuto {
    public static void main( String[] argv ){
        Rotatoria r = new Rotatoria();
        Auto[] a = new Auto[4];
        for (int i = 0; i < 4; i++){
            a[i] = new Auto(10,r,i);
            a[i].start();
        }
        System.out.println("THREAD LANCIATI");
        for (int i = 0; i < 4; i++){
            try{
                a[i].join();
            }catch (InterruptedException e){}
        }
        System.out.println("FINITO");
    }
}
