class Node {
    int data;      // Vagonun taşıdığı yük
    Node next;     // Bir sonraki vagona işaret

    Node(int data) {
        this.data = data;
        this.next = null;  // Başta sonraki yok
    }
}
