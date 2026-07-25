class BrowserHistory {
    Node current;
    
    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        current = node;
        current.next = null;
        current.prev = null;
        
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.prev = current;
        node.next = null;
        current = node;
    }
    
    public String back(int steps) {
        while(current.prev!=null && steps!=0){
            current = current.prev;
            steps--;
        }

        return current.value;
    }
    
    public String forward(int steps) {
        while(current.next!=null && steps!=0){
            current = current.next;
            steps--;
        }

        return current.value;
    }

    public class Node{
        String value;
        Node next;
        Node prev;

        public Node(String value){
            this.value = value;
        }
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */