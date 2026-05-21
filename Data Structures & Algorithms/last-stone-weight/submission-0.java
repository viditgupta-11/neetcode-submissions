class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int max = pq.poll();
            int secondMax = pq.poll();
            if (max != secondMax) {
                pq.add(Math.abs(max - secondMax));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
