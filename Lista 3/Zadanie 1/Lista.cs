namespace Z1{
    public class Element<T>{
        public T value;
        public Element<T>? next;

        public Element<T>? previous;

        public Element(T value){
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public class Lista<T>{
        protected Element<T>? head;
        protected Element<T>? tail;

        public void push_front(T value){
            Element<T> new_head = new Element<T>(value);
            if(is_empty()){
                head = new_head;
                tail = new_head;
                return;
            }
            head!.previous = new_head;
            new_head.next = head;
            head = new_head;
        }

        public void push_back(T value){
            Element<T> new_tail = new Element<T>(value);
            if(is_empty()){
                head = new_tail;
                tail = new_tail;
                return;
            }
            tail!.next = new_tail;
            new_tail.previous = tail;
            tail = new_tail;
        }

        public T pop_front(){
            if(is_empty()){
                throw new InvalidOperationException();
            }
            T value = head!.value;
            Element<T>? new_head = head.next;
            if(tail!.previous == head){
                tail = head;
            }
            head = new_head;
            return value;
        }

        public T pop_back(){
            if(is_empty()){
                throw new InvalidOperationException();
            }
            T value = tail!.value;
            Element<T>? new_tail = tail.previous;
            if(head!.next == tail){
                head = tail;
            }
            tail = new_tail;
            return value;
        }

        public bool is_empty(){
            if(head == null || tail == null) return true;
            return false;
        }
    }
}