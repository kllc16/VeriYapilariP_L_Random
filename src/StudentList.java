class StudentList {
    private StudentNode head;  // Listenin başı

    public StudentList() {
        this.head = null;
    }

    /**
     * Yeni öğrenci ekle - Listenin SONUNA ekler
     * Zaman Karmaşıklığı: O(n) - Sona gitmek için tüm listeyi gezmek gerekir
     */
    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);

        // Liste boşsa, yeni düğüm head olur
        if (head == null) {
            head = newNode;
            return;
        }

        // Liste doluysa, sona git ve ekle
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Öğrenciyi ID ile bul
     * Zaman Karmaşıklığı: O(n) - En kötü durumda tüm listeyi gezmek gerekir
     */
    public Student findStudent(int id) {
        StudentNode current = head;
        while (current != null) {
            if (current.student.id == id) {
                return current.student;
            }
            current = current.next;
        }
        return null; // Bulunamadı
    }

    /**
     * Tüm öğrencileri yazdır
     */
    public void printAll() {
        if (head == null) {
            System.out.println("   Liste boş!");
            return;
        }

        StudentNode current = head;
        int count = 1;
        while (current != null) {
            System.out.print(count++ + ". ");
            current.student.display();
            current = current.next;
        }
    }

    /**
     * Linked List'i array'e çevir (sorting için gerekli)
     * Zaman Karmaşıklığı: O(n)
     */
    public Student[] toArray() {
        // Önce kaç öğrenci var say
        int count = 0;
        StudentNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Array oluştur ve doldur
        Student[] array = new Student[count];
        current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.student;
            current = current.next;
        }

        return array;
    }

    /**
     * Array'den Linked List'i yeniden oluştur
     */
    public void fromArray(Student[] array) {
        head = null; // Listeyi temizle
        for (Student student : array) {
            addStudent(student);
        }
    }

    /**
     * Liste boş mu kontrol et
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Listedeki öğrenci sayısı
     */
    public int size() {
        int count = 0;
        StudentNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
