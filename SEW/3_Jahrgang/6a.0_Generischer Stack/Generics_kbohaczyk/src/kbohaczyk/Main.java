package kbohaczyk;

/**
 * Testen
 * @author Kacper Bohaczyk
 * @version 16-02-2023
 */
public class Main {
    public static void main(String[] args) throws StackFullException, StackEmptyException {

       Stack<String> st = new Stack<>(4);

       st.push("Joe");
       st.push("Joseph");
       st.push("Jonathan");
       System.out.println(st.peek());
       System.out.println(st.pop());
       System.out.println(st.pop());

       Stack<Integer> sti = new Stack<>(4);

        sti.push(1);
        sti.push(2);
        sti.push(3);
        System.out.println(sti.peek());
        System.out.println(sti.pop());
        System.out.println(sti.pop());
    }

}