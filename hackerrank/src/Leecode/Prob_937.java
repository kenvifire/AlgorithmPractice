package Leecode;


import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prob_937 {

    static class LogEntry implements Comparable<LogEntry>{
        private String[] logEntry;
        private int isLetterLog = 1;
        private String log;
        private int index;
        private String originalLog;

        public LogEntry(String log, int index) {
            this.originalLog = log;
            String[] logEntry = log.split(" ");
            this.logEntry = logEntry;
            this.index = index;
            StringBuilder sb = new StringBuilder();
            this.isLetterLog = isLetter(logEntry[1]) ? 1 : 0;
            for (int i = 1; i < logEntry.length; i++) {
               sb.append(logEntry[i] + " ");
            }
            sb.append(logEntry[0]);
            this.log = sb.toString();
        }

        @Override
        public int compareTo(LogEntry other) {
            if(this.isLetterLog != other.isLetterLog) return -(this.isLetterLog - other.isLetterLog);

            if(this.isLetterLog == 1) {
                return this.log.compareTo(other.log);
            }else {
                return this.index - other.index;
            }

        }

        private boolean isLetter(String str) {
            for (int i = 0; i < str.length(); i++) {
                if(Character.isDigit(str.charAt(i))) return false;
            }
            return true;
        }
    }


    public String[] reorderLogFiles(String[] logs) {
        List<LogEntry>  logList = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            logList.add(new LogEntry(logs[i], i));
        }

        Collections.sort(logList);

        String[] result = new String[logs.length];
        logList.stream().map(e -> e.originalLog).collect(Collectors.toList()).toArray(result);
        return result;

    }

    public static void main(String[] args) {
        PrintUtils.printArray(new Prob_937().reorderLogFiles(new String[] {
                "j mo", "5 m w", "g 07", "o 2 0", "t q h"
        }));
    }
}
