// Time Complexity : O(s + t); where s = length of string s and t = length of string t
// Space Complexity : O(s + t)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
  public String minWindow(String s, String t) {

      // null or empty string
      if (s.length() == 0 || t.length() == 0) {
          return "";
      }
      
      // create a Hash Map for string t
      Map<Character, Integer> tMap = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); i++) {
          char c = t.charAt(i);
          tMap.put(t.charAt(i), tMap.getOrDefault(c, 0) + 1);
      }

      // size of string t's Hash Map
      int required = tMap.size();
      
      // initialize left and right pointers
      int l = 0, r = 0;
      
      // set default window size to -1
      int minWindowSize = -1;
      
      // indexes to keep track of minimum window substring
      int startIdx = 0;
      int endIdx = 0;
      
      // to check if all the characters of string t are present in string s 
      int match = 0;
      
      Map<Character, Integer> sMap = new HashMap<Character, Integer>();

      // keep expanding the window size i.e right pointer 
      // until all the characters of string t are present in the window
      while (r < s.length()) {
          char c = s.charAt(r);
          sMap.put(c, sMap.getOrDefault(c, 0) + 1);

          // if character is present in string t and has same occurence as of string s, 
          // then increase the match by 1
          if (tMap.containsKey(c) && sMap.get(c).intValue() == tMap.get(c).intValue()) {
              match++;
          }

          // if all the required characters of string t are present in the string s
          while (l <= r && match == required) {
              c = s.charAt(l);
              
              // if the current window size is less than the previously stored window size,
              // then update the current window size and both the pointers
              if (minWindowSize == -1 || r - l + 1 < minWindowSize) {
                  minWindowSize = r - l + 1;
                  startIdx = l;
                  endIdx = r;
              }
              // System.out.println(s.substring(startIdx, endIdx + 1));

              // contracting the window size from left
              sMap.put(c, sMap.get(c) - 1);
              if (tMap.containsKey(c) && sMap.get(c).intValue() < tMap.get(c).intValue()) {
                  match--;
              }
              
              l++;
          }

          r++;   
      }
      
      return minWindowSize == -1 ? "" : s.substring(startIdx, endIdx + 1);
  }
}