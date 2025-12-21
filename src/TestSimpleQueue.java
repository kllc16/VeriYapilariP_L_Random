class TestSimpleQueue {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();

        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║     QUEUE (FIFO) DEMONSTRATION           ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");

        // TEST 1: Boş kuyruktan çıkarma
        System.out.println("=== TEST 1: Dequeue from Empty Queue ===");
        queue.dequeue();

        System.out.println("\n" + "=".repeat(45));

        // TEST 2: Enqueue (5 eleman ekle)
        System.out.println("\n=== TEST 2: Enqueue 5 Elements ===");
        System.out.println("(Düşün: 5 hasta sırayla geliyor)\n");

        queue.enqueue(10);  // Ahmet (1. sıra)
        queue.enqueue(20);  // Ayşe (2. sıra)
        queue.enqueue(30);  // Mehmet (3. sıra)
        queue.enqueue(40);  // Fatma (4. sıra)
        queue.enqueue(50);  // Ali (5. sıra)

        queue.printQueue();

        System.out.println("\n" + "=".repeat(45));

        // TEST 3: Peek (baş elemanı gör)
        System.out.println("\n=== TEST 3: Peek (See Front) ===");
        System.out.println("Front element: " + queue.peek());
        System.out.println("(Peek doesn't remove, just looks)");

        System.out.println("\n" + "=".repeat(45));

        // TEST 4: Dequeue (3 eleman çıkar)
        System.out.println("\n=== TEST 4: Dequeue 3 Elements ===");
        System.out.println("(İlk 3 hasta tedavi oluyor)\n");

        int first = queue.dequeue();   // 10 çıkar (Ahmet)
        int second = queue.dequeue();  // 20 çıkar (Ayşe)
        int third = queue.dequeue();   // 30 çıkar (Mehmet)

        System.out.println("\nRemoved: " + first + ", " + second + ", " + third);

        queue.printQueue();

        System.out.println("\n" + "=".repeat(45));

        // TEST 5: Yeni elemanlar ekle
        System.out.println("\n=== TEST 5: Add More Elements ===");
        System.out.println("(2 yeni hasta geldi)\n");

        queue.enqueue(60);  // Zeynep
        queue.enqueue(70);  // Hasan

        queue.printQueue();

        System.out.println("\n" + "=".repeat(45));

        // TEST 6: Tümünü çıkar
        System.out.println("\n=== TEST 6: Empty the Queue ===");
        System.out.println("(Kalan hastaları da tedavi et)\n");

        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        queue.printQueue();

        System.out.println("\n" + "=".repeat(45));

        // TEST 7: FIFO Gösterimi
        System.out.println("\n=== TEST 7: FIFO Visualization ===");

        System.out.println("\nAdding: A, B, C, D");
        SimpleQueue demo = new SimpleQueue();
        demo.enqueue('A');
        demo.enqueue('B');
        demo.enqueue('C');
        demo.enqueue('D');

        System.out.println("\n📥 INPUT ORDER: A → B → C → D");
        System.out.println("📤 OUTPUT ORDER: ");

        System.out.print("  ");
        while (!demo.isEmpty()) {
            char c = (char) demo.dequeue();
            System.out.print(c);
            if (!demo.isEmpty()) System.out.print(" → ");
        }
        System.out.println("\n\n✅ FIFO: First In (A), First Out (A)");

        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  KEY CONCEPTS:                           ║");
        System.out.println("║  • Enqueue = Add to REAR (O(1))          ║");
        System.out.println("║  • Dequeue = Remove from FRONT (O(1))    ║");
        System.out.println("║  • FIFO = Fair, First-Come-First-Served  ║");
        System.out.println("║  • Used for: Scheduling, BFS, etc.       ║");
        System.out.println("╚═══════════════════════════════════════════╝");
    }
}
