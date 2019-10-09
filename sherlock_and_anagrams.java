/*
[Hackerrank] : Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
*/

static boolean isAnagram( String str1, String str2){
        Map<Character, Integer> letters = new HashMap();
        int str1Len = str1.length();
        for ( int i = 0; i < str1Len; i++){
            char ch = str1.charAt(i);
            if ( letters.containsKey(ch)){
                letters.put(ch, letters.get(ch) + 1);
            }
            else{
                letters.put(ch, 1);
            }
        }
        for ( int i = 0; i < str1Len; i++){
            char ch = str2.charAt(i);
            if ( letters.containsKey(ch) && letters.get(ch) > 0){
                letters.put(ch, letters.get(ch) - 1);
            }
            else{
                return false;
            }
        }
        return true;
    }
    static List<String> findWords(String s){
        int sLen = s.length();
        List<String> words = new ArrayList();
        for ( int i = 0; i < sLen; i++){
            for ( int j = i+1; j <= sLen; j++){
                words.add(s.substring(i,j));
            }
        }
        return words;
    }
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int sLen = s.length();
        int letters[] = new int[26];
        boolean duplicates = false;
        for ( int i = 0; i < sLen; i++){
            int val = (s.charAt(i) - 'a');
            if (letters[val] != 0){
                duplicates = true;
                break;
            }
            letters[val] = letters[val] + 1;
        }
        if ( !duplicates){
            return 0;
        }
        List<String> words = new ArrayList();
        words = findWords(s);
        int wordsLen = words.size();
        int resCount = 0;
        for ( int i = 0; i < wordsLen; i++ ){
            for ( int j = i+1; j < wordsLen; j++){
                String str1 = words.get(i);
                String str2 = words.get(j);
                if ( str1.length() == str2.length() && isAnagram(str1, str2)){
                    resCount++;
                }
            }
        }
        return resCount;
    }
