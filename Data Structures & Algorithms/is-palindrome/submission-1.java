class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int chAscii = Character.toLowerCase(s.charAt(i));
            if ((chAscii <= 122 && chAscii >= 97) || (chAscii <= 57 && chAscii >= 48)) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int n2 = sb.length();
        for (int i = 0; i < n2; i++) {
            if (sb.charAt(i) != sb.charAt(n2 - i - 1))
                return false;
        }
        return true;
    }
}
