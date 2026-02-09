package com.classic.analysis.core.ds;

public class IArrayList <E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;

    public IArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        ensureCapacity();
        data[size++] = element;
    }

    public void add(int index, E element) {
        checkIndexForAdd(index);
        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        checkIndex(index);
        E old = (E) data[index];
        data[index] = element;
        return old;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E removed = (E) data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null; // avoid memory leak
        return removed;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length + (data.length >> 1); // 1.5x
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }
}