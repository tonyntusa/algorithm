package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class _217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        /**
         * Idea: Use a Set to know an item appear twice
         */
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))
                return true;

            set.add(nums[i]);
        }

        return false;
    }
}
