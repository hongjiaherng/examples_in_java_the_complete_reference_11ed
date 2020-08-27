package chapter22exploringjavanio.channelbasedio.mappedchannelread;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

class MappedChannelRead {
    public static void main(String[] args) {

        // Obtain a channel to a file within a try-with-resources block.
        try (FileChannel fChan =
                     (FileChannel) Files.newByteChannel(Path.of("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter22exploringjavanio\\channelbasedio\\mappedchannelread\\test.txt"))) {

            // Get the size of the file.
            long fSize = fChan.size();

            // Now, map the file into a buffer.
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            // Read and display bytes from buffer.
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }

            System.out.println();

        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

    }
}
