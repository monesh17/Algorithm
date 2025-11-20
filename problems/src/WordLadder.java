import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> front = new HashSet<>();
        Set<String> back  = new HashSet<>();
        Set<String> visited = new HashSet<>();

        front.add(beginWord);
        back.add(endWord);
        int level = 1;

        while (!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) {
                Set<String> tmp = front; front = back; back = tmp;
            }

            Set<String> next = new HashSet<>();
            for (String cur : front) {
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char orig = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) continue;
                        arr[i] = c;
                        String nxt = new String(arr);

                        if (back.contains(nxt)) return level + 1; // meet in the middle
                        if (dict.contains(nxt) && visited.add(nxt)) {
                            next.add(nxt);
                        }
                    }
                    arr[i] = orig;
                }
            }
            front = next;
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
      WordLadder wordLadder = new WordLadder();
      int result = wordLadder.ladderLength("hit","cog",List.of("hot","dot","dog","lot","log"));
      System.out.println(result);
    }

}
