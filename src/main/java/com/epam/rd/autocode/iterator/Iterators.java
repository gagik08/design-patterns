package com.epam.rd.autocode.iterator;


import com.epam.rd.autocode.iterator.concreteIterators.*;
import com.epam.rd.autocode.iterator.concreteIterators.TableIterable;

import java.util.Iterator;

public class Iterators {
    private Iterators() {
        // Private constructor to hide the implicit public one
    }

    public static Iterator<Integer> intArrayTwoTimesIterator(final int[] array) {
        return new IntArrayTwoTimesIterator(array);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(final int[] array) {
        return new IntArrayThreeTimesIterator(array);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(final int[] array) {
        return new IntArrayFiveTimesIterator(array);
    }

    public static Iterable<String> table(final String[] columns, final int[] rows) {
        return new TableIterable(columns, rows);
    }
}