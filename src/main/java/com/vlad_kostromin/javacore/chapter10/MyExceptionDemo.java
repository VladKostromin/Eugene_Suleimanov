package main.java.com.vlad_kostromin.javacore.chapter10;


class MyExceptionDemo {
    /*
    В приведенном ниже примере программы сначала объямяется новый подкласс,
производный от класса Exception, а затем он используется для вывода сообщения
об ошибке в методе. В этом подклассе метод toString() переопределяется таким
образом, чтобы вывести тщательно подготовленное описание исключения.
     */
    static void compute(int a) throws MyException {
        System.out.println("Вызван в метод compute(" + a + ")");
        if(a > 10) throw new MyException(a);
        System.out.println("Нормальное завершение");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}



 class MyException extends Exception {
    private int detail;

    public MyException(int a) {
        this.detail = a;
    }

    @Override
    public String toString() {
        return "MyException[" + detail + "]";
    }
}
