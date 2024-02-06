/*
 * 2024-02-06 프로그래머스: 프로세스
 * 그냥 규칙대로 움직이면서 순서를 세어 주면 된다. 
 */

package 프로세스;
import java.util.*;

public class Solution {

	public int solution(int[] priorities, int location) {
		int[] count = new int[10]; //priority == index인 요소의 갯수
		Queue<Integer> queue = new LinkedList<>(); //큐
		Integer target = new Integer(priorities[location]); //target의 참조 변수
		
		//queue에 우선 순위를 넣는다.
		for(int i=0; i<priorities.length; i++) {
			count[priorities[i]]++; //갯수를 셈
			if(i==location) {
				queue.add(target);
			}else {
				queue.add(priorities[i]);
			}
		}
		
		int order = 1; //처리된 순서
		while(true) {
			Integer p = queue.poll(); //큐에서 하나 꺼냄
			
			boolean isMyTime = true; //처리될 순번인지
			for(int n=9; n>p.intValue(); n--) {
				if(count[n] != 0) {//아직 나보다 큰 수가 있다면
					isMyTime = false;
					break;
				}
			}
			
			if(isMyTime) {//처리될 차례임
				if(target == p) { //target이면 끝
					return order;
				}else {
					count[p.intValue()]--; //큐에서 하나 나감
					order++;
				}
			}else {//아직 내차례가 아니면
				queue.add(p); //다시 뒤로 들아감
			}
		}
	}

}
