import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = toColumnIndex(ext);
        int sortIdx = toColumnIndex(sort_by);
        
        return Arrays.stream(data)
            .filter(row -> row[extIdx] < val_ext)
            .sorted(Comparator.comparingInt(row -> row[sortIdx]))
            .toArray(int[][]::new);
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