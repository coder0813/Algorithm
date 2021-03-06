//BFS
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for( int num : nums ){
            int size = res.size();
            for( int i = 0 ; i < size ; i++ ){
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}

// DFS
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() -1);
        }
    }
}

// Bit 
class Solution {
    public List<List<Integer>> subsets(int[] input) {
        Arrays.sort(input);
        int size = 1 << input.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i < size ; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0 ; j < input.length ; j++) {
                System.out.println( " i: " + i + " j: " + j + " bit cal: " + (i & (1 << j)));
                if ((i & (1 << j)) != 0) {
                    set.add(input[j]);
                }
            }
            res.add(set);
        }
        return res;
    }
}


// Follow-Up:Multiplication
public class Solution {
    public List<Integer> subsets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for( int num : nums ){
            Set<Integer> temp = new HashSet<>();
            for( int i : set ){
                temp.add(i*num);
            }
            set.add(num);
            set.addAll(temp);
        }
        //set.add(0);
        return new ArrayList<>(set);
    }
}

// Follow - Up : min（s）+max（s）<=k
public class Solution {
    public List<List<Integer>> subsets(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0 , Integer.MAX_VALUE, Integer.MIN_VALUE , k);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos , int min , int max , int k){
        if( min + max >= k ) return;
        res.add(new ArrayList<>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            //helper(res,list,nums,i+1,min,max,k);
            helper(res,list,nums,i+1,Math.min(min,nums[i]),Math.max(max,nums[i]),k);
            list.remove(list.size() -1);
        }
    }
}
