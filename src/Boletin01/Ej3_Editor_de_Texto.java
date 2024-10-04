package Boletin01;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ej3_Editor_de_Texto {
    private static final String RUTA = "prueba.txt";
    public static void main(String[] args) {
        Documento doc = new Documento(RUTA);
        System.out.println(doc.readFileNIO());
        doc.writeFromInputStream();
        System.out.println(doc.readFileNIO());

    }
}
class Documento{
    private File arquivo;
    public Documento(String arquivo){
        this.arquivo = new File(arquivo);
    }

    public  boolean exists(){
        return arquivo.exists();
    }

    public String readFile() {
        StringBuilder sb = new StringBuilder();
        try (var bis = new BufferedInputStream(new FileInputStream(arquivo))){
            byte[] b = bis.readAllBytes();
            char[] c = new char[b.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = (char) b[i];
            }
            sb.append(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public String readFileNIO(){
        if (!exists()) return null;
        StringBuilder sb = new StringBuilder();
        Path p = arquivo.toPath();
        try {
            return Files.readString(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFromString(String str) {
        String arquivoTxt = readFileNIO();
        try (var bw = new BufferedWriter(new FileWriter(arquivo))){
            bw.write(arquivoTxt);
            bw.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFromStringPrintWriter(String str) {
        String arquivoTxt = readFileNIO();
        try (var pw = new PrintWriter(arquivo)){
            pw.write(arquivoTxt);
            pw.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFromInputStream() {
        String arquivoTxt = readFileNIO();
        try (   var bw = new BufferedWriter(new FileWriter(arquivo));
                var sc = new Scanner(System.in)){
            bw.write(arquivoTxt);
            String line = "a";
            while (!line.equals(".")){
                line = sc.nextLine();
                if(!line.equals("."))
                    bw.write("\n"+line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile(){
        return arquivo;
    }

    @Override
    public String toString() {
        return arquivo.getAbsolutePath();
    }
}