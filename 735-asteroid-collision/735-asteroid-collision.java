class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> remains = new Stack<>();

        int top, cur;
        boolean isBroken;
        for (int asteroid : asteroids) {
            // 충돌이 되는 경우 :
            // 스택에 양수(->), 현재 음수(<-)
            if (!remains.isEmpty() && (remains.peek() > 0 && asteroid < 0)) {
                cur = -asteroid;
                isBroken = false;
                while (!remains.isEmpty() && remains.peek() > 0) {
                    top = remains.peek();

                    if (top == cur) {
                        // 두 행성 모두 삭제
                        isBroken = true;
                        remains.pop();
                        break;
                    } else if (top < cur) {
                        // 스택의 오른쪽 방향 행성 삭제
                        remains.pop();
                    } else {
                        // 현재 행성 삭제
                        isBroken = true;
                        break;
                    }
                }
                if (!isBroken) remains.add(asteroid);
            } else {
                remains.push(asteroid);
            }
        }

        int[] ans = new int[remains.size()];
        for (int i = remains.size() - 1; i >= 0; i--) {
            ans[i] = remains.pop();
        }

        return ans;
    }
}