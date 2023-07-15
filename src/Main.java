import java.util.Random;

public class Main {
    public static void main(String[] args) {

        IntegerList integerList1 = new IntegerListImpl(100_000);
        Random r = new Random();

        for (int i = 0; i < 100_000; i++) {
            integerList1.add(r.nextInt(1_000_000) + 1);
        }
        System.out.println("stringList = " + integerList1);
        System.out.println();


        IntegerList integerList2 = new IntegerListImpl(100_000);
        IntegerList integerList3 = new IntegerListImpl(100_000);
        integerList1.integerListCopy(integerList2);
        integerList1.integerListCopy(integerList3);

        long start1 = System.currentTimeMillis();
        System.out.println(integerList1.contains(85644,"Bubbles"));
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        System.out.println(integerList1.contains(85644,"Selection"));
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        System.out.println(integerList1.contains(85644,"Inspection"));
        System.out.println(System.currentTimeMillis() - start3);

    }
}