package org.example;

// Hash table basically is array of linked list
public class hashTable {
    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // linked list

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public hashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }


    public void put(String key, String value) {
        // Get index
        int index = getIndex(key);

        // Create linked list entry
        HashEntry newEntry = new HashEntry(key, value);

        // If no entry - add it
        if(data[index] == null) {
            data[index] = newEntry;
        }

        // Else handling collision by adding at the end of the linked list
        else{
            HashEntry oldEntries = data[index];
            // walk till the end
            while (oldEntries.next != null) {
                oldEntries = oldEntries.next;
            }

            oldEntries.next = newEntry;
        }
    }

    public String get(String keyToGet) {
        int index = getIndex(keyToGet);

        // get current list of entries
        HashEntry entries = data[index];

        // if we have existing entries
        if (entries != null) {
            while ( !entries.key.equals(keyToGet) && entries.next != null) {
                entries = entries.next;
            }
            return entries.value;
        }

        // if there's no entry
        return null;
    }

    private int getIndex(String key) {
        // get hash code
        int hashCode =  key.hashCode();
        System.out.println("hashCode: " + hashCode);

        // convert hash code to index
        // 0x7ff.. is the hexadecimal representation of max integer. In order to prevent negative number
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;
        // int index = hashCode % INITIAL_SIZE; // result in negative number

        System.out.println("index: " + index);

        // Force a collision for testing purpose
        if(key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 4;
        }

        return index;
    }

}
