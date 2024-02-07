/*
 * 2024-02-07 프로그래머스: 주식가격
 * 간단한 문제인데 알고리즘을 간단히 하기가 어려웠다. 맞긴 맞았으나 개선의 여지가 많다.
 * solution2()처럼 answer를 카운팅 해 나가는 방식으로 짜면 더 간단했을 것이다.
 */

package 주식가격;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(sol.solution1(prices)));
	}
	
	public int[] solution1(int[] prices) {
		int len = prices.length;//배열의 길이
        int[] answer = new int[len]; //결과
        for(int i=0; i<len; i++) {
        	int j=i+1;
        	while(j< len && prices[i] <= prices[j]) {
        		j++;
        	}
        	answer[i] = j-i;
        	if(j == len) { //끝이라면
        		answer[i] -=1;
        	}
        	
        }
        
        return answer;
    }
	
	
	public int[] solution2(int[] prices) {
		int len = prices.length; //배열의 길이
        int[] answer = new int[len]; //결과
        
        for(int i=0; i<len; i++) {
        	for(int j = i+1; j<len; j++) {
        		answer[i]++; //1초가 흐름
        		if(prices[j] < prices[i]) {//가격이 처음보다 낮으면 끝
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
