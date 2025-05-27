import java.util.AbstractList;

public class TestBench {
  public static AbstractList<String> buildList() {
    return addToList(new MyLinkedList<>());
  }

  public static AbstractList<String> addToList(AbstractList<String> list) {
    String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int x = 0; x < data.length(); x++) {
      list.add(data.charAt(x) + "");
    }
    return list;
  }

  public static void test(AbstractList<String> list) {
    System.out.println("--- Beginning Tests ---");

    System.out.println("No changes");
    System.out.println(list);

    System.out.println("Testing size()");
    System.out.println(list.size());

    System.out.println("Testing add(int index, E element)");
    list.add(0, "AAA");
    list.add(0, "BBB");
    list.add(10, "CCC");
    list.add(15, "DDD");
    list.add(list.size() - 1, "EEE");
    System.out.println(list);

    System.out.println("Testing get(int index)");
    System.out.println("Element at 0: " + list.get(0));
    System.out.println("Element at 10: " + list.get(10));
    System.out.println("Element at 20: " + list.get(20));
    System.out.println("Element at 26: " + list.get(26));
    System.out.println("Element at last position: " + list.get(list.size() - 1));

    System.out.println("Testing remove(int index)");
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(10));
    System.out.println(list.remove(20));
    System.out.println(list.remove(list.size() - 1));
    System.out.println(list);

    System.out.println("Testing set(int index, E element)");
    list.set(0, "QQQ");
    list.set(5, "WWW");
    list.set(10, "EEE");
    list.set(12, "RRR");
    list.set(4, "TTT");
    list.set(20, "TTT");
    list.set(list.size() - 1, "YYY");
    System.out.println(list);

    System.out.println("Testing indexOf(Object o)");
    System.out.println("indexOf QQQ: " + list.indexOf("QQQ"));
    System.out.println("indexOf WWW: " + list.indexOf("WWW"));
    System.out.println("indexOf D: " + list.indexOf("D"));
    System.out.println("indexOf HELLO: " + list.indexOf("HELLO"));
    System.out.println("indexOf RRR: " + list.indexOf("RRR"));
    System.out.println("indexOf TTT: " + list.indexOf("TTT"));
    System.out.println("indexOf GOODBYE: " + list.indexOf("GOODBYE"));

    System.out.println("Testing lastIndexOf(Object o)");
    System.out.println("lastIndexOf QQQ: " + list.lastIndexOf("QQQ"));
    System.out.println("lastIndexOf WWW: " + list.lastIndexOf("WWW"));
    System.out.println("lastIndexOf D: " + list.lastIndexOf("D"));
    System.out.println("lastIndexOf HELLO: " + list.lastIndexOf("HELLO"));
    System.out.println("lastIndexOf RRR: " + list.lastIndexOf("RRR"));
    System.out.println("lastIndexOf TTT: " + list.lastIndexOf("TTT"));
    System.out.println("lastIndexOf GOODBYE: " + list.lastIndexOf("GOODBYE"));

    System.out.println("Testing clear()");
    list.clear();
    System.out.println(list);
    System.out.println("Testing clear() [second time]");
    list.clear();
    System.out.println(list);

    System.out.println("Refilling the list");
    addToList(list);
    System.out.println(list);

    System.out.println("--- Ending Tests ---");
  }
}
