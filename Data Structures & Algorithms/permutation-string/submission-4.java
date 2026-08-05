class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        char [] temp2 = new char[n1];
        temp2 = s1.toCharArray();
        Arrays.sort(temp2);
        String n1Sorted = new String(temp2);
        int n2 = s2.length();

        if (n1 > n2)
            return false;

        for (int h = s1.length() - 1; h < n2; h++) {
            String sub = s2.substring(h - n1 + 1, h + 1);
            char[] temp = sub.toCharArray();

            Arrays.sort(temp);

            String sortedTemp = new String(temp);

            if (n1Sorted.equals(sortedTemp)) {
                return true;
            }
        }

        return false;
    }
}
