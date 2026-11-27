import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        Student[] rank = new Student[N];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; ++i) {
            rank[i] = new Student(arr[i], i + 1);
        }
        Arrays.sort(rank);

        // Solve
        StringBuilder sb = new StringBuilder();
        for (Student student : rank) {
            sb.append(student.finalGrade - student.midGrade).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}

class Student implements Comparable<Student>{
    int midGrade;
    int finalGrade;

    public Student(int finalGrade, int midGrade) {
        this.finalGrade = finalGrade;
        this.midGrade = midGrade;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.finalGrade, other.finalGrade);
    }
}
