package nurefsanalbas_;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author nurefsanalbas
 */
public class BinarySearchTree {

    Node root;

    void insert(String newData) {// Insert function in binary search tree.
        if (root == null) {
            root = new Node(newData);//If we have any root that creates new node which called root.
            root.count++;//This calculates number of each words.
        } else {
            Node temp = root;
            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {//If the first letter of the word comes later than the node in the alphabet, 
                    //it is written to the right of it.
                    if (temp.right == null) {
                        temp.right = new Node(newData);
                        temp.right.count++;//This calculates number of each words in right subtree.
                        return;
                    }
                    temp = temp.right;//Allows traversal over nodes on the right.
                } else if (newData.compareTo(temp.data) < 0) {//If the first letter of the word comes earlier than the node in the alphabet, 
                    //it is written to the left of it.
                    if (temp.left == null) {
                        temp.left = new Node(newData);
                        temp.left.count++;//This calculates number of each words in left subtree.
                        return;
                    }
                    temp = temp.left;//Allows traversal over nodes on the left.
                } else {
                    temp.count++;//If there any same words this condition runs and this calculates number of each words which are same.
                    return;
                }
            }
        }
    }

    void preorder(Node node, PrintStream printStream) throws IOException {
        if (node != null) {
     //        printStream.println(node.data);
            printStream.println(node.data + "," + node.count); //That works like system.out.println on file.
            preorder(node.left, printStream);//That allows traversal on left subtree and write them in output file with printStream.
            preorder(node.right, printStream);//That allows traversal on right subtree and write them in output file with printStream.
          
        }
    }

}
