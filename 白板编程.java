package com.chaoyue.java;

import java.util.Scanner;

/**
 * @author chaoyue
 * @data2021-11-13 17:16
 */
public class reverseTest {
    public static void main(String[] args) {
        reverseTest reverseTest = new reverseTest();
        Scanner scanner = new Scanner(System.in);
        String target = null;
        int tar = 0;
        while (scanner.hasNextLine()) {
            target = scanner.nextLine();
            if (target == null || target.length() == 0) break;
            tar = Integer.parseInt(target);
        }
        System.out.println(reverseTest.jumpFloor(tar));
    }
    public int jumpFloor(int target) {
        if (target < 2) return target;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }
}
