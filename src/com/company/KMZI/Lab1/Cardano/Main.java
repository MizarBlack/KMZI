package com.company.KMZI.Lab1.Cardano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int sizeTable = 8;
        int maxSizeMessage = sizeTable * sizeTable;
        String keyFile = "C:\\Users\\Gromotey\\IdeaProjects\\untitled1\\input.txt";


        BufferedReader reader = new BufferedReader(new FileReader(keyFile));
        String str;
        ArrayList<String> list = new ArrayList<>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
            }}
        System.out.println(list);


        System.out.println("Input message: ");
        Scanner scannerChar = new Scanner(System.in);
        String message = scannerChar.nextLine();
        if (message.length() <= maxSizeMessage) {
            System.out.println(message);
            char [] messageChar = message.toCharArray();
        }
        else {
            System.out.println("Сообщение слишком большое для данной решётки. Введите сообщение не больше 64 символов.");
        }

        char [][] secretMessage = new char[8][8];




    }
}
