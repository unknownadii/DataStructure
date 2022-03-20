package HeapAndPriorityQueue.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair> {
        int listIndex, dataIndex, data;

        public Pair(int listIndex, int dataIndex, int data) {
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return this.data - o.data;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> returningList = new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            queue.add(p);
        }
        while (queue.size() > 0) {
            Pair temp = queue.remove();
            returningList.add(temp.data);
            temp.dataIndex++;
            //checking list size
            if (temp.dataIndex < lists.get(temp.listIndex).size()) {
                temp.data = lists.get(temp.listIndex).get(temp.dataIndex);
                queue.add(temp);
            }
        }
        return returningList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of lists");
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            System.out.println("Enter length for list "+ (i+1));
            int n = Integer.parseInt(br.readLine());
            System.out.println("Enter values for " + i + "th list");
            String[] elements = br.readLine().split(",");
            for (int j = 0; j < elements.length; j++) {
                list.add(Integer.parseInt(elements[j]));
            }
            lists.add(list);
        }

        ArrayList<Integer> mergeList = mergeKSortedLists(lists);
        for (int val : mergeList) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
