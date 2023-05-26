public class VetorAluno implements IVetorAluno {
    private Aluno[] alunos = new Aluno[5];
    private int totalDeAlunos = 0;

    @Override
    public void adiciona(Aluno aluno) {
        if (cheio()) {
            garanteEspaco();
        } else {
            alunos[totalDeAlunos] = aluno;
            totalDeAlunos++;
        }
    }

    @Override
    public int tamanho() {
        return totalDeAlunos;
    }

    @Override
    public boolean contem(Aluno aluno) {
        for (int i = 0; i < totalDeAlunos; i++) {
            if (aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cheio() {
        if (totalDeAlunos == alunos.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void garanteEspaco() {
        if (this.cheio()) {
            Aluno[] novosAlunos = new Aluno[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++) {
                novosAlunos[i] = alunos[i];
                this.alunos = novosAlunos;
            }
        }
    }

    @Override
    public boolean remover(Aluno aluno) {
        int indice = -1;
        for (int i = 0; i < totalDeAlunos; i++) {
            if (aluno.equals(alunos[i])) {
                indice = i;
                break;
            }
        }
        if (indice != -1) {
            for (int i = indice; i < totalDeAlunos; i++) {
                alunos[i] = alunos[i - 1];
            }
            totalDeAlunos--;
            return true;
        }
        return false;
    }

}
