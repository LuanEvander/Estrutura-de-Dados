import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VetorMap implements Map<Integer, Veiculo> {
    private static final int INITIAL_CAPACITY = 100000;
    private Entry<Integer, Veiculo>[] table; // Vetor de entradas
    private int size; // Tamanho da coleção

    public VetorMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Retorna o tamanho da coleção.
     * 
     * @return o tamanho da coleção.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Verifica se a lista está vazia.
     * 
     * @return true se a lista estiver vazia, caso contrário, retorna false.
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Verifica se a chave especificada está presente no mapa.
     * 
     * @param key a chave a ser verificada.
     * @return true se a chave estiver presente no mapa, caso contrário, retorna
     *         false.
     */
    @Override
    public boolean containsKey(Object key) {
        // Realiza uma busca binária para encontrar a posição da chave no mapa.
        int index = binarySearch((Integer) key);
        return (index >= 0);
    }

    /**
     * Verifica se o valor especificado está presente no mapa.
     * 
     * @param value o valor a ser verificado.
     * @return true se o valor estiver presente no mapa, caso contrário, retorna
     *         false.
     */
    @Override
    public boolean containsValue(Object value) {
        for (Entry<Integer, Veiculo> entry : table) {
            if (entry != null && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o valor associado à chave especificada.
     * 
     * @param key a chave cujo valor associado será retornado.
     * @return o valor associado à chave especificada, ou null se a chave não
     *         estiver presente no mapa.
     */
    @Override
    public Veiculo get(Object key) {
        int index = binarySearch((Integer) key);
        return (index >= 0) ? table[index].getValue() : null;
    }

    /**
     * Associa o valor especificado à chave especificada.
     * 
     * @param key   a chave à qual o valor será associado.
     * @param value o valor a ser associado à chave.
     * @return o valor anteriormente associado à chave, ou null se a chave não
     *         estiver presente no mapa.
     */
    @Override
    public Veiculo put(Integer key, Veiculo value) {
        if (size == 0) {
            // Se o mapa estiver vazio, insere a entrada na primeira posição.
            table[0] = new Entry<>(key, value);
            size++;
            return null;
        }

        int index = binarySearch(key);

        if (index >= 0) {
            Veiculo oldValue = table[index].getValue();
            table[index].setValue(value);
            return oldValue;
        }

        int insertIndex = -index - 1;
        table[insertIndex] = new Entry<>(key, value); // Insere a entrada na posição correta
        size++;

        return null;
    }

    /**
     * Remove a chave especificada do mapa.
     * 
     * @param key a chave a ser removida.
     * @return o valor associado à chave removida, ou null se a chave não estiver
     *         presente no mapa.
     */
    @Override
    public Veiculo remove(Object key) {
        int index = binarySearch((Integer) key);
        if (index >= 0) {
            Veiculo oldValue = table[index].getValue();
            System.arraycopy(table, index + 1, table, index, size - index - 1);
            table[size - 1] = null;
            size--;
            return oldValue;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Veiculo> m) {
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    /**
     * Retorna um conjunto contendo todas as chaves presentes no mapa.
     * 
     * @return um conjunto contendo todas as chaves presentes no mapa.
     */
    @Override
    public Set<Integer> keySet() {
        Set<Integer> keys = new HashSet<>();
        for (Entry<Integer, Veiculo> entry : table) {
            if (entry != null) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    /**
     * Retorna uma coleção contendo todos os valores presentes no mapa.
     */
    @Override
    public Collection<Veiculo> values() {
        List<Veiculo> values = new ArrayList<>();
        for (Entry<Integer, Veiculo> entry : table) {
            if (entry != null) {
                values.add(entry.getValue());
            }
        }
        return values;
    }

    @Override
    public Set<Map.Entry<Integer, Veiculo>> entrySet() {
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }

    /**
     * Retorna a posição da chave especificada no vetor ordenado.
     * 
     * @param key a chave a ser buscada.
     * @return a posição da chave no vetor ordenado, ou o valor negativo da posição
     *         onde a chave deveria estar.
     */
    private int binarySearch(int key) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Entry<Integer, Veiculo> entry = table[mid];

            if (entry == null) {
                // Se encontrarmos uma entrada nula, movemos o índice 'low' para a direita
                // para procurar em uma posição não nula.
                low = mid + 1;
                continue;
            }

            int midKey = entry.getKey();

            if (midKey < key) {
                low = mid + 1;
            } else if (midKey > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -(low + 1);
    }

    /**
     * Classe interna que representa uma entrada no mapa.
     */
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
