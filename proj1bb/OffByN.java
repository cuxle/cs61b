public class OffByN implements CharacterComparator {
    public int det;
    public OffByN(int N) {
        det = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == det || diff == -det) {
            return true;
        } else {
            return false;
        }
    }
}
