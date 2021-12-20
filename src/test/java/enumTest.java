public enum enumTest {
    test1(1);
    int a;

    enumTest(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(enumTest.test1.name());
    }
}
