public class BSTFunction<Key> {
    static BST find(BST bst, Key key) {
        if (bst == null) {
            return null;
        }

        if (bst.key.equals(key)) {
            return bst;
        } else if (bst.key < key) {
            return find(bst.right, key);
        } else if (bst.key > key) {
            return find(bst.left, key);
        }
    }
}
