// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]; 
                }
            }
        }
        
    return dp[coins.length][amount];
    }
}