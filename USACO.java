import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename){
    File file = new File(filename);
    Scanner scan = new Scanner(file);

    String RCEN = scan.nextLine().split(" ");
    int r = parseInt[0];
    int c = parseInt[1];
    int e = parseInt[2];
    int n = parseInt[3];

    int[][] lake = new int[r][c];
    for(int i = 1; i <= r; i++){
      for (int j = 0; j < c; c++){
        lake[i][j] = scan.nextInt();
      }
    }

    int[][] directions = new int[n][3];
    for(int i = r+1; r <= n; r ++){
      for (int i2 = 0; i2 < 3; i2++){
        directions[i][i2] = scan.nextInt();
      }
    }


  }

  public static int silver(String filename){
    File file = new File(filename);
    Scanner scan = new Scanner(file);

    return 0;
  }
}
