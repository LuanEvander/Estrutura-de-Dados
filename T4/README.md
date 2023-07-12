## Objetivo 

Desenvolver uma aplicação para manipular veículos armazenados em um Mapa, em que o número do chassi é usado como chave. O TAD mapa é representado pela interface Map disponível em [MAP](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html).

Essa interface deve ser implementada utilizando Vetor (ordenado). Esta estrutura de dado deve ser implementada isto é, não é permitido o uso de classes de estruturas já existentes na linguagem Java.

Para a estrutura de dados deve ser medido o tempo total gasto para cada uma das 
seguintes operações (usar o método System.nanoTime() para ser mais preciso):

* Inserir 100.000 (cem mil) veículos;
* Apresentar todos os veículos em ordem crescente de número de chassi;
* Verificar quantos veículos são da marca Ford;
* Remover todos os veículos com número de chassi igual ou inferior à 202050000.

Os veículos devem ser gerados por meio da classe Veiculo.java que está disponível no Moodle e não pode ser modificada. Essa classe funciona como uma fábrica que gera veículos aleatórios de diferentes marcas.

### Apresentação 

O time deve elaborar uma apresentação para defender o trabalho contendo, 
obrigatoriamente, os seguintes itens:

* Mapas: motivação de empregar mapas e dicionário de dados como uma TAD.
* Lógica e decisões adotadas pelo grupo para o desenvolvimento do trabalho.
* Explicação breve dos algoritmos desenvolvidos.
* Análise dos resultados contendo, pelo menos, quatro gráficos:
    * Tempos de inserção nas diferentes estruturas de dados;
    * Tempos de impressão de todos os veículos em ordem crescente de número de chassi;
    * Tempo para mostrar o número de veículos da marca Ford;
    * Tempos para remover todos os veículos com chassi igual ou inferior à 202050000