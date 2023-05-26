public class App {
    public static void main(String[] args) throws Exception {
        LDE<Object> turma = new LDE<Object>();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        Aluno a4 = new Aluno();
        Aluno a5 = new Aluno();

        turma.insereFim(a1);
        turma.insereFim(a2);
        turma.insereFim(a3);
        turma.insereFim(a4);
        turma.insereFim(a5);
        
        System.out.println(turma.tamanho());

        turma.listarDoInicio();

        turma.remove(a4);

        System.out.println(turma.tamanho());
    }
}
