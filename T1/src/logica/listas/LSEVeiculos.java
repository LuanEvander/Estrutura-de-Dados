package logica.listas;

import logica.entidades.Veiculo;
import logica.tad.LSE;

public class LSEVeiculos {
    private LSE listaVeiculos;

    public LSEVeiculos() {
        this.listaVeiculos = new LSE();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veiculo não pode ser nulo");
        } else if (!(veiculo instanceof Veiculo)) {
            throw new IllegalArgumentException("Veiculo deve ser do tipo Veiculo");
        }

        listaVeiculos.insereFim(veiculo);
    }

    public Veiculo getVeiculo(String placa) {
        if (placa == null) {
            throw new IllegalArgumentException("Placa não pode ser nulo");
        } else if (!(placa instanceof String)) {
            throw new IllegalArgumentException("Placa deve ser do tipo String");
        }
    
        for (Object obj : listaVeiculos) {
            Veiculo veiculo = (Veiculo) obj;
    
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        
        return null;
    }

    public Veiculo atualizarVeiculo (Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veiculo não pode ser nulo");
        } else if (!(veiculo instanceof Veiculo)) {
            throw new IllegalArgumentException("Veiculo deve ser do tipo Veiculo");
        }
        
        Veiculo veiculoAtualizado = veiculo;
        
        if (veiculoAtualizado != null) {
            veiculoAtualizado.setPlaca(veiculo.getPlaca());
            veiculoAtualizado.setMarca(veiculo.getMarca());
            veiculoAtualizado.setModelo(veiculo.getModelo());
            veiculoAtualizado.setAno(veiculo.getAno());
            veiculoAtualizado.setPotencia(veiculo.getPotencia());
            veiculoAtualizado.setLugares(veiculo.getLugares());
            veiculoAtualizado.setIdCategoria(veiculo.getIdCategoria());
        }
        
        return veiculoAtualizado;
    }

    public void removerVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veiculo não pode ser nulo");
        } else if (!(veiculo instanceof Veiculo)) {
            throw new IllegalArgumentException("Veiculo deve ser do tipo Veiculo");
        }

        listaVeiculos.remove(veiculo);
    }

    public String listarVeiculos() {
        if (listaVeiculos.estahVazia()) {
            return null;
        }
        
        String lista = null;

        for (Object obj : listaVeiculos) {
            Veiculo veiculo = (Veiculo) obj;

            lista += veiculo.toString() + "\n";
        }

        return lista;
    }
}