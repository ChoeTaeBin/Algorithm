package 체육복;
import java.util.*;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		//0: 체육복 있음, 1: 여벌까지 있음, -1: 도난 당해서 없음 
		int[] student = new int[n+2]; //앞뒤에 여백을 둠

		//이 과정에서 여벌이 있고 도난당한 학생들은 0으로 상쇄됨
		for(int r: reserve) student[r] += 1; //여벌
		for(int l : lost) student[l] -=1; //도난

		//빌려주기
		for(int s=1; s<=n; s++) {
			if(student[s] == 1) { //여벌이 있는 학생은
				if(student[s-1] == -1) {
					student[s-1] += 1; 
					student[s] -= 1; 
				}else if(student[s+1] == -1) {
					student[s+1] += 1;
					student[s] -= 1;
				}
			}	
		}

		//체육 수업에 들어갈 수 있는 학생 수를 센다
		for(int s=1; s<=n; s++) {
			if(0 <= student[s]) answer++;
		}

		return answer;
	}
}