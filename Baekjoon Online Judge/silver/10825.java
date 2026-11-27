import java.io.*;
import java.util.*;

public class Main {
    static class Student{
        String name;
        int kor, eng, math;

        public Student(String name, String kor, String eng, String math) {
            this.name = name;
            this.kor = Integer.parseInt(kor);
            this.eng = Integer.parseInt(eng);
            this.math = Integer.parseInt(math);
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();
        String[] info;
        while (N-- > 0) {
            info = br.readLine().split(" ");
            list.add(new Student(info[0], info[1], info[2], info[3]));
        }

        // Solve
        list.sort((o1, o2) -> {
            if (o1.kor == o2.kor) {
                if (o1.eng == o2.eng) {
                    if (o1.math == o2.math)
                        return o1.name.compareTo(o2.name);
                    return o1.math < o2.math ? 1 : -1;
                }
                return o1.eng > o2.eng ? 1 : -1;
            }
            return o1.kor < o2.kor ? 1 : -1;
        });
        for (Student student : list) {
            sb.append(student.name).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
