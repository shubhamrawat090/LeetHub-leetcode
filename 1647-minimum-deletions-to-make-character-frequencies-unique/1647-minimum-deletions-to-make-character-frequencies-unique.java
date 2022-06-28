class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            pq.add(entry.getKey());
        }

        Set<Integer> hs = new HashSet<>();

        int ans = 0;
        while (!pq.isEmpty()) {
            char c = pq.poll();
            if (hs.isEmpty()) {
               hs.add(hm.get(c));
                continue;
            }
            int freq = hm.get(c);
            int del = 0;
            for (int i = freq; i>=1; i--) {
                if (!hs.contains(i)) {
                    hs.add(i);
                    break;
                }
                del++;
            }
            ans += del;
        }

        return ans;
    }
}

