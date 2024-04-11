// Dominik Muc, 345952, Zadanie 1 i 3

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(final String args[]){
        try{
            MyBuffer<Integer> buf = new MyBuffer<Integer>(3);
            Putter<Integer> w1 = new Putter<Integer>(buf, 10, 1000L); 
            Taker<Integer> w2 = new Taker<Integer>(buf, 2000L);
            w1.start();
            w2.start();
            int i = 0;
            while(i < 20){
                System.out.println("Elements in buffer: " + buf.getCount());
                Thread.sleep(500);
                i++;
            }
            w1.interrupt();
            w2.interrupt();

            FileOutputStream fileOut = new FileOutputStream("data");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(buf);
            out.close();

            FileInputStream fileIn = new FileInputStream("data");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyBuffer<Integer> read = (MyBuffer<Integer>) in.readObject();
            in.close();

            System.out.println(read.take());
        }
        catch(Exception e){
            System.err.println(e.getMessage() + e.getStackTrace());
        }
    }
}
