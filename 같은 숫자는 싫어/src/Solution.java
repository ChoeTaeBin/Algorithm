/*
 * 2024-02-05 프로그래머스: 같은 숫자는 싫어
 * 양방향 링크드 리스트를 이용해서 쉽게 풀 수 있었다.
 */
import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
		LinkedList<Integer> list = new LinkedList<>(); //양방향 연결 리스트
		int[] answer = {};//결과
		
		list.addLast(arr[0]); //맨앞 넣음
		for(int i=1; i<arr.length; i++) {
			if(list.peekLast() != arr[i]) {//맨 끝 원소와 다르면 넣는다.
				list.addLast(arr[i]);
			}
		}
		
		//앞에서 부터 꺼내서 배열로 만듦
		answer = new int[list.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.pollFirst();
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {1,1,3,3,0,1,1};
		System.out.println(Arrays.toString(sol.solution(arr)));
	}
}
