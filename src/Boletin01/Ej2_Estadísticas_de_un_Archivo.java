package Boletin01;

import java.io.*;
import java.util.Date;

/**
 * Realice un programa que recoja el nombre de un fichero y muestre una estadística de la ruta, número de líneas, número de espacios, número de letras, fecha última modificación, longitud del fichero, … Defina una clase EstatisticaFile con atributos: letras, linhas, espacios, archivo (tipo File).
 *
 * private File arquivo;
 * private int linhas;
 * private int letras;
 * private int espazos;
 * Métodos para obtener cada uno de los atributos, existe(), ultimaModificacion(), getRuta(). El constructor recoge el nombre del archivo.
 */
public class Ej2_Estadísticas_de_un_Archivo {
    private static final String RUTA = "a.txt";
    public static void main(String[] args) {
        EstatisticaFile ea = new EstatisticaFile(RUTA);
        System.out.println(ea.toString());
    }
}

class EstatisticaFile{
    private File arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstatisticaFile(String arquivo) {
        this.arquivo = new File(arquivo);
        leerArquivo();
    }

    public boolean existe(){
        return arquivo.exists();
    }

    public Date ultimaModificación(){
        return new Date(arquivo.lastModified());
    }

    public String getRuta(){
        return arquivo.getAbsolutePath();
    }

    private void leerArquivo(){
        try (var br = new BufferedReader(new FileReader(arquivo))){
            String line = "1";
            linhas = 0;
            letras = 0;
            espazos = 0;
            while (line != null){
                line= br.readLine();
                if (line != null){
                    linhas++;
                    espazos = espazos + line.split(" ").length-1;
                    letras = letras + line.length();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public int getLetras() {
        return letras;
    }

    public int getEspazos() {
        return espazos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EstatisticaFile{")
                .append("\n\tRuta: ").append(getRuta())
                .append("\n\tExiste: ").append(existe())
                .append("\n\tUltima Modificación: ").append(ultimaModificación())
                .append("\n\tLinhas: ").append(getLinhas())
                .append("\n\tLetras: ").append(getLetras())
                .append("\n\tEspazos: ").append(getEspazos())
                .append("\n}");
        return sb.toString();
    }
}

class EstatisticaRandomAccesFile {
    private RandomAccessFile arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstatisticaRandomAccesFile(String arquivo) throws FileNotFoundException {
        this.arquivo = new RandomAccessFile(arquivo,"r");
        leerArquivo();
    }

    public boolean existe(){
        return true;
    }

    public Date ultimaModificación(){
        return new Date();
    }

    public String getRuta(){
        return "";
    }

    private void leerArquivo(){

    }

    public int getLinhas() {
        return linhas;
    }

    public int getLetras() {
        return letras;
    }

    public int getEspazos() {
        return espazos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EstatisticaFile{")
                .append("\n\tRuta: ").append(getRuta())
                .append("\n\tExiste: ").append(existe())
                .append("\n\tUltima Modificación: ").append(ultimaModificación())
                .append("\n\tLinhas: ").append(getLinhas())
                .append("\n\tLetras: ").append(getLetras())
                .append("\n\tEspazos: ").append(getEspazos())
                .append("\n}");
        return sb.toString();
    }
}