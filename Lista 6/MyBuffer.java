// Dominik Muc, 345952, Zadanie 1 i 3

import java.io.Serializable;


public class MyBuffer<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    private T[] contents;
    private int end = 0;
    private int begin = 0;

    @SuppressWarnings("unchecked")
    public MyBuffer(int size){
        contents = (T[]) new Object[size];
    }

    public synchronized void put(T element) throws InterruptedException{
        try{
            while(getCount() == contents.length){
                wait();
            }
            end++;
            contents[end % contents.length] = element;
            notifyAll();
        }
        finally{
            
        }
    }

    public synchronized T take() throws InterruptedException{
        try{
            while(getCount() == 0){
                wait();
            }
            T ret = contents[begin % contents.length];
            begin++;
            notifyAll();
            return ret;
        }
        finally{
            
        }
    }
    
    public int getCount(){
        return end - begin;
    }
    
}
