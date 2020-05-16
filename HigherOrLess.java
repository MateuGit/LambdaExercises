package com.company;

@FunctionalInterface
public interface HigherOrLess <T, U>{
    Boolean apply(T var1, U var2);
}
