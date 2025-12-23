import java.util.HashMap;

class StudentManagementSystem {
    private StudentList studentList;                    // Linked List - Tüm öğrenciler
    private HashMap<Integer, Student> studentMap;       // HashMap - Hızlı arama için

    public StudentManagementSystem() {
        this.studentList = new StudentList();
        this.studentMap = new HashMap<>();
    }

    /**
     * Öğrenci ekle - Hem Linked List'e hem HashMap'e
     * Linked List: O(n) - Sona eklemek için
     * HashMap: O(1) - Sabit zamanda ekleme
     */
    public void addStudent(Student student) {
        // Duplicate ID kontrolü - HashMap sayesinde O(1)
        if (studentMap.containsKey(student.id)) {
            System.out.println("❌ HATA: " + student.id + " ID'si zaten kullanılıyor!");
            return;
        }

        // GPA kontrolü
        if (student.gpa < 0.0 || student.gpa > 4.0) {
            System.out.println("❌ HATA: GPA 0.0 ile 4.0 arasında olmalı!");
            return;
        }

        // Linked List'e ekle
        studentList.addStudent(student);

        // HashMap'e ekle - O(1)
        studentMap.put(student.id, student);

        System.out.println("✅ Öğrenci eklendi: " + student.name + " (ID: " + student.id + ")");
    }

    /**
     * Öğrenci ara - HashMap kullanarak HIZLI ARAMA
     * HashMap: O(1) - Çok hızlı!
     * Linked List kullanseydık: O(n) - Yavaş olurdu
     */
    public void searchStudent(int id) {
        System.out.println("\n🔍 ID " + id + " aranıyor...");

        // HashMap ile arama - O(1) - ANINDA BULUR!
        long startTime = System.nanoTime();
        Student foundByHash = studentMap.get(id);
        long hashTime = System.nanoTime() - startTime;

        if (foundByHash != null) {
            System.out.println("✅ HashMap ile bulundu (Süre: " + hashTime + " nanosaniye):");
            foundByHash.display();
        } else {
            System.out.println("❌ Öğrenci bulunamadı!");
        }

        // KARŞILAŞTIRMA: Linked List ile arama - O(n) - YAVAS!
        startTime = System.nanoTime();
        Student foundByList = studentList.findStudent(id);
        long listTime = System.nanoTime() - startTime;

        System.out.println("📊 Linked List ile arama süresi: " + listTime + " nanosaniye");
        System.out.println("⚡ HashMap " + (listTime / Math.max(hashTime, 1)) + "x daha hızlı!");
    }

    /**
     * BUBBLE SORT - GPA'ya göre sıralama (Büyükten küçüğe)
     * Zaman Karmaşıklığı: O(n²) - Yavaş ama basit
     */
    public void sortByGPA() {
        System.out.println("\n🔄 Öğrenciler GPA'ya göre sıralanıyor (BUBBLE SORT)...");

        // Linked List'i array'e çevir
        Student[] students = studentList.toArray();
        int n = students.length;

        if (n == 0) {
            System.out.println("⚠️ Sıralanacak öğrenci yok!");
            return;
        }

        // BUBBLE SORT BAŞLIYOR
        long startTime = System.currentTimeMillis();
        int swapCount = 0;      // Kaç kez yer değiştirildi
        int comparisonCount = 0; // Kaç kez karşılaştırıldı

        // Dış döngü: n-1 tur
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Bu turda hiç swap oldu mu?

            System.out.println("   Tur " + (i + 1) + "...");

            // İç döngü: Yan yana elemanları karşılaştır
            for (int j = 0; j < n - i - 1; j++) {
                comparisonCount++;

                // GPA küçükse yer değiştir (büyük olanlar başa gelsin)
                if (students[j].gpa < students[j + 1].gpa) {
                    // SWAP (Yer değiştirme)
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;

                    swapped = true;
                    swapCount++;
                }
            }

            // Eğer bu turda hiç swap olmadıysa, liste zaten sıralı demektir
            if (!swapped) {
                System.out.println("   ✓ Erken çıkış - Liste sıralı!");
                break;
            }
        }

        long endTime = System.currentTimeMillis();

        // Array'i tekrar Linked List'e çevir
        studentList.fromArray(students);

        System.out.println("✅ Sıralama tamamlandı!");
        System.out.println("   Süre: " + (endTime - startTime) + " ms");
        System.out.println("   Karşılaştırma sayısı: " + comparisonCount);
        System.out.println("   Yer değiştirme sayısı: " + swapCount);
        System.out.println("   Big O: O(n²) = O(" + n + "²) = " + (n * n));
    }

    /**
     * BUBBLE SORT - Yaşa göre sıralama (Küçükten büyüğe)
     */
    public void sortByAge() {
        System.out.println("\n🔄 Öğrenciler yaşa göre sıralanıyor (BUBBLE SORT)...");

        Student[] students = studentList.toArray();
        int n = students.length;

        if (n == 0) {
            System.out.println("⚠️ Sıralanacak öğrenci yok!");
            return;
        }

        // BUBBLE SORT - Yaş için
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Yaş büyükse yer değiştir (küçük olanlar başa gelsin)
                if (students[j].age > students[j + 1].age) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        studentList.fromArray(students);
        System.out.println("✅ Yaşa göre sıralama tamamlandı!");
    }

    /**
     * Sistem durumunu göster
     */
    public void printSystemState() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("📚 ÖĞRENCİ YÖNETİM SİSTEMİ DURUMU");
        System.out.println("=".repeat(70));

        System.out.println("📊 İstatistikler:");
        System.out.println("   Toplam Öğrenci (Linked List): " + studentList.size());
        System.out.println("   Toplam Öğrenci (HashMap): " + studentMap.size());

        if (!studentList.isEmpty()) {
            System.out.println("\n👥 ÖĞRENCİ LİSTESİ:");
            studentList.printAll();
        }

        System.out.println("=".repeat(70));
    }

    /**
     * Ortalama GPA hesapla
     */
    public void calculateAverageGPA() {
        Student[] students = studentList.toArray();
        if (students.length == 0) {
            System.out.println("⚠️ Hesaplanacak öğrenci yok!");
            return;
        }

        double total = 0;
        for (Student s : students) {
            total += s.gpa;
        }

        double average = total / students.length;
        System.out.println("📊 Ortalama GPA: " + String.format("%.2f", average));
    }
}
