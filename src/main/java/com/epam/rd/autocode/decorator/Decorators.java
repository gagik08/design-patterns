package com.epam.rd.autocode.decorator;

import java.util.List;

public class Decorators {
    public static <T> List<T> evenIndexElementsSubList(List<T> sourceList) {
        return new EvenIndexElementsSubListDecorator<>(sourceList);
    }
}
