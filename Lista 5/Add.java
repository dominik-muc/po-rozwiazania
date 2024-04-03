// Dominik Muc, 345952, Lista 5, zadanie 2 i 4

public class Add extends Expression{
    Expression e1;
    Expression e2;

    public Add(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int evaluate(){
        return e1.evaluate() + e2.evaluate();
    }

    @Override
    public String toString(){
        return e1.toString() + " + " + e2.toString();
    }

    @Override
    public Expression derivate(){
        return new Add(e1.derivate(), e2.derivate());
    }
}
