import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {

  static int jumlahTeknik = 0;
  static int jumlahManajemen = 0;
  static int jumlahFiksi = 0;
  static int jumlahLainya = 0;
  static int bukuLawas = 0;
  static int bukuBaru = 0;

  public static void main(String[] args) throws Exception {
    System.out.println("Daftar Buku Java yang Tersedia");
    System.out.println(
      "======================================================================================================="
    );

    ArrayList<Daftar> listDaftar = new ArrayList<Daftar>();
    int list = 1;

    do {
      showMenu();
      BufferedReader inputan = new BufferedReader(
        new InputStreamReader(System.in)
      );

      System.out.print("Pilih Menu: ");
      list = Integer.parseInt(inputan.readLine());

      if (list == 1) {
        System.out.print("NO: ");
        int nomor = Integer.parseInt(inputan.readLine());
        System.out.print("judul: ");
        String judul = inputan.readLine().toString();
        System.out.print("pengarang: ");
        String pengarang = inputan.readLine().toString();
        System.out.print("penerbit: ");
        String penerbit = inputan.readLine().toString();
        System.out.print("tahun: ");
        int tahun = Integer.parseInt(inputan.readLine());
        System.out.print("kategori: ");
        int kategori = Integer.parseInt(inputan.readLine());
        System.out.print("kategori: ");

        listDaftar.add(
          new Daftar(nomor, judul, pengarang, penerbit, tahun, kategori)
        );
        displayJmltoIndex(kategori);
        if (tahun <= 2000) {
          bukuLawas++;
        } else {
          bukuBaru++;
        }
      } else if (list == 2) {
        displayDft(listDaftar);
      }
    } while (list != 3);
  }

  public static void showMenu() {
    System.out.println("Menu :");
    System.out.print("1. Tambah Data or ");
    System.out.print("2. Tampilkan Data or ");
    System.out.print("3. Exit");
    System.out.println();
  }

  public static void displayDft(ArrayList<Daftar> listDaftar) {
    System.out.println(
      "========================================================================================================"
    );
    System.out.println(
      "NO\t\tjudul\t\tpengarang\t\tpenerbit\t\ttahun\t\tkategori"
    );
    System.out.println(
      "========================================================================================================"
    );
    for (Daftar buku : listDaftar) {
      String jenis = App.JenisToIndex(buku.kategori);
      System.out.println(
        buku.nomor +
        "\t\t" +
        buku.judul +
        "\t\t" +
        buku.pengarang +
        "\t\t\t" +
        buku.penerbit +
        "\t\t\t" +
        buku.tahun +
        "\t\t" +
        jenis
      );
    }

    for (Daftar jumlah : listDaftar) { //assign first element to min value
      int jumlahBuku = jumlah.nomor;
      for (int i = 1; i <= jumlah.nomor - 1; i++) { //till end of array, compare and find min value
        int value = jumlah.nomor;
        if (value < jumlahBuku) {
          jumlahBuku = value;
        }
      }
    }
    System.out.println("Jumlah buku yang tersedia: " + listDaftar.size());
    System.out.println("Buku Teknik : " + jumlahTeknik);
    System.out.println("Buku Manajemen : " + jumlahManajemen);
    System.out.println("Buku Fiksi : " + jumlahFiksi);
    System.out.println("Buku Lainnya : " + jumlahLainya);
    System.out.println("Buku Lawas : " + bukuLawas);
    System.out.println("Buku Baru : " + bukuBaru);
  }

  public static String JenisToIndex(int kategori) {
    String jenis;
    if (kategori == 1) {
      jenis = "teknik";
    } else if (kategori == 2) {
      jenis = "manajemen";
      if (jenis == "manajemen") {
        kategori += kategori;
      }
    } else if (kategori == 3) {
      jenis = "fiksi";
      if (jenis == "fiksi") {
        kategori += kategori;
      }
    } else if (kategori == 4) {
      jenis = "lainya";
      if (jenis == "lainya") {
        kategori += kategori;
      }
    } else {
      jenis = "";
    }
    return jenis;
  }

  public static void displayJmltoIndex(int kategori) {
    if (kategori == 1) {
      jumlahTeknik++;
    } else if (kategori == 2) {
      jumlahManajemen++;
    } else if (kategori == 3) {
      jumlahFiksi++;
    } else if (kategori == 4) {
      jumlahFiksi++;
    } else {
      jumlahLainya++;
    }
  }
}
