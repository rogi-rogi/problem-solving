class Solution {
    public int[] solution(int brown, int yellow) {
        int mid = 1;
        int weight = (brown - 2 * mid) >> 1;
        
        while (weight >= 3) {
            if ((weight - 2) * mid == yellow) break;
            ++mid;
            --weight;
        }
        return new int[]{weight, mid + 2};
    }
}
