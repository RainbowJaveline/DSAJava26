class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        boolean[] visited = new boolean[nums2.length];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (!visited[j] && nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                    visited[j] = true;
                    break;
                }
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            result[i] = ans.get(i);

        return result;
    }
}