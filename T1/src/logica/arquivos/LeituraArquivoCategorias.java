package logica.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import logica.entidades.Categoria;

public class LeituraArquivoCategorias {
    String nomeArquivo = "Categorias.csv";

    public void lerArquivoCategorias() {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            // Ler e ignorar a primeira linha (cabeçalho)
            br.readLine();

            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                if (partes.length == 2) {
                    int idCategoria = Integer.parseInt(partes[0]);
                    String nomeCategoria = partes[1];

                    Categoria categoria = new Categoria(idCategoria, nomeCategoria);
                    // Faça o que deseja com o objeto Categoria criado
                    System.out.println(categoria);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
