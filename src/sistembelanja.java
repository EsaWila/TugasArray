import java.util.ArrayList;
import java.util.Scanner;

public class sistembelanja {
    
    static ArrayList<ArrayList<String>> buah = new ArrayList<>();
    static ArrayList<String> namaBuah = new ArrayList<>();
    static ArrayList<Integer> jumlahBuah = new ArrayList<>();
    static ArrayList<Integer> hargaBuah = new ArrayList<>();

    static int totalHarga = 0;

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> buah1 = new ArrayList<>();
        buah1.add("Apel");
        buah1.add("35000");
        buah.add(buah1);

        ArrayList<String> buah2 = new ArrayList<>();
        buah2.add("Jeruk");
        buah2.add("50000");
        buah.add(buah2);

        ArrayList<String> buah3 = new ArrayList<>();
        buah3.add("Mangga");
        buah3.add("25000");
        buah.add(buah3);

        ArrayList<String> buah4 = new ArrayList<>();
        buah4.add("Duku");
        buah4.add("15000");
        buah.add(buah4);

        ArrayList<String> buah5 = new ArrayList<>();
        buah5.add("Semangka");
        buah5.add("20000");
        buah.add(buah5);

        int pilihan = 1;
        String lanjut = "y";
        String tBuah = "y";

        do {
            System.out.println("Menu: ");
            System.out.println();
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.println();

            System.out.println("-".repeat( 30));
            System.out.println("Masukkan Pilihan: ");
            pilihan = input.nextInt();
            System.out.println("-".repeat(30));

            input.nextLine();

            if (pilihan == 3) {
                System.out.println("Terimakasih");
                break;  
            } 
            
            switch (pilihan) {
                case 1:

                do {

                    System.out.println();
                    System.out.println("Menu Buah: ");
                    System.out.println();

                    for (int i = 0; i <= 4; i++) {
                        String nama = buah.get(i).get(0);
                        System.out.println((i+1) + ". " + nama);
                    }

                    System.out.println();
                    System.out.print("Pilih buah (1-5): ");
                    int pilihBuah = input.nextInt();
                    input.nextLine();
                    pilihBuah -= 1;
                    
                    if (pilihBuah >= 0 && pilihBuah < buah.size()) {
                        System.out.print("Masukan jumlahnya: ");
                        int jumlah = input.nextInt();
                        input.nextLine();

                        String nama = buah.get(pilihBuah).get(0);
                        int harga = Integer.parseInt(buah.get(pilihBuah).get(1));
                        int subTotal = jumlah * harga;

                        namaBuah.add(nama);
                        jumlahBuah.add(jumlah);
                        hargaBuah.add(harga);
                        totalHarga += subTotal;
                        System.out.println();
                        
                        System.out.println("-".repeat(30));
                        System.out.println("Dimasukan kedalam keranjang!");
                        System.out.println("-".repeat(30));

                        System.out.println();
                        System.out.print("Apakah ingin tambah buah lagi? (y/n): ");
                        tBuah = input.nextLine().toLowerCase();

                    } else {
                        System.out.println("Masukan angka yang benar!");
                    }
                    
                } while (tBuah.equals("y"));
                    break;
                case 2 :
                    System.out.println();
                    System.out.println("Daftar Belanja Anda: ");
                    System.out.println();
                    if (namaBuah.isEmpty()) {
                        System.out.println("Belum ada buah yang dipilih!");
                        break;
                    }

                    System.out.println("=".repeat(50));
                    System.out.println("No\tNama Buah\tJumlah\tHarga\tSubtotal");

                    for (int i = 0; i < namaBuah.size(); i++) {
                        String nama = namaBuah.get(i);
                        int jumlah = jumlahBuah.get(i);
                        int harga = hargaBuah.get(i);
                        int subTotal = jumlah * harga;

                        System.out.println((i+1) + "\t" + nama +"     "+ "\t" + jumlah + "\t" + harga + "\t" + subTotal);
                    }

                    System.out.println("=".repeat(50));
                    System.out.println();
                    System.out.println("=".repeat(50));
                    System.out.println("Total Harga: "+ totalHarga);
                    int diskon = (totalHarga*15)/100;
                    System.out.println("Discount-15%: "+diskon);
                    int totalBayar = totalHarga-diskon;
                    System.out.println("Total yang harus dibayar: "+totalBayar);
                    System.out.println("=".repeat(50));
                    System.out.println();
                    System.out.println("1. Bayar");
                    System.out.println("2. Kembali");
                    System.out.println();
                    System.out.print("Apakah anda ingin bayar sekarang?: ");
                    int isi = input.nextInt();

                    if (isi == 1) {
                        System.out.print("Masukan Jumlah Uang Anda: ");
                        int jumlahUang = input.nextInt();
                        input.nextLine();

                        if (jumlahUang < totalBayar) {
                            System.out.println("Uang Anda tidak Mencukupi!");
                            break;
                        }
                        else{
                            System.out.println();
                            System.out.println("=".repeat(30));
                            System.out.println("Yeayy!!, Pembayaran Berhasil!");
                            System.out.println("=".repeat(30));
                            int kembalian = jumlahUang - totalBayar;
                            System.out.println();
                            System.out.println("Kembalian: "+kembalian);
                            System.out.println();
                            System.out.print("Ingin membeli buah Lagi? (y/n): ");
                            lanjut = input.nextLine();
                            namaBuah.clear();
                            jumlahBuah.clear();
                            hargaBuah.clear();
                            totalHarga = 0;
                        }
                    }else if (isi != 2) {
                        System.out.println("Masukan pilihan yang benar!");
                    }
                    break;

                default:
                    System.out.println("Masukan Pilihan yang benar!");
                    break;
                   }
        } while (lanjut.equals("y"));
        input.close();
    }
}