package tmp.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	
        int[] answer = new int[id_list.length];
        Map<String,Set<String>> setMap = new HashMap<String, Set<String>>();
        Map<String, Integer> idIdxMap = new HashMap<String, Integer>();
        for (int i = 0; i < id_list.length; i++) {
			idIdxMap.put(id_list[i], i);
		}
        for (int i = 0; i < report.length; i++) {
			String reporter=report[i].split(" ")[0];
			String reported=report[i].split(" ")[1];
			if(!setMap.containsKey(reported)) {
				setMap.put(reported, new HashSet<String>());
			}
			setMap.get(reported).add(reporter);
		}
        for(String reported: setMap.keySet()) {
        	if(setMap.get(reported).size()>=k) {
        		for (String reporter : setMap.get(reported)) {
        			answer[idIdxMap.get(reporter)]++;
				}
        	}
        }
        return answer;
    }
}
