public class JhonsonProtter {

    public int[] mass;
    int maxMovPos;
    String[] vectors;

    public void body(int n) {
        if (n == 0) return;
        mass = new int[n];
        vectors = new String[n];
        maxMovPos = n - 1;
        for (int i = 0; i < n; i++) {
            mass[i] = i + 1;
            vectors[i] = "l";
        }
        for (int k = 0; k < factorial(n); k++) {
            print();
            for (int i = 0; i < n; i++) {
                if (vectors[i].equals("l")) {
                    if (i == 0) {
                        continue;
                    }
                    if (mass[i] > mass[i - 1] & mass[maxMovPos] < mass[i]) {
                        maxMovPos = i;
                    }
                } else {
                    if (i == n - 1) continue;
                    if (mass[i] > mass[i + 1] & mass[maxMovPos] < mass[i]) {
                        maxMovPos = i;
                    }
                }
            }
            swap(maxMovPos);
        }
    }

    public void swap(int pos) {
        if(pos -1 == -1) return;
        int tmp;
        String tmpStr;
        if (vectors[pos].equals("l")) {
            tmp = mass[pos];
            mass[pos] = mass[pos - 1];
            mass[pos - 1] = tmp;
            tmpStr = vectors[pos];
            vectors[pos] = vectors[pos - 1];
            vectors[pos - 1] = tmpStr;
            pos -= 1;
        } else {
            tmp = mass[pos];
            mass[pos] = mass[pos + 1];
            mass[pos + 1] = tmp;
            tmpStr = vectors[pos];
            vectors[pos] = vectors[pos + 1];
            vectors[pos + 1] = tmpStr;
            pos += 1;
        }
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > mass[pos]) {
                vectors[i] = vectors[i].equals("l") ? "r" : "l";
            }
        }
    }

    public void print() {
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        /*System.out.println();
        for (int i = 0; i < mass.length; i++) {
            System.out.print(vectors[i] + " ");
        }*/
        System.out.println();
    }

    public int factorial(int number) {
        return number == 1 ? number : factorial(number - 1) * number;
    }
}
