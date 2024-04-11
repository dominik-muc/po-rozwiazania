// Dominik Muc, 345952, Zadanie 1 i 3

public class Putter<T> extends Worker<T>{
    protected T value;
    public Putter(MyBuffer<T> buff, T value, long interval) {
        super(buff, interval);
        this.value = value;
    }

    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                buff.put(value);
                Thread.sleep(interval);
            }
        }
        catch(Exception e){
            
        }
    }
}
