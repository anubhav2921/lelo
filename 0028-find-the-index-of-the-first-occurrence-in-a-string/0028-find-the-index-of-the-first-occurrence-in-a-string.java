class Solution {
    public int strStr(String haystack, String needle) {
        String[] parts = ("A" + haystack+"A").split(needle);
        if(parts.length==1) return -1;
        return parts[0].length() -1;
    }
}