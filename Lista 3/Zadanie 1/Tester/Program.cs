using Lista;

namespace Tester
{
    public static class Program
    {
        public static void Main()
        {
            Lista<int> lista = new();
            lista.PushBack(4);
            lista.PushBack(5);
            lista.PushBack(6);
            lista.PushBack(7);
            while(!lista.IsEmpty())
            {
                Console.WriteLine(lista.PopFront());
            }
            lista.PushBack(1);
            lista.PushBack(2);
            lista.PushBack(3);
            lista.PushBack(4);
            while(!lista.IsEmpty())
            {
                Console.WriteLine(lista.PopBack());
            }
        }
    }
}