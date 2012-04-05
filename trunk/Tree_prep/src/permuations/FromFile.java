package permuations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FromFile {
	
	//str is the content of the file to be parsed.
	Map<String, List<String>> getAnagrams(String str) {
	    if (str == null)
	        return null;
	 
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	 
	    // get all the words. (or build the dictionary.)
	    String[] words = str.split("\\b+");
	 
	    Set<String> hasAnagram = new HashSet<String>();
	    for (String wd : words) {
	        if (wd.length() <= 1)
	            continue;
	 
	        // sort the characters in this word
	        char[] chars = wd.toCharArray();
	        Arrays.sort(chars);
	        String anaKey = String.valueOf(chars);
	 
	        // update the list of anagrams
	        List<String> anagramList = null;
	        if (map.containsKey(anaKey)) {
	            anagramList = map.get(anaKey);
	            hasAnagram.add(anaKey);
	        }
	        if (anagramList == null) {
	            anagramList = new ArrayList<String>();
	            map.put(anaKey, anagramList);
	        }
	        if (!anagramList.contains(wd)) {
	            anagramList.add(wd);
	        }
	    }
	 
	    // get rid of those words without anagrams.
	    String keys[] = new String[map.size()];
	    for (String key : map.keySet().toArray(keys)) {
	        if (!hasAnagram.contains(key))
	            map.remove(key);
	    }
	 
	    return map;
	}

}
