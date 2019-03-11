import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner scan = new Scanner(file);

    String[] RCEN = scan.nextLine().split(" ");
    int r = Integer.parseInt(RCEN[0]);
    int c = Integer.parseInt(RCEN[1]);
    int e = Integer.parseInt(RCEN[2]);
    int n = Integer.parseInt(RCEN[3]);

    int[][] lake = new int[r][c];
    for(int i = 0; i < r; i++){
      for (int j = 0; j < c; j++){
        lake[i][j] = scan.nextInt();
      }
    }

    int[][] directions = new int[n][3];
    for(int i = 0; i < n; i++){
      for (int i2 = 0; i2 < 3; i2++){
        directions[i][i2] = scan.nextInt();
        System.out.println(directions[i][i2]);
      }
    }

    for (int dir = 0; dir < directions.length; dir++){
      int row = directions[dir][0] - 1;
      int col = directions[dir][1] - 1;
      int subtract = directions[dir][2];
      int max = 0;

      for (int i = row; i-row < 3 && i < r; i++){
        for (int j = col; j-col < 3 && j < c; j++){
          if (lake[i][j] > max){
            max = lake[i][j];
          }
        }
      }

      max -= subtract;

      for (int i = row; i-row < 3 && i < r; i++){
        for (int j = col; j-col < 3 && j < c; j++){
          if (lake[i][j] > max){
            lake[i][j] = max;
          }
        }
      }

      for (int r1 = 0; r1 < lake.length; r1++){
        for (int c1 = 0; c1 < lake[0].length; c1++){
          System.out.print(lake[r1][c1] + " ");
        }
        System.out.print("\n");
      }
    }


    int totDepth = 0;
    for (int row = 0; row < lake.length; row++){
      for (int col = 0; col < lake[0].length; col++){
        if (e - lake[row][col] > 0){
          totDepth += e - lake[row][col];
        }
      }
    }

    return totDepth * 72 * 72;
  }

  public static int silver(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner scan = new Scanner(file);

    int n = scan.nextInt();
    int m = scan.nextInt();
    int t = scan.nextInt();
    scan.nextLine();

    String[][] field = new String[n][m];
    for (int i = 0; i < n; i++){
      String line = scan.nextLine();
      for (int i2 = 0; i2 < m; i2++){
        field[i][i2] = line.substring(i2, i2+1);
      }
    }

    int r1 = scan.nextInt() - 1;
    int c1 = scan.nextInt() - 1;
    int r2 = scan.nextInt() - 1;
    int c2 = scan.nextInt() - 1;

    int[][] moveOn = new int[n][m];

    field[r1][c1] = "1";
    moveOn[r1][c1] = 1;
    for (int r = 0; r < n; r ++){
      for (int c = 0; c < m; c++){
        if (field[r][c].equals("*")){
          moveOn[r][c] = -1;
        }
      }
    }
    for (int i=0; i<n; i++){
      System.out.println(" ");
      for(int j=0; j<m; j++){
        System.out.print(field[i][j] + " ");
      }
    }
    for (int r = 0; r < n; r ++){
      System.out.println("");
      for (int c = 0; c < m; c++){
        System.out.print(moveOn[r][c] + " ");
      }
    }

      for (int currentMove = 1; currentMove <= t; currentMove++){
        for(int r = 0; r < n; r ++){
          for (int c = 0; c < m; c ++) {
            if (moveOn[r][c] == currentMove){
              moveOn[r][c] = 0;
              int[] nextMoves = {1, 0, -1, 0, 0, 1, 0, -1};
              for (int i = 0 ; i < nextMoves.length; i = i + 2){
                int rF = r + nextMoves[i];
                int cF = c + nextMoves[i+1];
                if (rF >= 0 && rF < n && cF >= 0 && cF < m){
                  if (field[rF][cF].equals(".")){
                    field[rF][cF] = field[r][c];
                    moveOn[rF][cF] = currentMove + 1;
                  }else if (!(field[rF][cF].equals("*"))){
                    field[rF][cF] = "" + (Integer.parseInt(field[rF][cF]) + Integer.parseInt(field[r][c]));
                    moveOn[rF][cF] = currentMove + 1;
                  }
                }
              }
              field[r][c] = "0";
              if (currentMove == 1){
                field[r][c] = "0";
              }
            }
          }
        }
        System.out.println(currentMove);
        for (int r = 0; r < n; r ++){
          System.out.println("");
          for (int c = 0; c < m; c++){
            System.out.print(field[r][c] + " ");
          }
        }
        System.out.println(" ");
        for (int r = 0; r < n; r ++){
          System.out.println("");
          for (int c = 0; c < m; c++){
            System.out.print(moveOn[r][c] + " ");
          }
        }
    }
    System.out.println("incoming");
    return Integer.parseInt(field[r2][c2]);
  }
}
