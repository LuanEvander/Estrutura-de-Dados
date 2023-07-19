package logica.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {
    private static int codigo = 10000;
    private int codigoLocacao;
    private String cnhLocador;
    private String placaVeiculo;
    private Date dataLocacao;
    private Date dataDevolucao;
    private float valorLocacao;

    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public Locacao(String cnhLocador, String placaVeiculo, String dataDevolucao, float valorLocacao) {
        this.codigoLocacao = codigo++;
        this.cnhLocador = cnhLocador;
        this.placaVeiculo = placaVeiculo;

        formatoData.setLenient(false); // Não aceita datas inválidas.
        this.dataLocacao = new Date();

        try {
            formatoData.setLenient(false); // Não aceita datas inválidas.
            this.dataDevolucao = formatoData.parse(dataDevolucao);
        } catch (ParseException e) {
            System.err.println(
                    "Erro ao converter data de devolução. Verifique se a data e o formato (dd/MM/yyyy) estão corretos.");
            e.printStackTrace();
        }

        this.valorLocacao = valorLocacao;
    }

    public Locacao() {
    }

    /**
     * @return int return the codigoLocacao
     */
    public int getCodigoLocacao() {
        return codigoLocacao;
    }

    /**
     * @param codigoLocacao the codigoLocacao to set
     */
    public void setCodigoLocacao(int codigoLocacao) {
        this.codigoLocacao = codigoLocacao;
    }

    /**
     * @return String return the cnhLocador
     */
    public String getCnhLocador() {
        return cnhLocador;
    }

    /**
     * @param cnhLocador the cnhLocador to set
     */
    public void setCnhLocador(String cnhLocador) {
        this.cnhLocador = cnhLocador;
    }

    /**
     * @return String return the placaVeiculo
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * @param placaVeiculo the placaVeiculo to set
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    /**
     * @return Date return the dataLocacao
     */
    public Date getDataLocacao() {
        return this.dataLocacao;
    }

    /**
     * @param dataLocacao the dataLocacao to set
     */
    public void setDataLocacao(Date dataLocacao) {
        throw new UnsupportedOperationException("Não é possível alterar a data de locação");
    }

    /**
     * @return Date return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return this.dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        // Valida para não permitir datas passadas
        if (dataDevolucao.before(new Date())) {
            throw new IllegalArgumentException("Data de devolução inválida");
        }

        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return float return the valorLocacao
     */
    public float calcularValorLocacao(Date dataLocacao, Date dataDevolucao) {
        // Lógica para calcular o valor baseado nas datas...
        return valorLocacao;
    }

    /**
     * @return float return the valorLocacao
     */
    public float getValorLocacao() {
        return this.valorLocacao;
    }

    /**
     * @param valorLocacao the valorLocacao to set
     */
    public void setValorLocacao(float valor) {
        this.valorLocacao = valor;
    }

    public String toString() {
        return "Código da locação: " + this.codigoLocacao + "\nCNH do locador: " + this.cnhLocador
                + "\nPlaca do veículo: " + this.placaVeiculo + "\nData da locação: "
                + formatoData.format(this.dataLocacao)
                + "\nData da devolução: " + formatoData.format(this.dataDevolucao) + "\nValor da locação: "
                + this.valorLocacao;
    }
}
