/*
 * 2024-02-06 프로그래머스: 올바른 괄호
 * 스택을 사용하는 유명한 문제라서 쉽게 풀었다.
 * 
 */
import java.util.*;

public class Solution {
	
	boolean solution(String s) {
        Stack<Character> stack = new Stack<>(); //괄호검사를 위한 stack
        
        for(int i=0; i<s.length(); i++) {//오른쪽부터 한 글자씩 보면서
        	char c = s.charAt(i);//현재 글자
        	if(c == '(') { //여는 괄호이면 push
        		stack.push(new Character(c));
        	}else if(c == ')' && !stack.isEmpty() && stack.pop().charValue() == '('){
        		//닫는 괄호이면 stack에서 껀낸 값이 열린 괄호이어야 함
        	}else {
        		return false; //그외는 꽝
        	}
        }
        return stack.isEmpty(); //여는 괄호가 아직 남아있으면 틀린 괄호임
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(""));
		System.out.println(sol.solution("((()))"));
		System.out.println(sol.solution("(()()(())"));
		System.out.println(sol.solution("(()(()()))"));

	}
	
}
