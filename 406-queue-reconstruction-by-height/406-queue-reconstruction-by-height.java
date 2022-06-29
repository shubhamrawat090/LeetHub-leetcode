class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        
        // or we can aplly directly
        // Arrays.sort(people, (a,b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        
        int n = people.length;
        List<int[]> list = new ArrayList<>();
        
        for(int[] i : people) {
            list.add(i[1], new int[] {i[0], i[1]});
        }
        
        return list.toArray(new int[n][2]);
    }
}