import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) throws IOException {
        File file = new File("Student.csv");
        InputStream input = new FileInputStream(file);
        ArrayList<HashMap<String, Object>> csv = Parsing.parseCSV(input);

        System.out.println("All GPA");
        csv.stream().map(m -> m.entrySet()
                .stream()
                .filter(map -> map.getKey().equals("GPA"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
        ).forEach(System.out::println);

        System.out.println("BIO GPA");
        csv.stream().map(m -> m.entrySet()
                .stream()
                .filter(map -> map.getValue().equals("BIO"))
                .map(entry -> m.get("GPA"))
                .collect(Collectors.toList())
        ).forEach(s -> {
            if(!s.isEmpty())
                System.out.println(s);
        });

        System.out.println("Stat Report");
        Averager average = csv.stream().map(m -> m.entrySet()
                .stream()
                .filter(map -> !map.getValue().equals("MAS"))
                .map(entry -> (Double)m.get("GPA"))
                .collect(Collectors.toList())
        ).map(entry -> entry.get(0)).collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println(average.average());

        StandardDev stdDev = csv.stream().map(m -> m.entrySet()
                .stream()
                .filter(map -> !map.getValue().equals("MAS"))
                .map(entry -> (Double)m.get("GPA"))
                .collect(Collectors.toList())
        ).map(entry -> entry.get(0)).collect(StandardDev::new, StandardDev::accept, StandardDev::combine);
        System.out.println(stdDev.standardDev());

        System.out.println("GPA by Major");
        csv.stream().map(m -> m.entrySet()
                .stream()
                .collect(Collectors.groupingBy(map -> m.get("Major"),
                        Collectors.averagingDouble(entry -> (double) m.get("GPA"))))
        )
                .collect(Collectors.groupingBy(Map::keySet))
                .forEach((a, b) -> System.out.println(a + " " + b));
    }

    static class Averager implements DoubleConsumer {
        private double total = 0;
        private double count = 0;

        public double average() {
            return count > 0 ? ((double) total)/count : 0;
        }

        public void accept(double i) { total += i; count++; }
        public void combine(Averager other) {
            total += other.total;
            count += other.count;
        }
    }

    static class StandardDev implements DoubleConsumer{
        private double sumSquare = 0;
        private double sum = 0;
        private double count = 0;

        @Override
        public void accept(double value) {
            sumSquare += value * value;
            sum += value;
            count++;
        }

        public void combine(StandardDev other){
            sumSquare += other.sumSquare;
            sum += other.sum;
            count += other.count;
        }

        public double standardDev(){
            return Math.sqrt((((count * sumSquare) - (sum * sum)) / (count * (count - 1))));
        }
    }
}
