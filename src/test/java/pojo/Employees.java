package pojo;

public class Employees {
    private int Id;
    private String FirstName;
    private String LastName;
    private int Age;
    private int Salary;
    private String Department;

    Employees(){}
    public Employees(int Id, String FirstName, String LastName, int Age, int Salary, String Department) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.Salary = Salary;
        this.Department = Department;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public int getSalary() {
        return Salary;
    }

    public String getDepartment() {
        return Department;
    }

   public static class Builder{
       private int Id;
       private String FirstName;
       private String LastName;
       private int Age;
       private int Salary;
       private String Department;

       public Builder(){}

       public Builder setId(int Id){this.Id=Id; return this;}

       public Builder setFirstName(String FirstName){this.FirstName=FirstName; return this;}

       public Builder setLastName(String LastName){this.LastName=LastName;return this;};

       public Builder setAge(int Age){this.Age=Age;return this;}

       public Builder setSalary(int Salary){this.Salary=Salary;return this;};

       public Builder setDepartment(String Department){this.Department=Department;return this;};

       public Employees build()
       {
           return new Employees(Id,FirstName,LastName,Age,Salary,Department);
       }


   }
}
