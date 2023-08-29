package main.java.com.vlad_kostromin.javacore.chapter20;

import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

// Посмотреть каталог HTML-файлов
public class DirListOnly {
    public static void main(String[] args) {
        String dirname = "src/main/java/com/vlad_kostromin/javacore/chapter20/files";
        File file = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        FilenameFilter only1 = (f, s) -> f.isDirectory() && s.endsWith(".html");
        String[] s = file.list(only1);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
