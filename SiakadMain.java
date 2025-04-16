import java.util.*;

public class SiakadMain {
    static Scanner input = new Scanner(System.in);
    static DataSiakad dataSiakad = new DataSiakad();

    public static void main(String[] args) {

        Mahasiswa[] mahasiswaBatch = {
                new Mahasiswa("Ali Rahman", "22001", "Informatika"),
                new Mahasiswa("Budi Santoso", "22002", "Informatika"),
                new Mahasiswa("Citra Dewi", "22003", "Informatika")
        };

        MataKuliah[] mataKuliahBatch = {
                new MataKuliah("MK001", "Struktur Data", 3),
                new MataKuliah("MK002", "Basis Data", 3),
                new MataKuliah("MK003", "Desain Web", 3)
        };

        Penilaian[] penilaianBatch = {
                new Penilaian(mahasiswaBatch[0], mataKuliahBatch[0], 80, 85, 90),
                new Penilaian(mahasiswaBatch[0], mataKuliahBatch[1], 60, 75, 70),
                new Penilaian(mahasiswaBatch[1], mataKuliahBatch[0], 75, 70, 80),
                new Penilaian(mahasiswaBatch[2], mataKuliahBatch[1], 85, 90, 95),
                new Penilaian(mahasiswaBatch[2], mataKuliahBatch[2], 80, 90, 65)
        };

        for (Mahasiswa mhs : mahasiswaBatch) {
            dataSiakad.tambahMahasiswa(mhs);
        }

        for (MataKuliah mk : mataKuliahBatch) {
            dataSiakad.tambahMataKuliah(mk);
        }

        for (Penilaian penilaian : penilaianBatch) {
            dataSiakad.tambahPenilaian(penilaian);
        }

        int pilihan;
        do {
            System.out.println("=== MENU SISTEM AKADEMIK ==");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu (0 - 5) : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanMahasiswa();
                    break;
                case 2:
                    tampilkanMataKuliah();
                    break;
                case 3:
                    dataSiakad.tampilkanPenilaian();
                    break;
                case 4:
                    menuSorting();
                    break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = input.nextLine();
                    dataSiakad.cariMahasiswa(nimCari);
                    break;
                case 0:
                    System.out.println("Terima Kasih!");
                    return;
                default:
                    System.out.println("\nMaaf Menu Tidak Tersedia\n");
            }
        } while (pilihan != 0);

        input.close();
    }

    static void tampilkanMahasiswa() {
        if (dataSiakad.dataMhs[0] == null) {
            System.out.println("Tidak ada data yang tersedia.");
        } else {
            dataSiakad.tampilMhs();
        }
    }

    static void tampilkanMataKuliah() {
        if (dataSiakad.dataMk[0] == null) {
            System.out.println("Tidak ada data yang tersedia.");
        } else {
            dataSiakad.tampilkanMataKuliah();
        }
    }

    static void menuSorting() {
        int pilSorting;
    
        while (true) {
            System.out.println("\n==== Pilihan Sorting ====");
            System.out.println("1. Terkecil ke terbesar (ASC)");
            System.out.println("2. Terbesar ke terkecil (DESC)");
            System.out.println("3. Keluar");
            System.out.print("Pilih Tipe Sorting : ");
            pilSorting = input.nextInt();
            input.nextLine();
    
            switch (pilSorting) {
                case 1:
                    dataSiakad.urutkanNilaiAkhirASC();
                    return;
                case 2:
                    dataSiakad.urutkanNilaiAkhirDESC();
                    return;
                case 3:
                    System.out.println("Keluar dari menu sorting.");
                    return;
                default:
                    System.out.println("\nInput tidak valid. Masukkan Input yang benar!");
            }
        }
    }    
}
