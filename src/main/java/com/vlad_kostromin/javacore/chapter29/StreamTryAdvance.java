package main.java.com.vlad_kostromin.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamTryAdvance {
    public static void main(String[] args) {
        // создать список символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        // получить итератор для потока данных
        Stream<String> myStream = myList.stream();
        Spliterator<String> splitItr = myStream.spliterator();

        // перебрать элементы в потоке данных
        while(splitItr.tryAdvance((n) -> System.out.println(n)));
    }
}
