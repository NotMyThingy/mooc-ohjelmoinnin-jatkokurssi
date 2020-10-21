
public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int numberOfValue;


    public HashMap() {
        this.values = new List[32];
        this.numberOfValue = 0;
    }

    /**
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        List<Pair<K, V>> valuePairList = getValuePairList(key);
        int index = getIndexByKey(key, valuePairList);

        if (index < 0) {
            valuePairList.add(new Pair<>(key, value));
            this.numberOfValue++;
        } else {
            valuePairList.get(index).setValue(value);
        }

        if (1.0 * this.numberOfValue / this.values.length > 0.75) {
            this.doubleArraySize();
        }
    }

    /**
     * @param key
     * @return
     */
    public V get(K key) {
        int hash = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hash] == null) {
            return null;
        }

        List<Pair<K, V>> valuePairList = this.values[hash];

        for (int i = 0; i < valuePairList.size(); i++) {
            if (valuePairList.get(i).getKey().equals(key)) {
                return valuePairList.get(i).getValue();
            }
        }

        return null;
    }

    public V remove(K key) {
        List<Pair<K, V>> list = getValuePairList(key);
        if (list.size() == 0) {
            return null;
        }

        int index = getIndexByKey(key, list);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = list.get(index);
        list.remove(pair);
        return pair.getValue();
    }


    /******************************************************/
    /**********        PRIVATE METHODS        *************/
    /******************************************************/

    private List<Pair<K, V>> getValuePairList(K key) {
        int hash = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hash] == null) {
            this.values[hash] = new List<>();
        }

        return this.values[hash];
    }


    private int getIndexByKey(K key, List<Pair<K, V>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void doubleArraySize() {
        List<Pair<K, V>>[] newArray = new List[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            arrayCopy(newArray, i);
        }

        this.values = newArray;
    }

    private void arrayCopy(List<Pair<K, V>>[] newArray, int fromIndex) {
        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            Pair<K, V> pair = this.values[fromIndex].get(i);

            // Calculate new hash for even distribution inside of new, larger array
            int hash = Math.abs(pair.getKey().hashCode() % newArray.length);
            if (newArray[hash] == null) {
                newArray[hash] = new List<>();
            }

            newArray[hash].add(pair);
        }


    }
}
