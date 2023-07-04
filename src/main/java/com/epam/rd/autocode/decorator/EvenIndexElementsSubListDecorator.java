package com.epam.rd.autocode.decorator;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class EvenIndexElementsSubListDecorator<T> extends AbstractList<T> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EvenIndexElementsSubListDecorator<?> that = (EvenIndexElementsSubListDecorator<?>) o;

        return Objects.equals(sourceList, that.sourceList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sourceList != null ? sourceList.hashCode() : 0);
        return result;
    }
}

