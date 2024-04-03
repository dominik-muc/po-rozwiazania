// Dominik Muc, 345952, Lista 5, zadanie 2 i 4

public class Const extends Expression{
    int value;

    public Const(int value){
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public Expression derivate(){
        return new Const(0);
    }
}
