class Solution {
    public int scheduleCourse(int[][] courses) {
        //sort courses on the basis of their last day for ease in processing
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0]-b[0]: a[1]-b[1]);
        
        //get more time taking course from the ones we have taken so far
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        int timeElapsed = 0;
        for(int[] course: courses) {
            int duration = course[0];
            int lastDay = course[1];
            
            //only work if duration is within the last day to finish the course
            if(duration<=lastDay) {
                //if time taken till now + duration of current course is withing the last day then add it in our time taken
                if(timeElapsed + duration <= lastDay) {
                    timeElapsed += duration;
                    pq.offer(duration);
                } else {
                    //try to swap the longest course taken till now with the current course and check if can be withing last day of current course
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