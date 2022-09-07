package nurefsanalbas_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nurefsanalbas
 *  PROJE3
 */
public class NurefsanAlbas_ {

    static int rv = 0;
    static MinHeap<String> heap = new MinHeap(10);

    public static int searchInFile(String fileName, String word) throws FileNotFoundException {
        //In this method, my goal is to split the text I received from the user into parts and see if it is in the file.
        rv = 0;//This took relevance value;
        FileReader fileReader = new FileReader(fileName);
        Scanner sc = new Scanner(fileReader);
        int flag = 0;
        while (sc.hasNext()) {

            String a = sc.next();
            String wordArr[] = word.split("\s");//Array where the text I get from the user is split and assigned according to the blanks.
            String docArr[] = a.split(",");//An array that splits the data in the file containing the vocabulary and frequency I prepared in the 2nd project according to ",". 
            //According to this array, docArr[0], before "," gives us the word; docArr[1] returns the frequency.

            for (int i = 0; i < wordArr.length; i++) {
                if (wordArr[i].equals(docArr[0])) {//if one of the words entered by the user is equal to one of the words in the file,
                    int freq = Integer.parseInt(docArr[1]);
                    rv += freq;//I add the frequency to rv to calculate the relevance value of that word. (For two or more words rv calculate like this.)
                    //I have defined rv as static so it always adds on the last value.
                    flag = 1;//I used the flag to use the calculated rv in the other method.
                }
            }
        }
        if (flag == 1) {//At the same time, returning 1 from the flag shows that the word is in the file and helps us while adding it to the heap.
            return 1;
        } else {
            return 0;
        }
    }

    public static void Operation(MyFile[] fileArray, String word) throws FileNotFoundException {
//Here, I send each file to my searchInFile method by looping over the file array I created in main,
//and according to the 1 or 0 returned from it, the file array i. to the heap I am inserting this.
        for (int i = 0; i < fileArray.length; i++) {
            if (searchInFile(fileArray[i].filename, word) == 1) {
                fileArray[i].rv = rv;
                heap.insert(fileArray[i]);
            }
        }
        heap.SortAndPrintHeap();//Here I sorting and printing heap.
    }

    public static void ReadToFile(String fileName, BinarySearchTree bst) throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader(fileName);//I create a fileReader object to read the file.
        Scanner sc = new Scanner(fileReader);//I read file with scanner, in this way I can read word by word.
        ArrayList<String> ignoreList = ReadToIgnoreList();//This holds the numbers read by the ignoreList.txt file returned from ReadToIgnoreList.
        ArrayList<String> htmlList = new ArrayList<String>();//This list holds ignore html tags and punctuations.
        htmlList.add("<DOC>");
        htmlList.add("<DOCNO>");
        htmlList.add("</DOCNO>");
        htmlList.add("<TITLE>");
        htmlList.add("</TITLE>");
        htmlList.add("<AUTHOR>");
        htmlList.add("</AUTHOR>");
        htmlList.add("<BIBLIO>");
        htmlList.add("</BIBLIO>");
        htmlList.add("<TEXT>");
        htmlList.add("</TEXT>");
        htmlList.add("</DOC>");
        htmlList.add(".");
        htmlList.add(",");

        while (sc.hasNext()) {//This read text end of the file.
            String word = sc.next();//In next() method we can read word by word.
            if (!(ignoreList.contains(word)) && !(htmlList.contains(word))) {//If word equals in word which is not in ignoreList,
                bst.insert(word);                                         //I inserted it in binary search tree.
            }
        }
    }

    public static ArrayList<String> ReadToIgnoreList() throws FileNotFoundException, IOException {
//This method reads ignoreList.txt and add ignoreList to an arrayList and it returns ignoreLineList
        FileReader fR = new FileReader("ignoreList.txt");
        ArrayList<String> ignoreLineList = new ArrayList<String>();
        BufferedReader br2 = new BufferedReader(fR);
        String ignoreLine;
        while ((ignoreLine = br2.readLine()) != null) {//That reads line to end of the file
            ignoreLineList.add(ignoreLine);//And add lines to ignoreLineList.
        }
        br2.close();
        return ignoreLineList;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Which word do you want to search?");
        String word = s.nextLine();
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();
        BinarySearchTree tree3 = new BinarySearchTree();
        BinarySearchTree tree4 = new BinarySearchTree();
        BinarySearchTree tree5 = new BinarySearchTree();
        BinarySearchTree tree6 = new BinarySearchTree();
        BinarySearchTree tree7 = new BinarySearchTree();
        BinarySearchTree tree8 = new BinarySearchTree();
        BinarySearchTree tree9 = new BinarySearchTree();
        BinarySearchTree tree10 = new BinarySearchTree();

        //Test for first html file
        ReadToFile("cse22501.html", tree1);
        PrintStream p1 = new PrintStream("doc1.txt");
        tree1.preorder(tree1.root, p1);

        //Test for second html file
        ReadToFile("cse22502.html", tree2);
        PrintStream p2 = new PrintStream("doc2.txt");
        tree2.preorder(tree2.root, p2);

        //Test for third html file
        ReadToFile("cse22503.html", tree3);
        PrintStream p3 = new PrintStream("doc3.txt");
        tree3.preorder(tree3.root, p3);

        //Test for fourth html file
        ReadToFile("cse22504.html", tree4);
        PrintStream p4 = new PrintStream("doc4.txt");
        tree4.preorder(tree4.root, p4);

        //Test for fifth html file
        ReadToFile("cse22505.html", tree5);
        PrintStream p5 = new PrintStream("doc5.txt");
        tree5.preorder(tree5.root, p5);

        //Test for sixth html file
        ReadToFile("cse22506.html", tree6);
        PrintStream p6 = new PrintStream("doc6.txt");
        tree6.preorder(tree6.root, p6);

        //Test for seventh html file
        ReadToFile("cse22507.html", tree7);
        PrintStream p7 = new PrintStream("doc7.txt");
        tree7.preorder(tree7.root, p7);

        //Test for eightth html file
        ReadToFile("cse22508.html", tree8);
        PrintStream p8 = new PrintStream("doc8.txt");
        tree8.preorder(tree8.root, p8);

        //Test for nineth html file
        ReadToFile("cse22509.html", tree9);
        PrintStream p9 = new PrintStream("doc9.txt");
        tree9.preorder(tree9.root, p9);

        //Test for tenth html file
        ReadToFile("cse22510.html", tree10);
        PrintStream p10 = new PrintStream("doc10.txt");
        tree10.preorder(tree10.root, p10);

        //I created objects from my own MyFile class, which inherited from the File class.
        MyFile m1 = new MyFile("doc1.txt");
        MyFile m2 = new MyFile("doc2.txt");
        MyFile m3 = new MyFile("doc3.txt");
        MyFile m4 = new MyFile("doc4.txt");
        MyFile m5 = new MyFile("doc5.txt");
        MyFile m6 = new MyFile("doc6.txt");
        MyFile m7 = new MyFile("doc7.txt");
        MyFile m8 = new MyFile("doc8.txt");
        MyFile m9 = new MyFile("doc9.txt");
        MyFile m10 = new MyFile("doc10.txt");

        MyFile fileArray[] = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10};
        Operation(fileArray, word);//Operation method made all operation which required for project 3.

    }
}
