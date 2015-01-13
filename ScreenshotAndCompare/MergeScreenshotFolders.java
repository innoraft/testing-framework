package Testing;

import Testing.ScreenshotFunctions;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import Testing.ScreenshotFunctions.*;

/**
 * Created by om on 11/7/2014.
 */
public class MergeScreenshotFolders {
    public static void main(String[] args) throws IOException {
        String Sitelevel1 = "Test";
        String Sitelevel2 = "Mt";
        String Site = "HCL";
        String Path = "Screenshots\\" + Site + "\\";

        ScreenshotFunctions func = new ScreenshotFunctions();
        func.Folder_Setup(Sitelevel1, Sitelevel2, Site, Path);

        /**
         * After merge the screenshots of two sitelevel, we will do screenshot comparision.
         * 1. First specify the folder name with path in config file that contain screenshots.
         * 2. Open console and move to folder that contains screenshots.
         * 3. Run command "wraith crop_images configFileName" to cut the images at same height.
         * 4. Run command "wraith compare_images configFileName" to generate diff image.
         */
    }
}
