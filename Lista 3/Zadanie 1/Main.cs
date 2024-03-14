namespace Z1{
    public static class App{
        public static int Main(){
            Lista<int> lista = new Lista<int>();
            lista.push_back(4);
            lista.push_back(5);
            while(!lista.is_empty()){
                Console.WriteLine(lista.pop_back());
            }
            return 0;
        }
    }
}