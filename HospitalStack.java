import java.util.Stack;

public class HospitalStack {
    public static void main(String[] args) {
        // Membuat objek Stack untuk menyimpan data pasien
        Stack<stackPatient> patientStack = new Stack<>();

        // Menambahkan pasien ke dalam stack
        patientStack.push(new stackPatient("Rizky", 20));
        patientStack.push(new stackPatient("Akbar", 32));
        patientStack.push(new stackPatient("Suyatno", 66));
        patientStack.push(new stackPatient("Siti", 21));
        patientStack.push(new stackPatient("Aziz", 19));

        // Menampilkan data pasien sebelum proses
        System.out.println("Data pasien sebelum proses:");
        for (stackPatient patient : patientStack) {
            System.out.println(patient);
        }

        // Menghapus dan memproses pasien dari stack menggunakan DFS
        processPatientsDFS(patientStack);

        // Menampilkan informasi setelah memproses pasien
        System.out.println("Semua pasien telah diproses.");
    }

    public static void processPatientsDFS(Stack<stackPatient> stack) {
        // Base case: stack kosong, rekursi berhenti
        if (stack.isEmpty()) {
            return;
        }

        // Ambil pasien dari stack
        stackPatient currentPatient = stack.pop();
        System.out.println("Memproses pasien: " + currentPatient);

        // Panggil rekursif untuk memproses sisa pasien
        processPatientsDFS(stack);

        // Menampilkan informasi setelah memproses pasien
        System.out.println("Pasien " + currentPatient.getName() + " telah diproses.");
    }
}