package utils;

import java.util.Scanner;

public class utilsme {
    public static int response(int size)
    {
        Scanner scanner =new Scanner(System.in);
        String result =scanner.next();
        try {
            int value = Integer.parseInt(result);
            if (value>size)
            {
                System.out.println("number has to be less than "+size);
                return response(size);
            }
            else
                return value;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
            return response(size);
        }
    }
}
