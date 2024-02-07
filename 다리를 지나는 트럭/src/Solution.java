/*
 * 2024-02-07 프로그래머스: 다리를 지나는 트럭
 * 큐를 이용해서 다리를 모델링했다. while문이 한바퀴씩 돌을때 마다 일초가 가는 것으로 보았다.
 * 빈 공간을 0으로채운다는 아이디어로 쉽게 풀었다.
 */
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		System.out.println(sol.solution(bridge_length, weight, truck_weights));
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>(); //다리를 나타냄
        int sec = 0; //소요시간
        int numArrived = 0; //도착한 트럭의 수
        int truckIdx = 0; //다음에 들어갈 truck의 인덱스
        int weightSum = 0; //다리위에 있는 트럭의 총 무게
        
        while(numArrived < truck_weights.length) {
        	if(bridge.size() == bridge_length) {//하나 나가야함
        		int w = bridge.poll();
        		if(w != 0) {//빈공간이 아닌 트럭이면
        			numArrived++;//하나 도착
        			weightSum -= w; //다리에서 나감
        		}
        	}
        	
        	if(truckIdx < truck_weights.length && weightSum+truck_weights[truckIdx] <= weight) {
        		//아직 올라갈 트럭이 남았고 올라갈 수 있으면
        		bridge.add(truck_weights[truckIdx]); //다리에 올라감
        		weightSum += truck_weights[truckIdx]; //무게를 합산
        		truckIdx++;
        	}else {
        		bridge.add(0); //빈공간은 0으로 표현
        	}
        	
        	//System.out.println(bridge.toString());
        	sec++;
        }
        
        return sec;
	}

}
