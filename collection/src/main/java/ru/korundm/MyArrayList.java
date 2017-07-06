package ru.korundm;

import java.util.*;

/**
 * Created by anton
 */
public class MyArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final Object[] EMPTY_ARRAY = {};
    private int size;
    private Object[] array;

    public MyArrayList(int startCapacity) {
        if (startCapacity > 0) {
            this.array = new Object[startCapacity];
        } else if (startCapacity == 0) {
            this.array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + startCapacity);
        }
        this.size = 0;
    }

    public MyArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public MyArrayList(Collection<? extends T> collection) {
        this.array = collection.toArray();
        this.size = array.length;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyItr<>(0);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size());
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(size() - size < 1) {
            array = Arrays.copyOf(array, size + 1);
        }
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] addArray = c.toArray();
        int addLength = addArray.length;
        int freePositions = array.length - size;

        if(addLength > freePositions) {
            size = array.length + (addLength - freePositions);
            array = Arrays.copyOf(array, size);
        } else {
            size += addLength;
        }

        System.arraycopy(addArray, 0, array, size, addLength);
        return addLength != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        T t = (T) array[index];
        array[index] = element;
        return t;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyItr<>(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyItr<>(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private class MyItr<U> implements ListIterator<U> {

        private int cursor,last;

        MyItr(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public U next() {
            last = cursor;
            U u = null;
            if(cursor <= (size() - 1)){
                u = (U) array[cursor++];
            }
            return u;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public U previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(U u) {
            MyArrayList.this.set(last, (T) u);
        }

        @Override
        public void add(U u) {

        }
    }
}
