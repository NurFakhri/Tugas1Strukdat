import java.util.LinkedList;
import java.util.Queue;

public class HospitalQueue {
    public static void main(String[] args) {
        // Membuat objek Queue untuk menyimpan antrian pasien
        Queue<queuePatient> patientQueue = new LinkedList<>();

        // Menambahkan pasien ke dalam antrian
        patientQueue.add(new queuePatient("Rizky", 20));
        patientQueue.add(new queuePatient("Akbar", 32));
        patientQueue.add(new queuePatient("Suyatno", 66));
        patientQueue.add(new queuePatient("Siti", 21));
        patientQueue.add(new queuePatient("Aziz", 19));

        // Menampilkan antrian pasien sebelum proses
        System.out.println("Antrian pasien:");
        for (queuePatient patient : patientQueue) {
            System.out.println(patient);
        }

        // Menghapus dan memproses pasien dari antrian
        while (!patientQueue.isEmpty()) {
            queuePatient currentPatient = patientQueue.poll();
            System.out.println("Memproses pasien: \n" + currentPatient);

            // Menampilkan informasi setelah memproses pasien
            System.out.println("Pasien " + currentPatient.getName() + " telah diproses.");
        }
    }
}