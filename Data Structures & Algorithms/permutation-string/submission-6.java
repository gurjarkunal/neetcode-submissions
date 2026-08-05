class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Optimal solution using Sliding Window
        int n1 = s1.length();
        int n2 = s2.length();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        if (n1 > n2)
            return false;

        for (int i = 0; i < n1; i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;
        while (j < n2) {
            if ((j - i + 1) > n1) {
                arr2[s2.charAt(i) - 'a']--;
                i++;
            } else {
                arr2[s2.charAt(j) - 'a']++;
                j++;
                if (Arrays.equals(arr1, arr2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
