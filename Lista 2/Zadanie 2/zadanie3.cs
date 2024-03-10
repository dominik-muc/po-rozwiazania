using System.Collections;
using System.Numerics;

namespace Z3{
    public class App{
        public static int Main(){
            BigInteger big = new(10);
            big *= 10;
            Console.WriteLine(big);
            return 0;
        }
    }
}