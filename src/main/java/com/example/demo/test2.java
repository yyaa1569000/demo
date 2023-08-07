package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.Stack;

@SpringBootApplication
public class test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // 創建一個 Scanner 讓用戶輸入

		System.out.print("請輸入括號：");
		String input = scanner.nextLine();        // 使用 Scanner 讀取用戶輸入的文字

		int validCount = 0; // 用於計算合法括號數量的變量
		Stack<Character> stack = new Stack<>(); // 創建一個 stack，用於存儲遇到的左括號 '('

		// 遍歷輸入的字符串的每個字符
		for (char c : input.toCharArray()) {
			if (c == '(') { // 如果遇到左括號 '('，將其推入stack
				stack.push(c);
			} else if (c == ')') { // 如果遇到右括號 ')'，進行處理
				if (!stack.isEmpty() && stack.peek() == '(') { // 如果 stack 不為空，且最上面的數據是左括號 '('
					stack.pop(); // 取出元素，表示找到一對匹配的括號
					validCount++; // 合法的括號數量增加
				} else {
					System.out.println("不合法"); // 如果stack為空，或最上面的數據不是左括號 '('，則括號不匹配，輸出"不合法"
					scanner.close();
					return;
				}
			}
		}

		// 遍歷結束後，stack中如果還有元素，說明括號不匹配
		if (stack.isEmpty()) {
			System.out.println("YES ! " + validCount + " 個括號"); // 如果stack為空，輸出合法的括號數量
		} else {
			System.out.println("不合法"); // 如果stack不為空，輸出"不合法"
		}

		scanner.close();
	}
}
