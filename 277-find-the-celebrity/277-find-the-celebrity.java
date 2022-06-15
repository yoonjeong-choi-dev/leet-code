/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // Idea : i가 j를 아는 경우 => i는 정답이 될 수 없고, j는 후보
        // Condition : There will be exactly one celebrity if they are at the party.
        // => 0 ~ n-1 까지 순회하면서 후보를 찾는다
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // candidate < i
            if (knows(candidate, i)) {
                // candidate 이 i를 아는 경우 => i가 후보
                // => candidate 보다 작은 값의 사람은 후보가 될 수 없음
                candidate = i;
            }
        }

        // candidate 이 유명한지 확인
        boolean isCeleb = true;
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) {
                isCeleb = false;
                break;
            }
        }

        return isCeleb ? candidate : -1;
    }
}