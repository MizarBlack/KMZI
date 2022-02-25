package com.company.KMZI.Lab1.Cardano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int sizeTable = 8;
        int maxSizeMessage = sizeTable * sizeTable;
        String keyFile = "C:\\Users\\Gromotey\\IdeaProjects\\untitled1\\input.txt";



        File inFile = new File(keyFile); // Чтение ключа в массив char
        Scanner scanner = new Scanner(inFile);
        char[][] array = new char[sizeTable][sizeTable];
        for(int i=0; i < sizeTable; i++) {
            array[i] = scanner.nextLine().toCharArray();
        }
        for(int i = 0; i < sizeTable; i++){
            for (int j = 0; j < sizeTable; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        System.out.println("Input message: ");  // Ввод сообщения
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
