import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej4 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("prueba.txt", "rw");
            raf.seek(0);
            raf.writeUTF("Hola, mundo!");
            System.out.println(raf.length());
            byte[] b = new byte[(int)raf.length()-2];
            raf.seek(2);
            System.out.println(raf.read(b));
            for(byte by : b){
                System.out.print((char)by);
            }
            //raf.seek(0);
            //System.out.println(raf.readUTF());
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
