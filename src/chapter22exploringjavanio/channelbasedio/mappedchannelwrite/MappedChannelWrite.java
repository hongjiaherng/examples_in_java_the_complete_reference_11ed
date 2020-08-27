package chapter22exploringjavanio.channelbasedio.mappedchannelwrite;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class MappedChannelWrite {
    public static void main(String[] args) {

        // Obtain a channel to a file within a try-with-resources block.
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(
                Path.of("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter22exploringjavanio\\channelbasedio\\mappedchannelwrite\\test.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE)) {

            // Then, map the file into a buffer.
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            // Write some bytes to the buffer.
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }

        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

    }
}
