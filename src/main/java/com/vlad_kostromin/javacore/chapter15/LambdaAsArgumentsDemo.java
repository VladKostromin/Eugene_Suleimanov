package main.java.com.vlad_kostromin.javacore.chapter15;

// Передать лямбда-выражение в качесте аргумента методу
interface StringFunc1 {
    String func(String string);
}

public class LambdaAsArgumentsDemo {
    /*
       Первый параметр жэтого метода имеет тип функционального
       интерфейса. Следовательно, ему можно передать ссылку на
       любой экземпляр этого интерфейса, включа экземпляр,
       создаваемый в лямбда-выражении. А второй параметр
       обозначает обрабатываемую символьную строку
        */
    static String stringOP(StringFunc sf, String s) {
        return sf.func(s);
    }
    public static void main(String[] args) {
        String inStr = "Лямбда-выражение повышают эффективность Java";
        String outStr = "";

        System.out.println("Это исходная строка: " + inStr);

        // Ниже приведено простое лямбда-выражение, преобразующее
        // в верхний регистр букв все символы исходной строки,
        // передаваемой методу stringOP()

        outStr = stringOP((str) -> str.toUpperCase(), inStr);
        System.out.println("Это строка в врехнем регистре: " + outStr);

        // А здесь передается блочное лямбда-выражение, удалябщее
        // пробелы из исходной символьной строки
        outStr = stringOP((str) -> {
            String result = "";

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != ' ')
                    result += str.charAt(i);
            }
            return result;
        }, inStr);
        System.out.println("Это строка с удаленными пробелами: " + outStr);

        // Конечно, можно передать и экземпляр интерфейса StringFunc,
        // созданный в предыдущем лямбда-выражении. Например, после
        // следующего объявления ссылка reverse делается на экземпляр
        // интерфейса StringFunc
        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0 ; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        // А теперь ссылку reverse можно передать в качестве первого
        // параметра методу stringOp()
        // так как она является обьектом типа StringFunc

        System.out.println("Это обращенная строка: " + stringOP(reverse, inStr));
    }
}
