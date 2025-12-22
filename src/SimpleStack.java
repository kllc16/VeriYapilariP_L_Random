class SimpleStack {
    private StackNode top;    // Stack'in tepesi (en üstteki eleman)
    private int size;         // Stack boyutu

    /**
     * Constructor - Boş stack oluştur
     */
    public SimpleStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * PUSH - Stack'e EKLE (üste ekle)
     *
     * Mantık: Yeni tabağı en üste koy
     *
     * @param data Eklenecek veri
     * Time Complexity: O(1)
     */
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        System.out.println("⬆️  Push: " + data);

        // Yeni node'un next'i eski top'u gösterir
        newNode.next = top;

        // Top'u yeni node yap
        top = newNode;

        size++;
        System.out.println("   Stack size: " + size);
    }

    /**
     * POP - Stack'ten ÇIKAR (üstten çıkar)
     *
     * Mantık: En üstteki tabağı al
     *
     * @return Çıkarılan veri, stack boşsa -1
     * Time Complexity: O(1)
     */
    public int pop() {
        // DURUM 1: Stack boş
        if (top == null) {
            System.out.println("❌ Pop failed: Stack is empty!");
            return -1;
        }

        // Çıkarılacak elemanı sakla
        int removed = top.data;
        System.out.println("⬇️  Pop: " + removed);

        // Top'u bir alta kaydır
        top = top.next;

        size--;
        System.out.println("   Stack size: " + size);

        return removed;
    }

    /**
     * PEEK - En üstteki elemanı GÖR (çıkarmadan)
     *
     * @return En üstteki veri, stack boşsa -1
     */
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    /**
     * SIZE - Stack boyutunu döndür
     */
    public int size() {
        return size;
    }

    /**
     * ISEMPTY - Stack boş mu?
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * PRINT - Stack'i yazdır
     */
    public void printStack() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║  STACK (Size: " + size + ")                  ║");
        System.out.println("╠════════════════════════════════════╣");

        if (top == null) {
            System.out.println("║  Empty stack                       ║");
            System.out.println("╚════════════════════════════════════╝");
            return;
        }

        System.out.println("║  TOP (Most Recent) ↓               ║");

        StackNode current = top;
        int position = 1;

        while (current != null) {
            System.out.printf("║    %d. [%d]%s                    ║%n",
                    position,
                    current.data,
                    position == 1 ? " ← TOP" : "");
            current = current.next;
            position++;
        }

        System.out.println("║  ↑ BOTTOM (Oldest)                 ║");
        System.out.println("╚════════════════════════════════════╝");
    }
}
