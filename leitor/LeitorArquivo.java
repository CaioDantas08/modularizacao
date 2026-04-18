package leitor;
import java.io.*;

public class LeitorArquivo {

    public String ler(String caminho) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        StringBuilder sb = new StringBuilder();

        while ((linha = br.readLine()) != null) {
            sb.append(linha).append("\n");
        }
 
        br.close();
        return sb.toString();
    }

}