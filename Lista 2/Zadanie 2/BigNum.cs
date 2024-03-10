using System.Data;
using System.Reflection.Metadata;

namespace Z3{
    public class BigNum{
        public const int MAX_BITS = 256;
        protected List<int> digits = new List<int>();
        public BigNum(int value){
            int i = 0;
            while(value > 0){
                array[i] = value % 2 == 1;
                i++;
            }
        }

        public void Write(){

        }
    }
}