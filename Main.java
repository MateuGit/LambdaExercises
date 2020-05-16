package com.company;

import javafx.util.converter.DateStringConverter;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        /*Crear un Function que devuelva el módulo a elección de un numero entero.*/
        Function<Integer, Integer> module = (value) -> value % 2;
        System.out.println(module.apply(10));

        /*tilizar una interfaz Supplier en un método de una clase que tenga como atributo una fecha (el Supplier devuelve un timestamp actual).
        Puede hacerse pasando el objeto Supplier o pasando un lamda a un método*/
        Supplier<Timestamp> supply = () -> new Timestamp(System.currentTimeMillis());
        System.out.println(supply.get());

        /*Utilizar una interfaz Bifunction la cual reciba 2 strings y retorne un entero con los largos de ambos strings sumados.*/
        BiFunction<String, String, Integer> lenghts = (string1, string2) -> (string1.length() + string2.length());
        System.out.println(lenghts.apply("hello", "goodbye"));

       /*Recorrer un HashMap<Integer,String> utilizando un Biconsumer e imprimir sus keys y values ,
        de a 1 entrada por vez solo si el largo del value de esa entrada (string) es mayor a 10. Sino imprimir alguna otra cosa. */
        Map<Integer, String> values = new HashMap<>();
        values.put(1, "1");
        values.put(2, "2323");
        values.put(3, "3223");
        values.forEach((key, value) -> {
            printHigherThanOne(value, key);
        });

        /*Crear interfaces funcionales propias(que reciban valores o no, que devuelvan algo o no), luego instanciarlas en una variable y ejecutar sus métodos).*/
        HigherOrLess<Integer, Integer> comparable = (value1, value2) -> value1 < value2;
        System.out.println(comparable.apply(6, 3));
    }

    public static void printHigherThanOne(String value, Integer key) {
        if (value.length() < 2) {
            System.out.println("Less than 1");
        } else {
            System.out.println(String.format("key: %d - value: %S", key, value));
        }
    }


}
