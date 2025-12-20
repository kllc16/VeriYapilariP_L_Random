class SimpleLinkedList {
    Node head;  // Trenin başı (lokomotif)

    // Constructor
    SimpleLinkedList() {
        this.head = null;  // Başta tren boş
    }

    // SONA ELEMAN EKLE (Trene yeni vagon ekle)
    void add(int data) {
        Node newNode = new Node(data);
        // Yeni vagon yap

        // DURUM 1: Tren boşsa
        if (head == null) {
            head = newNode;  // İlk vagon
            System.out.println("İlk eleman eklendi: " + data);
            return;
        }

        // DURUM 2: Tren doluysa, sona git
        Node current = head;  // Baştan başla
        while (current.next != null) {  // Son vagon değilse
            current = current.next;  // Bir sonraki vagona geç
        }
        current.next = newNode;  // Son vagona yeni vagonu bağla
        System.out.println("Sona eklendi: " + data);
    }

    boolean search(int data) {
        Node current = head;  // Baştan başla

        while (current != null) {  // Tren bitene kadar
            if (current.data == data) {  // Buldum!
                System.out.println("Bulundu: " + data);
                return true;
            }
            current = current.next;  // Sonraki vagona geç
        }

        System.out.println("Bulunamadı: " + data);
        return false;
    }

    // ELEMAN SİL (Trenden vagon çıkar)
    void remove(int data) {
        // DURUM 1: Tren boş
        if (head == null) {
            System.out.println("Liste boş!");
            return;
        }

        // DURUM 2: İlk vagon silinecek
        if (head.data == data) {
            head = head.next;  // İkinci vagonu baş yap
            System.out.println("Silindi (baş): " + data);
            return;
        }

        // DURUM 3: Ortadaki bir vagon
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                // Silinecek vagonu atla
                current.next = current.next.next;
                System.out.println("Silindi: " + data);
                return;
            }
            current = current.next;
        }

        System.out.println("Silinemedi (bulunamadı): " + data);
    }

    // TÜM LİSTEYİ YAZDIR (Treni göster)
    void print() {
        if (head == null) {
            System.out.println("Liste boş!");
            return;
        }

        System.out.print("Liste: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println(" → null");
    }
}
