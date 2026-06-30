class LRUCache {

    class Node{
        int key, value;
        Node prev, next;
    }

    Map<Integer, Node> cache;
    Node head, tail;
    int cap;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }

    private void addNode(Node node){
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;
    }

    private void moveToFront(Node node){
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }else {
            moveToFront(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            if(cache.size() == cap){
                Node lfu = tail.prev;
                removeNode(lfu);
                cache.remove(lfu.key);
            }
            cache.put(key, newNode);
            addNode(newNode);
        }else {
            node.value = value;
            moveToFront(node);
        }
    }
}
