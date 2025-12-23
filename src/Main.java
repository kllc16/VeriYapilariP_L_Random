public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║     ÖĞRENCİ YÖNETİM SİSTEMİ - HashMap & Bubble Sort Demo     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        // Sistem oluştur
        StudentManagementSystem system = new StudentManagementSystem();

        // ============= TEST 1: ÖĞRENCİ EKLEME =============
        System.out.println("📝 TEST 1: Öğrenci Ekleme (HashMap kullanımı)\n");
        System.out.println("Her öğrenci hem Linked List'e hem HashMap'e ekleniyor...\n");

        system.addStudent(new Student(1001, "Ahmet Yılmaz", 3.45, 20));
        system.addStudent(new Student(1002, "Ayşe Kaya", 3.89, 19));
        system.addStudent(new Student(1003, "Mehmet Demir", 2.67, 22));
        system.addStudent(new Student(1004, "Fatma Şahin", 3.92, 21));
        system.addStudent(new Student(1005, "Ali Çelik", 2.34, 23));
        system.addStudent(new Student(1006, "Zeynep Arslan", 3.78, 20));
        system.addStudent(new Student(1007, "Mustafa Öz", 3.12, 19));
        system.addStudent(new Student(1008, "Elif Yıldız", 3.56, 22));

        // Duplicate ID testi
        System.out.println("\n⚠️ Duplicate ID Testi (HashMap containsKey kullanımı):");
        system.addStudent(new Student(1005, "Yanlış Öğrenci", 4.0, 25));

        // Geçersiz GPA testi
        System.out.println("\n⚠️ Geçersiz GPA Testi:");
        system.addStudent(new Student(1009, "Hatalı Öğrenci", 5.0, 20));

        // İlk durum
        system.printSystemState();

        bekle();

        // ============= TEST 2: ARAMA İŞLEMİ (HashMap vs Linked List) =============
        System.out.println("\n📝 TEST 2: Öğrenci Arama (HashMap'in Hızını Gör!)\n");
        System.out.println("HashMap O(1) - Linked List O(n) karşılaştırması:\n");

        // Başta bir öğrenci ara
        system.searchStudent(1002);

        bekle();

        // Sonda bir öğrenci ara (Linked List için en kötü durum)
        system.searchStudent(1008);

        bekle();

        // Olmayan bir öğrenci ara
        system.searchStudent(9999);

        bekle();

        // ============= TEST 3: BUBBLE SORT (GPA'ya göre) =============
        System.out.println("\n📝 TEST 3: Bubble Sort ile GPA Sıralaması\n");
        System.out.println("Şu anki sıralama (ekleme sırasına göre):");
        system.printSystemState();

        bekle();

        // GPA'ya göre sırala
        system.sortByGPA();

        // Sıralı hali göster
        System.out.println("\n✅ Sıralanmış Liste (GPA Büyükten Küçüğe):");
        system.printSystemState();

        bekle();

        // ============= TEST 4: BUBBLE SORT (Yaşa göre) =============
        System.out.println("\n📝 TEST 4: Bubble Sort ile Yaş Sıralaması\n");

        system.sortByAge();

        System.out.println("\n✅ Sıralanmış Liste (Yaş Küçükten Büyüğe):");
        system.printSystemState();

        bekle();

        // ============= TEST 5: İSTATİSTİKLER =============
        System.out.println("\n📝 TEST 5: İstatistik Hesaplama\n");
        system.calculateAverageGPA();

        // ============= BİTİŞ =============
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    TESTLER TAMAMLANDI!                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("\n💡 ÖNEMLİ NOKTALAR:");
        System.out.println("   1. HashMap O(1) arama - Linked List O(n) aramadan ÇOK HIZLI");
        System.out.println("   2. Bubble Sort O(n²) - Basit ama yavaş");
        System.out.println("   3. Duplicate kontrolü HashMap.containsKey() ile O(1)");
        System.out.println("   4. Sorting için array'e çevirme gerekli (Linked List sıralamak zor)");
    }

    // Kullanıcıya okuma zamanı vermek için bekle
    private static void bekle() {
        System.out.println("\n⏳ Devam etmek için Enter'a basın...");
        try {
            System.in.read();
            // Buffer'daki kalan karakterleri temizle
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (Exception e) {
            // Hata olursa devam et
        }
    }
}
