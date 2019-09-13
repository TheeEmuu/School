import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;

public class ProjectServer {
    private static HashSet<String> dictionary;

    static class Handle extends Thread {
        Socket clientSocket;

        public void go(Socket client){
            clientSocket = client;

            this.start();
        }

        @Override
        public void run(){
            try (
                OutputStream out = clientSocket.getOutputStream();
                InputStream in = clientSocket.getInputStream();
            ) {
                System.out.println("Client connected on port " + clientSocket.getPort());
                while(true) {
                    int code = in.read();

                    if (code == 1)
                        break;
                    else if (code == 0) {
                        byte[] arrr = new byte[4];
                        in.read(arrr);
                        int length = ByteBuffer.wrap(arrr).getInt();

                        String[] arr = new String[length];

                        for(int i = 0; i < length; i++){
                            arr[i] = Character.toString((char)in.read());
                        }

                        StringBuilder build = new StringBuilder();
                        for(int i = 0; i < arr.length; i++){
                            build.append(arr[i]);
                        }
                        String word = build.toString();

                        if (checkSpelling(word))
                            send("correct", out);
                        else
                            send("misspelled", out);
                    }
                }

                System.out.println("Client on port " + clientSocket.getPort() + " closed");
            } catch (IOException e) { }
        }

        private void send(String word, OutputStream out) throws IOException{
            out.write(new byte[]{2});

            out.write(ByteBuffer.allocate(4).putInt(word.length()).array());

            out.write(word.getBytes());
        }

        private boolean checkSpelling(String word){
            return dictionary.contains(word);
        }
    }

    public static void main(String[] args) throws IOException{
        int portNumber = 6969;

        System.out.println("Initializing...");
        ServerSocket serverSocket = new ServerSocket(portNumber);

        dictionary = new HashSet<>();

        File dict = new File("words");
        BufferedReader in = new BufferedReader(new FileReader(dict));

        String st;
        while((st = in.readLine()) != null)
            dictionary.add(st);

        System.out.println("Awaiting Connection");
        while(true){
                Socket clientSocket = serverSocket.accept();

                Handle h = new Handle();

                h.go(clientSocket);
        }
    }
}
