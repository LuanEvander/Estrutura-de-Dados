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
     * Retorna o índice calculado a partir da chave usando uma função de hash.
     *
     * @param key a chave a ser usada no cálculo do índice.
     * @return o índice calculado.
     */
    private int hash(Integer key) {
        return key.hashCode() % table.length;
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
        int index = hash((Integer) key);
        Entry<Integer, Veiculo> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.getNext();
        }
        return false;
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
            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
                entry = entry.getNext();
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
        int index = hash((Integer) key);
        Entry<Integer, Veiculo> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
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
        int index = hash(key);
        Entry<Integer, Veiculo> entry = table[index];
        Entry<Integer, Veiculo> prev = null;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                Veiculo oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
            prev = entry;
            entry = entry.getNext();
        }
        Entry<Integer, Veiculo> newEntry = new Entry<>(key, value);
        if (prev != null) {
            prev.setNext(newEntry);
        } else {
            table[index] = newEntry;
        }
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
        int index = hash((Integer) key);
        Entry<Integer, Veiculo> entry = table[index];
        Entry<Integer, Veiculo> prev = null;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                Veiculo oldValue = entry.getValue();
                if (prev != null) {
                    prev.setNext(entry.getNext());
                } else {
                    table[index] = entry.getNext();
                }
                entry.setNext(null);
                size--;
                return oldValue;
            }
            prev = entry;
            entry = entry.getNext();
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
     * Classe interna que representa uma entrada no mapa.
     */
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
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

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
