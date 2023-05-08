package bstmap;

import java.util.Iterator;
import java.util.Set;

/** Map的本质是通过key得到value的数据结构
 * BST表示value的组织方式
 * */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTNode root;
    private int size;


    private class BSTNode {
        K key;
        V val;
        BSTNode lchild;
        BSTNode rchild;

        public BSTNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return containKey(key, root);
    }

    private boolean containKey(K key, BSTNode node) {
        if (node != null && key.equals(node.key))
            return true;

        if (node == null)
            return false;

        return containKey(key, node.lchild) || containKey(key, node.rchild);
    }

    @Override
    public V get(K key) {
        if (!containsKey(key))
            return null;

        return get(key, root);
    }

    private V get(K key, BSTNode node) {
        /* get(K key) 只是一个入口，并不能规避(node == null), 所以一开始需要if*/
        if (node == null)
            return null;

        if (key.equals(node.key))
            return node.val;

        if (key.compareTo(node.key) < 0) {
            return get(key, node.lchild);
        } else {
            return get(key, node.rchild);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new BSTNode(key, value);
            this.size++;
        }
        if (!containsKey(key))
            put(key, value, root);
    }

    private void put(K key, V value, BSTNode node) {
        if (key.compareTo(node.key) < 0) {
            if (node.lchild == null) {
                node.lchild = new BSTNode(key, value);
                size++;
                return;
            }
            put(key, value, node.lchild);
        } else {
            if (node.rchild == null) {
                node.rchild = new BSTNode(key, value);
                size++;
                return;
            }
            put(key, value, node.rchild);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printInOrder(BSTNode node) {
        /*System.out.println(node.val);
        if (node.lchild != null) printSelf(node.lchild);
        if (node.rchild != null) printSelf(node.rchild);*/

        if (node == null) {
            return;
        }
        printInOrder(node.lchild);
        System.out.println(node.key.toString() + " -> " + node.val.toString());
        printInOrder(node.rchild);
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }
}
