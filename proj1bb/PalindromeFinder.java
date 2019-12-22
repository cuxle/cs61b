/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    private static void PalindromeFindOffByN(int N) {
        CharacterComparator cc = new OffByN(N);

        int minLength = 4;
        In in = new In("../library-sp19/library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }

    }
    public static void main(String[] args) {
        PalindromeFindOffByN(2);
    }
}