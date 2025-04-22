package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] quotes = {
                "Be yourself; everyone else is already taken. – Oscar Wilde",
                "In the middle of every difficulty lies opportunity. – Albert Einstein",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill",
                "Do what you can, with what you have, where you are. – Theodore Roosevelt",
                "Whether you think you can or you think you can’t, you’re right. – Henry Ford",
                "Life is what happens when you’re busy making other plans. – John Lennon",
                "You miss 100% of the shots you don’t take. – Wayne Gretzky",
                "Believe you can and you’re halfway there. – Theodore Roosevelt",
                "The only way to do great work is to love what you do. – Steve Jobs",
                "Happiness is not something ready-made. It comes from your own actions. – Dalai Lama"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 10 to see a famous quote: ");
        int choice = scanner.nextInt();

        System.out.println("Your quote: " + quotes[choice - 1]);
        }
    }
