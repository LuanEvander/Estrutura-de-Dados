package logica.entidades;

public class Cliente {

    
    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;

    // Construtor padrão sem parâmetros
    public Cliente() {
    }

    // Construtor recebendo os dados do cliente
    public Cliente(String nome, String cpf, String cnh, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    // Getters e Setters

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        // Valida que nome não é vazio
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }

        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        // Valida CPF só numeros
        if (cpf == null || !cpf.matches("[0-9]{11}")) {
            throw new IllegalArgumentException("CPF inválido");
        }

        this.cpf = cpf;
    }

    public String getCnh() {
        return this.cnh;
    }

    public void setCnh(String cnh) {
        // Valida CNH só numeros
        if (cnh == null || !cnh.matches("[0-9]{11}")) {
            throw new IllegalArgumentException("CNH inválida");
        }

        this.cnh = cnh;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        // Valida telefone só numeros
        if (telefone == null || !telefone.matches("[0-9]{8,9}")) {
            throw new IllegalArgumentException("Telefone inválido");
        }

        this.telefone = telefone;
    }

    // Método que retorna representação textual do cliente
    @Override
    public String toString() {
        return "Nome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nCNH: " + this.cnh +
                "\nTelefone: " + this.telefone;
    }

}