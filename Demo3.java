public class Demo3 {
  public static void main(String[] args) {
    MyLinkedList<String> list = new MyLinkedList<>();

    list.add("E");
    list.add("A");
    list.add("D");
    list.add("B");
    list.add("C");
    System.out.println("Small data set");
    System.out.println(list);
    System.out.println("Sort");
    list.sort();
    System.out.println(list);

    System.out.println("Clearing");
    list.clear();
    System.out.println(list);

    System.out.println("Building list");
    TestBench.addToList(list);
    System.out.println(list);

    System.out.println("Shuffle 1");
    list.shuffle(150);
    System.out.println(list);

    System.out.println("Shuffle 2");
    list.shuffle(250);
    System.out.println(list);

    System.out.println("Sort");
    list.sort();
    System.out.println(list);

    System.out.println("Adding more elements and shuffling");
    TestBench.addToList(list);
    TestBench.addToList(list);
    list.shuffle(250);
    System.out.println(list);

    System.out.println("Sorting");
    list.sort();
    System.out.println(list);

  }
}
