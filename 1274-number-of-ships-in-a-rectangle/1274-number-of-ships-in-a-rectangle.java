/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        // Case 1 : not a rectangle
        if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1]) return 0;

        // Case 2 : no ship
        if (!sea.hasShips(topRight, bottomLeft)) return 0;

        // Case 3 : one point
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;

        // Divide and Conquer
        int midX = bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2;
        int midY = bottomLeft[1] + (topRight[1] - bottomLeft[1]) / 2;

        int ans = 0;
        ans += countShips(sea, new int[]{midX, midY}, bottomLeft);
        ans += countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
        ans += countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});
        ans += countShips(sea, topRight, new int[]{midX + 1, midY + 1});
        return ans;
    }
}