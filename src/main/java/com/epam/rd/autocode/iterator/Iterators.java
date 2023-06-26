package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(final int[] array) {
        return new TwoTimesIterator(array);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(final int[] array) {
        return new ThreeTimesIterator(array);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(final int[] array) {
        return new FiveTimesIterator(array);
    }

    public static Iterable<String> table(final String[] columns, final int[] rows) {
        return new TableIterable(columns, rows);
    }

    private static class TwoTimesIterator implements Iterator<Integer> {
        private final int[] array;
        private int currentIndex;
        private int iterationCount;

        public TwoTimesIterator(int[] array) {
            this.array = array;
            this.currentIndex = 0;
            this.iterationCount = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.length * 2;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int value = array[currentIndex / 2];
            currentIndex++;
            if (currentIndex % 2 == 0) {
                iterationCount++;
            }

            return value;
        }
    }

    private static class ThreeTimesIterator implements Iterator<Integer> {
        private final int[] array;
        private int currentIndex;
        private int iterationCount;

        public ThreeTimesIterator(int[] array) {
            this.array = array;
            this.currentIndex = 0;
            this.iterationCount = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.length * 3;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int value = array[currentIndex / 3];
            currentIndex++;
            if (currentIndex % 3 == 0) {
                iterationCount++;
            }

            return value;
        }
    }

    private static class FiveTimesIterator implements Iterator<Integer> {
        private final int[] array;
        private int currentIndex;
        private int iterationCount;

        public FiveTimesIterator(int[] array) {
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

    private static class TableIterable implements Iterable<String> {
        private final String[] columns;
        private final int[] rows;

        public TableIterable(String[] columns, int[] rows) {
            this.columns = columns;
            this.rows = rows;
        }

        @Override
        public Iterator<String> iterator() {
            return new TableIterator();
        }

        private class TableIterator implements Iterator<String> {
            private int columnIndex;
            private int rowIndex;

            @Override
            public boolean hasNext() {
                return rowIndex < rows.length && columnIndex < columns.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                String cell = columns[columnIndex] + rows[rowIndex];

                rowIndex++;
                if (rowIndex >= rows.length) {
                    rowIndex = 0;
                    columnIndex++;
                }

                return cell;
            }
        }
    }
}
