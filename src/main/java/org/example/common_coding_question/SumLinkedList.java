package org.example.common_coding_question;

/*
* Given 2 numbers represented by linked lists
* Each node of the list is a single digit, in reverse order
* Having a function to add the 2 numbers and return the sum as linked list
*
* E.g
* Input: (8 -> 2 -> 5) + (4 -> 3 -> 1) that is 528 + 134
* Output: (0 -> 7 -> 6) that is 670
*
* The idea is to use Stack which built on top of Linked List and given the number in reverse order
* as head will become last when we push new items to Stack (LIFO)
*
* */

import java.util.Stack;

public class SumLinkedList {
    public String sum(Stack first, Stack second) {
        int num1 = convertFrom(first);
        int num2 = convertFrom(second);
        int sum = num1 + num2;

        return convertTo(sum).toString();
    }

    public int convertFrom(Stack numStack) {
        // convert to String then parse it to int
        StringBuilder numStr = new StringBuilder();
        while (!numStack.isEmpty()) {
            int num = (int) numStack.pop();
            numStr.append(num);
        }
        return Integer.parseInt(numStr.toString());
    }

    // should be Stack but convert to String for readiness
    private Stack convertTo(int sum) {
        // Because the result need to be in reverse order hence we store them first then reverse
        Stack<Object> forward = new Stack<>();
        Stack<Object> backward = new Stack<>();

        while (sum > 0) {
            forward.push(sum % 10); // chia lấy dư (hàng đơn vị) push vào stack i.e 678 % 10 = 8
            sum = sum / 10; // chia lấy nguyên i.e 678/10 = 67
        }

        // reverse stack
        while (!forward.isEmpty()) {
            backward.push(forward.pop());
        }

        return backward;
    }
}
