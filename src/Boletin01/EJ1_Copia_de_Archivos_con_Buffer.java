package Boletin01;

import java.io.*;

/**
 * <h6>Se realice un programa para copiar archivos. El programa debe recoger el
 * nombre del archivo origen y destino. Se existe debe solicitar confirmación sobrescribir.
 * Úsese I/O con buffer y métodos estáticos (tenga en cuenta que los archivos pueden ser
 * binarios).
 * <p>a) Para la lectura desde teclado puede emplearse la clase Scanner.
 * <p>b) Realiza el mismo ejercicio, pero empleando entradas desde ventana con JFileChooser y mensajes de error en JOptionPane, si los hay.
 * <p>c) Realiza un programa que lea con un JOptionPane pida una URL y para
 * posteriormente abrir un JFileChooser para guardarlo en el disco local.
 * Ayuda: para abrir un flujo de entrada a una URL puede hacerse con el
 * método openStream() de URL. Ten en cuenta que puede lanzar excepciones.
 * <b>InputStream in = new URL(FILE_URL).openStream();
 * <p>d) Mejora el aparado a) para que la lectura de los datos lo haga en bloques
 * (buffer) y no byte a byte.
 */
public class EJ1_Copia_de_Archivos_con_Buffer {
    public static void main(String[] args) {

        try(var bis = new BufferedInputStream(new FileInputStream(""));
            var bos = new BufferedOutputStream(new FileOutputStream(""))){

            System.out.println("a");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
