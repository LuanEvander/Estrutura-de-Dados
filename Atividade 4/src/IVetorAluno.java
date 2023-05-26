public interface IVetorAluno {
    public void adiciona(Aluno aluno);

    public int tamanho();

    public boolean contem(Aluno aluno);

    public boolean cheio();

    public void garanteEspaco();

    public boolean remover(Aluno aluno);
}
