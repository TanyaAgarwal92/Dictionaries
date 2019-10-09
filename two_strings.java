/*
[HackerRank] : Given two strings, determine if they share a common substring. A substring may be as small as one character.
*/

// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<Character> letters = new HashSet();
        int s1Len = s1.length();
        int s2Len = s2.length();
        for ( int i = 0; i < s1Len; i++){
            char ch = s1.charAt(i);
            letters.add(ch);
        }
        for ( int i = 0; i < s2Len; i++){
            char ch = s2.charAt(i);
            if ( letters.contains(ch)){
                return "YES";
            }
        }
            return "NO";
    }
