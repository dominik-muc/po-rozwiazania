// Dominik Muc, 345952, Lista 3, Zadanie 1

namespace Lista
{
    public class Element<T>(T value)
    {
        public T value = value;
        public Element<T>? next = null;

        public Element<T>? previous = null;
    }

    public class Lista<T>
    {
        protected Element<T>? head;
        protected Element<T>? tail;

        public void PushFront(T value)
        {
            Element<T> new_head = new(value);
            if(IsEmpty())
            {
                head = new_head;
                tail = new_head;
                return;
            }
            head!.previous = new_head;
            new_head.next = head;
            head = new_head;
        }

        public void PushBack(T value)
        {
            Element<T> new_tail = new(value);
            if(IsEmpty())
            {
                head = new_tail;
                tail = new_tail;
                return;
            }
            tail!.next = new_tail;
            new_tail.previous = tail;
            tail = new_tail;
        }
        
        public T PopFront()
        {
            if(IsEmpty())
            {
                throw new InvalidOperationException();
            }
            
            T value = head!.value;
            Element<T>? new_head = head.next;
            if(new_head == null)
            {
                tail = null;
            }
            head = new_head;
            return value;
        }

        public T PopBack()
        {
            if(IsEmpty())
            {
                throw new InvalidOperationException();
            }
            T value = tail!.value;
            Element<T>? new_tail = tail.previous;
            if(new_tail == null)
            {
                head = null;
            }
            tail = new_tail;
            return value;
        }

        public bool IsEmpty()
        {
            if(head == null) return true;
            return false;
        }
    }
}