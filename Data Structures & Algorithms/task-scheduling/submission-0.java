class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        int noOfMaxFreqTasks = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                noOfMaxFreqTasks++;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + noOfMaxFreqTasks);
    }
}
