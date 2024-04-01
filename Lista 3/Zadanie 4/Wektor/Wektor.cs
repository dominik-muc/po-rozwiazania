// Dominik Muc, 345952, Lista 3, Zadanie 4

namespace Library;

public class Wektor
{
    public int Dimension { get; }

    public float[] Coords { get; set; }

    public Wektor(int dimension, params float[] coords)
    {
        if (dimension < 1)
        {
            throw new ArgumentOutOfRangeException(nameof(dimension), dimension, $"Wymiar wektora musi być w zakresie 1 - {int.MaxValue}");
        }
        if (coords.Length != dimension)
        {
            throw new ArgumentException("Podano niepoprawną ilość współrzędnych dla wymiaru wektora.");
        }
        Dimension = dimension;
        Coords = coords;
    }

    public static Wektor operator +(Wektor a, Wektor b)
    {
        if (a.Dimension != b.Dimension)
        {
            throw new InvalidOperationException("Nie można dodać dwóch wektorów o różnych wymiarach.");
        }
        float[] coords = new float[a.Dimension];
        for (int i = 0; i < a.Dimension; i++)
        {
            coords[i] = a.Coords[i] + b.Coords[i];
        }
        return new Wektor(a.Dimension, coords);
    }

    public static float operator *(Wektor a, Wektor b)
    {
        if (a.Dimension != b.Dimension)
        {
            throw new InvalidOperationException("Nie można obliczyć iloczynu skalarnego dwóch wektorów o różnych wymiarach.");
        }
        float result = 0;
        for (int i = 0; i < a.Dimension; i++)
        {
            result += a.Coords[i] * b.Coords[i];
        }
        return result;
    }

    public static Wektor operator *(Wektor a, float c)
    {
        float[] coords = new float[a.Dimension];
        for (int i = 0; i < a.Dimension; i++)
        {
            coords[i] = a.Coords[i] * c;
        }
        return new Wektor(a.Dimension, coords);
    }

    public static Wektor operator *(float c, Wektor a) => a * c;

    public float Norma() => (float)Math.Sqrt(this * this);

    public static float operator +(Wektor a) => a.Norma();

}
