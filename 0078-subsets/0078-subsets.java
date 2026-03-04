import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Base case
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 1️⃣ Include current element
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);

        // Backtrack (undo)
        current.remove(current.size() - 1);

        // 2️⃣ Exclude current element
        backtrack(nums, index + 1, current, result);
    }
}