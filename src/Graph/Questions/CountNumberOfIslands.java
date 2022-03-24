package Graph.Questions;

public class CountNumberOfIslands {
    public static void main(String[] args) {
        int arr[][]={
                {0,0,1,1,1},
                {0,0,1,1,1},
                {1,1,0,0,1},
                {1,1,1,1,1},
                {1,1,0,0,1},
                {1,1,0,0,1},
        };
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    gcc(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void gcc(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length ||
                arr[i][j] == 1 || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;
        gcc(arr, i + 1, j, visited);
        gcc(arr, i, j + 1, visited);
        gcc(arr, i - 1, j, visited);
        gcc(arr, i, j - 1, visited);
    }
}
