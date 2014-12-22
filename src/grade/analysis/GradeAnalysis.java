package grade.analysis;

/**
 * A class to provide statistical and analytical information about a set of grades
 * @author Isaac Mast
 */
public class GradeAnalysis {

	/**
	 * Constructor
	 */
	public GradeAnalysis() {

	}

	/**
	 * Calculate the average grade
	 * @return average grade
	 */
	public double average(double[] grades) {
		double sum = 0, average;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		average = sum/grades.length;
		return average;
	}

	/**
	 * Finds the highest grade in grades[]
	 * @param grades array
	 * @return max which is highest grade in grades[]
	 */
	public double max(double[] grades) {
		double max = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) max = grades[i];
		}
		return max;
	}

	/**
	 * Finds the lowest grade in grades[]
	 * @param grades array
	 * @return min which is lowest grade in grades[]
	 */
	public double min(double[] grades) {
		double min = grades[0];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) min = grades[i];
		}
		return min;
	}

	/**
	 * Prints out a sideways histogram of the grades from grades[]
	 * @param grades array
	 */
	public void histogram(double[] grades) {
		String[] histogram = {"  0 - 9|", "10 - 19|", "20 - 29|", "30 - 39|", "40 - 49|",
				"50 - 59|", "60 - 69|", "70 - 79|", "80 - 89|", "90 - 99|", "   100+|"};
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < 10) histogram[0] += "*";
			else if (grades[i] > 9 && grades[i] < 20) histogram[1] += "*";
			else if (grades[i] > 19 && grades[i] < 30) histogram[2] += "*";
			else if (grades[i] > 29 && grades[i] < 40) histogram[3] += "*";
			else if (grades[i] > 39 && grades[i] < 50) histogram[4] += "*";
			else if (grades[i] > 49 && grades[i] < 60) histogram[5] += "*";
			else if (grades[i] > 59 && grades[i] < 70) histogram[6] += "*";
			else if (grades[i] > 69 && grades[i] < 80) histogram[7] += "*";
			else if (grades[i] > 79 && grades[i] < 90) histogram[8] += "*";
			else if (grades[i] > 89 && grades[i] < 100) histogram[9] += "*";
			else if (grades[i] > 99) histogram[10] += "*";
		}
		for (int i = 0; i < histogram.length; i++) {
			System.out.println(histogram[i]);
		}
	}

	/**
	 * Calculates the variance of the grades in grades[]
	 * @param grades array
	 * @return variance of grades in grades[]
	 */
	public double variance(double[] grades) {
		double mean = average(grades);
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			double gradeDiff = grades[i] - mean;
			double squaredDiff = Math.pow(gradeDiff, 2);
			sum += squaredDiff;
		}
		double variance = sum/grades.length;
		return variance;
	}

	/**
	 * Calculates the standard deviation of the grades in grades[]
	 * @param grades array
	 * @return sd which is the standard deviation
	 */
	public double standDev(double[] grades) {
		double variance = variance(grades);
		double sd = Math.sqrt(variance);
		return sd;
	}

	/**
	 * Sorts the numbers in grades[] with a bubble sort algorithm
	 * @param grades array
	 * @return grades array once sorted
	 */
	public double[] sort(double[] grades) {
		double temp;
		boolean sorted = false;
		while (sorted == false) {
			sorted = true;
			for (int i = 0; i < grades.length - 1; i++) {
				if (grades[i] > grades[i + 1]) {
					temp = grades[i + 1];
					grades[i + 1] = grades[i];
					grades[i] = temp;
					sorted = false;
				}
			}
		}
		return grades;
	}

	/**
	 * Determines the median grade
	 * @param grades array
	 * @return median grade from grades[]
	 */
	public double median(double[] grades) {
		double median;
		sort(grades);
		if (grades.length % 2 == 1) {
			median = grades[grades.length / 2];
		}
		else {
			median = (grades[grades.length / 2] + grades[(grades.length / 2) + 1]) / 2;
		}
		return median;
	}
	
	/**
	 * Prints out the array of grades in order
	 * @param grades array
	 * @return output, which holds the string of sorted numbers
	 */
	public String toString(double[] grades) {
		String output = "";
		sort(grades);
		for (int i = 0; i < grades.length - 1; i++) {
			output += grades[i] + ", ";
		}
		return output + grades[grades.length - 1];
	}
}
