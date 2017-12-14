import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class Solution {

    private static class Node {
        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    private static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return (node);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Node _root;
        int root_i = 0, root_cnt = 0, root_num = 0;
        root_cnt = in.nextInt();
        _root = null;
        for (root_i = 0; root_i < root_cnt; root_i++) {
            root_num = in.nextInt();
            if (root_i == 0)
                _root = new Node(root_num);
            else
                insert(_root, root_num);
        }

        int _x = in.nextInt();
        System.out.println(isPresent(_root, _x));
        return;
    }

    private static int isPresent(Node root, int val) {

            /* For your reference
            class Node {
                    Node left, right;
                    int data;
                            Node(int newData) {
                        left = right = null;
                        data = newData;
                    }
                }
            */

            //Navigate the Tree. Move left and right by checking the value with searchvalue

        Node current_node= root;
        int retVal=0;
        while(current_node!=null){
            if(current_node.data == val) {
                retVal=1;
                return retVal;
            }
            else if(current_node.left==null || current_node.right==null)
            {
                // End of Tree
                retVal=0;
                return retVal;
            }
            else if(val>=current_node.right.data){
                current_node = current_node.right;
            } else if(val<=current_node.left.data) {
                current_node = current_node.left;
            } else {
                //val is in between left and right nodes. Have to go through both nodes
                current_node = current_node.left; //start with left
                if(isPresent(current_node.left, val)!=1 && isPresent(current_node.right, val)!=1){
                    retVal=0;
                } else {
                    retVal=1;
                    return retVal;
                }
            }
        }

        return retVal;
    }
}