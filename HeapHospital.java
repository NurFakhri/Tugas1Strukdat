public class HeapHospital {
    // Fungsi untuk menjaga sifat heap maksimum
    public static void heapify(HeapPatient[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].getAge() > arr[largest].getAge()) {
            largest = left;
        }

        if (right < n && arr[right].getAge() > arr[largest].getAge()) {
            largest = right;
        }

        if (largest != i) {
            HeapPatient temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Fungsi untuk melakukan Heap Sort
    public static void heapSort(HeapPatient[] arr) {
        int n = arr.length;

        // Membangun heap maksimum
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Ekstraksi elemen satu per satu dari heap dan melakukan pengurutan
        for (int i = n - 1; i >= 0; i--) {
            HeapPatient temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        // Membuat daftar pasien
        HeapPatient[] patients = {
                new HeapPatient("Rizky", 20),
                new HeapPatient("Akbar", 32),
                new HeapPatient("Suyatno", 66),
                new HeapPatient("Siti", 21),
                new HeapPatient("Aziz", 19)
        };

        // Menampilkan daftar pasien sebelum diurutkan
        System.out.println("Daftar pasien sebelum diurutkan:");
        for (HeapPatient patient : patients) {
            System.out.println(patient);
        }

        // Mengurutkan daftar pasien menggunakan Heap Sort
        heapSort(patients);

        // Menampilkan daftar pasien setelah diurutkan
        System.out.println("\nDaftar pasien setelah diurutkan (berdasarkan umur):");
        for (HeapPatient patient : patients) {
            System.out.println(patient);
        }
    }
}