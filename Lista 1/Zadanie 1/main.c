//Dominik Muc, 345952, Lista 1, Zadanie 1
//ujemne wartosci dla kwadratu i trojkata mowia nam w ktora strone zwrocona jest figura.
#include <stdio.h>
#include <stdlib.h>

#define PI 3.14f

typedef enum Type{
    TRIANGLE,
    CIRCLE,
    SQUARE
} Type;

typedef struct Figura{
    Type typfig;
    float x;
    float y;
    float size1;
    float size2;
} Figura;

Figura* new_triangle(float x, float y, float hyp, float base){
    if(hyp == 0 || base == 0){
        printf("Niepoprawne parametry, nie utworzono obiektu.\n");
        return NULL;
    }
    Figura* new = malloc(sizeof(Figura));
    if(!new){
        printf("Blad alokacji pamieci.\n");
        return NULL;
    }
    new->typfig = TRIANGLE;
    new->x = x;
    new->y = y;
    new->size1 = hyp;
    new->size2 = base;
    return new;
}

Figura* new_circle(float x, float y, float r){
    if(r <= 0){
        printf("Zly promien, nie utworzono obiektu.\n");
        return NULL;
    }
    Figura* new = malloc(sizeof(Figura));
    if(!new){
        printf("Blad alokacji pamieci.\n");
        return NULL;
    }
    new->typfig = CIRCLE;
    new->x = x;
    new->y = y;
    new->size1 = r;
    return new;
}

Figura* new_square(float x, float y, float base){
    if(base == 0){
        printf("Niepoprawne parametry, nie utworzono obiektu.\n");
        return NULL;
    }
    Figura* new = malloc(sizeof(Figura));
    if(!new){
        printf("Blad alokacji pamieci.\n");
        return NULL;
    }
    new->typfig = SQUARE;
    new->x = x;
    new->y = y;
    new->size1 = base;
    return new;
}

float pole(Figura* f){
    if(!f){
        printf("Figura nie istnieje!\n");
        return 0;
    }
    switch(f->typfig){
        case TRIANGLE:
        return (f->size1 * f->size2) / 2.0f;
        case CIRCLE:
        return PI * (f->size1 * f->size1);
        case SQUARE:
        return (f->size1 * f->size1);
    }
}

void show(Figura* f){
    if(!f){
        printf("Figura nie istnieje!\n");
        return;
    }
    char* type;
    switch(f->typfig){
        case TRIANGLE:
        type = "Triangle";
        break;
        case CIRCLE:
        type = "Circle";
        break;
        case SQUARE:
        type = "Square";
        break;
    }
    printf("Type: %s Cords: (%f, %f)\n", type, f->x, f->y);
}

void przesun(Figura* f, float x, float y){
    if(!f){
        printf("Figura nie istnieje!\n");
        return;
    }
    f->x += x;
    f->y += y;
}

float sumapol(Figura* f[], int size){
    float sum = 0;
    for(int i = 0; i < size; i++){
        if(!(f[i])){
            printf("Figura nie istnieje!\n");
            return 0;
        }
        sum += pole(f[i]);
    }
    return sum;
}

void zniszczfigure(Figura* f){
    if(!f){
        printf("Figura nie istnieje!\n");
        return;
    }
    free(f);
}

int main(){
    Figura* figures[3];
    figures[0] = new_circle(2, 3, 5);
    figures[1] = new_triangle(2, 3, 5, 4);
    figures[2] = new_square(2, 3, 5);

    show(figures[0]);
    show(figures[1]);
    show(figures[2]);

    printf("Suma pol: %f\n", sumapol(figures, 3));

    for(int i = 0; i < 3; i++){
        zniszczfigure(figures[i]);
    }

    return 0;
}