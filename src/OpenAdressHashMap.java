import java.util.HashMap;

public class OpenAdressHashMap {
    private static final int DEFAULT_CAPACITY = 32;
    private static final int MINIMUM_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 536870912;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Pair[] table;
    private int size;
    private int threshold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);


    public OpenAdressHashMap() {
        table = new Pair[DEFAULT_CAPACITY];
    }

    public OpenAdressHashMap(int m) {
        if (m <= 0){
            throw new IllegalArgumentException("Illegal Argument, size must be greater then zero");
        }
        table = new Pair[m];
    }

    public boolean put(int x, long y) {
        int h = hash(x);
        int i = 0;
        if (size == threshold){
            resize(table.length * 2);
        }
        try{
            if (table[h].getKey() == 0) {
                table[h] = new Pair(x, y);
                size++;
                return true;
            }
            for (i = h + 1; i != h; i = (i + 1) % table.length) {
                if (table[i].getKey() == 0 || table[i].getKey() == x) {
                    table[i] = new Pair(x, y);
                    size++;
                    return true;
                }
            }
            return false;
        } catch(NullPointerException e) {
            table[h] = new Pair(x, y);
            size++;
            return true;
        }
    }
  private void resize(int newCapacity)
    {
        if (table.length == MAXIMUM_CAPACITY)
        {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Pair[] newTable = new Pair[newCapacity];
        table = transfer(newTable);
        threshold = (int)(newCapacity * DEFAULT_LOAD_FACTOR);
    }

    public Pair[] transfer(Pair[] newTable){
        Pair[] src = table;
        int newCapacity = newTable.length;

        for (int j = 0; j < src.length; j++) {
            Pair p = src[j];
            if (p!=null){
                src[j] = null;
                int key = p.getKey();
                int h = hash_2(key,newCapacity);
                newTable[h] = p;
            }
        }
        return newTable;
    }

    public long get(int x) {
        int h = hash(x);
        try{
            if (table[h].getKey() == x && table[h].getKey() != 0) {
                return table[h].getValue();
            }
            for (int i = h + 1; i != h; i = (i + 1) % table.length) {
                if(table[i].getValue() == x && table[i].getKey()!=0) {
                    return table[h].getValue();
                }
            }
            return 0;
        }catch(NullPointerException e){
            return 0;
        }
    }
    public int size(){
        return this.size;
    }
    public int hash(int k){
        if (k < 0){
            return -1 * (k % table.length);
        }
        return  k % table.length;
    }
    public int hash_2(int k,int size){
        if (k < 0){
            return -1 * (k%size);
        }
        return k % size;
    }

}

