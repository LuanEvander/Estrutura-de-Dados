public class App {
    public static void main(String[] args) throws Exception {
        LSE turma = new LSE();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        turma.insereFim(a1);
        turma.insereFim(a2);

        System.out.println(turma.tamanho());

        turma.insereFim(a3);

        System.out.println(turma.tamanho());

        turma.remove(a2);

        System.out.println(turma.tamanho());
    }
}
