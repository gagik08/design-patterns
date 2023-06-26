package com.epam.rd.autocode.decorator;

import java.util.AbstractList;
import java.util.List;

public class Decorators {
    public static <T> List<T> evenIndexElementsSubList(List<T> sourceList) {
        return new EvenIndexElementsSubListDecorator<>(sourceList);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private static class EvenIndexElementsSubListDecorator<T> extends AbstractList<T> {
        private final List<T> sourceList;

        public EvenIndexElementsSubListDecorator(List<T> sourceList) {
            this.sourceList = sourceList;
        }

        @Override
        public T get(int index) {
            return sourceList.get(index * 2);
        }

        @Override
        public int size() {
            return (sourceList.size() + 1) / 2;
        }
    }
}
