package chapter21exploringjavaio.file.filenamefilter;

import java.io.File;
import java.io.FilenameFilter;

class DirListOnly {
    public static void main(String[] args) {
        String dirname = "\\Program Files\\Java\\jre1.8.0_45";
        File f1 = new File(dirname);

        FilenameFilter only = new OnlyExt("html");
        String s[] = f1.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
