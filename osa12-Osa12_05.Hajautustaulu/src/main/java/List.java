public class List<T> {

    private T[] values;
    private int valuesCount;

    public List() {
        this(10);
    }

    public List(int size) {
        values = (T[]) new Object[size];
        valuesCount = 0;
    }

    /**
     * @param value Adds given value into an array.
     */
    public void add(T value) {
        // check if array is running out of space
        if (values.length == valuesCount) {
            resize();
        }

        values[valuesCount] = value;
        valuesCount++;
    }

    /**
     * @param value Search param
     * @return true if an array contain value.
     */
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    /**
     * Removes first instance of given value.
     *
     * @param value Search param
     */
    public void remove(T value) {
        int removed = indexOf(value);
        if (removed < 0) {
            return;
        }

        moveValuesToLeftFrom(removed);
        valuesCount--;
    }

    /**
     * @param value Search param
     * @return index of given value. Returns -1 if not found.
     */
    public int indexOf(T value) {
        for (int i = 0; i < valuesCount; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index Search param
     * @return value in index.
     */
    public T get(int index) {
        if (index < 0 || index > valuesCount) {
            throw new IndexOutOfBoundsException("Index should be between [0 - " + valuesCount + "]");
        }

        return values[index];
    }

    /**
     * @return Current size of the array.
     */
    public int size() {
        return valuesCount;
    }

    private void resize() {
        int newLength = values.length + values.length / 2;
        T[] newArray = (T[]) new Object[newLength];
        for (int i = 0; i < values.length; i++) {
            newArray[i] = values[i];
        }

        values = newArray;
    }

    private void moveValuesToLeftFrom(int indefOfValue) {
        for (int i = indefOfValue; i < valuesCount - 1; i++) {
            values[indefOfValue] = values[indefOfValue + 1];
        }
        values[valuesCount - 1] = null;
    }

}
