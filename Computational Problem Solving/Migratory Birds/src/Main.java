import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static int migratoryBirds(List<Integer> arr) {
        int[] totalSightings = new int[]{-1,0,0,0,0,0};

        for (int x : arr) {
            totalSightings[x]++;
        }

        int largest = 0;
        for (int i = 1; i <= 5; i++){
            if(totalSightings[largest] < totalSightings[i])
                largest = i;
        }

        return largest;
    }
}
