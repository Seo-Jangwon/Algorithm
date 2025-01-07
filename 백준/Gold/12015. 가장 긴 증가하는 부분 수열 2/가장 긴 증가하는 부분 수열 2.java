
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        list = new ArrayList<Integer>();

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        list.add(arr[0]);
        for (int i = 0; i < n; i++) {
            putNum(arr[i]);
        }

        bw.write(String.valueOf(list.size()));
        bw.flush();
        bw.close();

    }//end main

    static void putNum(int num) {
        int start = 0, end = list.size() - 1; //다 index
        if(list.get(end)< num) {list.add(num);}
        else{

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < num) {// 리스트의 중간값이 내가 넣어야 하는 숫자보다 작다면
                    start = mid + 1;
                } else {//리스트의 중간값이 내가 넣어야 하는 숫자보다 크거나 같다면
                    end = mid - 1;
                }
            }
            list.set(start, num);
        }
    }

}
