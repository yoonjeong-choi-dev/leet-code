/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // inDegree[i] : i를 아는 사람 수
        int[] inDegree = new int[n];

        // outDegree[i] : i가 아는 사람 수
        int[] outDegree = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (knows(i, j)) {
                    // i가 j를 아는 경우
                    inDegree[j]++;
                    outDegree[i]++;
                }

                if (knows(j, i)) {
                    // j가 i를 아는 경우
                    inDegree[i]++;
                    outDegree[j]++;
                }
            }
        }

        // celeb == x <=> inDegree[x] = n-1 && outDegree[x] == 0
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) return i;
        }

        // 없는 경우 -1
        return -1;
    }
}