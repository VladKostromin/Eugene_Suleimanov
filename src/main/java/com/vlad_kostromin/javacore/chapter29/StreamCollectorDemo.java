package main.java.com.vlad_kostromin.javacore.chapter29;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Применить метод map() для создагия нового потока данных,
// содержащего только избранные элементы из исходного потока
public class StreamCollectorDemo {

    public static void main(String[] args) {

        // Список имен, номеров телефонов и адресов электронной почты
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

       // отобразить только имена и номера телефонов на новый поток данных
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNumb));

        // вызвать метод collect(), чтобы составить список типа List
        // из мен и номеров телефонов
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Имена и номера телефонов в списке типа List:");
        for (NamePhone e : npList) {
            System.out.println(e.name + ": " + e.phone);
        }

        // получить другое отображение имен и номеров телефонов
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNumb));

        // а теперь создать множество типа Set, вызвав метод collect()
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nИмена и номера телефонов в множестве типа Set:");
        for (NamePhone e : npSet) {
            System.out.println(e.name + ": " + e.phone);
        }

        LinkedList<NamePhone> npList1 = nameAndPhone.collect(() -> new LinkedList<>(), (list, element) -> list.add(element),
                (listA, listB) -> listA.addAll(listB));

        HashSet<NamePhone> npList2 = nameAndPhone.collect(HashSet::new, HashSet::add, HashSet::addAll);
    }
}
