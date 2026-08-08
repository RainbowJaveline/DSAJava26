class LRUCache {
    HashMap<Integer , Node> map;
    int capacity;
    Node head = new Node();
    Node tail = new Node();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.value = -1;
        head.key = -1;
        tail.key = -1;
        tail.value = -1;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAtStart(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAtStart(node);
        }else{
            if(map.size() == capacity){
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node();
            node.value = value;
            node.key = key;
            map.put(key , node);
            insertAtStart(node);
        }
        
    }

    public void insertAtStart(Node node){
            Node currNext = head.next;
            node.next = currNext;
            node.prev = head;
            head.next = node;
            currNext.prev = node;
    }

    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
}

class Node {
    int value;
    int key;
    Node next;
    Node prev;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */