package edu.kis.vh.nursery.list;

/**
 * Prosta implementacja stosu liczb całkowitych oparta na liście wiązanej
 */
public class IntLinkedList {

    public static final int DEFAULT_VALUE = -1;
    private Node last;
    int i;

    /**
     * Dodaje wartość na szczyt stosu.
     *
     * @param i wartośćdo dodania
     */
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    /**
     * Sprawdza, czy stos jest pusty.
     *
     * @return true, jeśli stos jest pusty, w przeciwnym razie false
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * Sprawdza, czy stos jest pełny
     *
     * @return false, ponieważ ta implementacja nie ma stałego ograniczenia pojemności
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Zwraca wartość ze szczytu stosu bez usuwamia jej.
     *
     * @return wartość ze szczytu lub DEFAULT_VALUE,jeśli stos jest pusty
     */
    public int top() {
        if (isEmpty())
            return DEFAULT_VALUE;
        return last.value;
    }

    /**
     * Usuwa i zwraca wartość ze szczytu stosu.
     *
     * @return usunięta wartość lub DEFAULT_VALUE,jeśli stos jest pusty
     */
    public int pop() {
        if (isEmpty())
            return DEFAULT_VALUE;
        int ret = last.value;
        last = last.prev;
        return ret;
    }

    /**
     * Wewnętrzny element listy używany przez klasę IntLinkedList.
     */
    static class Node {

        public final int value;
        public Node prev, next;

        /**
         * Tworzy nowy węzeł z podaną wartośćią.
         *
         * @param i wartość przechowywana w wężle
         */
        public Node(int i) {
            value = i;
        }

    }

}
