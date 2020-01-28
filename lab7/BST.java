public class BST<K extends Comparable<K>, V> {
    private Node root;
    public class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Node(){

        }
    }
    public BST() {
    }

    public BST(K k, V v) {
        root.key = k;
        root.value = v;
    }

    public BST(K key, V value, Node left, Node right) {
        root.key = key;
        root.value = value;
        root.left = left;
        root.right = right;
    }

    public V getValue(K key) {
        return getValue(root, key);
    }

    private V getValue(Node node, K key) {
        if (key == null) {
            throw new IllegalArgumentException("can't get a null key!");
        }
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) < 0) {
            return getValue(node.right, key);
        } else if (node.key.compareTo(key) > 0) {
            return getValue(node.left, key);
        } else {
            return node.value;
        }

    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("can't put null key!");
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);

    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (node.key.compareTo(key) < 0) {
            node.right = put(node.right, key, value);
        } else if (node.key.compareTo(key) > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("call delete() with a null key!");
        }
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return node;
        }
        if (node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else if (node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            // not to happen

        }
        return node;
    }

    public Node find(K key) {
        if (key == null) {
            throw new IllegalArgumentException("find a null key!");
        }
        return find(root, key);
    }

    private Node find(Node node, K key) {
        if (node == null) {
            return node;
        }
        if (node.key.compareTo(key) < 0) {
            return find(node.right, key);
        } else if (node.key.compareTo(key) > 0) {
            return find(node.left, key);
        } else {
            return node;
        }
    }


}