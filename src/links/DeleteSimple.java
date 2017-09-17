package links;

public class DeleteSimple {
    public static void main(String[] args) {
        Node<Integer> node = new Node(2);

        System.out.println(node.hashCode());
        for(int i =0;i<5;i++) {
            addNode(node,2*i+4);
        }

        do{
            System.out.println(node.getData());
            node = node.getNext();
        }while(node!= null);


    }

    public static void addNode(Node head,int data){
        Node add = new Node(data);
        add.setNext(head);
        head = add;
        System.out.println(head.hashCode());
    }
}
