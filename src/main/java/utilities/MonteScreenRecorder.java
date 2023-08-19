package utilities;

import org.monte.media.Format;
import org.monte.media.FormatKeys.*;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class MonteScreenRecorder extends ScreenRecorder
{
    public static ScreenRecorder screenRecorder;
    public String name;

    //This is the constructor of the class. It takes various parameters required for screen recording and initializes the object.
    public MonteScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                               Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    //This method is overridden from a superclass and is responsible for creating the movie file for recording.
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        }
        else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        System.out.println("Recorded Screen Cast File is Now Created");
        return new File(movieFolder,
                name + "." + Registry.getInstance().getExtension(fileFormat));
    }

    //This method starts the screen recording. It takes a parameter "methodName" which is used to name the recorded file.
    public static void startRecord(String methodName) throws Exception {
        File file = new File("./test-recordings/");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        Rectangle captureSize = new Rectangle(0, 0, width, height);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();
        screenRecorder = new MonteScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);
        screenRecorder.start();
    }
    //This method stops the screen recording.
    public static void stopRecord() throws Exception {
        screenRecorder.stop();
        System.out.println("Recorded Screen Cast File Stop Recording");
    }
}
