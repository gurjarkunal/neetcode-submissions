class Solution {
    public int longestConsecutive(int[] arr) {
			if (arr.length == 0) return 0;
			int N = arr.length;
        Arrays.sort(arr);
       int mx = 1;
       int cr = 1;
	   for (int i = 1; i < N; i++){
	       if (arr[i] - arr[i - 1] == 1){
	           cr++;
	           if (cr > mx){
	               mx = cr;
	           }
	       }
	       else if (arr[i] - arr[i - 1] != 0){
	           cr = 1;
	       }
	   }
	   return mx;
    }
}
