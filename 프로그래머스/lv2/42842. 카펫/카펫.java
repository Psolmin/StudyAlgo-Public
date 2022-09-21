class Solution {
    public int[] solution(int brown, int yellow) {
        int a = (brown - 4) / 2;
        double y = (a + Math.sqrt((a * a) - (4 * yellow))) / 2;
        double x = a - y;

        return new int[]{(int) Math.max(x, y) + 2, (int) Math.min(x, y) + 2};
    }
}