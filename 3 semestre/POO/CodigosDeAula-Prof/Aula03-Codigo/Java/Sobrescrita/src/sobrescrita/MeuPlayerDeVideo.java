 // Example 21.7: MediaTest.java
// A simple media player
package sobrescrita;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import sobrescrita.MeuPlayer;

public class MeuPlayerDeVideo extends MeuPlayer{
    // launch the application

    public void Toca(String sFileName) {
        // create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // show open file dialog
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) // user chose a file
        {
            URL mediaURL = null;

            try {
                // get the file as URL
                mediaURL = fileChooser.getSelectedFile().toURL();
            } // end try
            catch (MalformedURLException malformedURLException) {
                System.err.println("Could not create URL for the file");
            } // end catch

            if (mediaURL != null) // only display if there is a valid URL
            {
                JFrame mediaTest = new JFrame("Media Tester");
                mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                MediaPanel mediaPanel = new MediaPanel(mediaURL);
                mediaTest.add(mediaPanel);

                mediaTest.setSize(300, 300);
                mediaTest.setVisible(true);
            } // end inner if
        } // end outer if
    } // end main
} // end class MediaTest
