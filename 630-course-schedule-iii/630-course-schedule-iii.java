class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0]-b[0]: a[1]-b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        int time = 0;
        for(int[] course: courses) {
            //only work if duration is within the last day to finish the course
            if(course[0]<=course[1]) {
                if(course[0] + time <= course[1]) {
                    time += course[0];
                    pq.add(course[0]);
                } else {
                    if(!pq.isEmpty() && pq.peek()>course[0]) {
                        time -= pq.remove();
                        time += course[0];
                        pq.add(course[0]);
                    }
                }
            }
        }
        
        return pq.size();
    }
}