package com.company.KMZI.Lab1.Cardano;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static char [][] rotate(char[][] def, int size ){
        char [][] chars = new char[size][size];
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                chars[j][size-1-i] = def[i][j];
            }
        }
        return chars;
    }

    public static void main(String[] args) throws IOException {
        int sizeTable = 8;
        int maxSizeMessage = sizeTable * sizeTable;
        String keyFile = "C:\\Users\\Gromotey\\IdeaProjects\\untitled1\\input.txt";



        File inFile = new File(keyFile); // Чтение ключа в массив char
        Scanner scanner = new Scanner(inFile);
        char [][] key = new char[sizeTable][sizeTable];
        for(int i = 0; i < sizeTable; i++) {
            key[i] = scanner.nextLine().toCharArray();
        }
        /*for(int i = 0; i < sizeTable; i++){
            for (int j = 0; j < sizeTable; j++){
                System.out.print(key[i][j]);
            }
            System.out.println();
        }*/

        System.out.println("Input message: ");  // Ввод сообщения
        Scanner scannerChar = new Scanner(System.in);
        String message = scannerChar.nextLine();
        char [] messageChar = new char[0];
        if (message.length() <= maxSizeMessage) {
            messageChar = message.toCharArray();
            //System.out.println(messageChar);
        }
        else {
            System.out.println("Сообщение слишком большое для данной решётки. Введите сообщение не больше 64 символов.");
        }


        char [][] anSecretMessage = new char[sizeTable][sizeTable];
        for (int i = 0; i < sizeTable; i++){
            for (int j = 1; j <= sizeTable; j++){
                anSecretMessage[i][j-1] = messageChar[j + (i * 8 - 1)];
            }
        }

        /*for (int i = 0; i < sizeTable; i++){
            for (int j = 0; j < sizeTable; j++){
                System.out.print(key[i][j]);
            }
            System.out.println();
        }*/

        char [][] secretMessage = new char[sizeTable][sizeTable]; //Текст для шифрования по лабораторной КМЗИ.Сделал Громов Владимир
        for (int q = 0; q < 4; q++){ // Повторяем четыре раза, на четыре поворота ключа
            for (int i = 0; i < sizeTable; i++){
                for (int j = 0; j < sizeTable; j++){
                    if (key[i][j] == 49){
                        secretMessage[i][j] = anSecretMessage[i][j];
                    }
                }
            }
            key = rotate(key, sizeTable);
        }

        for (int i = 0; i < sizeTable; i++){
            for (int j = 0; j < sizeTable; j++){
                System.out.print(secretMessage[i][j]);
            }
            System.out.println();
        }

    }
}
