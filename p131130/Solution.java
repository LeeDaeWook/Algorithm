package programmers.p131130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
	public int solution(int[] cards) {
		List<Integer> subCards = new ArrayList<>();
		List<Integer> sum = new ArrayList<>();
		int nextNum = 1;

		while (nextNum <= cards.length) {
			if (cards[nextNum - 1] == 0) {
				nextNum++;
				continue;
			}

			nextNum = cards[nextNum - 1];
			if (isEnd(subCards, nextNum)) {
				sum.add(subCards.size());
				cards = Arrays.stream(cards)
						.map(card -> subCards.stream().anyMatch(subCard -> subCard == card) ? 0 : card)
						.toArray();
				subCards.clear();
				nextNum = 1;
			}
			else
				subCards.add(nextNum);
		}

		sum.sort(Comparator.naturalOrder());

		if (sum.size() <= 1)
			return 0;
		return sum.get(sum.size() - 1) * sum.get(sum.size() - 2);
	}

	private boolean isEnd(List<Integer> subCards, int num) {
		return subCards.contains(num);
	}
}
