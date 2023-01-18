package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            BufferedReader inputstream = new BufferedReader(new FileReader("D:/UM/WIX1002 Fundamentals of Programming/org.example.Assignment/extracted_log.txt"));
            int month = 0;
            String check = "";
            String[] arrayMonth = {"06", "07", "08", "09", "10", "11", "12"};
            String[] Month = {"June", "July", "August", "September", "October", "November", "December"};


                check = "\\[(.*)] sched: Allocate JobId=(\\d+) NodeList=(.*) #CPUs=(\\d+) Partition=(.*)";//

            int[] countAmount = new int[7];

            String line;

            for (int i = 0; i < arrayMonth.length; i++) {
                while ((line = inputstream.readLine()) != null) {
                    Pattern patternDate = Pattern.compile("\\[2022-(\\d+)-(.+)] (.*)");
                    Matcher matcherDate = patternDate.matcher(line);
                    Pattern pattern = Pattern.compile(check);
                    Matcher matcher = pattern.matcher(line);
                    matcherDate.find();
                    if (!matcherDate.group(1).equals(arrayMonth[i]) && matcher.matches()) {
                        countAmount[i + 1]++;
                        break;
                    }

                    if (matcher.matches())
                        countAmount[i]++;

                }

            }

            inputstream.close();
            check obj = new check();
            obj.graph(Month, countAmount);
//            org.example.graph Graph = new org.example.graph();
//            Graph.call();
        } catch (
                IOException e) {
            System.out.println("Input file problem");
        }

    }
    private String[] month= new String[7];
    private int[] amount = new int[7];

    public void graph(String[] Month, int[] countAmount){
        String[] month = Month;
        int[] amount = countAmount;
    }
    public String[] getMonth(){
        return month;
    }
    public int[] getAmount(){
        return amount;

    }
