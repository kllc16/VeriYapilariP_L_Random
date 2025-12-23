class StudentNode {
    Student student;      // Bu düğümde tutulan öğrenci
    StudentNode next;     // Bir sonraki düğüm

    public StudentNode(Student student) {
        this.student = student;
        this.next = null;
    }
}
