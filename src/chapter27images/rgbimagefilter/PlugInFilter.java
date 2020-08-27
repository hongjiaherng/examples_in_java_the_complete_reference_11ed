package chapter27images.rgbimagefilter;

import java.awt.*;

interface PlugInFilter {
    Image filter(Frame f, Image in);
}
