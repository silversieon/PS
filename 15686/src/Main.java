import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] city, distance;
    static boolean[][] visitied;
    static StringTokenizer st;
    static HashMap<Point, Integer> hash = new HashMap<>();
    static ArrayList<Point> houseList = new ArrayList<>(), chickenList = new ArrayList<>();
    static void chickenValueCalculate(){
        for(Point chicken : chickenList){
            int chickenX = (int)chicken.getX();
            int chickenY = (int)chicken.getY();
            hash.put(chicken, 0);
            for(Point house : houseList){
                int houseX = (int)house.getX();
                int houseY = (int)house.getY();
                hash.put(chicken, hash.get(chicken) + Math.abs(chickenX - houseX) + Math.abs(chickenY - houseY));
            }
        }
        System.out.println(hash.values());
        for(int i=0; i<chickenList.size()-M; i++){
            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        visitied = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int k = Integer.parseInt(st.nextToken());
                if(k==1){
                    houseList.add(new Point(i, j));
                } else if (k==2){
                    chickenList.add(new Point(i, j));
                }
                city[i][j] = k;
            }
        }
        distance = new int[houseList.size()][chickenList.size()];
        chickenValueCalculate();
    }
}
