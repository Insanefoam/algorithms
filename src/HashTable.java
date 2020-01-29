public class HashTable {
    public int tableSize;
    private int[] values;
    public int compares = 0;
    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        values = new int[tableSize];
    }

    public int putInTable(int value) {
        int key = value % tableSize;

        if (getByKey(key) != Integer.MIN_VALUE) {
            //Решаем проблему коллизий с помощью свободной адрессации
            //Ищем новое место для очередного элемента
            //удаление, кольцевание, количество сравнений
            int new_key = key;
            while (new_key != values.length && (values[new_key] != 0 || values[new_key] != Integer.MIN_VALUE)) {
                new_key++;
                compares++;
            }

            //Если места нету - выводим, что таблица полная
            if (new_key == values.length) {
                System.out.println("Table is full");
                return Integer.MIN_VALUE;
            }

            //Иначе кладем ее в свободную ячейку
            values[new_key] = value;
            System.out.println("Compares before solve collision:" + compares);
            return new_key;
        } else {
            values[key] = value;
            System.out.println("Compares before solve collision:" + compares);
            return key;
        }
    }

    public int getByKey(int key) {
        if (values[key] == 0)
            return Integer.MIN_VALUE;
        else return values[key];
    }

    public int getIdByValue(int value) {
        if (getByKey(value % tableSize) != value) {
            int searchedId = value % tableSize;
            while (searchedId != values.length && values[searchedId] != value) {
                searchedId++;
            }
            if (searchedId == values.length) {
                System.out.println("Nothing like this value in the table :(");
                return Integer.MIN_VALUE;
            }
            return searchedId;
        } else return value % tableSize;
    }

    public int removeFromTable(int value) {
        if (getByKey(getIdByValue(value)) == value) {
            values[getIdByValue(value)] = Integer.MIN_VALUE;
            return 1;
        } else {
            System.out.println("Dont find value like this");
            return 0;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int a : values)
            str = str.concat(a + " ");
        str = str.concat("\n");
        return str;
    }
}
