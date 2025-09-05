import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st;
				int N = Integer.parseInt(br.readLine());
				int[] arr = new int[N];
				
				String s1 = br.readLine();
				st = new StringTokenizer(s1);
				
				for(int i=0; i<N; i++){
					arr[i] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(arr);
				
				int M = Integer.parseInt(br.readLine());
				String s2 = br.readLine();
				st = new StringTokenizer(s2);
				StringBuilder sb = new StringBuilder();
				
				for(int i=0; i<M; i++){
					if(binarySearch(arr, Integer.parseInt(st.nextToken()))>=0){
						sb.append(1).append("\n");
						}
					else{
						sb.append(0).append("\n");
					}
				}
                System.out.print(sb);
					br.close();
            }	
	public static int binarySearch(int[] arr, int key){
		int lo = 0;
		int hi = arr.length -1;
		
		while(lo<=hi){
			int mid = (lo+hi)/2;
			
			if(key < arr[mid]){
				hi = mid - 1;
			}
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}
}
