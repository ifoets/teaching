package interview.advance;

public class MyTreeHashMap<K extends Comparable<K>, V> {

    private static final int INITIAL_CAPACITY=4;
    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;

    private TreeNode<K,V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyTreeHashMap() {
        buckets = new TreeNode[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        buckets[index] = insert(buckets[index], key, value);
        size++;
         if((1.0*size)/ buckets.length>=LOAD_FACTOR_THRESHOLD)
        {
          resize();;
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        TreeNode<K,V> node = search(buckets[index],key);
        return node==null?null: node.value;
    }

    @SuppressWarnings("unchecked")
    public V remove(K key) {
         int index = getIndex(key);
         if(search(buckets[index],key)==null) return  null;
         TreeNode<K,V> [] temp = new TreeNode[1]; //hold the delted node
         buckets[index] = delete(buckets[index],key,temp);
         size--;
         return temp[0].value;
    }

    public int size() {
       return  size;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode())%buckets.length;
    }

    private TreeNode<K, V> insert(TreeNode<K, V> node, K key, V value) {
        if(node==null) return new TreeNode<>(key,value);
        int com = key.compareTo(node.key);

        if(com<0) node.left = insert(node.left, key,value);
        else if(com>0) node.right = insert(node.right, key, value);
        else node.value=value;//replace old value
    return node;
    }

    private TreeNode<K, V> search(TreeNode<K, V> node, K key) {
        while (node!=null)
        {
            int com = key.compareTo(node.key);
            if(com<0) node= node.left;
            else if(com>0)node = node.right;
            else return node;
        }
       return null;
    }
    @SuppressWarnings("unchecked")
    private TreeNode<K, V> delete(TreeNode<K, V> node, K key, TreeNode<K, V>[] deleted) {
        if(node==null)return  null;

        int com = key.compareTo(node.key);
        if(com<0){
            node.left = delete(node.left,key,deleted);
        }else if(com>0)
        {
            node.right = delete(node.right,key,deleted);
        }else {
            deleted[0]=node;
            if(node.left==null) return node.right;
            if(node.right==null) return node.right;

            //replace min value in right subtree and delete that
            TreeNode<K,V> min = findMin(node);
            node.key = min.key;
            node.value = min.value;
            node.right = delete(node.right,min.key,new TreeNode[1]);
        }
        return node;
    }

    private TreeNode<K, V> findMin(TreeNode<K, V> node) {
        while (node.left!=null)node=node.left;
        return node;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
         TreeNode<K, V> [] oldBucket = buckets;
         buckets = new TreeNode[oldBucket.length*2];
          size =0;
         for(TreeNode<K,V> root : oldBucket)
         {
             reinsertAll(root);
         }
    }

    private void reinsertAll(TreeNode<K, V> node) {
        if(node!=null)
        {
            put(node.key,node.value);
            reinsertAll(node.left);
            reinsertAll(node.right);
        }
    }
    public void printMap(MyTreeHashMap<K,V> map)
    {
        for(int i=0;i< map.buckets.length;i++){
            if(map.buckets[i]!=null)
                printTree(map.buckets[i]);
        }
    }

    private void printTree(TreeNode<K,V> root)
    {
        if(root!=null)
        {
            System.out.println(root.key+"="+root.value);
            printTree(root.left);
            printTree(root.right);
        }
    }
    private static class TreeNode<K,V>
    {
        K key;
        V value;
        TreeNode<K, V> left, right;

        TreeNode(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.left = this.right =null;
        }
    }
}
