package Latihan;

import java.util.Scanner;

class InvalidBookIdException extends Exception {
    public InvalidBookIdException(String message) {
        super(message);
    }
}

class InvalidLoanDurationException extends Exception {
    public InvalidLoanDurationException(String message) {
        super(message);
    }
}

public class PeminjamanBuku {

    private static final String[] VALID_BOOK_IDS = {"B001", "B002", "B003"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input data
            System.out.print("Masukkan nama Anda: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan ID buku: ");
            String idBuku = scanner.nextLine();
            validateBookId(idBuku);

            System.out.print("Masukkan lama peminjaman (hari): ");
            int lamaPinjam = scanner.nextInt();
            validateLoanDuration(lamaPinjam);

            // Jika semua valid
            System.out.println("Peminjaman berhasil dicatat.");
            System.out.println("Nama: " + nama);
            System.out.println("ID Buku: " + idBuku);
            System.out.println("Lama Peminjaman: " + lamaPinjam + " hari");

        } catch (InvalidBookIdException | InvalidLoanDurationException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program selesai.");
        }
    }

    private static void validateBookId(String id) throws InvalidBookIdException {
        for (String validId : VALID_BOOK_IDS) {
            if (validId.equalsIgnoreCase(id)) return;
        }
        throw new InvalidBookIdException("ID buku tidak valid. Harus salah satu dari: B001, B002, B003.");
    }

    private static void validateLoanDuration(int days) throws InvalidLoanDurationException {
        if (days < 1 || days > 14) {
            throw new InvalidLoanDurationException("Lama peminjaman harus antara 1 - 14 hari.");
        }
    }
}
