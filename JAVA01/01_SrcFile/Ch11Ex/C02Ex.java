package Ch11Ex;

import java.util.Scanner;

public class C02Ex {

	public static void main(String[] args) {
		//5 명의 학생에 국영수점수를 입력받아 2차원배열 저장
		//각 학생의 국영수 점수의 합/평균 구하고
		//각 과목당 합 /평균 구해보세요
		int [][] score = new int[5][3];
		Scanner sc = new Scanner(System.in);
		System.out.println("국영수 점수 입력 >");
		for(int i=0;i<score.length;i++) //score.length==5
		{
			for(int j=0;j<score[i].length;j++) // score[i].length==각행의 길이
			{
				score[i][j]=sc.nextInt();
			}
		}
		//각 학생별(행 별) 국영수 총합/평균
		int stdsum[] = new int[5];
		double stdavg[] = new double[5];
		for(int i=0;i<score.length;i++) //score.length==5
		{
			for(int j=0;j<score[i].length;j++) // score[i].length==각행의 길이
			{
				stdsum[i]+=score[i][j];
			}
			stdavg[i]=stdsum[i]/3;
		}		
		
		for(int i=0;i<5;i++) {
			System.out.printf("%d 번째 학생 점수 : %d  %f\n",i,stdsum[i],stdavg[i]);
		}
		
		//각 과목(열 별) 국영수 총합/평균
		int subjectSum[] = new int[3];	//	0 :국어 1 : 영어 2 :수학
		double subjectAvg[] = new double[3];
		for(int j=0;j<3;j++) //score.length==5
		{
			for(int i=0;i<5;i++) // score[i].length==각행의 길이
			{
				subjectSum[j]+=score[i][j];
			}
			//총합 구해지고 난다음 평균계산
			subjectAvg[j]=subjectSum[j]/score.length;
		}	
		
		System.out.printf("국영수 총합 : %d %d %d \n" , subjectSum[0],subjectSum[1],subjectSum[2]);
		System.out.printf("국영수 평균 : %f %f %f \n" , subjectAvg[0],subjectAvg[1],subjectAvg[2]);

	}

}
