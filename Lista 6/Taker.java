// Dominik Muc, 345952, Zadanie 1 i 3

public class Taker<T> extends Worker<T>{
    public Taker(MyBuffer<T> buff, long interval) {
        super(buff, interval);
    }

    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                buff.take();
                sleep(interval);
            }
        }
        catch(Exception e){
            
        }
    }
}
