package com.epam.rd.autocode.iterator.concreteIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayFiveTimesIterator implements Iterator<Integer> {
    private final int[] array;
    private int currentIndex;
    private int iterationCount;

    public IntArrayFiveTimesIterator(int[] array) {
        this.array = array;
        this.currentIndex = 0;
        this.iterationCount = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length * 5;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int value = array[currentIndex / 5];
        currentIndex++;
        if (currentIndex % 5 == 0) {
            iterationCount++;
        }

        return value;
    }
}
