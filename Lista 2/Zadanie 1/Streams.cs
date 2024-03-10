//Dominik Muc, 345952, Lista 2, Zadanie 1
using System.Security.Cryptography;
using System.IO;

namespace Z1{

    public class IntStream{
        protected int current = 0;
        public virtual int Next(){
            if(Eos()){
                throw new EndOfStreamException();
            }
            return current++;
        }

        public virtual bool Eos(){
            if(current == int.MaxValue) return true;
            return false;
        }

        public virtual void Reset(){
            current = 0;
        }
    }

    public class FibStream : IntStream{
        protected int previous = 1;
        public override int Next(){
            if(Eos()){
                throw new EndOfStreamException();
            }
            int next = current + previous;
            previous = current;
            current = next;
            return current;
        }
        public override bool Eos(){
            if(current > int.MaxValue - previous) return true;
            return false;
        }
        public override void Reset(){
            previous = 1;
            base.Reset();
        }
    }

    public class RandomStream : IntStream{
        public override int Next(){
            return RandomNumberGenerator.GetInt32(int.MaxValue);
        }
        public override bool Eos(){
            return false;
        }
    }

    public class RandomWordStream{
        private readonly FibStream fs = new FibStream();
        private readonly RandomStream rs = new RandomStream();
        public string Next(){
            string s = "";
            if(fs.Eos()){
                throw new EndOfStreamException();
            }
            int len = fs.Next();
            for(int i = 0; i < len; i++){
                s += (char)((rs.Next() % (126 - 33)) + 33);
            }
            return s;
        }
    }
}
