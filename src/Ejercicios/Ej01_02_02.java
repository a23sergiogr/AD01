package Ejercicios;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej01_02_02 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("prueba.txt", "rw");
            raf.seek(0);

            for (int i = 0; i < 10; i++) {
                raf.write(i);
            }

            System.out.println(readAll(raf));

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAll(RandomAccessFile raf) throws IOException {
        StringBuilder sc = new StringBuilder();
        raf.seek(0);
        byte[] b = new byte[(int)raf.length()];
        System.out.println(raf.read(b));
        for(byte by : b){
            sc.append((char)by);
        }

        return sc.toString();
    }
}
