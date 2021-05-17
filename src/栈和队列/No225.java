package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225 用队列实现栈
 *
 *请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 *
 */
public class No225 {

    class MyStack {

        Queue<Integer> queue1 = null;
        Queue<Integer> queue2 = null;

        public MyStack() {
            queue1  = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * 先进2，然后把1中元素全部加入2，再把1、2互换
         * @param x
         */
        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
