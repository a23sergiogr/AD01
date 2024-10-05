import java.io.*;

public class aaPruebas {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("prueba.txt"));
        bw.write("AAAAAAAAAAAA");
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;
        while(!(linha = br.readLine()).equalsIgnoreCase("_EXIT_")){
            System.out.println("linha: " + linha);
        }
    }
}


