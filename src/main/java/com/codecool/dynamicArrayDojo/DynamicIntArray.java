package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {
    private int[] array;
    private int size = 0;

    public DynamicIntArray() {
        array = new int[5];
    }

    public DynamicIntArray(int length) {
        array = new int[length];
    }

    public void add(int numberToAdd) {
        resizeIfNecessary();
        array[size++] = numberToAdd;
    }

    private void resizeIfNecessary() {
        if (size == array.length) {
            array = createBiggerArray();
        }
    }

    private int[] createBiggerArray() {
        int[] newArray = new int[size + 5];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
    }

    public void insert(int index, int numberToAdd) {
        resizeIfNecessary();
        if (index > size) {
            add(numberToAdd);
        } else {
            for (int i = size - 1; i >= index; i--) {
                array[i+1] = array[i];
            }
            array[index] = numberToAdd;
            size++;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }
}
