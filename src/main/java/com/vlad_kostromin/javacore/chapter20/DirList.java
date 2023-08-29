package main.java.com.vlad_kostromin.javacore.chapter20;

import java.io.File;

// Использовать каталоги
public class DirList {
    public static void main(String[] args) {
        String dirname = "src/main/java/com/vlad_kostromin/javacore/chapter20";
        File file = new File(dirname);
        if(file.isDirectory()) {
            System.out.println("Каталог " + dirname);
            String[] s = file.list();

            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if(f.isDirectory()) {
                    System.out.println(s[i] + " является каталогом");
                } else {
                    System.out.println(s[i] + " является файлом");
                }
            }
        } else {
            System.out.println(dirname + " не является каталогом");
        }
    }
}
