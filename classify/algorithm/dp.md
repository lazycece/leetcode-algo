# 动态规划

## dp解题步骤

- 确定dp数组（dp table）以及下标的含义
- 确定递推公式
- dp数组如何初始化
- 确定遍历顺序
- 举例推导dp数组

## 典型题型
- 基础问题
- 背包问题
  - 01背包
  - 完全背包
  - 多重背包
- 打家劫舍
- 股票问题
- 子序列问题

## 解题公式

### 背包

#### 01背包


### 打家劫舍

### 股票买卖

- [买卖股票的最佳时机](/src/main/java/com/lazycece/algo/lc_101_150/lc121_maxProfit/Lc121MaxProfit_t.txt)
- [买卖股票的最佳时机II](/src/main/java/com/lazycece/algo/lc_101_150/lc122_maxProfit/Lc122MaxProfit_t.txt)
- [买卖股票的最佳时机III](/src/main/java/com/lazycece/algo/lc_101_150/lc123_maxProfit/Lc123MaxProfit_t.txt)
- [买卖股票的最佳时机IV](/src/main/java/com/lazycece/algo/lc_151_200/lc188_maxProfit/Lc188MaxProfit_t.txt)
- [最佳买卖股票时机含冷冻期](/src/main/java/com/lazycece/algo/lc_301_350/lc309_maxProfit/Lc309MaxProfit_t.txt)
- [买卖股票的最佳时机含手续费](/src/main/java/com/lazycece/algo/lc_701_750/lc714_maxProfit/Lc714MaxProfit_t.txt)

a) 无限次交易or一次交易：定义dp[i][0] 表示昨天未持有股票，dp[i][1]表示昨天持有股票

```java
// 公式推导
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
```
```java
        int unhold = 0, hold = 0 - prices[0];
        for (int i = 1; i < prices.length; i++) {
            unhold = Math.max(unhold, hold + prices[i]);
            // -price[i] 表示只买入一次
            // unhold - price[i] 表示可以买入n次，即无限次
            hold = Math.max(hold, 0 - prices[i]);
        }
```

b) 有限次交易：定义dp[i][k][0] 表示k次未持有股票，dp[i][1]表示k次持有股票;当k>n/2时，问题退化为无限次出手机会
```java
       int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = 0 - prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
```
```java
       int[][] dp = new int[3][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i == 0) {
                    dp[k][0] = 0;
                    dp[k][1] = -prices[i];
                }
                dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i]);
                dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - prices[i]);
            }
        }
```

### 子序列

- [最长递增子序列](/src/main/java/com/lazycece/algo/lc_251_300/lc300_lengthOfLIS/Lc300LengthOfLIS_t.txt)
```bash
dp[i] = max(dp[i], dp[j] + 1)  0=<j<i
```

- [最长连续递增序列](/src/main/java/com/lazycece/algo/lc_651_700/lc674_findLengthOfLCIS/Lc674FindLengthOfLCIS_t.txt)
```bash
d[i] = d[i]+1 , if nums[i]>nums[i-1]
     = 1 , if nums[i]<=nums[i-1]
```

- [最长重复子数组](/src/main/java/com/lazycece/algo/lc_701_750/lc718_MaximumLengthOfRepeatedSubarray/Lc718MaximumLengthOfRepeatedSubarray_t.txt)
```bash
dp[i][j]: 子数组中结尾为i元素与j元素的的情况
 = dp[i-1][j-1]+1, if a[i-1]==b[j-1]
 = 1, if a[i-1]==b[j-1]&&(j==0||i==0)
 = 0, if a[i-1]!=b[j-1]
```

- [最长公共子序列](/src/main/java/com/lazycece/algo/lc_1100_1150/lc1143_longestCommonSubsequence/Lc1143LongestCommonSubsequence3_t.txt)
- [不相交的线](/src/main/java/com/lazycece/algo/lc_1001_1050/lc1035_maxUncrossedLines/Lc1035MaxUncrossedLines_t.txt)
- [判断子序列](/src/main/java/com/lazycece/algo/lc_351_400/lc392_isSubsequence/Lc392IsSubsequence_t.txt)
- [两个字符串的删除操作](/src/main/java/com/lazycece/algo/lc_551_600/lc583_minDistance/Lc583MinDistance_t.txt)
```bash
dp[i][j] = dp[i-1][j-1]+1, if a[i]==n[j]
         = max(dp[i-1][j],dp[i][j-1]), if a[i]!=n[j]

---------------------------------------------------------------

int[][] dp = new int[n1 + 1][n2 + 1];
int res = 0;
for (int i = 1; i <= n1; i++) {
    for (int j = 1; j <= n2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
            res = Math.max(res, dp[i][j]);
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
   
```
- [不同的子序列](/src/main/java/com/lazycece/algo/lc_101_150/lc115_numDistinct/Lc115NumDistinct_t.txt)
```bash
dp[i][j]: 以i为结尾的字符串中, j所属字符串的个数
= dp[i-1][j-1] + dp[i-1][j], if a[i]==b[j],当相等时,存在两种case: 匹配j, 删除j不进行匹配
= dp[i-1][j], if a[i]!=b[j],当不等时,一定是删除不匹配

------------------------------------------------------------------------

   int ns = s.length(), nt = t.length();
   int[][] dp = new int[ns + 1][nt + 1];
   for (int i = 0; i < ns; i++) {
       // 以s[i-1]为结尾的字符串中, 空串的个数
       dp[i][0] = 1;
   }
   for (int i = 1; i <= ns; i++) {
       for (int j = 1; j <= nt; j++) {
           if (s.charAt(i - 1) == t.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
           } else {
               dp[i][j] = dp[i - 1][j];
           }
       }
   }
   return dp[ns][nt];
```

- [最大子序和](/src/main/java/com/lazycece/algo/lc_51_100/lc53_maxSubArray/Lc53MaxSubArray_t.txt)
```bash
最大和的连续子数组,预设第i个数字属于子数组,则0到i的最大和为dp[i]
存在: dp[i] = max(dp[i-1]+nums[i],nums[i])
```

- [最长回文子序列](/src/main/java/com/lazycece/algo/lc_501_550/lc516_longestPalindromeSubseq/Lc516LongestPalindromeSubseq_t.txt)

```bash
 dp[i][j]
 = dp[i+1][j-1] +2, if a[i]==a[j]
 = max(dp[i][j-1], dp[i+1][j]), if a[i]!=a[j]
 由于[i+1][j-1] 可以看出, dp是从矩阵的左下角推导出来的
 
 --------------------------------------------
int[][] dp = new int[n][n];
for (int i = n - 1; i >= 0; i--) {
    dp[i][i] = 1;
    for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
            if (j - i == 1) dp[i][j] = 2;
            else if (j - i == 2) dp[i][j] = 3;
            else dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
    }
}
return dp[0][n - 1];
```

#### 编辑距离

[判断子序列](/src/main/java/com/lazycece/algo/lc_351_400/lc392_isSubsequence/Lc392IsSubsequence_t.txt)
```bash
判断b是a的子序列
dp[i][j] = dp[i-1][j-1]+1, if a[i]==n[j]
         = dp[i-1][j], if a[i]!=n[j]
```
[不同的子序列](/src/main/java/com/lazycece/algo/lc_101_150/lc115_numDistinct/Lc115NumDistinct_t.txt)
```bash
dp[i][j]: 以i为结尾的字符串中, j所属字符串的个数
= dp[i-1][j-1] + dp[i-1][j], if a[i]==b[j],当相等时,存在两种case: 匹配j, 删除j不进行匹配
= dp[i-1][j], if a[i]!=b[j],当不等时,一定是删除不匹配
```
[两个字符串的删除操作](/src/main/java/com/lazycece/algo/lc_551_600/lc583_minDistance/Lc583MinDistance_t.txt)
```bash
dp[i][j] 
= dp[i - 1][j - 1] if a[i]==b[i]
= min({dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1, dp[i][j - 1] + 1}) , if a[i]!=b[i]      
```
[编辑距离](/src/main/java/com/lazycece/algo/lc_51_100/lc72_minDistance/Lc72MinDistance_t.txt)
```bash
dp[i][j]
= dp[i-1][j-1], if a[i]==a[j]
= min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1), if a[i]!=a[j]
```