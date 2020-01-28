import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHRIterator implements Iterator<OHRequest> {
    private OHRequest cur;
    public OHRIterator(OHRequest queue) {
        cur = queue;
    }

    public boolean hasNext() {
        while (cur != null && !isGood((cur.description))) {
            cur = cur.next;
        }
        return cur != null;
    }
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest ret = cur;
        cur = cur.next;
        return ret;
    }

    public boolean isGood(String description) {
        return description != null && description.length() > 5;
    }
}