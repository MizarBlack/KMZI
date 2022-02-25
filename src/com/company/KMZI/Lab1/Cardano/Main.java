package com.company.KMZI.Lab1.Cardano;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static char[][] rotate(char[][] def, int size) {
        char[][] chars = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chars[j][size - 1 - i] = def[i][j];
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
        char[][] key = new char[sizeTable][sizeTable];
        for (int i = 0; i < sizeTable; i++) {
            key[i] = scanner.nextLine().toCharArray();
        }

        System.out.print("Input message for encryption: ");  // Ввод сообщения
        Scanner scannerChar = new Scanner(System.in);
        String message = scannerChar.nextLine();
        char[] messageChar = new char[0];
        if (message.length() <= maxSizeMessage) {
            messageChar = message.toCharArray();
        } else {
            System.out.println("\nСообщение слишком большое для данной решётки.");
        }

        char[][] secretMessage = new char[sizeTable][sizeTable]; //Текст для шифрования по лабораторной КМЗИ.Сделал Громов Владимир
        int count = 0;
        for (int q = 0; q < 4; q++) { // Повторяем четыре раза, на четыре поворота ключа
            for (int i = 0; i < sizeTable; i++) {
                for (int j = 0; j < sizeTable; j++) {
                    if (key[i][j] == '1') {
                        secretMessage[i][j] = messageChar[count];
                        count++;
                    }
                }
            }
            key = rotate(key, sizeTable);
        }

        for (int i = 0; i < sizeTable; i++) {
            for (int j = 0; j < sizeTable; j++) {
                    System.out.print(secretMessage[i][j]);
            }
        }

        System.out.print("\nInput message for decryption: ");  // Ввод сообщения
        message = scannerChar.nextLine();
        messageChar = new char[0];
        if (message.length() <= maxSizeMessage) {
            messageChar = message.toCharArray();
        } else {
            System.out.println("Сообщение слишком большое для данной решётки.");
        }

        count = 0; //Тр енаониГя пксртой  мКдоловя М В лЗабИл.шоСифрдаеладитмирроаовл
        for (int q = 0; q < 4; q++) { // Повторяем четыре раза, на четыре поворота ключа
            for (int i = 0; i < sizeTable; i++) {
                for (int j = 0; j < sizeTable; j++) {
                    if (key[i][j] == '1') {
                        messageChar[count] = secretMessage[i][j];
                        count++;
                    }
                }
            }
            key = rotate(key, sizeTable);
        }

            for (int j = 0; j < maxSizeMessage; j++){
                System.out.print(messageChar[j]);
            }

    }
}
