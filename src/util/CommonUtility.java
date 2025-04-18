package util;

import learnandpractice.linkedlist.DNode;
import learnandpractice.linkedlist.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonUtility {

    public static int sumOfNNaturalNumbers(int N) {
        return (N * (N + 1)) / 2;
    }

    public static int sumOfArrayValues(int[] array) {
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum = sum + array[j];
        }
        return sum;
    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }

    public static void swapBasedOnIndexArrayList(int j, int i, ArrayList<Integer> array) {
        int tempValue = array.get(j); // IMP store the value not the index
        array.set(j, array.get(i));
        array.set(i, tempValue);
    }

    public static void reverseArray(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int[] sortArray_Selection(int[] array) {
        int n = array.length;
        // n-2 bcz we don't need to sort the array till last element bcz of the inner loop and swap the last element at the end of sorting will be sorted
        for (int i = 0; i <= n - 2; i++) {
            int minimumValueIndex = i;
            // j=i , bcz we need to update the starting point of the sorting, if 0th index is sorted than the next loop should start from 1st index
            // n-1, bcz we want to check till the last element of the array
            for (int j = i; j <= n - 1; j++) {
                if (array[j] < array[minimumValueIndex]) {
                    minimumValueIndex = j; // IMP to update this
                }
            }

            swapBasedOnIndex(minimumValueIndex, i, array);
        }

        System.out.println("SORTED ARRAY " + Arrays.toString(array));
        return array;
    }

    public static void traverseAndPrintLL(Node head) {
        System.out.println("Whole LINKED LIST: ");
        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.data);
            traverseNode = traverseNode.next;
        }
    }

    public static void traverseAndPrintDLL(DNode head) {
        System.out.println("Whole DOUBLY LINKED LIST: ");
        DNode traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.data);
            traverseNode = traverseNode.next;
        }
    }


    public static Node convertArrayToLL(int a[]) {
        Node head = new Node(a[0]);
        Node mover = head;// Created another node for logic bcz we always try to avoid updating head
        // If head is updated we will forget the starting point of the LL

        for (int i = 1; i < a.length; i++) {
            Node temp = new Node(a[i]);
            mover.next = temp;// linking mover to the next element, but after this we need to move mover to next node to link it to next node(elements)
            mover = temp;//move mover to next node(temp) place, in next loop temp will be at next index and we can keep moving mover after linking it to temp
        }

        return head;
    }


    public static DNode convertArrayToDLL(int a[]) {
        DNode head = new DNode(a[0]);
        DNode prev = head;

        for (int i = 1; i < a.length; i++) {// i=1 so it will assign next element of prev/head
            DNode nxtTemp = new DNode(a[i]);
            nxtTemp.prev = prev;// linking back to prev
            prev.next = nxtTemp;// linking prev to nxtTemp(front)
            // Now there is 2 way communication between DNode

            //We need to move prev to next for the upcoming nodes
            prev = nxtTemp;
        }

//        CommonUtility.traverseAndPrintDLL(head);
        return head;
    }

}
