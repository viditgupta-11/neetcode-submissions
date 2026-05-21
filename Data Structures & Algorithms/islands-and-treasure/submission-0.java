class Solution {
    private void dfs(int[][] grid, int i, int j, int level) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] <= level) {
            return;
        }
        grid[i][j] = level;
        dfs(grid, i - 1, j, level + 1);
        dfs(grid, i + 1, j, level + 1);
        dfs(grid, i, j - 1, level + 1);
        dfs(grid, i, j + 1, level + 1);
    }
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i - 1, j, 1);
                    dfs(grid, i + 1, j, 1);
                    dfs(grid, i, j - 1, 1);
                    dfs(grid, i, j + 1, 1);
                }
            }
        }
    }
}
