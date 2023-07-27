public class TabelaHash {
    private static final int TAMANHO_INICIAL = 10;
    private static final double FATOR_CARGA_MAXIMO = 0.75;

    private Entrada[] tabela;
    private int tamanho;
    private int capacidade;

    public TabelaHash() {
        this.tabela = new Entrada[TAMANHO_INICIAL];
        this.tamanho = 0;
        this.capacidade = TAMANHO_INICIAL;
    }

    public void put(String chave, Object valor) {
        if ((double) tamanho / capacidade >= FATOR_CARGA_MAXIMO) {
            redimensionar();
        }

        int indice = hash(chave);

        while (tabela[indice] != null && !tabela[indice].chave.equals(chave)) {
            indice = (indice + 1) % capacidade; // Estratégia de busca linear
            // Ou use busca quadrática: indice = (indice + i * i) % capacidade;
        }

        if (tabela[indice] == null) {
            tamanho++;
        }

        tabela[indice] = new Entrada(chave, valor);
    }

    public Object get(String chave) {
        int indice = hash(chave);

        while (tabela[indice] != null && !tabela[indice].chave.equals(chave)) {
            indice = (indice + 1) % capacidade; // Estratégia de busca linear
            // Ou use busca quadrática: indice = (indice + i * i) % capacidade;
        }

        if (tabela[indice] != null) {
            return tabela[indice].valor;
        } else {
            return null;
        }
    }

    public void remove(String chave) {
        int indice = hash(chave);

        while (tabela[indice] != null && !tabela[indice].chave.equals(chave)) {
            indice = (indice + 1) % capacidade; // Estratégia de busca linear
            // Ou use busca quadrática: indice = (indice + i * i) % capacidade;
        }

        if (tabela[indice] != null) {
            tabela[indice] = null;
            tamanho--;
        }
    }

    private int hash(String chave) {
        return Math.abs(chave.hashCode() % capacidade);
    }

    private void redimensionar() {
        int novaCapacidade = capacidade * 2;
        Entrada[] novaTabela = new Entrada[novaCapacidade];

        for (Entrada entrada : tabela) {
            if (entrada != null) {
                int indice = hash(entrada.chave);

                while (novaTabela[indice] != null) {
                    indice = (indice + 1) % novaCapacidade;
                }

                novaTabela[indice] = entrada;
            }
        }

        tabela = novaTabela;
        capacidade = novaCapacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void imprimirTabela() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < capacidade; i++) {
            if (tabela[i] != null) {
                System.out.println("Índice " + i + ": " + tabela[i].chave + " -> " + tabela[i].valor);
            } else {
                System.out.println("Índice " + i + ": vazio");
            }
        }
    }

    private static class Entrada {
        private String chave;
        private Object valor;
    
        public Entrada(String chave, Object valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
}