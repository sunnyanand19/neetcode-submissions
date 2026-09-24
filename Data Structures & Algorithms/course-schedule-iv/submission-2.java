class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrereq = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            isPrereq[prerequisite[0]][prerequisite[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrereq[i][k] && isPrereq[k][j]) {
                        isPrereq[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrereq[query[0]][query[1]]);
        }
        return result;
    }
}