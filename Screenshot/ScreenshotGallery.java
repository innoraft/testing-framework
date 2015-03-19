package Screenshot;

import java.io.IOException;

/**
 * Created by om on 2/3/2015.
 */
public class ScreenshotGallery {
    public static void main(String[] args) throws IOException {
        String Path = "TestingFiles\\Screenshots\\HCL\\HCL_DemoLiveDriver_DemoProdDriver";

        ScreenshotFunctions func = new ScreenshotFunctions();
        func.RenameFilesAfterScreenshotComparision(Path);
    }
}
