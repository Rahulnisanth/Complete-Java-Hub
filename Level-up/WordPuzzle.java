import java.util.*;

public class WordPuzzle {
    static char[][] puzzle = { {'A','B','C','I'},
                        {'B','I','C','S'},
                        {'C','D','E','E'}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i < t; i++) {
            String searchWord = sc.next();
            if(solvePuzzle(searchWord)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
        sc.close();
    }
    private static boolean solvePuzzle(String word) {
        if(word == " "){
            return false;
        } else {
            for(int i = 0;i < puzzle.length; i++) {
                for(int j = 0;j < puzzle[i]. length;j++) {
                    if(findWord(i, j, 0, word)){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    private static boolean findWord(int x, int y, int idx, String searchWord) {
        // In-valid indices :
        if(x < 0 || x >= puzzle.length || y < 0 || y >= puzzle[x].length ) {
            return false;
        }
        // If letter doesn't matched :
        if(puzzle[x][y] != searchWord.charAt(idx)) {
            return false;
        }
        // If word matched :
        if(idx == searchWord.length() - 1) {
            return true;
        }
        // Traversing the other places from the given x & y :
        puzzle[x][y] = '#';
        boolean flag = findWord(x, y + 1, idx + 1, searchWord) || 
        findWord(x, y - 1, idx + 1, searchWord) || 
        findWord(x + 1, y, idx + 1, searchWord) ||
        findWord(x - 1, y, idx + 1, searchWord);
        puzzle[x][y] = searchWord.charAt(idx);
        return flag;
    }
}
