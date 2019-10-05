import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //JhonsonProtter tmp = new JhonsonProtter();
        //tmp.body(1);
        //Horspul tmp2 = new Horspul();
        //System.out.println(tmp2.body("dwacdwadwa", "adw"));
        //Brute brute = new Brute();
        //System.out.println(brute.body("dwacdwadwa", "adw"));
        //substringTest();
        Haffman haffman = new Haffman();
        haffman.body("beep boop beer!");
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
