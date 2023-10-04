import java.io.*;

public class FileXOR {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java FileXOR inputFile outputFile key");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String key = args[2];

        try {
            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            int bytesRead;
            int keyIndex = 0;
            byte[] buffer = new byte[1024];

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] = (byte) (buffer[i] ^ key.charAt(keyIndex));
                    keyIndex = (keyIndex + 1) % key.length();
                }
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("File XOR encryption completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
