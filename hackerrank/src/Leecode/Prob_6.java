package Leecode;

public class Prob_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length())  return s;

        StringBuilder sb = new StringBuilder(s.length());

        int numsPerCol = numRows > 2 ? 2 * (numRows -1 ) : numRows;

        int columns = (int)Math.ceil((float)s.length() / (float)numsPerCol);

        int index = 0;
        int margin =  2 * (numRows - 1);


        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < columns; c++) {
                if(r == 0 || r == (numRows -1)) {
                    int originIndex = r + c * margin;
                    if (originIndex < s.length()) {
                        sb.append(s.charAt(originIndex));
                        index++;
                    }
                } else {
                    int originIndex = r + c * margin;
                    if (originIndex < s.length()) {
                        sb.append(s.charAt(originIndex));
                        index++;
                    }

                    originIndex += margin - 2 * r;
                    if (originIndex < s.length()) {
                        sb.append(s.charAt(originIndex));
                        index++;
                    }

                }

                if (index >= s.length()) break;
            }
            if (index >= s.length()) break;
        }
        return sb.toString();
    }
}
