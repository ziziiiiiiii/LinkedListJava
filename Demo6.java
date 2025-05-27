public class Demo6 {
  public static void main(String[] args) {
    MyLinkedList<String> list = new MyLinkedList<>();
    TestBench.addToList(list);
    TestBench.addToList(list);
    TestBench.addToList(list);
    TestBench.addToList(list);
    for (int x = 0; x < list.size(); x += 1 + x/3) {
      System.out.println("Removing element at index: " + x);
      list.remove(x);
    }

    System.out.println("Result");
    System.out.println(list);

    System.out.println("Shuffling");
    list.shuffle(7777);
    System.out.println(list);

    System.out.println("Removing duplicates (keeping first instance)");
    list.removeDuplicates();
    System.out.println(list);
  }
}
