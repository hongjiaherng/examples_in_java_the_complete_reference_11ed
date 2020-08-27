package chapter27images.cropimagefilter.trysomething;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

public class Mosaic extends Frame {

    Image img;
    int imgWidth, imgHeight, croppedImgWidth, croppedImgHeight;
    Image[] cells = new Image[9 * 9];

    public Mosaic() {

        try {
            File sourceImg = new File("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter27images\\cropimagefilter\\trysomething\\sourceImage.jpg");

            // Load the image.
            img = ImageIO.read(sourceImg);

            imgWidth = img.getWidth(null);
            imgHeight = img.getHeight(null);
            croppedImgWidth = imgWidth / 9;
            croppedImgHeight = imgHeight / 9;

            CropImageFilter filter;
            FilteredImageSource filteredImageSource;

            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    filter = new CropImageFilter(x * croppedImgWidth, y * croppedImgHeight, croppedImgWidth, croppedImgHeight);
                    filteredImageSource = new FilteredImageSource(img.getSource(), filter);
                    int num = y * 9 + x;
                    cells[num] = createImage(filteredImageSource);
                }
            }

            for (int swapNum = 0; swapNum < 729; swapNum++) {
                int numOfCroppedImageA = (int) (Math.random() * 81);
                int numOfCroppedImageB = (int) (Math.random() * 81);
                Image temp = cells[numOfCroppedImageA];
                cells[numOfCroppedImageA] = cells[numOfCroppedImageB];
                cells[numOfCroppedImageB] = temp;
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
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                g.drawImage(cells[y * 9 + x], x * croppedImgWidth + getInsets().left, y * croppedImgHeight + getInsets().top, null);
            }
        }
    }

    public static void main(String[] args) {
        Mosaic imageProcessor = new Mosaic();

        imageProcessor.setSize(new Dimension(1024, 1024));
        imageProcessor.setTitle("Random Image Processor");
        imageProcessor.setVisible(true);
    }

}
