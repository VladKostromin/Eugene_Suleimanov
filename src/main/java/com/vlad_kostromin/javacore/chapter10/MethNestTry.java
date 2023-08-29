package main.java.com.vlad_kostromin.javacore.chapter10;

public class MethNestTry {
    static void nesttry (int a) {
        /* Вложение операторов try может быть не столь очевидным при вызовах мето-
дов. Например, вызов метода можно заключить в блок оператора t ry, а в теле это-
го метода организовать еще один блок оператора try. В этом случае блок опера-
тора try в теле метода оказывается вложенным во внешний блок оператора try,

откуда вызывается этот метод. Ниже приведена версия предыдущей программы,
где блок вложенного оператора try перемещен в тело метода ne sttry ( ) .
         */
        try { //вложенный блок оператора try
           /*
           Если указан один аргумент командной строки,
           то исключение в связи с делением на нуль
           будет сгененрированно в следующем коде.
            */
            if(a == 1) a = a/ (a - a); //деление на нуль
            /*
            Если указаны два аргумента командной строки,
            то гененриуется исключение в связи с выходом
            за пределы
             */
            if(a == 2) {
                int c[] = { 1 };
                c[42] = 99; // здесь гененрируется исключение в связи
                            // с символом за пределы массива
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс за пределами массива: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            int a = args.length;
            /* Если не указаны аргументы командной строки ,
                в следующем операторе будет сгенерировано
                исключение в связи с делением на нуль .
            */
            int Ь = 42 / a;
            System.out . println ("a = " + a);
            nesttry (a);
        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль: " + e);
        }
    }
}
