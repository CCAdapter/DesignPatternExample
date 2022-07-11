import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 报错，初始化错误
 */
public class test {
    String name;
    String abbreviation;
//    public static final test SUNDAY = new test("Sunday", "Sun");

    private static final Map<String, test> ABBREV_MAP = new HashMap<String, test>();


//    private static final Map<String, test> ABBREV_MAP = new HashMap<String, test>();

//    private test(String name, String abbreviation) {
//
//        this.name = name;
//
//        this.abbreviation = abbreviation;
//
//        ABBREV_MAP.put(abbreviation, this);
//
//    }

    private void test1() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.equals("123")) {
            System.out.println("1");
        }
        System.out.println(2);

    }

    public static void main(String[] args) {
//        System.out.println(new BigDecimal("10.6").intValue());
        new test().test1();
    }
}
