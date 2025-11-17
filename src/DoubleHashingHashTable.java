class DoubleHashingHashTable {
    private int size;
    private int[] table;
    private boolean[] occupied;

    public DoubleHashingHashTable(int size) {
        this.size = size;
        this.table = new int[size];
        this.occupied = new boolean[size];
    }

    // Primary hash function
    private int hash1(int key) {
        return key % size;
    }

    // Secondary hash function (must be non-zero and less than table size)
    private int hash2(int key) {
        return 7 - (key % 7); // Using a prime number for better distribution
    }

    // Insert a key using double hashing
    public void insert(int key) {
        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;
        int probes = 1; // Count probes
        
        while (occupied[(index + i * stepSize) % size]) {
            i++;
            probes++;
            if (i == size) {
                System.out.println("Hash table is full! Cannot insert " + key);
                return;
            }
        }
        
        index = (index + i * stepSize) % size;
        table[index] = key;
        occupied[index] = true;
        System.out.println("Inserted " + key + " at index " + index + " with " + probes + " probes.");
    }

    // Search for a key using double hashing
    public boolean search(int key) {
        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;
        int probes = 1;
        
        while (occupied[(index + i * stepSize) % size]) {
            int newIndex = (index + i * stepSize) % size;
            if (table[newIndex] == key) {
                System.out.println("Found " + key + " at index " + newIndex + " with " + probes + " probes.");
                return true;
            }
            i++;
            probes++;
            if (i == size) break;
        }
        System.out.println("Key " + key + " not found after " + probes + " probes.");
        return false;
    }

    // Delete a key using double hashing
    public void delete(int key) {
        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;
        int probes = 1;
        
        while (occupied[(index + i * stepSize) % size]) {
            int newIndex = (index + i * stepSize) % size;
            if (table[newIndex] == key) {
                occupied[newIndex] = false;
                System.out.println("Deleted " + key + " from index " + newIndex + " with " + probes + " probes.");
                return;
            }
            i++;
            probes++;
            if (i == size) break;
        }
        System.out.println("Key " + key + " not found after " + probes + " probes.");
    }

    // Display the hash table with probe count
    public void display() {
        System.out.println("Index | Key ");
        for (int i = 0; i < size; i++) {
            if (occupied[i]) {
                System.out.println(i + " | " + table[i] );
            } else {
                System.out.println(i + " | EMPTY ");
            }
        }
    }
}
