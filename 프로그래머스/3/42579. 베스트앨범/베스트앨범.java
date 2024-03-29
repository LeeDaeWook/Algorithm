import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Queue<Pair>> hash = new HashMap<>();
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<Integer>> genreNum = new LinkedHashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (hash.get(genres[i]) == null) {
                hash.put(genres[i], new PriorityQueue<>());
                genreNum.put(genres[i], new ArrayList<>());
            }
            if (hash.get(genres[i]).size() >= 2) {
                if (hash.get(genres[i]).peek().count < plays[i]) {
                    Integer songNum = hash.get(genres[i]).poll().index;
                    genreNum.get(genres[i]).remove(genreNum.get(genres[i]).indexOf(songNum));
                    hash.get(genres[i]).add(new Pair(i, plays[i]));
                    genreNum.get(genres[i]).add(i);
                }
            }
            else {
                hash.get(genres[i]).add(new Pair(i, plays[i]));
                genreNum.get(genres[i]).add(i);
            }
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> orderedGenreCount = new ArrayList<>(genreCount.entrySet());
        orderedGenreCount.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : orderedGenreCount) {
            String genre = entry.getKey();
            int[] values = genreNum.get(genre).stream().mapToInt(Integer::intValue).toArray();
            if (hash.get(genre).size() >= 2) {
                int songNum1 = hash.get(genre).peek().index;
                int value1 = hash.get(genre).poll().count;
                int songNum2 = hash.get(genre).peek().index;
                int value2 = hash.get(genre).poll().count;
                
                if (value1 == value2) {
                    answer.add(values[0]);
                    answer.add(values[1]);
                }
                else {
                    answer.add(songNum2);
                    answer.add(songNum1);
                }
            }
            else
                answer.add(hash.get(genre).peek().index);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Pair implements Comparable<Pair> {
    int index;
    int count;

    public Pair(int index, int count) {
        this.index = index;
        this.count = count;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.count > p.count)
            return 1;
        else if (this.count < p.count)
            return -1;
        else
            return 0;
    }
}                        
