// This is a linked list with basic functionality, as well as the ability to
// sort, shuffle, remove minimum, remove duplicates, reverse, and clear.

import java.lang.IndexOutOfBoundsException;
import java.util.AbstractList;
import java.lang.StringBuilder;
import java.util.Random;

public class MyLinkedList<E extends Comparable<E>> extends AbstractList<E> {
    private Node first, last;
    public int numElements = 0;

    private Node getNode(int index) {
        Node ref = first;

        for (int x = 1; x <= index; x++) {
            ref = ref.next;
        }

        return ref;
    }

    public E get(int index) {
        return (E) getNode(index).value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return numElements;
    }

    public boolean add(E element) {
        if (isEmpty()) {
            first = last = new Node((String) element);
        }
        else {
            last.next = new Node((String) element);
            last = last.next;
        }

        numElements++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + index);
        }

        if (index == 0) {
            first = new Node((String) element, first, null);
            numElements++;
            return;
        }

        Node ref = first;
        for (int x = 0; x < index - 1; x++) {
            ref = ref.next;
        }
        ref.next = new Node((String) element, ref.next, ref.prev);

        numElements++;

        if (last.next != null) {
            last = last.next;
        }
    }

    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + index);
        }

        if (index == 0) {
            first.value = (String) element;
            return null;
        }

        Node ref1 = first;
        for (int x = 0; x < index; x++) {
            ref1 = ref1.next;
        }

        ref1.value = (String) element;
        return null;
    }

    public E remove(int index) {
        if (index == 0) {
            Node returnVal = first;
            first = first.next;
            numElements--;
            return (E) returnVal.value;
        }
        else if (index == size() - 1) {
            Node secondToLast = getNode(size() - 1);
            secondToLast.next = null;
            last = secondToLast;
            numElements--;
            return (E) secondToLast.value;
        }
        else {
            Node remove = getNode(index);
            Node oneBefore = getNode(index - 1);
            oneBefore.next = oneBefore.next.next;
            numElements--;
            return (E) remove.value;
        }
    }

    public int indexOf(String val) {
        if (isEmpty()) {
            return -1;
        }
        else {
            for (int x = 0; x < size(); x++) {
                if (get(0).equals(val)) {
                    return x;
                }
            }
            return -1;
        }
    }

    public int lastIndexOf(String val) {
        if (isEmpty()) {
            return -1;
        }
        else {
            int tempVar = 0;

            for (int x = 0; x < size(); x++) {
                if (get(0).equals(val)) {
                    tempVar = x;
                }
            }
            if (tempVar != 0) {
                return tempVar;
            }
            else {
                return -1;
            }
        }
    }

    public void clear() {
        int totalSize = size();
        for (int x = 0; x < totalSize; x++) {
            first.value = null;
            first = first.next;
        }
        first = last = null;
        numElements = 0;
    }

    public void swap(int index1, int index2) {
        E shiftNode = get(index1);
        E tempNode = get(index2);
        set(index1, tempNode);
        set(index2, shiftNode);
    }

    public void shuffle (long seed) {
        Random rng = new Random(seed);

        for (int x = 0; x < size() ; x++) {
            int rand = rng.nextInt(0, size());

            swap(rand, x);
        }
    }

    public boolean isNotSorted() {
        boolean sorted = false;
        for (int x = 0; x < size(); x++) {
            String compare1 = (String) get(x);
            String compare2 = "";
            if (x + 1 != size()) {
                compare2 = (String) get(x + 1);
            }
            if (compare(compare1, compare2) && x + 1 != size()) {
                sorted = true;
                break;
            }
        }
        return sorted;
    }

    public void sort() {
        while (isNotSorted()){
            for (int x = 0; x < size(); x++) {
                String compare1 = (String) get(x);
                String compare2 = "";
                String compare3 = "";

                if (x + 1 != size()) {
                    compare2 = (String) get(x + 1);
                }

                if (x - 1 != -1) {
                    compare3 = (String) get(x - 1);
                }
                if (compare(compare1, compare2) && x + 1 != size()) {
                    swap(x, x + 1);
                } else if (compare(compare3, compare1) && x - 1 != -1) {
                    swap(x, x - 1);
                }
            }
        }
    }

    public boolean compare(String compare1, String compare2) {
        if (compare1.compareToIgnoreCase(compare2) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void reverse() {
        for (int index = 0; index < size() / 2; index++) {
            swap(size() - 1 - index, index);
        }
    }

    public E removeMinimum() {
        String minVal = "";
        int minIndex = -1;

        for (int index1 = 0; index1 < size(); index1++) {
            if (minVal.equals("")) {
                minVal = (String) get(index1);
                minIndex = index1;
            }
            else {
                String compareVal = (String) get(index1);
                if (compareVal.compareToIgnoreCase((minVal)) < 0) {
                    minVal = compareVal;
                    minIndex = index1;
                }
            }
        }

        if (minIndex > -1) {
            remove(minIndex);
            return (E) minVal;
        }
        else {
            return null;
        }
    }

    public void removeDuplicates() {
        for (int index1 = 0; index1 < size(); index1++) {
            String compareVal1 = (String) get(index1);
            for (int index2 = index1 + 1; index2 < size(); index2++) {
                String compareVal2 = (String) get(index2);
                if (compareVal1.compareToIgnoreCase(compareVal2) == 0) {
                    remove(index2);
                    index2 --;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("[ ]");
        }
        else {
            sb.append("[");
            for (int x = 0; x < size() - 1; x++) {
                sb.append(get(x) + ", ");
            }
            sb.append(get(size() - 1) + "]");
        }
        return sb.toString();
    }
}