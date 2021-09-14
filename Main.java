package com.bank;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {

        int i =0;
        BufferedReader br = new BufferedReader(new FileReader("/Users/bhawnasharma/Downloads/bank_transactions.txt"));
        ArrayList lines = new ArrayList();
        PrintWriter f1 = new PrintWriter(new FileWriter("output1.txt"));

        for (String line = br.readLine(); line != null; line = br.readLine())
            {

            if (i >= 1)
                {
                    String[] tokens = line.split("\t");
                    String valueNeeded = tokens[1];
                    Date date = new Date(valueNeeded);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
                    String strDate = formatter.format(date);
                    Date dt1 = formatter.parse(strDate);
                    DateFormat format2 = new SimpleDateFormat("EEEE");
                    String finalDay = format2.format(dt1);

                        if (finalDay.equals("Monday") || finalDay.equals("Wednesday") || finalDay.equals("Friday"))
                        {
                        System.out.println(line);
                        f1.println(line);
                        }
                }
                        i = i + 1;

            }
        }
    }