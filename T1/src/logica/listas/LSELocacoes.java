package logica.listas;

import logica.entidades.Locacao;
import logica.tad.LSE;

public class LSELocacoes {
    private LSE listaLocacoes;

    public LSELocacoes() {
        this.listaLocacoes = new LSE();
    }

    public void adicionarLocacao(Locacao locacao) {
        if (locacao == null) {
            throw new IllegalArgumentException("Locacao não pode ser nulo");
        } else if (!(locacao instanceof Locacao)) {
            throw new IllegalArgumentException("Locacao deve ser do tipo Locacao");
        }

        listaLocacoes.insereFim(locacao);
    }

    public Locacao getLocacao(String placaVeiculo) {
        if (placaVeiculo == null) {
            throw new IllegalArgumentException("Placa do veiculo não pode ser nulo");
        } else if (!(placaVeiculo instanceof String)) {
            throw new IllegalArgumentException("Placa do veiculo deve ser do tipo String");
        }
    
        for (Object obj : listaLocacoes) {
            Locacao locacao = (Locacao) obj;
    
            if (locacao.getPlacaVeiculo().equals(placaVeiculo)) {
                return locacao;
            }
        }

        return null;
    }

    public void removerLocacao(Locacao locacao) {
        if (locacao == null) {
            throw new IllegalArgumentException("Locacao não pode ser nulo");
        } else if (!(locacao instanceof Locacao)) {
            throw new IllegalArgumentException("Locacao deve ser do tipo Locacao");
        }

        listaLocacoes.remove(locacao);
    }

    public String listarLocacoes() {
        if (listaLocacoes.estahVazia()) {
            return null;
        }
        
        String lista = null;

        for (Object obj : listaLocacoes) {
            Locacao locacao = (Locacao) obj;

            lista += locacao.toString() + "\n";
        }

        return lista;
    }
}
