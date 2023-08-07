package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


@SpringBootApplication
public class test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 創建一個 Scanner 讓用戶輸入

        System.out.print("請输入文字，用空格分隔：");
        String inputLine = scanner.nextLine();      // 使用 Scanner 讀取用戶輸入的文字

        String[] inputArray = inputLine.split(" "); // 將輸入的文字用空格分割
        // 例如，如果用戶輸入 "1 2 3"，則 inputArray 將包含 ["1", "2", "3"

        // 使用 Stream 對數組中的每個元素進行操作
        String output = Arrays.stream(inputArray)   // 將數組轉化為 Stream
                .map(s -> "TEST-" + s)               // 對每個元素的前面添加 "TEST-"
                .collect(Collectors.joining(", ")); // 使用 Collectors 將所有元素連接為一個字符串

        System.out.println(output); // 印出來

        scanner.close();
    }
}
