public class DataSiakad {
    Mahasiswa[] dataMhs = new Mahasiswa[3];
    int mhsIndex = 0;
    MataKuliah[] dataMk = new MataKuliah[3];
    int mkIndex = 0;
    Penilaian[] dataPenilaian = new Penilaian[5];
    int penilaianIndex = 0;

    void tambahMahasiswa(Mahasiswa mahasiswa) {
        if (mhsIndex < dataMhs.length) {
            dataMhs[mhsIndex] = mahasiswa;
            mhsIndex++;
        } else {
            System.out.println("Array Mahasiswa penuh!");
        }
    }

    void tambahMataKuliah(MataKuliah mataKuliah) {
        if (mkIndex < dataMk.length) {
            dataMk[mkIndex] = mataKuliah;
            mkIndex++;
        } else {
            System.out.println("Array Mata Kuliah penuh!");
        }
    }

    void tambahPenilaian(Penilaian penilaianObj) {
        if (penilaianIndex < dataPenilaian.length) {
            dataPenilaian[penilaianIndex] = penilaianObj;
            penilaianIndex++;
        } else {
            System.out.println("Array Penilaian penuh!");
        }
    }

    void tampilMhs() {
        System.out.println("\nDaftar Mahasiswa: ");
        for (Mahasiswa mhs : dataMhs) {
            mhs.tampilMahasiswa();
        }
        System.out.println();
    }

    void tampilkanMataKuliah() {
        System.out.println("\nDaftar Mata Kuliah: ");
        for (MataKuliah matkul : dataMk) {
            matkul.tampilMatakuliah();
        }
        System.out.println();
    }

    void cariMahasiswa(String nimCari) {
        boolean ketemu = false;
        for (int i = 0; i < mhsIndex; i++) {
            if (dataMhs[i].nim.equals(nimCari)) {
                System.out.print("\nData Mahasiswa Ditemukan : ");
                dataMhs[i].tampilMahasiswa();
                ketemu = true;
                break;
            }
        }
        if (!ketemu) {
            System.out.println("\nMahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }
        System.out.println();
    }

    void urutkanNilaiAkhirDESC() {
        for (int i = 0; i < dataPenilaian.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < dataPenilaian.length; j++) {
                double nilaiAkhirMax = dataPenilaian[maxIndex].hitungNilaiAkhir();
                double nilaiAkhirCurrent = dataPenilaian[j].hitungNilaiAkhir();

                if (nilaiAkhirCurrent > nilaiAkhirMax) {
                    maxIndex = j;
                }
            }

            Penilaian temp = dataPenilaian[i];
            dataPenilaian[i] = dataPenilaian[maxIndex];
            dataPenilaian[maxIndex] = temp;
        }

        tampilkanPenilaian();
    }

    void urutkanNilaiAkhirASC() {
        for (int i = 0; i < dataPenilaian.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < dataPenilaian.length; j++) {
                double nilaiAkhirMin = dataPenilaian[minIndex].hitungNilaiAkhir();
                double nilaiAkhirCurrent = dataPenilaian[j].hitungNilaiAkhir();

                if (nilaiAkhirCurrent < nilaiAkhirMin) {
                    minIndex = j;
                }
            }

            Penilaian temp = dataPenilaian[i];
            dataPenilaian[i] = dataPenilaian[minIndex];
            dataPenilaian[minIndex] = temp;
        }

        tampilkanPenilaian();
    }

    void tampilkanPenilaian() {
        System.out.println();
        for (Penilaian p : dataPenilaian) {
            double nilaiAkhir = p.hitungNilaiAkhir();
            System.out.println(p.mahasiswa.nama + " | " + p.mataKuliah.namaMK + " | " + nilaiAkhir);
        }
        System.out.println();
    }
}
