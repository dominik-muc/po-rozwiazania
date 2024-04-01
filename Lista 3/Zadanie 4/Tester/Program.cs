// Dominik Muc, 345952, Lista 3, Zadanie 4

using Library;

namespace Tester;

public static class Program
{
    public static void Main()
    {
        try
        {
            Wektor a = new(2, 2.3f, 3.4f);
            Wektor b = new(2, 4.5f, 6.7f);
            Wektor c = a + b;
            Console.WriteLine(c.Coords[1]);
            Wektor d = 3.4f * a;
            Console.WriteLine($"{d.Coords[0]}, {d.Coords[1]}");
            Console.WriteLine(d.Norma());
            // długość wektora także jako +Wektor
            Console.WriteLine(+c);
            Wektor e = new(3, 2f, 3f, 4f);
            Wektor f = a + e;
        }
        catch (Exception e)
        {
            Console.Error.WriteLine($"Error: '{e.Message}'\n{e.StackTrace}");
        }
    }
}
