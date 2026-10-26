import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = toColumnIndex(ext);
        int sortIdx = toColumnIndex(sort_by);
        
        List<int[]> filtered = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filtered.add(row);
            }
        }
        
        filtered.sort(Comparator.comparingInt(a -> a[sortIdx]));
        return filtered.toArray(new int[0][]);
    }
    private int toColumnIndex(String column) {
        return switch(column) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> throw new IllegalArgumentException("error");
        };
    }
}