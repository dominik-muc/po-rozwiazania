//Dominik Muc, 345952, Lista 1, Zadanie 2

#include <stdio.h>
#include <stdlib.h>

int gcd(int a, int b){
    if (b == 0) return a;
    return gcd(b, a % b);
}

////////////////////////////////////////////////////////// "klasa" ulamek
typedef struct Ulamek{
    int licznik;
    int mianownik;
} Ulamek;

Ulamek* nowy_ulamek(int num, int denom){
    int g = gcd(num, denom);
    Ulamek* new = malloc(sizeof(Ulamek));
    new->licznik = num / g;
    new->mianownik = denom / g;
    return new;
}

void show(Ulamek* u){
    printf("%i/%i ~= %f\n", u->licznik, u->mianownik, (float)u->licznik/(float)u->mianownik);
}

Ulamek* add_new(Ulamek* a, Ulamek* b){
    Ulamek* new = malloc(sizeof(Ulamek));
    new->licznik = (a->licznik * b->mianownik) + (b->licznik * a->mianownik);
    new->mianownik = a->mianownik * b->mianownik;
    int g = gcd(new->licznik, new->mianownik);
    new->licznik /= g;
    new->mianownik /= g;
    return new;
}

Ulamek* sub_new(Ulamek* a, Ulamek* b){
    Ulamek* new = malloc(sizeof(Ulamek));
    new->licznik = (a->licznik * b->mianownik) - (b->licznik * a->mianownik);
    new->mianownik = a->mianownik * b->mianownik;
    int g = gcd(new->licznik, new->mianownik);
    new->licznik /= g;
    new->mianownik /= g;
    return new;
}

Ulamek* mul_new(Ulamek* a, Ulamek* b){
    Ulamek* new = malloc(sizeof(Ulamek));
    new->licznik = a->licznik * b->licznik;
    new->mianownik = a->mianownik * b->mianownik;
    int g = gcd(new->licznik, new->mianownik);
    new->licznik /= g;
    new->mianownik /= g;
    return new;
}

Ulamek* div_new(Ulamek* a, Ulamek* b){
    Ulamek* new = malloc(sizeof(Ulamek));
    new->licznik = a->licznik * b->mianownik;
    new->mianownik = a->mianownik * b->licznik;
    int g = gcd(new->licznik, new->mianownik);
    new->licznik /= g;
    new->mianownik /= g;
    return new;
}

void add_change(Ulamek* a, Ulamek* b){
    b->licznik *= a->mianownik;
    b->licznik += a->licznik * b->mianownik;
    b->mianownik *= a->mianownik;
    int g = gcd(b->licznik, b->mianownik);
    b->licznik /= g;
    b->mianownik /= g;
}

void sub_change(Ulamek* a, Ulamek* b){
    b->licznik *= -1 * a->mianownik;
    b->licznik += a->licznik * b->mianownik;
    b->mianownik *= a->mianownik;
    int g = gcd(b->licznik, b->mianownik);
    b->licznik /= g;
    b->mianownik /= g;
}

void mul_change(Ulamek* a, Ulamek* b){
    b->licznik *= a->licznik;
    b->mianownik *= a->mianownik;
    int g = gcd(b->licznik, b->mianownik);
    b->licznik /= g;
    b->mianownik /= g;
}

void div_change(Ulamek* a, Ulamek* b){
    b->licznik *= a->mianownik;
    b->mianownik *= a->licznik;
    int g = gcd(b->licznik, b->mianownik);
    b->licznik /= g;
    b->mianownik /= g;
}
////////////////////////////////////////////////////////////////

int main(){
    //tu można się pobawić
    Ulamek* ul = nowy_ulamek(6, 8);
    Ulamek* ul2 = nowy_ulamek(5, 8);
    div_change(ul, ul2);
    show(ul);
    show(ul2);
    return 0;
}