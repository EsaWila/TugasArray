import java.util.Scanner;

public class mahasiswa {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner (System.in);

        String[] mahasiswa = new String [5];
        int [] nilai = new int[5];
        String [] keterangan = new String[5];
        String lanjut = "y";

        int sum = 0;
        int i = 0;

        do {
            System.out.println("Masukkan Nama: ");
            mahasiswa[i] = input.nextLine();
            System.out.println("Masukkan Nilai: ");
            nilai[i] = input.nextInt();
            input.nextLine();

            if (nilai[i] >=75) {
                keterangan[i] = "Lulus";               
            } else {
                keterangan[i] = "Tidak Lulus";
                
            }
            System.out.println("Input Lagi? (y/n): ");
            lanjut = input.nextLine().toLowerCase();

            sum += nilai[i];
            i++;
            
        } while (i < 5 && lanjut.equals("y"));
        System.out.println();
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("=".repeat(15));
        System.out.println("No\tNama\tNilai\tKeterangan");

       for (int j = 0; j < mahasiswa.length; j++) {
        if (mahasiswa[j] == null) {
            break;           
        }
        System.out.println((j+1)+"\t" + mahasiswa[j]+"\t" + "  "+nilai[j]+"\t"  + keterangan[j]);

        
       }
       
       double avg = sum/i;
       System.out.println("=".repeat(15));
       System.out.println("Total Nilai: "+sum);
       System.out.println("Rata-ratanya: "+avg);
       input.close();
    }
}
