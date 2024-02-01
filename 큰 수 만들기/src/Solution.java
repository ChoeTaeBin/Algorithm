/*
 * 2024-02-01 프로그래머스 큰 수 만들기
 * 내 코드도 통과했지만 우여곡절이 있었고 코드도 깔끔하지 않았다.
 * solution2 처럼 k개의 숫자를 없애는 과정에 초점을 맞추는 것이 더 좋다.
 */
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution1("12345678",2));
	}

	//내가 짠 코드
	public String solution1(String number, int k) {
		int[] nArr = new int[number.length()]; //각 자릿수를 배열로 저장
		int answerLen = number.length() - k; //결과의 길이
		StringBuffer answer = new StringBuffer(); //결과

		for(int i=0; i<nArr.length; i++) {
			nArr[i] = number.charAt(i)-'0';
		}

		int startIdx = 0; //이 인덱스 부터 글자를 고를 수 있음

		Outer:for(int i=0; i<answerLen; i++) {//한글자씩 고름
			int digit=9;//이어붙일 숫자
			Inner: for( ; digit>=0; digit--) {//9부터 하나씩 내려가면서 검사
				for(int j=startIdx; j<nArr.length; j++) {
					//nArr에 digit가 있어야 하고 뒤에 최소 answerLen - (i+1)개 이상의 요소가 있어야함
					if(nArr[j] == digit) {
						if(answerLen-i<nArr.length-j) { //뒤에 answerLen - (i+1)개 초과의 요소
							startIdx = j+1; //startIdx갱신
							answer.append(digit);
							break Inner;
						}else if(answerLen-i == nArr.length-j) {// answerLen - (i+1)개의 요소
							for(int l=j; l<nArr.length; l++) {//뒤에있는 것 모두 붙이고 끝
								answer.append(nArr[l]);
							}
							break Outer;
						}
					}
				}
			}	
		}
		return answer.toString().trim();
	}


	/*
	 * 다른사람이 짠 코드 
	 * 없애는 과정에 집중을 하니 보다 간결한 코드가 나온다.
	 * 
	 */
	public String solution2(String number, int k) {
		char[] result = new char[number.length() - k]; //결과배열
		Stack<Character> stack = new Stack<>();

		for (int i=0; i<number.length(); i++) { //왼쪽부터 한 글자씩 보면서
			char c = number.charAt(i);
			
			while (!stack.isEmpty() && stack.peek() < c && k > 0) {
				//아직 k개를 제거하지 못했을때, 현재 수 보다 작은 애들은 모두 pop하여 없애버린다.
				stack.pop();
				k--;
			}
			
			stack.push(c);//현재수를 push한다.
			/*
			 * 결과적으로 stack에서
			 * 1. 더 왼쪽인 숫자가 더 아래에 있다.
			 * 2. 더 큰수가 더 아래에 있다.
			 */
		}
		
		//stack 아래부터 복사한다.
		for (int i=0; i<result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}

}
