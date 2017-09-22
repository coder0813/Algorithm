public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        // minHeap
        // PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
        //     @Override
        //     public int compare(ListNode o1, ListNode o2){
        //         if(o1.val < o2.val) return -1;
        //         else if(o1.val == o2.val) return 0;
        //         else return 1;
        //     }
        // });
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val );
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        // add all head nodes of K list into the heap
        for(ListNode node : lists){
            if( node != null ) heap.add(node);
        }
        while(!heap.isEmpty()){
            head.next = heap.poll();
            head = head.next;
            // if list just extract fromt sill has element, add it to the heap
            if(head.next != null ) heap.add(head.next);
        }
        return dummy.next;
    }
}

// Merge K sorted Array
public class Solution {
    public static void main(String[] args) {
        int[][] tes = {{1,3,5,7,},{2,8,11,19},{0,4,6,10}};
        Solution sol = new Solution();
        int[] aws = sol.mergeKSortedArray(tes);
        for(int i = 0 ; i < aws.length ; i++){
            System.out.print(aws[i]);
        }
    }
    public int[] mergeKSortedArray(int[][] array){
        int m = array.length;
        int n = array[0].length;
        int[] res = new int[m*n];
        int index = 0;
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(array.length, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0)<o2.get(0)) return -1;
                else if(o1.get(0)==o2.get(0)) return 0;
                else return 1;
            }
        });

        for( int i = 0 ; i < array.length ; i++ ){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(array[i][0]);
            tempList.add(n*i);
            heap.add(new ArrayList<>(tempList));
        }
        while(!heap.isEmpty()){
            List<Integer> list = heap.poll();
            int val = list.get(0);
            res[index++] = val;
            int pos = list.get(1);
            int posY = pos / n;
            int posX = pos % n;
            if( posX + 1 < n ) {
                List<Integer> newList = new ArrayList<>();
                newList.add(array[posY][posX+1]);
                newList.add(posY*n + posX +1);
                heap.add(newList);
            }
        }
        return res;
    }
}