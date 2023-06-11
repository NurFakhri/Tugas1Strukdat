class AVLTreePatient {
    private String name;
    private int age;

    // Konstruktor kelas Patient
    public AVLTreePatient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter untuk nama pasien
    public String getName() {
        return name;
    }

    // Getter untuk umur pasien
    public int getAge() {
        return age;
    }
}

class AVLNode {
    private AVLTreePatient patient;
    private AVLNode leftChild;
    private AVLNode rightChild;
    private int height;

    // Konstruktor kelas AVLNode
    public AVLNode(AVLTreePatient patient) {
        this.patient = patient;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 1;
    }

    // Getter dan setter untuk pasien
    public AVLTreePatient getPatient() {
        return patient;
    }

    public void setPatient(AVLTreePatient patient) {
        this.patient = patient;
    }

    // Getter dan setter untuk left child
    public AVLNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLNode leftChild) {
        this.leftChild = leftChild;
    }

    // Getter dan setter untuk right child
    public AVLNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLNode rightChild) {
        this.rightChild = rightChild;
    }

    // Getter dan setter untuk height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class AVLTree {
    private AVLNode root;

    // Konstruktor kelas AVLTree
    public AVLTree() {
        root = null;
    }

    // Metode untuk menambahkan pasien ke dalam AVL Tree
    public void addPatient(AVLTreePatient patient) {
        root = insert(root, patient);
    }

    // Metode rekursif untuk memasukkan pasien ke dalam AVL Tree
    private AVLNode insert(AVLNode node, AVLTreePatient patient) {
        if (node == null) {
            return new AVLNode(patient);
        }

        if (patient.getAge() < node.getPatient().getAge()) {
            node.setLeftChild(insert(node.getLeftChild(), patient));
        } else {
            node.setRightChild(insert(node.getRightChild(), patient));
        }

        // Menghitung tinggi node
        node.setHeight(1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())));

        // Melakukan rotasi jika diperlukan
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (patient.getAge() < node.getLeftChild().getPatient().getAge()) {
                // Single right rotation
                return rotateRight(node);
            } else {
                // Double left-right rotation
                node.setLeftChild(rotateLeft(node.getLeftChild()));
                return rotateRight(node);
            }
        }

        if (balanceFactor < -1) {
            if (patient.getAge() > node.getRightChild().getPatient().getAge()) {
                // Single left rotation
                return rotateLeft(node);
            } else {
                // Double right-left rotation
                node.setRightChild(rotateRight(node.getRightChild()));
                return rotateLeft(node);
            }
        }

        return node;
    }

    // Metode untuk melakukan rotasi ke kanan (untuk menyeimbangkan AVL Tree)
    private AVLNode rotateRight(AVLNode node) {
        AVLNode newRoot = node.getLeftChild();
        AVLNode rightChildOfNewRoot = newRoot.getRightChild();

        // Melakukan rotasi
        newRoot.setRightChild(node);
        node.setLeftChild(rightChildOfNewRoot);

        // Mengupdate tinggi node
        node.setHeight(1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())));
        newRoot.setHeight(1 + Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())));

        return newRoot;
    }

    // Metode untuk melakukan rotasi ke kiri (untuk menyeimbangkan AVL Tree)
    private AVLNode rotateLeft(AVLNode node) {
        AVLNode newRoot = node.getRightChild();
        AVLNode leftChildOfNewRoot = newRoot.getLeftChild();

        // Melakukan rotasi
        newRoot.setLeftChild(node);
        node.setRightChild(leftChildOfNewRoot);

        // Mengupdate tinggi node
        node.setHeight(1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())));
        newRoot.setHeight(1 + Math.max(getHeight(newRoot.getLeftChild()), getHeight(newRoot.getRightChild())));

        return newRoot;
    }

    // Metode untuk mendapatkan tinggi node (null-safe)
    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return node.getHeight();
    }

    // Metode untuk mendapatkan faktor keseimbangan node (null-safe)
    private int getBalanceFactor(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
    }

    // Metode untuk melakukan traversal Inorder pada AVL Tree
    public void inorderTraversal() {
        inorder(root);
    }

    // Metode rekursif untuk traversal Inorder
    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.getLeftChild());
            System.out.println("Name: " + node.getPatient().getName() + ", Age: " + node.getPatient().getAge());
            inorder(node.getRightChild());
        }
    }
}

