package com.test;

import java.util.*;

public class DanceRevolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] ins = new String[n];
        for (int i = 0; i < n; i++) {
            ins[i] = scanner.nextLine();
        }

        Map<String, Integer> tmap = new HashMap<>();
        tmap.put("up", 0);
        tmap.put("right", 1);
        tmap.put("down", 2);
        tmap.put("left", 3);

        int[][][] dp = new int[n + 1][4][4];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        for (int l = 0; l < 4; l++) {
            for (int r = 0; r < 4; r++) {
                dp[0][l][r] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int target = tmap.get(ins[i]);
            for (int l = 0; l < 4; l++) {
                for (int r = 0; r < 4; r++) {
                    if (dp[i][l][r] == Integer.MAX_VALUE) continue;

                    if (target != r) {
                        dp[i + 1][target][r] = Math.min(dp[i + 1][target][r], dp[i][l][r] + (l == target ? 0 : 1));
                    }

                    if (target != l) {
                        dp[i + 1][l][target] = Math.min(dp[i + 1][l][target], dp[i][l][r] + (r == target ? 0 : 1));
                    }
                }
            }
        }

        int minMoves = Integer.MAX_VALUE;
        for (int l = 0; l < 4; l++) {
            for (int r = 0; r < 4; r++) {
                minMoves = Math.min(minMoves, dp[n][l][r]);
            }
        }
        System.out.print(minMoves);
    }
}
