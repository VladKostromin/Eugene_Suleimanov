package main.java.com.vlad_kostromin.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

// Применить метод map() для создагия нового потока данных,
// содержащего только избранные элементы из исходного потока
class NamePhoneEmail {
    String name;
    String phoneNumb;
    String email;

    public NamePhoneEmail(String name, String phoneNumb, String email) {
        this.name = name;
        this.phoneNumb = phoneNumb;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phone;

    public NamePhone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
public class MapChooseFieldStreamDemo {

    public static void main(String[] args) {

        // Список имен, номеров телефонов и адресов электронной почты
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((s) -> {
            System.out.println(s.name + " " + s.phoneNumb + " " + s.email);
        });
        System.out.println();

        // отобразить на новый поток данных
        // только имена и номера телефонов
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phoneNumb));
        nameAndPhone.forEach((a) -> {
            System.out.println(a.name + " " + a.phone);
        });

        nameAndPhone = myList.stream().filter((a) -> a.name.equals("James")).map((a) -> new NamePhone(a.name, a.phoneNumb));
        System.out.println();
        System.out.println("Отфильтрованный список по имени: ");
        nameAndPhone.forEach((a) -> System.out.println(a.name + " " + a.phone));
    }
}
