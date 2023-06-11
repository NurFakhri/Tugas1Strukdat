public class HospitalAVLTree {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Menambahkan beberapa pasien ke dalam AVL Tree
        avlTree.addPatient(new AVLTreePatient("Rizky", 20));
        avlTree.addPatient(new AVLTreePatient("Akbar", 32));
        avlTree.addPatient(new AVLTreePatient("Suyatno", 66));
        avlTree.addPatient(new AVLTreePatient("Siti", 21));
        avlTree.addPatient(new AVLTreePatient("Aziz", 19));

        // Menampilkan daftar pasien setelah dimasukkan ke dalam AVL Tree
        System.out.println("Daftar pasien setelah dimasukkan ke dalam AVL Tree:");
        avlTree.inorderTraversal();
    }
}
