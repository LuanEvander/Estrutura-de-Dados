public class App {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Luiz", 20);
        Aluno a2 = new Aluno("Maria", 19);
        Aluno a3 = new Aluno("João", 18);

        VetorAluno turma = new VetorAluno();

        turma.adiciona(a1);
        turma.adiciona(a2);
        turma.adiciona(a3);

        System.out.println(turma.contem(a1));

        System.out.println(turma.contem(a2));

        turma.tamanho();
    }
}