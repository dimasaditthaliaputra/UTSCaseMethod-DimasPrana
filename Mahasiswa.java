//Pranata
public class Mahasiswa {
    String nama19;
    String nim19;
    String prodi19;

    Mahasiswa(String nama19, String nim19, String prodi19) {
        this.nama19 = nama19;
        this.nim19 = nim19;
        this.prodi19 = prodi19;
    }

    void tampilMahasiswa() {
        System.out.println("NIM: " + nim19 + " | Nama: " + nama19 + " | Prodi: " + prodi19);
    }
}