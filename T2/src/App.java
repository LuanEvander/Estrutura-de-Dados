public class App {
    public static void main(String[] args) {
        // Palavra a ser verificada como palíndromo
        String palavra1 = "arara";
        String palavra2 = "palindromo";

        // Instancie um objeto da classe Pilha
        Pilha pilha1 = new Pilha(palavra1.length());
        Pilha pilha2 = new Pilha(palavra2.length());

        // Verifique se a palavra é um palíndromo usando o método palindromo 
        boolean ehPalindromo1 = pilha1.palindromo(palavra1);

        boolean ehPalindromo2 = pilha2.palindromo(palavra2);

        // Imprima o resultado
        if (ehPalindromo1) {
            System.out.println("'" + palavra1 + "' é um palíndromo.");
        } else {
            System.out.println("'" + palavra1 + "' não é um palíndromo.");
        }

        if (ehPalindromo2) {
            System.out.println("'" + palavra2 + "' é um palíndromo.");
        } else {
            System.out.println("'" + palavra2 + "' não é um palíndromo.");
        }

        // Imprima o estado da pilha1 após a verificação
        pilha1.imprimirPilha();

        // Crie uma instância da lista encadeada
        LSE listaAlunos = new LSE();

        // Insira os alunos na lista encadeada
        listaAlunos.insereFim(new Aluno("João"));
        listaAlunos.insereFim(new Aluno("Maria"));
        listaAlunos.insereFim(new Aluno("Pedro"));
        listaAlunos.insereFim(new Aluno("Ana"));

        // Crie uma instância da classe Pilha
        PilhaAluno pilha = new PilhaAluno(listaAlunos.tamanho());

        // Percorra a lista encadeada e empilhe os alunos na pilha
        Noh<Object> nohAtual = listaAlunos.getInicio();
        while (nohAtual != null) {
            pilha.push((Aluno) nohAtual.getObject());
            nohAtual = nohAtual.getProximo();
        }

        // Imprima o estado da pilha
        pilha.imprimirPilha();
    }

}