// 1. Sort Array
// 2. Use HashMap to maintain the frequency of numbers
public class Solution {
    public List<List<Integer>> threeSum(int[] n) {
        Arrays.sort(n);
        List<List<Integer>> res = new ArrayList<>();
        if(n.length < 3 ) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n.length ; i++ ){
            map.put(n[i], map.containsKey(n[i]) ? map.get(n[i])+1 : 1);
        }
        // 0~1 0~2 0~3 ......
        // 1~2 1~3 1~4 .....
        for( int i = 0; i< n.length ; i++ ){
            for( int j = i+1 ; j < n.length ; j++ ){
                int rest = 0 - n[i] - n[j];
                int count = 0;
                if( n[i] == rest ) count++;
                if( n[j] == rest ) count++;
                if( map.containsKey(rest) && map.get(rest) > count && rest >= n[j]){
                    res.add(Arrays.asList(n[i],n[j],rest));
                }
                while(j < n.length - 1 && n[j] == n[j+1]) j++;
            }
            while( i < n.length - 1 && n[i] == n[i+1]) i++;
        }
        return res;
    }
}