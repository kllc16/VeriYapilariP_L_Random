class TestSimpleStack {
    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack();

        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║     STACK (LIFO) DEMONSTRATION           ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");

        // TEST 1: Boş stack'ten çıkarma
        System.out.println("=== TEST 1: Pop from Empty Stack ===");
        stack.pop();

        System.out.println("\n" + "=".repeat(45));

        // TEST 2: Push (5 eleman ekle)
        System.out.println("\n=== TEST 2: Push 5 Elements ===");
        System.out.println("(Düşün: 5 tabak üst üste koyuyoruz)\n");

        stack.push(10);  // İlk tabak (en altta)
        stack.push(20);  // İkinci tabak
        stack.push(30);  // Üçüncü tabak
        stack.push(40);  // Dördüncü tabak
        stack.push(50);  // Beşinci tabak (en üstte!)

        stack.printStack();

        System.out.println("\n" + "=".repeat(45));

        // TEST 3: Peek (üst elemanı gör)
        System.out.println("\n=== TEST 3: Peek (See Top) ===");
        System.out.println("Top element: " + stack.peek());
        System.out.println("(Peek doesn't remove, just looks)");

        System.out.println("\n" + "=".repeat(45));

        // TEST 4: Pop (3 eleman çıkar)
        System.out.println("\n=== TEST 4: Pop 3 Elements ===");
        System.out.println("(Üstten 3 tabak alıyoruz)\n");

        int first = stack.pop();   // 50 çıkar (en üstteki)
        int second = stack.pop();  // 40 çıkar
        int third = stack.pop();   // 30 çıkar

        System.out.println("\nRemoved (LIFO order): " + first + ", " + second + ", " + third);

        stack.printStack();

        System.out.println("\n" + "=".repeat(45));

        // TEST 5: Yeni elemanlar ekle
        System.out.println("\n=== TEST 5: Add More Elements ===");
        System.out.println("(2 yeni tabak ekliyoruz)\n");

        stack.push(60);  // Yeni üst
        stack.push(70);  // En yeni üst!

        stack.printStack();

        System.out.println("\n" + "=".repeat(45));

        // TEST 6: Tümünü çıkar
        System.out.println("\n=== TEST 6: Empty the Stack ===");
        System.out.println("(Tüm tabakları alıyoruz)\n");

        while (!stack.isEmpty()) {
            stack.pop();
        }

        stack.printStack();

        System.out.println("\n" + "=".repeat(45));

        // TEST 7: LIFO Gösterimi
        System.out.println("\n=== TEST 7: LIFO Visualization ===");

        System.out.println("\nAdding: A, B, C, D");
        SimpleStack demo = new SimpleStack();
        demo.push('A');  // İlk eklenen
        demo.push('B');
        demo.push('C');
        demo.push('D');  // Son eklenen (en üstte)

        System.out.println("\n📥 INPUT ORDER: A → B → C → D");
        System.out.println("📤 OUTPUT ORDER: ");

        System.out.print("  ");
        while (!demo.isEmpty()) {
            char c = (char) demo.pop();
            System.out.print(c);
            if (!demo.isEmpty()) System.out.print(" → ");
        }
        System.out.println("\n\n✅ LIFO: Last In (D), First Out (D)");

        System.out.println("\n" + "=".repeat(45));

        // TEST 8: TABAK ANALOJİSİ
        System.out.println("\n=== TEST 8: Plate Stack Analogy ===\n");

        SimpleStack plates = new SimpleStack();

        System.out.println("Mutfakta tabak yıkıyoruz:");
        plates.push(1); // İlk tabak (en alt)
        System.out.println("  [1] tabağı koyduk (en alt)");

        plates.push(2);
        System.out.println("  [2] tabağı üstüne koyduk");

        plates.push(3);
        System.out.println("  [3] tabağı üstüne koyduk");

        plates.push(4);
        System.out.println("  [4] tabağı üstüne koyduk");

        plates.push(5);
        System.out.println("  [5] tabağı üstüne koyduk (en üst)");

        System.out.println("\nTabak almak istiyoruz:");
        System.out.println("  Hangi tabağı alırız? → [5] (en üstteki!)");
        System.out.println("  [1] tabağını almak için önce üstteki 4 tabağı çıkarmalıyız!");

        plates.pop();
        System.out.println("  [5] aldık");

        System.out.println("\n✅ Bu STACK (LIFO) mantığıdır!");

        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  KEY CONCEPTS:                           ║");
        System.out.println("║  • Push = Add to TOP (O(1))              ║");
        System.out.println("║  • Pop = Remove from TOP (O(1))          ║");
        System.out.println("║  • LIFO = Last In, First Out             ║");
        System.out.println("║  • Used for: Undo, History, DFS, etc.    ║");
        System.out.println("║  • Medical: Recent records first!        ║");
        System.out.println("╚═══════════════════════════════════════════╝");
    }
}
