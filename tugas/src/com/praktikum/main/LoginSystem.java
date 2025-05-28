package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loginUlang;

        do {
            loginUlang = false;
            System.out.println("=== SISTEM LOGIN ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Pilih opsi: ");
            int pilihan = input.nextInt();
            input.nextLine();

            User user = null;

            if (pilihan == 1) {
                System.out.print("Masukkan username: ");
                String username = input.nextLine();
                System.out.print("Masukkan password: ");
                String password = input.nextLine();

                user = new Admin("Admin Utama", "0000000000", "Admin259", "password259");
                if (user.login(username, password)) {
                    System.out.println("\nLogin Admin berhasil!");
                    user.displayAppMenu();
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                    loginUlang = promptLoginUlang(input);
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = input.nextLine();

                user = new Mahasiswa("Grenda Agriansyah", "202410370110259");
                if (user.login(nama, nim)) {
                    System.out.println("\nLogin Mahasiswa berhasil!");
                    user.displayAppMenu();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                    loginUlang = promptLoginUlang(input);
                }
            } else {
                System.out.println("Pilihan tidak valid.");
                loginUlang = promptLoginUlang(input);
            }
        } while (loginUlang);

        input.close();
    }

    private static boolean promptLoginUlang(Scanner input) {
        System.out.print("Coba lagi? (ya/tidak): ");
        String ulang = input.nextLine();
        return ulang.equalsIgnoreCase("ya");
    }
}
