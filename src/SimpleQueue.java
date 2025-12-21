class SimpleQueue {
    private QueueNode front;  // Kuyruğun başı (ilk gelen)
    private QueueNode rear;   // Kuyruğun sonu (son gelen)
    private int size;         // Kuyruk boyutu

    /**
     * Constructor - Boş kuyruk oluştur
     */
    public SimpleQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * ENQUEUE - Kuyruğa EKLE (sona ekle)
     *
     * Mantık: Yeni gelen hasta kuyruğun SONUNA gider
     *
     * @param data Eklenecek veri
     * Time Complexity: O(1) - rear pointer sayesinde
     */
    public void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);
        System.out.println("➕ Enqueue: " + data);

        // DURUM 1: Kuyruk boş
        if (rear == null) {
            front = newNode;  // İlk eleman hem front hem rear
            rear = newNode;
            System.out.println("   First in queue");
        }
        // DURUM 2: Kuyrukta eleman var
        else {
            rear.next = newNode;  // Son elemanın next'i yeni eleman
            rear = newNode;        // Rear'ı güncelle
            System.out.println("   Added to rear");
        }

        size++;
        System.out.println("   Queue size: " + size);
    }

    /**
     * DEQUEUE - Kuyruktan ÇIKAR (baştan çıkar)
     *
     * Mantık: İlk gelen hasta tedavi olup çıkar (FIFO)
     *
     * @return Çıkarılan veri, kuyruk boşsa -1
     * Time Complexity: O(1) - front pointer sayesinde
     */
    public int dequeue() {
        // DURUM 1: Kuyruk boş
        if (front == null) {
            System.out.println("❌ Dequeue failed: Queue is empty!");
            return -1;
        }

        // Çıkarılacak elemanı sakla
        int removed = front.data;
        System.out.println("➖ Dequeue: " + removed);

        // Front'u bir sonrakine kaydır
        front = front.next;

        // DURUM 2: Son eleman çıkarıldı
        if (front == null) {
            rear = null;  // Rear'ı da null yap
            System.out.println("   Queue is now empty");
        }

        size--;
        System.out.println("   Queue size: " + size);

        return removed;
    }

    /**
     * PEEK - En öndeki elemanı GÖR (çıkarmadan)
     *
     * @return En öndeki veri, kuyruk boşsa -1
     */
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    /**
     * SIZE - Kuyruk boyutunu döndür
     */
    public int size() {
        return size;
    }

    /**
     * ISEMPTY - Kuyruk boş mu?
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * PRINT - Kuyruğu yazdır
     */
    public void printQueue() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║  QUEUE (Size: " + size + ")                  ║");
        System.out.println("╠════════════════════════════════════╣");

        if (front == null) {
            System.out.println("║  Empty queue                       ║");
            System.out.println("╚════════════════════════════════════╝");
            return;
        }

        System.out.println("║  FRONT (First Out) →               ║");

        QueueNode current = front;
        int position = 1;

        while (current != null) {
            System.out.printf("║    %d. [%d]%s                    ║%n",
                    position,
                    current.data,
                    current == front ? " ← NEXT OUT" : "");
            current = current.next;
            position++;
        }

        System.out.println("║  ← REAR (Last In)                  ║");
        System.out.println("╚════════════════════════════════════╝");
    }
}