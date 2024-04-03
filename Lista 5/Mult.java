// Dominik Muc, 345952, Lista 5, zadanie 2 i 4

public class Mult extends Expression{
    Expression e1;
    Expression e2;

    public Mult(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int evaluate() {
        return e1.evaluate() * e2.evaluate();
    }

    @Override
    public String toString() {
        String a = e1.toString();
        String b = e2.toString();
        if(e1 instanceof Add) a = "(" + a + ")";
        if(e2 instanceof Add) b = "(" + b + ")";
        return a + " * " + b;
    }
    
    @Override
    public Expression derivate(){
        return new Add(new Mult(e1, e2.derivate()), new Mult(e1.derivate(), e2));
    }
}
