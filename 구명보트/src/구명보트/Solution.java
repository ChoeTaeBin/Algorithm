/*
 * 2024-02-04
 * 프로그래머스 구명 보트 문제
 * 투포인터 방법을 이용하여 한번에 쉽게 풀었다.
 * 다만, 반복문이 끝나고 두 포인터가 겹쳐있을때를 처리하는 if문을 제거할 수 있다면 더 좋을 것이다.
 * 알고리즘을 보다 간결하게 짜보자
 */

package 구명보트;
import java.util.*;

public class Solution {

	public int solution(int[] people, int limit) {
		Arrays.sort(people); //오름차순 정렬
        int answer = 0; //구명보트의 수
        int left = 0; //왼쪽 포인터
        int right = people.length-1; //오른쪽 포인터
        /*
         * 투 포인터 알고리즘을 이용, 가벼운 애랑 무거운 애랑 짝을 지어서 최대한 두명씩 탈 수 있도록 한다.
         * 루프가 한번돌때 보트가 하나씩 이용된다. '둘이서 탈지 무거운애 혼자서 탈지'만 결정하면 된다.
         */
        while(left<right) {
        	if(people[left]+people[right] <= limit) { //무게 제한을 넘지 않음
        			left++; //왼쪽이랑 오른쪽이랑 짝을 이룸
        	}
        	right--;
        	answer++; //보트 이용
        }
        if(left == right) { //아직 중간에 하나가 처리가 안됐다면
    		answer++; //보트 이용
    	}
        return answer;
    }
}
