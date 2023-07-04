package com.epam.rd.autocode.iterator.concreteIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class TableIterable implements Iterable<String> {
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