// Better Solution
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int currsum = nums[i] + nums[j];
                if(map.containsKey(-1*currsum)){
                    int k = map.get(-1*currsum);
                    if(!set.contains(nums[i]+":"+nums[j]+":"+nums[k]) && k>i && k>j){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        set.add(nums[i]+":"+nums[j]+":"+nums[k]);
                    }
                }
            }
        }
        return result;
    }
}

// Optimal Solution
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length - 1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> lst = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(lst);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }            
        }
        return result;
    }
}
