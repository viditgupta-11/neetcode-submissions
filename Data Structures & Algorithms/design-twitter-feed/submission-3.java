class Twitter {
    private int timestamp;
    private Map<Integer, List<int[]>> postMap;
    private Map<Integer, Set<Integer>> followers;

    public Twitter() {
        timestamp = 0;
        postMap = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        postMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        if (postMap.containsKey(userId)) {
            for (int[] posts : postMap.get(userId)) {
                pq.add(posts);
            }
        }
        if (followers.containsKey(userId)) {
            for (int f : followers.get(userId)) {
                if (postMap.containsKey(f)) {
                    for (int[] fPosts : postMap.get(f)) {
                        pq.add(fPosts);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll()[1]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
