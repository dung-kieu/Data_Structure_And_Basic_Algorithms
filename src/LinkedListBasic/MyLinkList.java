package LinkedListBasic;



public class MyLinkList {
    private Node head;
    private int numNodes;

    public MyLinkList(Object data){
        head = new Node(data);
    }

    private class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    public void add(int index , Object data){
        Node temp = head;
        Node holder;

        for (int i = 0; i  < index-1 && temp.next != null ; i++){
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;

    }

    public void AddFirst(Object data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("/=/=/= Testing /=/=/=");
        MyLinkList ll = new MyLinkList(10);
        ll.AddFirst(11);
        ll.AddFirst(12);
        ll.AddFirst(13);

        ll.add(7,3);
        ll.add(8,9);
        ll.printList();
    }
}
