import java.util.HashMap;

public class Horspul {
    public int body(String source, String template) {
        int sourceLen = source.length();
        int templateLen = template.length();
        int comparings = 0;
        if (templateLen > sourceLen) {
            return -1;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= sourceLen - 1; i++) {
            offsetTable.put(source.charAt(i), templateLen);
        }
        for (int i = 0; i < templateLen - 1; i++) {
            offsetTable.put(template.charAt(i), templateLen - i - 1);
        }
        int i = templateLen - 1; //Конец шаблона относительно основной строки
        int j = i; //Курсор на шаблоне
        int k = i; //Курсор на основной строке
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            //Сверка с конца
            while (j >= 0 && source.charAt(k) == template.charAt(j)) {
                k--;
                j--;
                comparings++;
            }
            //Перенос шаблона
            i += offsetTable.get(source.charAt(i));
        }
        System.out.println("Количество сравнений (horspul): " + comparings);
        if (k >= sourceLen - templateLen) {
            return comparings;
        } else {
            return comparings;
        }
    }
}
