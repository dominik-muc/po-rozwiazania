// Dominik Muc, 345952, Lista 5, zadanie 2 i 4

public class Variable extends Expression{
    String symbol;
    int value;
    boolean isSet = false;

    public Variable(String symbol){
        this.symbol = symbol;
    }

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public int evaluate() {
        if(!isSet) throw new IllegalStateException("Zmienna nie ma wartosci do obliczenia!");
        return value;
    }

    @Override
    public String toString() {
        return symbol;
    }
    
    @Override
    public Expression derivate(){
        return new Const(1);
    }
}
