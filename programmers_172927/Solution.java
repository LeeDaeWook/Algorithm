package programmers_172927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	Map<String, Integer> fatigueTable = new HashMap<>();

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		fatigueTable.put("diamond", 0);
		fatigueTable.put("iron", 1);
		fatigueTable.put("stone", 2);

		List<List<Integer>> fatigue = new ArrayList<>();

		int sumPicks = Arrays.stream(picks).sum();
		int idx = 0;
		List<String> mineralList = new ArrayList<>(Arrays.asList(minerals));
		while (true) {
			int toIndex = Math.min(mineralList.size(), 5);
			List<String> fiveMinerals = mineralList.subList(0, toIndex);

			fatigue.add(idx, new ArrayList<>());
			for (int i = 0; i < 3; i++) {
				fatigue.get(idx).add(calculateFatigueOfFive(fiveMinerals, i));
			}
			fatigue.get(idx).sort(Comparator.naturalOrder());
			idx++;
			sumPicks--;
			if (sumPicks == 0 || fiveMinerals.size() < 5) {
				break;
			}
			mineralList = mineralList.subList(5, mineralList.size());
		}
		fatigue.sort(Comparator.comparingInt(o -> o.get(2)));
		Collections.reverse(fatigue);

		return dig(fatigue, picks);
	}

	private int dig(List<List<Integer>> fatigue, int[] picks) {
		int result = 0;
		int idx = 0;

		for (List<Integer> list : fatigue) {
			while (idx <= 2 && picks[idx] == 0) {
				idx++;
			}
			if (idx == 3) {
				break;
			}

			result += list.get(idx);
			picks[idx]--;
		}

		return result;
	}

	private int calculateFatigueOfFive(List<String> minerals, int curPick) {
		int result = 0;
		for (String mineral : minerals) {
			result += calculateFatigue(curPick, mineral);
		}

		return result;
	}

	private int calculateFatigue(int curPick, String curMineral) {
		if (fatigueTable.get(curMineral) - curPick >= 0) {
			return 1;
		} else if (fatigueTable.get(curMineral) - curPick == -1) {
			return 5;
		} else if (fatigueTable.get(curMineral) - curPick == -2) {
			return 25;
		} else {
			return 0;
		}
	}
}
