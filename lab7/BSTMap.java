import java.util.Iterator;
import java.util.Set;

public class BSTMap <K extends Comparable<K>, V> implements Map61B<K, V> {

    private int size;
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

    public BSTMap() {
        root = null;
        size = 0;
    }

    public BSTMap(K key, V value) {
        root = new Node(key, value);
        size = 1;
    }
    @Override
    public void clear()
    {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("can not find null value !");
        }

        return find(root, key) != null;
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

    @Override
    public V get(K key) {
        Node T = find(root, key);
        if (T != null) {
            return T.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("can not put null key!");
        }
        if (root == null) {
            root = new Node(key, value);
            size += 1;
            return;
        }
        put(root, key, value);
        size += 1;
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

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("unsupport");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("unsupport");
    }


    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("unsupport");
    }
}
