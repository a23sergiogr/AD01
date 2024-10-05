package Boletin01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej4_Lectura_de_Teclado {
    public static void main(String[] args) {
        Teclado t = new Teclado();
        String s = t.lerString();
        System.out.println(s);
        char c = t.lerChar();
        System.out.println(c);
        int i = t.lerInt();
        System.out.println(i);
        long l = t.lerLong();
        System.out.println(l);
        boolean b = t.lerBoolean();
        System.out.println(b);
        float f = t.lerFloat();
        System.out.println(f);
        double d = t.lerDouble();
        System.out.println(d);
        byte by = t.lerByte();
        System.out.println(by);
        short sh = t.lerShort();
        System.out.println(sh);

    }
}

class Teclado{
    private static BufferedReader br;

    public Teclado(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String lerString(){
        try {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("No se pudo leer la String");
        }
        return null;
    }

    public Character lerChar(){
        try {
            return br.readLine().charAt(0);
        } catch (IOException e) {
            System.err.println("No se pudo leer el Char");
        }
        return null;
    }

    public Integer lerInt(){
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Int");
        }
        return null;
    }

    public Long lerLong(){
        try {
            return Long.parseLong(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Long");
        }
        return null;
    }

    public Boolean lerBoolean(){
        try {
            return Boolean.parseBoolean(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Boolean");
        }
        return null;
    }

    public Float lerFloat(){
        try {
            return Float.parseFloat(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Float");
        }
        return null;
    }

    public Double lerDouble(){
        try {
            return Double.parseDouble(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Double");
        }
        return null;
    }

    public Byte lerByte(){
        try {
            return Byte.parseByte(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Byte");
        }
        return null;
    }

    public Short lerShort(){
        try {
            return Short.parseShort(br.readLine());
        } catch (IOException e) {
            System.err.println("No se pudo leer el Short");
        }
        return null;
    }
}
