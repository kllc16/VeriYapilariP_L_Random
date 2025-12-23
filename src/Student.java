class Student {
    int id;           // Öğrenci numarası (benzersiz)
    String name;      // Öğrenci adı
    double gpa;       // Not ortalaması (0.0 - 4.0 arası)
    int age;          // Yaş

    // Constructor - Öğrenci oluştururken çalışır
    public Student(int id, String name, double gpa, int age) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    // Öğrenci bilgilerini ekrana yazdır
    public void display() {
        System.out.printf("   ID: %-6d | Ad: %-20s | GPA: %.2f | Yaş: %d%n",
                id, name, gpa, age);
    }
}
