package com.aditya.personal.algorithmproblems.leetCode;

import java.util.*;

public class M_15_3Sum {

    public List<List<Integer>> threeSumAlternate(int[] nums) {

        if (nums.length == 0)
            return new ArrayList<>();

        Set<List<Integer>> toReturn = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int difference = -nums[i];

            List<Integer> subMatch = findTwoSum(nums, i, nums[i], difference);

            if (subMatch == null)
                continue;

            toReturn.add(subMatch);
        }
        return new ArrayList<>(toReturn);
    }

    private List<Integer> findTwoSum(int[] numbers, int skipIndex, int current, int remainingSum) {

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            if (i == skipIndex)
                continue;

            if (complements.containsKey(numbers[i])) {
                List<Integer> toReturn = Arrays.asList(current, complements.get(numbers[i]), numbers[i]);
                Collections.sort(toReturn);
                return toReturn;
            }

            complements.put(remainingSum - numbers[i], numbers[i]);
        }
        return null;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> toReturn = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                int low = i + 1;

                int high = nums.length - 1;

                while (low < high) {

                    int sum = nums[i] + nums[low] + nums[high];

                    if (sum == 0) {
                        toReturn.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (sum > 0)
                        high--;
                    else
                        low++;
                }
            }

        }
        return toReturn;
    }

    public static void main(String[] args) {
        M_15_3Sum instance = new M_15_3Sum();

        System.out.println(instance.threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));

    }
}
