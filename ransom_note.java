/*
[HackerRank] : Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
*/

// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer> map = new HashMap();
        boolean match = true;
        for ( String word : magazine){
            if( map.containsKey(word)){
                map.put(word, map.get(word) +1);
            }
            else{
                map.put(word, 1);
            }
        }
        for (String word : note){
            if ( map.containsKey(word) && map.get(word) > 0){
                map.put(word, map.get(word) -1);
            }
            else{
                match = false;
                break;
            }
        }
        if(match){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
