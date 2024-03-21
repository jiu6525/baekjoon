import java.util.*;
class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<Map<Integer, Integer>>> playList = new HashMap<>();

        for (String genre : genres) {
            playList.put(genre, new ArrayList<>());
        }

        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> songInfo = new HashMap<>();
            songInfo.put(i, plays[i]); 
            playList.get(genres[i]).add(songInfo); 
        }

        for (String genre : genres) {
            List<Map<Integer, Integer>> list = playList.get(genre);
            list.sort((o1, o2) -> o2.values().iterator().next().compareTo(o1.values().iterator().next()));
        }


        List<String> genresSortedByPlays = new ArrayList<>(totalPlays.keySet());
        genresSortedByPlays.sort((o1, o2) -> totalPlays.get(o2) - totalPlays.get(o1));


        for (String genre : genresSortedByPlays) {
            List<Map<Integer, Integer>> list = playList.get(genre);
            int count = 0;
            for (Map<Integer, Integer> songInfo : list) {
                answerList.add(songInfo.keySet().iterator().next());
                count++;
                if (count >= 2) 
                    break;
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}