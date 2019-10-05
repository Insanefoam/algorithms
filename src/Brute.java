public class Brute {
    public int body(String source, String template) {
        int sourceLen = source.length();
        int templateLen = template.length();
        int comparings = 0;
        int j;
        for (int i = 0; i <= sourceLen - templateLen; i++) {
            for (j = 0; j < templateLen; j++) {
                if (template.charAt(j) != source.charAt(i + j)) {
                    comparings++;
                    break;
                }

            }
            if (j == templateLen)
            {
                System.out.println("Количество сравнений (brute): "+comparings);
                return comparings;
            }
        }
        System.out.println("Количество сравнений (brute): "+comparings);
        return comparings;
    }

}
