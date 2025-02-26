import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int age = Integer.parseInt(in[0]);
            String name = in[1];
            people[i] = new Person(age, name, i);
        }

        Arrays.sort(people);

        for (Person p : people) {
            bw.write(p.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Person implements Comparable<Person> {

        int age;
        String name;
        int date;

        public Person(int age, String name, int date) {
            this.age = age;
            this.name = name;
            this.date = date;
        }

        @Override
        public int compareTo(Person other) {
            int val = this.age - other.age;
            if (val == 0) {
                return this.date - other.date;
            } else {
                return val;
            }
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

}
