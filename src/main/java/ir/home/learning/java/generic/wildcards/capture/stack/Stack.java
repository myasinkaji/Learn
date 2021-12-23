package ir.home.learning.java.generic.wildcards.capture.stack;

import java.util.Collection;

public class Stack<E> {
    private int index;
    private Object[] array;

    public void push(E e) {
        this.array[index++] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        return (E) array[--index];
    }

    public void pushAll(Iterable<? extends E> src) {
        src.forEach(this::push);
    }

    public void popAll(Collection<? super E> dest) {
        while (isNotEmpty())
            dest.add(pop());
    }

    private boolean isNotEmpty() {
        return !isEmpty();
    }

    private boolean isEmpty() {
        return index == 0;
    }

}
