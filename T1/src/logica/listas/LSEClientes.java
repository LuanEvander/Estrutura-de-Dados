package logica.listas;

import logica.entidades.Cliente;
import logica.tad.LSE;

public class LSEClientes {
    private LSE listaClientes;

    public LSEClientes() {
        this.listaClientes = new LSE();
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        } else if (!(cliente instanceof Cliente)) {
            throw new IllegalArgumentException("Cliente deve ser do tipo Cliente");
        }

        listaClientes.insereFim(cliente);
    }

    public Cliente getCliente(String cpf) {

        for (Object obj : listaClientes) {
            Cliente cliente = (Cliente) obj;

            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;

    }

    public Cliente atualizarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        } else if (!(cliente instanceof Cliente)) {
            throw new IllegalArgumentException("Cliente deve ser do tipo Cliente");
        }

        Cliente clienteAtualizado = cliente;

        if (clienteAtualizado != null) {
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setCpf(cliente.getCpf());
            clienteAtualizado.setCnh(cliente.getCnh());
            clienteAtualizado.setTelefone(cliente.getTelefone());
        }

        return clienteAtualizado;
    }

    public void removerCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        } else if (!(cliente instanceof Cliente)) {
            throw new IllegalArgumentException("Cliente deve ser do tipo Cliente");
        }

        listaClientes.remove(cliente);
    }

    public String listarClientes() {
        if (listaClientes.estahVazia()) {
            return null;
        }

        String lista = null;

        for (Object obj : listaClientes) {
            Cliente cliente = (Cliente) obj;
            lista += cliente.toString() + "\n";
        }

        return lista;
    }
}
