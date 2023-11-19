package programmers_172927;


public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] picks = {1,3,2};
		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

		int result = solution.solution(picks, minerals);
		System.out.println(result);
	}
}
