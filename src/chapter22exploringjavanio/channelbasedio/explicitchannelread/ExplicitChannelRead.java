package chapter22exploringjavanio.channelbasedio.explicitchannelread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath = null;
        int loops = 0;

        // First, obtain a path to the file.
        try {
            filepath = Path.of("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter22exploringjavanio\\channelbasedio\\explicitchannelread\\test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
            return;
        }

        // Next, obtain a channel to that file within a try-with-resources block.
        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {

            // Allocate a buffer.
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                // Read the characters from the fChan channel into a buffer, mBuf.
                count = fChan.read(mBuf); // returns the number of bytes actually read.
                loops++;
                // Stop when end of file is reached.
                if (count != -1) {

                    // Rewind the buffer so that it can be read.
                    mBuf.rewind();

                    // Read bytess from the buffer and show them on the screen as characters.
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }

            } while (count != -1);

            System.out.println();

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        System.out.println("Number of loops: " + loops);
    }
}
