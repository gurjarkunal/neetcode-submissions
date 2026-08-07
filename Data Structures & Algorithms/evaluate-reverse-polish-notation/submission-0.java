class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int e1 = 0;
        int e2 = 0;
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("+")) {
                int sum = operation(st, "+");
                st.push(sum);
            } else if (tokens[i].equals("-")) {
                int sum = operation(st, "-");
                st.push(sum);
            } else if (tokens[i].equals("*")) {
                int sum = operation(st, "*");
                st.push(sum);
            } else if (tokens[i].equals("/")) {
                int sum = operation(st, "/");
                st.push(sum);
            } else {
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.peek();
    }
    public int operation(Stack<Integer> st, String operator) {
        int op2 = 0;
        int op1 = 0;
        if (operator.equals("+") && !st.isEmpty()) {
            op2 = st.pop();
            if (!st.isEmpty()) {
                op1 = st.pop();
            }
            return op2 + op1;
        } else if (operator.equals("-") && !st.isEmpty()) {
            op2 = st.pop();
            if (!st.isEmpty()) {
                op1 = st.pop();
            }
            return op1 - op2;
        } else if (operator.equals("*") && !st.isEmpty()) {
            op2 = st.pop();
            if (!st.isEmpty()) {
                op1 = st.pop();
            }
            return op1 * op2;
        } else {
            op2 = st.pop();
            if (!st.isEmpty()) {
                op1 = st.pop();
            }
            return op1 / op2;
        }
    }
}
