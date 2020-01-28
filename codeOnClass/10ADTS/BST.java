public class BST<Key> {
	private Key key;
	private BST left;
	private BST right;

	public BST(Key key, BST left, BST right) 
	{
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public BST(Key key) {
		this.key = key;
	}

	public static BST find(BST T, Key key) {
		if (T == null) {
			return null;
		}

		if (T.key.equals(key)) {
			return T;
		} else if (T.key < key) {
			return find(T.right, key);
		} else {
			return find(T.left, key);
		}
	}

	public static BST insert(BST T, Key ik) {
		if (T == null) {
			return new BST(ik);
		}

		if (T.key < ik) {
			T.left = insert(T.right, ik);
		} else if (T.key > ik){
			T.right = insert(T.left, ik);
		}
		return T;
 	}
}