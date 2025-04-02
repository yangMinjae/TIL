package tmp.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	
        int[] answer = new int[id_list.length];
        int[] reported = new int[id_list.length];
        Map<String,Set<String>> setMap = new HashMap<String, Set<String>>();
        Map<String, Integer> idIdxMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < id_list.length; i++) {
        	Set<String> set = new HashSet<String>();
            for (int j = 0; j < report.length; j++) {
    			String tmp[] = report[j].split(" ");
    			if(tmp[0].equals(id_list[i])) {
    				set.add(tmp[1]);
    			}
    		}
            setMap.put(id_list[i],set);
            idIdxMap.put(id_list[i],i);
		}
        
        for (int j = 0; j < id_list.length; j++) {
        	Set<String> set = setMap.get(id_list[j]);
        	Iterator<String> itr = set.iterator();
        	while(itr.hasNext()) {
        		String item = itr.next();
        		int i = idIdxMap.get(item);
        		reported[i]+=1;
        	}
		}
        
        for(int i = 0; i<reported.length; i++) {
        	if(reported[i]>=k) {
        		for (int j = 0; j < reported.length; j++) {
                	Set<String> set = setMap.get(id_list[j]);
                	Iterator<String> itr = set.iterator();
                	while(itr.hasNext()) {
                		if(itr.next().equals(id_list[i])) {
                			answer[j]+=1;
                		}
                	}
				}

        	}
        }
        
        return answer;
    }
}
