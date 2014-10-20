/* Two folders that contains different images with same name and the third folder that will be created.
Two images of same name from first two folder will be copied in a folder with same name as images that
it contains within a third folder. */

package Testing;

/**
 * Created by om on 10/20/2014.
 */
import java.io.*;

public class Screen_Wraith {
    public static void main(String[] args) throws IOException {
        File folder1 = new File("C:\\Users\\om\\Downloads\\Programs\\etc\\Screen\\f_1");
        File folder2 = new File("C:\\Users\\om\\Downloads\\Programs\\etc\\Screen\\f_2");
        // An array will be create that will have the list of image names of folder.
        File[] listOfFiles1 = folder1.listFiles();
        File[] listOfFiles2 = folder2.listFiles();
        for (int i = 0 ; i < listOfFiles1.length ; i++) {
            // Through FileInputStream a file can be read.
            InputStream in1 = new FileInputStream(listOfFiles1[i]);
            InputStream in2 = new FileInputStream(listOfFiles2[i]);

            // Get the name of file.
            String file_name = listOfFiles1[i].getName();
            file_name = file_name.substring(0, file_name.lastIndexOf("."));
            // Create the folder as same as file name.
            File dir = new File("C:\\Users\\om\\Downloads\\Programs\\etc\\Screen\\f_3\\" + file_name);
            dir.mkdir();

            File image1 = new File("C:\\Users\\om\\Downloads\\Programs\\etc\\Screen\\f_3\\" + file_name + "\\" + file_name + "_1.png");
            File image2 = new File("C:\\Users\\om\\Downloads\\Programs\\etc\\Screen\\f_3\\" + file_name + "\\" + file_name + "_2.png");
            // Through FileOutputStream a file can be write.
            OutputStream out1 = new FileOutputStream(image1);
            OutputStream out2 = new FileOutputStream(image2);

            // It will read the data from one file and then write to another file.
            byte[] buf1 = new byte[1024];
            int len1;
            while ((len1 = in1.read(buf1)) > 0) {
                out1.write(buf1, 0, len1);
            }
            byte[] buf2 = new byte[1024];
            int len2;
            while ((len2 = in2.read(buf2)) > 0) {
                out2.write(buf2, 0, len2);
            }
            in1.close();
            in2.close();
            out1.close();
            out2.close();
        }
    }
}