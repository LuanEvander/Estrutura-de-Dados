package logica.listas;

import logica.entidades.Categoria;
import logica.tad.LSE;

public class LSECategorias {
    private LSE listaCategorias;

    public LSECategorias() {
        this.listaCategorias = new LSE();
    }
    
    public void adicionarCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nulo");
        } else if (!(categoria instanceof Categoria)) {
            throw new IllegalArgumentException("Categoria deve ser do tipo Categoria");
        }

        listaCategorias.insereFim(categoria);
    }

    public Categoria getCategoria(int identificador) {
        if (identificador < 0) {
            throw new IllegalArgumentException("Identificador não pode ser negativo");
        }
    
        for (Object obj : listaCategorias) {
            Categoria categoria = (Categoria) obj;
    
            if (categoria.getIdentificador() == identificador) {
                return categoria;
            }
        }
        
        return null;
    }

    public Categoria atualizarCategoria (Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nulo");
        } else if (!(categoria instanceof Categoria)) {
            throw new IllegalArgumentException("Categoria deve ser do tipo Categoria");
        }
        
        Categoria categoriaAtualizada = categoria;
        
        if (categoriaAtualizada != null) {
            categoriaAtualizada.setNome(categoria.getNome());
            categoriaAtualizada.setIdentificador(categoria.getIdentificador());
        }
        
        return categoriaAtualizada;
    }

    public void removerCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nulo");
        } else if (!(categoria instanceof Categoria)) {
            throw new IllegalArgumentException("Categoria deve ser do tipo Categoria");
        }
        
        listaCategorias.remove(categoria);
    }

    public String listarCategorias() {
        if (listaCategorias.estahVazia()) {
            return null;
        }
        
        String lista = null;

        for (Object obj : listaCategorias) {
            Categoria categoria = (Categoria) obj;

            lista += categoria.toString() + "\n";
        }

        return lista;
    }
}
