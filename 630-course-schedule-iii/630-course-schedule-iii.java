class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0]-b[0]: a[1]-b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        int timeElapsed = 0;
        for(int[] course: courses) {
            int duration = course[0];
            int lastDay = course[1];
            
            //only work if duration is within the last day to finish the course
            if(duration<=lastDay) {
                if(duration + timeElapsed <= lastDay) {
                    timeElapsed += duration;
                    pq.offer(duration);
                } else {
                    if(!pq.isEmpty() && pq.peek()>duration) {
                        timeElapsed = timeElapsed - pq.poll();
                        timeElapsed += duration;
                        pq.offer(duration);
                    }
                }
            }
        }
        
        return pq.size();
    }
}