package learncollection;

import java.util.*;

//<> diamon operator
public class LearnCollection {

    public static void main(String[] args) {

        // List family

        /*
        Creating collect:
        2 types:
        1. Type safe: Same type of elements(objects) are added to collection, we can only pass wrapper class
        2. Non-type safe: Diff types of elements can be added to collection

        This can be used for all the implementations
         */

        //TypeSafe
        ArrayList<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("test2");
        System.out.println("TYPE " + strings.get(1));
//        strings.remove() : by object or index
//        strings.empty() :
//        strings.contains() : check if value contains: this checks the equal method of that datatype

        //Non-type: Diff datatype can be added
        LinkedList linkedList = new LinkedList();
        linkedList.add("String");
        linkedList.add(1);
        System.out.println("NON Type " + linkedList);


        // SET family:
//         same way of creating objects like list : type and non-type
        // Treeset : sort the value by default


        // Traversing
        //1.  for-each loop


//        2. Iterator

        Iterator<String> iterator = strings.iterator();
//iterator.hasNext() : returns true if there are new elements
//iterator.next() : to get the current element
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //backward iterator
        ListIterator<String> stringListIterator = strings.listIterator(strings.size());// strings.size() : need to pass strings.size() if you want to do backward iterate
        // stringListIterator.hasPrevious() to traverse n backward direction
        // stringListIterator.previous() to get previous element
        while (stringListIterator.hasPrevious()) {
            System.out.println(stringListIterator.previous());
        }

        // forEach method using lamda
        strings.forEach(s -> {
            System.out.println("FF " + s);
        });

        //TreeSet to sort the elements


        // Comparable and Comparator to define custom sorting for objects


        //MAP

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "test1");
        hashMap.put(3, "test3");
        hashMap.put(2, "test2");

        hashMap.forEach((key, value) -> {

            System.out.println("MM " + key + " " + value);
        });

    }
}
