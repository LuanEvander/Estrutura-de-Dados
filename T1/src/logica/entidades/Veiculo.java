package logica.entidades;

import java.util.Calendar;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private int potencia;
    private int lugares;
    private int idCategoria;

    public Veiculo(String placa, String modelo, String marca, int ano, int potencia, int lugares, int idCategoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.lugares = lugares;
        this.idCategoria = idCategoria;
    }

    public Veiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (!placa.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")) {
            throw new IllegalArgumentException("Placa inválida");
        }
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano < 1900 || ano > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new IllegalArgumentException("Ano inválido");
        }
        this.ano = ano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        if (potencia <= 0) {
            throw new IllegalArgumentException("Potência inválida");
        }
        this.potencia = potencia;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        if (lugares <= 0) {
            throw new IllegalArgumentException("Lugares deve ser maior que zero");
        }
        this.lugares = lugares;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        // Verifica se categoria é válida
        this.idCategoria = idCategoria;
    }

    public String toString() {
        return "Placa: " + this.placa + "\nModelo: " + this.modelo + "\nMarca: " + this.marca + "\nAno: " + this.ano
                + "\nPotencia: " + this.potencia + "\nLugares: " + this.lugares + "\nCategoria: " + this.idCategoria;
    }
}
