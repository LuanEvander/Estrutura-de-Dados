public class App {
    public static void main(String[] args) throws Exception {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        Aluno a4 = new Aluno();
        Aluno a5 = new Aluno();

        VetorAluno turma = new VetorAluno();

        turma.adiciona(a1);
        turma.adiciona(a2);

        a1.setNome("João");
        a2.setNome("Maria");

        System.out.println(turma.contem(a1));

        System.out.println(turma.contem(a2));

        System.out.println(turma.tamanho());

        System.out.println(turma.cheio());

        turma.adiciona(a3);
        turma.adiciona(a4);
        turma.adiciona(a5);

        System.out.println(turma.tamanho());

        System.out.println(turma.remover(a5));

        System.out.println(turma.tamanho());
    }
}
