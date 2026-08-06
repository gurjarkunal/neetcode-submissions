class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        if (n == 1 || s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char temp;
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if (ch == ')') {
                if (st.isEmpty()) return false;
                temp = st.pop();
                if (temp != '(')
                    return false;
            } else if (ch == ']') {
                if (st.isEmpty()) return false;
                temp = st.pop();
                if (temp != '[')
                    return false;
            } else {
                if (st.isEmpty()) return false;
                temp = st.pop();
                if (temp != '{')
                    return false;
            }
        }
        return st.isEmpty();
    }
}
