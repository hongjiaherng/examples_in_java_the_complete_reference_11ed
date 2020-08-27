package chapter27images.histograb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

public class HistoGrab extends Frame {
    Dimension d;
    Image img;
    int iw, ih;
    int[] pixels;
    int[] hist = new int[256];
    int max_hist = 0;
    Insets ins;

    public HistoGrab() {
        try {
            // C:\Users\USER\Downloads\Hibiscus (1).jpg
            // C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter27images\\histograb\\waterlilies (1).jpg
            File imageFile = new File("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter27images\\histograb\\Hibiscus (1).jpg");

            // Load the image.
            img = ImageIO.read(imageFile);

            iw = img.getWidth(null);
            ih = img.getHeight(null);
            pixels = new int[iw * ih]; // Array size: 152000
            PixelGrabber pg = new PixelGrabber(img, 0, 0, iw, ih, pixels, 0, iw);
            pg.grabPixels();

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            return;
        } catch (IOException e) {
            System.out.println("Cannot load image file.");
            System.exit(0);
        }

        for (int i = 0; i < iw * ih; i++) {
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);
            int y = (int) (.33 * r + .56 * g + .11 * b); // ??
            hist[y]++;
        }

        for (int i = 0; i < 256; i++) {
            if (hist[i] > max_hist) {
                max_hist = hist[i];
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // Get the border/header insets.
        ins = getInsets();

        g.drawImage(img, ins.left, ins.top, null);

        int x = (iw - 256) / 2;
        int lasty = ih - ih * hist[0] / max_hist;

        for (int i = 0; i < 256; i++, x++) {
            int y = ih - ih * hist[i] / max_hist;

            // Draw the histogram.
            // The color of each histogram bar will turn from black to white along with the increasing value of i
            g.setColor(new Color(i, i, i));
            g.fillRect(x + ins.left, y + ins.top, 1, ih - y);

            // Draw the outline of the histogram.
            g.setColor(Color.red);
            g.drawLine((x - 1) + ins.left, lasty + ins.top, x + ins.left, y + ins.top);
            lasty = y;


        }
    }

    public static void main(String[] args) {
        HistoGrab appwin = new HistoGrab();

        appwin.setSize(new Dimension(400, 380));
        appwin.setTitle("HistoGrab");
        appwin.setVisible(true);
    }
}
