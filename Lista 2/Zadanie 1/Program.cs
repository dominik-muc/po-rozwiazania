//Dominik Muc, 345952, Lista 2, Zadanie 1
using System;

namespace Z1{
    public class App{
        static int Main(){
            var stream = new IntStream();
            Console.Write("IntStream: ");
            for(int i = 0; i < 10; i++)
                Console.Write("{0} ", stream.Next());

            stream = new FibStream();

            Console.Write("\nFibStream: ");
            for(int i = 0; i < 10; i++)
                Console.Write("{0} ", stream.Next());
            
            stream = new RandomStream();

            Console.Write("\nRandomStream: ");
            for(int i = 0; i < 10; i++)
                Console.Write("{0} ", stream.Next());

            var rws = new RandomWordStream();

            Console.Write("\nRandomWordStream: ");
            for(int i = 0; i < 10; i++)
                Console.Write("{0} ", rws.Next());

            Console.WriteLine();
            return 0;
        }
    }
}
