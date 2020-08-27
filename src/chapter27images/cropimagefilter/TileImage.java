package chapter27images.cropimagefilter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

public class TileImage extends Frame {
    Image img;
    Image cell[] = new Image[4*4];
    int iw, ih;
    int tw, th;

    public TileImage() {
        try {
            File imageFile = new File("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter27images\\cropimagefilter\\Hibiscus.jpg");

            // Load the image.
            img = ImageIO.read(imageFile);

            iw = img.getWidth(null);
            ih = img.getHeight(null);
            tw = iw / 4;
            th = ih / 4;

            CropImageFilter f;
            FilteredImageSource fis;

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    f = new CropImageFilter(tw * x, th * y, tw, th);
                    fis = new FilteredImageSource(img.getSource(), f);
                    int i = y * 4 + x;
                    cell[i] = createImage(fis);
                }
            }

            for (int i = 0; i < 32; i++) {
                int si = (int) (Math.random() * 16);
                int di = (int) (Math.random() * 16);
                Image tmp = cell[di];
                cell[si] = cell[di];
                cell[di] = tmp;
            }

        } catch (IOException e) {
            System.out.println("Cannot load image file.");
            System.exit(0);
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
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                g.drawImage(cell[y*4+x], x * tw + getInsets().left, y * th + getInsets().top, null);
            }
        }
    }

    public static void main(String[] args) {
        TileImage appwin = new TileImage();

        appwin.setSize(new Dimension(420, 420));
        appwin.setTitle("TileImage");
        appwin.setVisible(true);
    }
}
