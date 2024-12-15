package com.test;

import java.util.*;

public class PotionBrewer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // HashMap to store the recipes
        HashMap<String, List<String[]>> recipes = new HashMap<>();

        // Parse the recipes
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("=");
            String potion = parts[0];
            String[] ingredients = parts[1].split("\\+");

            recipes.putIfAbsent(potion, new ArrayList<>());
            recipes.get(potion).add(ingredients);
        }

        // The potion to brew
        String targetPotion = sc.nextLine();

        // HashMap to memoize results for optimization
        HashMap<String, Integer> memo = new HashMap<>();

        // Compute the minimum number of magical orbs
        int result = computeOrbs(targetPotion, recipes, memo);

        // Print the result
        System.out.println(result);
    }

    private static int computeOrbs(String potion, HashMap<String, List<String[]>> recipes, HashMap<String, Integer> memo) {
        // If it's an item, no orbs are needed
        if (!recipes.containsKey(potion)) {
            return 0;
        }

        // Check memoization
        if (memo.containsKey(potion)) {
            return memo.get(potion);
        }

        int minOrbs = Integer.MAX_VALUE;

        // Iterate over all recipes for this potion
        for (String[] ingredients : recipes.get(potion)) {
            int orbs = ingredients.length - 1; // Orbs required for this recipe

            // Compute orbs for all ingredients
            for (String ingredient : ingredients) {
                orbs += computeOrbs(ingredient, recipes, memo);
            }

            // Update the minimum orbs
            minOrbs = Math.min(minOrbs, orbs);
        }

        // Memoize and return the result
        memo.put(potion, minOrbs);
        return minOrbs;
    }
}
