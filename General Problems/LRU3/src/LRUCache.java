import java.util.HashMap;

public class LRUCache {

    //Hashmap for storing a pointer to value

    // Doubly linked list for keeping the actual value

    class DNode {
        int key=-1;
        int value=-1;
        DNode prev;
        DNode next;

        DNode(int key, int value){

            this.key = key;
            this.value = value;
        }

    }

    int capacity;
    HashMap<Integer, DNode> hm = new HashMap<Integer, DNode>();
    DNode head= null;
    DNode tail = null;

    LRUCache(int capacity){
        this.capacity = capacity;

    }

    int get(int key){

        int val=-1;

        //Lookup hashmap and return
        DNode dn = hm.get(key);
        if(dn!=null) {
            val = dn.value;
            //TBD Move this node to Head as it just got accessed
            removeNode(dn);
            setHead(dn);
        }

        return val;

    }

    void put(int key, int value){

        //Check if present in Hashmap, if so update
        // if not add and evict if capacity is over

        //Lookup hashmap and return
        DNode dn = hm.get(key);
        if(dn!=null) {
            dn.value= value;
            //TBD set this as Head as it got accessed
            removeNode(dn);
            setHead(dn);
        } else{
            //new entry
            //Check if capacity breach
            if((hm.size()+1) >capacity){
                //TBD evict LRU - which is the Tail Node and add this to Head
                removeNode(tail);
                setHead(dn);
            } else{
                setHead(dn);
            }

            hm.put(key, dn);
        }

    }

   boolean setHead(DNode dn){
        if(dn==null) return false;
        dn.next = head;
        dn.prev = null;

        if(head!=null){
            head.prev= dn;
        }
        if(tail==null)
            tail = head;
        head=dn;

        return true;
    }

    boolean removeNode(DNode node){
        if(node==null) return false;
        DNode prevNode = node.prev;
        DNode nextNode= node.next;

        if(prevNode!=null) {
            prevNode.next = node.next;
        } else{
            //This is a head removal
            head = nextNode;
        }
        if(nextNode!=null) {
            nextNode.prev = node.prev;
        } else {
            // This is a tail removal
            tail = prevNode;
        }


        return true;
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        LRUCache obj = new LRUCache(2);
        int param_1 = obj.get(1);
         obj.put(2,2);
    }
}
