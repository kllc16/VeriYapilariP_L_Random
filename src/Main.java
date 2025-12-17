class Main {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();

        System.out.println("=== EKLEME ===");
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();

        System.out.println("\n=== ARAMA ===");
        list.search(20);
        list.search(50);

        System.out.println("\n=== SİLME ===");
        list.remove(20);
        list.print();

        list.remove(10);
        list.print();
    }
}
/*
ÇIKTI:
=== EKLEME ===
İlk eleman eklendi: 10
Sona eklendi: 20
Sona eklendi: 30
Liste: 10 → 20 → 30 → null

=== ARAMA ===
Bulundu: 20
Bulunamadı: 50

=== SİLME ===
Silindi: 20
Liste: 10 → 30 → null
Silindi (baş): 10
Liste: 30 → null
*/
