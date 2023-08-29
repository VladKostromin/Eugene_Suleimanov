package main.java.com.vlad_kostromin.javacore.chapter15;

// Продемонстрировать ссылку на статическйи метод

interface StringFunc3 {
    String func(String n);
}

// В этом интерфейсе определяется статический метод strReverse()
class MyStringOps {
    // Статический метод, изменяющий порядок
    // следования символов в строке
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
public class MethodRefDemo {
    /*
    В этом методе функциональный интерфейс указывается в качестве
    типа первого его параметра. Следовательно, ему может быть передан
    любой экземпляр этого интерфейса, включая и ссылку на метод
     */
    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражение повышают эффективность Java";
        String outStr;

        // Здесь ссылка на метод strReverse() передается методу stringOp()
        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
