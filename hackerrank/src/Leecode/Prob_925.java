package Leecode;

public class Prob_925 {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;
        if(name.length() == 0 && typed.length() == 0) return true;

        int nameIndex = 0;
        int typedIndex = 0;
        Character currentChar = null;
        int nameCnt = 0;
        int typedCnt = 0;


        while (nameIndex < name.length() && typedIndex < typed.length()) {
            currentChar = name.charAt(nameIndex);
            nameCnt = 0;
            typedCnt = 0;
            while (nameIndex < name.length() && currentChar == name.charAt(nameIndex)) {
                nameIndex++;
                nameCnt++;
            }

            while (typedIndex < typed.length() && currentChar == typed.charAt(typedIndex)) {
                typedIndex++;
                typedCnt++;
            }

            if(typedCnt < nameCnt) return false;
        }

        if(nameIndex < name.length() || typedIndex < typed.length()) return false;

        return true;


    }
}
