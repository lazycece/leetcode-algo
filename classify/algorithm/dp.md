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

[买卖股票的最佳时机](/src/main/java/com/lazycece/algo/lc_101_150/lc121_maxProfit/Lc121MaxProfit_t.txt)
[买卖股票的最佳时机II](/src/main/java/com/lazycece/algo/lc_101_150/lc122_maxProfit/Lc122MaxProfit_t.txt)
[买卖股票的最佳时机III](/src/main/java/com/lazycece/algo/lc_101_150/lc123_maxProfit/Lc123MaxProfit_t.txt)
[买卖股票的最佳时机IV](/src/main/java/com/lazycece/algo/lc_151_200/lc188_maxProfit/Lc188MaxProfit_t.txt)
[最佳买卖股票时机含冷冻期](/src/main/java/com/lazycece/algo/lc_301_350/lc309_maxProfit/Lc309MaxProfit_t.txt)
[买卖股票的最佳时机含手续费](/src/main/java/com/lazycece/algo/lc_701_750/lc714_maxProfit/Lc714MaxProfit_t.txt)

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


