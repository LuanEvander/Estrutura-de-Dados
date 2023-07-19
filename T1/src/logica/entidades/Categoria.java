package logica.entidades;

/**
 * Classe que representa uma categoria de veículo.
 * 
 * Atributos:
 * - identificador: código que identifica unicamente a categoria
 * - nome: nome descritivo da categoria
 */
public class Categoria {

    // Atributo privado que armazena o identificador numérico da categoria
    private int identificador;

    // Atributo privado que armazena o nome textual da categoria
    private String nome;

    // Construtor padrão sem parâmetros
    public Categoria() {
    }

    // Construtor recebendo identificador e nome
    public Categoria(int identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    // Getter para obter o identificador
    public int getIdentificador() {
        return this.identificador;
    }

    // Setter para modificar o identificador
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    // Getter para obter o nome
    public String getNome() {
        return this.nome;
    }

    // Setter para modificar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método que retorna uma representação textual da categoria
    @Override
    public String toString() {
        return "Identificador: " + this.identificador + "\nNome: " + this.nome;
    }

}