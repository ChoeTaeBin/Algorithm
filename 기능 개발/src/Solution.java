/*
 * 2024-02-05 프로그래머스: 기능개발
 * 소요일수만 계산하니 정렬없이 O(n)으로 풀 수 있었다.
 */
import java.util.*;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] day = new int[progresses.length]; //소요일수
		int[] temp = new int[progresses.length]; //result배열을 만들기 위함,일단 최대 길이를 할당
		
		for(int r=0; r<day.length; r++) {
			day[r] = ((100 - progresses[r]) + (speeds[r]-1)) /speeds[r]; //소요 일수를 계산
		}
		
		int max = -1; //지금까지 공정에서 최대 소요일수, 첫번째 요소는 무조건 max보다 클것
		int endIdx = -1; //사용한 인덱스의 끝
		for(int i=0; i<day.length; i++) {
			if(max<day[i]){//앞의 모든 공정보다 오래걸린다면
				max = day[i]; //최대값 갱신
				endIdx++; //한칸 더씀
			}
			temp[endIdx]++; //끝값을 1증가시킴
		}
	
		return Arrays.copyOfRange(temp,0,endIdx+1);
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] progresses = {93, 30, 55};
		int[] speedes = {1, 30, 5};
		
		System.out.println(Arrays.toString(sol.solution(progresses, speedes)));
	}
}
