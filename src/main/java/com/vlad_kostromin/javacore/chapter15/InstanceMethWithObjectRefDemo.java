package main.java.com.vlad_kostromin.javacore.chapter15;

// Использовать ссылку на метод экземпляра вместе с разными объектами

// Функциональный интерфейс с методом, принимающим два ссылочных
// аргумента и возвращающим логическое значение
interface MyFunc1<T> {
    boolean func(T v1, T v2);
}

// класс для хранения максимальной температуры за день
class HighTemp {
    private int hTemp;

    HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }
    // возвращает логическое значение ture, если вызывающий объект
    // типа HighTemp имеет такую же температуру, как и у объекта hTemp2
    boolean sameTemp (HighTemp hTemp2) {
        return hTemp == hTemp2.hTemp;
    }
    // возвращает логическое значение ture, если вызывающий объект
    // типа HighTemp имеет температуру ниже, чем у объекта hTemp2
    boolean lessThanTemp(HighTemp hTemp2) {
        return hTemp < hTemp2.hTemp;
    }
}

public class InstanceMethWithObjectRefDemo {
    // Метод, возвращающий количество экземпляров объекта,
    // найденных по критериям, задаваемым параметром
    // функционального интерфейса MyFunc
    static <T> int counter(T[] vals, MyFunc1<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if(f.func(vals[i], v)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count;
        // создать массив объектов типа HighTemp
        HighTemp[] weekDayHighs = { new HighTemp(89), new HighTemp(82), new HighTemp(90),
        new HighTemp(89), new HighTemp(89), new HighTemp(91), new HighTemp(84), new HighTemp(83) };

        // Использовать метод counter() вместе с массивами объектов
        // типа HighTemp. Обратите внимание на то, что ссылка на метод
        // экземпляра sameTemp() передается в качестве второго параметра
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была 89: " + count);

        // А теперь создаать и использовать вместе с дынным
        // методом еще один массив объектов типа HighTemp
        HighTemp[] weekDayHighs2 = { new HighTemp(32), new HighTemp(12), new HighTemp(24),
        new HighTemp(19), new HighTemp(18), new HighTemp(12), new HighTemp(-1), new HighTemp(13)};

        count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println("Дней, когда максимальная температура была 12: " + count);

        // А теперь воспользоваться методом lessThanTemp(), чтобы
        // выяснить, сколько дней температура была меньше заданной
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была меньше 89: " + count);

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println("Дней, когда максимальная температура была меньше 19: " + count);
    }
}
