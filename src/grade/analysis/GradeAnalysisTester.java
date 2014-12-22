package grade.analysis;

/**
 * Tester class for analyzing a set of grades
 * @author Isaac Mast
 */
import java.util.*;

public class GradeAnalysisTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create objects 
		Scanner sc = new Scanner(System.in);
		GradeAnalysis gradeAnalysis = new GradeAnalysis();
		
		try {
			System.out.println("How many grades would you like to enter?");
			int numGrades = sc.nextInt();
			double[] grades = new double[numGrades];
			System.out.println();
			
			for (int i = 0; i < numGrades; i++) {
				System.out.print("Enter a grade: ");
				double grade = sc.nextDouble();
				grades[i] = grade;
			}
			
			System.out.println();
			System.out.println("Grades = " + gradeAnalysis.toString(grades));
			System.out.println();
			System.out.println("Histogram");
			System.out.println("---------");
			gradeAnalysis.histogram(grades);
			System.out.println();
			System.out.println("Data Summary");
			System.out.println("------------");
			System.out.println("Highest grade = " + gradeAnalysis.max(grades));
			System.out.println("Average grade = " + gradeAnalysis.average(grades));
			System.out.println("Lowest grade = " + gradeAnalysis.min(grades));
			System.out.println("Variance = " + gradeAnalysis.variance(grades));
			System.out.println("Standard deviation = " + gradeAnalysis.standDev(grades));
			System.out.println("Median = " + gradeAnalysis.median(grades));
			
		}
		catch(Exception e) {
			System.out.println("You must enter a number.");
		}
		finally {
			sc.close();
		}
	}
}
