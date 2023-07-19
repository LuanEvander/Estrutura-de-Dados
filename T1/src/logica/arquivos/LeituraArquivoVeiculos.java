package logica.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import logica.entidades.Veiculo;

public class LeituraArquivoVeiculos {
    String nomeArquivo = "Veiculos.csv";

    public void lerArquivoVeiculos() {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            // Ler e ignorar a primeira linha (cabeçalho)
            br.readLine();

            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                if (partes.length == 7) {
                    String placa = partes[0];
                    String modelo = partes[1];
                    String marca = partes[2];
                    int ano = Integer.parseInt(partes[3]);
                    int potencia = Integer.parseInt(partes[4]);
                    int lugares = Integer.parseInt(partes[5]);
                    int idCategoria = Integer.parseInt(partes[6]);

                    Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, idCategoria);
                    // Faça o que deseja com o objeto Veiculo criado
                    System.out.println(veiculo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}