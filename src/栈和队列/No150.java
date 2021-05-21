package 栈和队列;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 *
 */
public class No150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                int second = stack.pop();
                int first = stack.pop();
                int cur = first + second;
                stack.push(cur);
            } else if ("-".equals(tokens[i])) {
                int second = stack.pop();
                int first = stack.pop();
                int cur = first - second;
                stack.push(cur);
            } else if ("*".equals(tokens[i])) {
                int second = stack.pop();
                int first = stack.pop();
                int cur = first * second;
                stack.push(cur);
            } else if ("/".equals(tokens[i])) {
                int second = stack.pop();
                int first = stack.pop();
                int cur = first / second;
                stack.push(cur);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
