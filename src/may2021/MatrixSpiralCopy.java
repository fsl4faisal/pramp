package may2021;

import java.util.ArrayList;
import java.util.List;

class MatrixSpiralCopy {

  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> answer = new ArrayList<>();
    int col = matrix[0].length - 1;
    int row = matrix.length - 1;

    int direction = 0;
    int x = 0, y = 0;
    int circle = 0;
    while (true) {
      if (answer.size() == matrix.length * matrix[0].length)
        break;
      if (answer.size() + 1 == matrix.length * matrix[0].length
          && matrix.length == matrix[0].length) {
        answer.add(matrix[circle][circle]);
        break;
      }

      switch (direction % 4) {
        case 0:
          for (; y < col - circle;)
            answer.add(matrix[x][y++]);
          break;
        case 1:
          for (; x < row - circle;)
            answer.add(matrix[x++][y]);
          break;
        case 2:
          for (; y > circle;)
            answer.add(matrix[x][y--]);
          break;
        case 3:
          for (; x > circle;)// same as above
            answer.add(matrix[x--][y]);
          circle++;

          x = circle;
          y = circle;
          break;
      }
      direction++;
    }

    return answer;
  }


  public static void main(String[] args) {
    // int[][] input = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19,
    // 20}};
    // int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    // int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] input = {{1, 2, 3}};

    List<Integer> output = new MatrixSpiralCopy().spiralOrder(input);
    for (int i : output)
      System.out.print(i + ",");
    System.out.println();
  }

}
