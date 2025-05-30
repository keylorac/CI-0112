public class StudentTest 
{
    public static void main(String[] args)
    {
        Student account1 = new Student("Keylor Arley", 93.5);
        Student account2 = new Student("David Castro", 95);
        

        System.out.printf("%s's letter grade for Student is: %s%n", account1.getName(), account1.getLetterGrade());
        System.out.printf("%s's letter grade for Student is: %s%n", account2.getName(), account2.getLetterGrade());
    }
    
}
