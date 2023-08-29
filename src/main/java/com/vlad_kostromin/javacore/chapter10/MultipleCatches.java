package main.java.com.vlad_kostromin.javacore.chapter10;

public class MultipleCatches {
    public static void main(String[] args) {
        //В этой программе произойдет исключение в связи с делением на нуль, если
        //
        //она будет запущена без аргументов командной строки. Ведь в этом случае значе-
        //ние переменной а будет равно нулю. Деление будет выполнено нормально, если
        //
        //программе будет передан аргумент командной строки, устанавливающий в пере-
        //менной а значение больше нуля. Но в этом случае возникнет исключение типа
        //
        //ArrayIndexOutOfBoundsException, поскольку длина массива целых чисел с рав-
        //на 1, тогда как программа пытается присвоить значение элементу массива с [ 42].
        try {
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int c[]  = {1};
            c[42] = 99;
        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индексации за пределами массива: " + e);
        }
        System.out.println("После блока операторов try/catch.");
    }
}
