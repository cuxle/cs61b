public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null || word.isEmpty()) {
            return null;
        }
        Deque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }
/**
    public boolean isPalindrome(String word) {
        //TODO
        if (word.length() < 2) {
            return true;
        }
        int lastIndex = word.length() - 1;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(lastIndex - i)) {
                return false;
            }
        }
        return true;
    }
 */
    //recursise version
    public boolean isPalindrome(String word) {
        Deque<Character> deq = wordToDeque(word);
        return isPalindrome(deq);
    }

    private boolean isPalindrome(Deque<Character> deq) {
        if (deq == null || deq.size() < 2) {
            return true;
        } else {
            if (deq.removeFirst() == deq.removeLast()) {
                return isPalindrome(deq);
            } else {
                return false;
            }
        }

    }

    private boolean isPalindrome(Deque<Character> deq, CharacterComparator cc) {
        if (deq == null || deq.size() < 2) {
            return true;
        } else {
            if (cc.equalChars(deq.removeFirst(), deq.removeLast())) {
                return isPalindrome(deq, cc);
            } else {
                return false;
            }
        }

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deq = wordToDeque(word);
        return isPalindrome(deq, cc);
    }
}
