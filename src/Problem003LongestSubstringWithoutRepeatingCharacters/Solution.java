package Problem003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int lengthOfLongestSubstring(String s) {

        if(s==null || "".equals(s)){
            return 0;
        }
        if(s.length()==1)
            return 1;

        int longest=0;


        int start=0;
        int end=0;

        Set<Character> charSet=new HashSet<>();

        while(start!=s.length()){

            while(end<s.length()
                    &&charSet.add(s.charAt(end))){
                end++;
            }
            if(charSet.size()>longest){
                longest=charSet.size();
            }
            charSet.clear();
            if(end>1
                    &&s.charAt(end-1)==s.charAt(end-2)){
                start=end;
            }else{start++;
            end=start;
            }

        }




      return  longest;
        }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
    }


