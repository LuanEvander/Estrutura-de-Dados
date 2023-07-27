public class App {
    public static void main(String[] args) {
        // Crie uma instância da lista encadeada
        LSE listaAlunos = new LSE();

        // Insira os alunos na lista encadeada
        listaAlunos.insereFim(new Aluno("João", "2301"));
        listaAlunos.insereFim(new Aluno("Maria", "2304"));
        listaAlunos.insereFim(new Aluno("Pedro", "2311"));
        listaAlunos.insereFim(new Aluno("Ana", "2317"));

        // Crie uma instância da classe TabelaHash
        TabelaHash tabelaHash = new TabelaHash();

        // Percorra a lista encadeada e insira os alunos na tabela hash
        Noh<Object> nohAtual = listaAlunos.getInicio();
        while (nohAtual != null) {
            Aluno aluno = (Aluno) nohAtual.getObject();
            tabelaHash.put(aluno.getMatricula(), aluno);
            nohAtual = nohAtual.getProximo();
        }

        // Imprima o estado da tabela
        tabelaHash.imprimirTabela();
    }
}