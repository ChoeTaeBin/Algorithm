package 조이스틱;
import java.util.*;

/*
 * 20240131
 * 프로그래머스 조이스틱 문제
 * 좌우 이동의 최솟값을 찾는것이 어려워서 여러사람의 코드를 참고했다.
 * 그럼에도 미심쩍은 부분이 남아있다. 
 * Q.) i에서 next까지 쭉 도는 경로는 어디서 고려되는가?
 * 
 * 
 * 
 *       0
 *   G        i
 *  T          A     next: i의 왼쪽 가장 가까운 '비A'인덱스
 *   B        A      i를 0에서 끝까지 바꾸어 가며
 *      next         0~i(right) -> i~0(left) -> 0~next(left)
 *                                vs
 *                   0~next(left) -> next~0(left) -> 0~i(left)
 *                   			  vs
 *                   지금까지 최소 경로
 *                   중 최소로 업데이트 해 나간다
 *                   
 */
public class Solution {

	public int solution(String name) {
        int answer = 0;
        char[] cName = name.toCharArray(); //char배열로 변환
        int minMove = cName.length - 1; // 좌우 움직임 수(최대 움직임 수로 초기화)
        
        for(int i=0; i<cName.length; i++) {
        	//상하 이동 처리
        	answer += Math.min('Z' - cName[i] + 1, cName[i] - 'A');
        	
        	
        	int next = i+1;//왼쪽 비A의 시작점 인덱스
        	while(next<cName.length && cName[next] == 'A') {
        		next++;
        	}
        	//(0부터 i까지 왼쪽 이동 -> i에서 0까지 오른쪽 이동 -> 0에서 next까지 오른쪽 이동) vs 지금까지 최소
        	minMove = Math.min(minMove, i+i+(cName.length - next));
        	//(0에서 next까지 오른쪽 이동->next에서 0까지 왼쪽이동 -> 0에서 i까지 오른쪽 이동) vs 지금까지 최소
        	minMove = Math.min(minMove, (cName.length-next) + (cName.length-next) + i);
        }
        
        answer+=minMove;
        return answer;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String name = "JAN";
		System.out.println(sol.solution(name));
	}
}
