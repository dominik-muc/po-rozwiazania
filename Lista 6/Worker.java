// Dominik Muc, 345952, Zadanie 1 i 3

public abstract class Worker<T> extends Thread{
    protected final MyBuffer<T> buff;
    protected long interval;
    public Worker(MyBuffer<T> buff, long interval){
        this.buff = buff;
        this.interval = interval;
    }
}
