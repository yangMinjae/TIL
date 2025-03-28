package org.joonzis.DI_3_component;

public class Solution {
	private String video_len,pos,op_start,op_end;
    private String[] commands;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.video_len=video_len;
        this.pos=pos;
        this.op_start=op_start;
        this.op_end = op_end;
        this.commands = commands;
    	String answer = toStr(commCond());
        return answer;
    }
    // 전자가 후자보다 크면 1 작으면 -1 같으면 0 리턴
    private int compare(String time1, String time2){
        int[] time1_ = toIntArr(time1);
        int[] time2_ = toIntArr(time2);
        if(time1_[0]>time2_[0]){
            return 1;
        }else if(time1_[0]==time2_[0]){
            if(time1_[1]>time2_[1]){
                return 1;
            }else if(time1_[1]==time2_[1]){
                return 0;
            }
            return -1;
        }else{
            return -1;
        }
    }
    
    private int[] toIntArr(String time){
        int time_[]= new int[2];
        for(int i =0; i<2;i++){
        time_[i] = Integer.parseInt(time.split(":")[i]);
        }
        return time_;
    }
    private String toStr(int[] a) {
    	String result;
    	if(a[0]<10) {
    		result = ""+0+a[0]+":"+a[1];    		
    	}else {
    		if(a[1]<10) {
    			result = ""+a[0]+":0"+a[1];  
    		}else {
    			result=""+a[0]+":"+a[1];    			
    		}
    	}
    	return result;
    }
    private boolean isInOp(String inp){
        boolean result=false;
        if(compare(op_start,inp) == -1&&compare(op_end,inp)==1){
           result=true; 
        }
        return result;
    }
    
    private int[] commCond() {
    	int[] result = toIntArr(pos);
    	if(isInOp(pos)) {
    		result = toIntArr(op_end);
    	}
    	for(String ele : commands) {
    		if(ele.equals("next")) {
    			if(result[1]<50) {
    				result[1]+=10;
    			}else {
    				result[0]+=1;
    				result[1]=result[1]-50;
    			}
    			if(compare(video_len,toStr(result))==-1) {
    				result=toIntArr(video_len);
    			}
    		}else {
    			if(result[0]<10) {
    				result[1]=0;
    				if(result[1]>0) {
    					result[0]-=1;    					
    				}
    			}else {
    				result[0]-=10;
    			}
    		}
    	}
    	if(isInOp(toStr(result))) {
    		result=toIntArr(op_end);
    	}
    	return result;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println("결과 : "+sol.solution("34:33","13:00","00:55","02:55",new String[]{"next","prev"}));
	}
}
