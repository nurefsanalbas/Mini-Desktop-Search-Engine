package nurefsanalbas_;

import java.io.File;

/**
 *
 * @author nurefsanalbas
 */
public class MyFile extends File {

    public String filename;//I kept filename
    public int rv;// and relevance value

    public MyFile(String filename) {
        super(filename);
        this.filename = filename;
        this.rv = rv;
    }
}
