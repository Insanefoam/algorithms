import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] values1 = readFromFile("numbers1.txt");
        HashTable hashTable1 = new HashTable(11);
        for (int a : values1) {
            hashTable1.putInTable(a);
        }
        System.out.println(hashTable1);
        hashTable1.removeFromTable(77);
        System.out.println(hashTable1);

        int[] values2 = readFromFile("numbers2.txt");
        HashTable hashTable2 = new HashTable(11);
        for (int a : values2) {
            hashTable2.putInTable(a);
        }
        System.out.println(hashTable2);
        System.out.println(hashTable2.getIdByValue(321));
        System.out.println(hashTable2.removeFromTable(321));
        System.out.println("Количество сравнений в первой таблице: " + hashTable1.compares);
        System.out.println("Количество сравнений во второй таблице: " + hashTable2.compares);
    }

    public static int[] readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String str = "";
        while (scanner.hasNextLine()) {
            str = str.concat(scanner.nextLine() + " ");
        }
        String[] stringedValues = str.split(" ");
        int[] values = new int[stringedValues.length];
        for (int i = 0; i < stringedValues.length; i++) {
            values[i] = Integer.parseInt(stringedValues[i]);
        }
        return values;
    }

    public static void substringTest() {
        Date date = new Date();
        Horspul horspul = new Horspul();
        Brute brute = new Brute();
        long horspulFirst = 0;
        long hourspulLast = 0;
        long bruteFirst = 0;
        long brutelLast = 0;
        String str1 = "ocvuaowswv";
        String template1 = "aow";
        String str2 = "3T9rknltdmnYo5BSOOQAQTXyFNmFAUwpqi7QtX8VrtKQQcwtO2kBtV1cnuj2bh0PsAlvVrRVlnMPPTfQcuIOjYAIaEodiJTcOKfX".toLowerCase();
        String template2 = "qtx";
        String str3 = "JPZlpa3gcYWR3efsexMyVo40y5xZtwG6gly73fOyUCNOP6KZ0ZZt8WQ621toqB0x4A2udnQuFbETk9mLYdKMTskcNmcZ1ax9VILjAyiLJrEFEfrTQzhoJSzCkG20U71KDRQRgliu09gds4Wcag915eV8knutzk45i0CBodSLecJNrakvkjT2uug4CCrc0v5jeectUlUqolwPC0eglARN8iUK1AwptHg80AElKhA8QDHH8DziIJi8ZXfz9Kc4MkVTPl6eOkjGoNQT4fmb5N5vZwWWITIUmNrLEm5kJUYKvIed".toLowerCase();
        String template3 = "jee";
        int avg1 = 0;
        int avg2 = 0;
        horspulFirst = System.nanoTime();
        avg1 += horspul.body(str1, template1);
        avg1 += horspul.body(str2, template2);
        avg1 += horspul.body(str3, template3);
        hourspulLast = System.nanoTime();
        System.out.println(hourspulLast - horspulFirst + " - horspul speed");

        bruteFirst = System.nanoTime();
        avg2 += brute.body(str1, template1);
        avg2 += brute.body(str2, template2);
        avg2 += brute.body(str3, template3);
        brutelLast = System.nanoTime();
        System.out.println(brutelLast - bruteFirst + " - brute speed");
        System.out.println("Average horspul: " + avg1 / 3);
        System.out.println("Average brute: " + avg2 / 3);
    }
}
