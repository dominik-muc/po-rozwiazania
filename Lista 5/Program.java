// Dominik Muc, 345952, Lista 5, zadanie 2 i 4

public class Program {
    public static void main(String[] args){
        try{
            Expression expr = new Add(new Const(4), new Variable("x"));
            System.out.println(expr.toString());
            expr = new Mult(new Add(new Const(4), new Const(5)), new Const(10));
            System.out.println(expr.toString());
            System.out.println(expr.evaluate());
            expr = new Mult(new Add(new Const(4), new Variable("x")), new Const(10));
            System.out.println("Wyraznie: " + expr.toString());
            System.out.println("Pochodna: " + expr.derivate().toString());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
