package arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MahasiswaAksi {
    public static void main(String[] args) {

        // membuat objek ArrayList untuk menyimpan data mahasiswa
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        Scanner scanner = new Scanner(System.in);
        String input = "";
        char input_ips = 'y';

        System.out.println("Program menghitung IPK mahasiswa");

        // Loop utama untuk meminta input dari pengguna
        while (!input.equals("exit")) {
            System.out.println("------------------------------");
            System.out.print("Masukkan perintah (tambah/lihat/exit): ");
            input = scanner.nextLine();

            // Memproses input pengguna
            if (input.equals("tambah")) {
                System.out.println("------------------------------");
                System.out.print("Masukkan nama mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan nim mahasiswa: ");
                String nim = scanner.nextLine();

                ArrayList<Double> nilaiIps = new ArrayList<>();
                do {
                    System.out.print("Masukkan nilai ips mahasiswa: ");
                    double ips = scanner.nextDouble();
                    nilaiIps.add(ips);

                    System.out.print("Tambahkan lagi nilai mahasiswa?(y/t): ");
                    input_ips = scanner.next().charAt(0);

                } while (input_ips != 't');

                mahasiswaList.add(new Mahasiswa(nama, nim, nilaiIps));
                scanner.nextLine();

            } else if (input.equals("lihat")) {
                // menampilkan data mahasiswa dan IPK menggunakan Iterator
                System.out.println("------------------------------");
                System.out.println("Daftar IPK mahasiswa:");
                Iterator<Mahasiswa> iterator = mahasiswaList.iterator();
                while (iterator.hasNext()) {
                    Mahasiswa mahasiswa = iterator.next();
                    System.out.println("Nama: " + mahasiswa.getNama() + ", NIM: " +
                            mahasiswa.getNim() + ", IPK: " + mahasiswa.hitungIPK());
                }

            } else if (!input.equals("exit")) {
                System.out.println("Perintah tidak dikenali.");
            }
        }
        scanner.close();
    }
}
