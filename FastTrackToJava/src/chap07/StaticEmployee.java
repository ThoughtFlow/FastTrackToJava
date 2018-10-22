package chap07;

class StaticEmployee {
    String name;
    String ssn;
    String emailAddress;
    int yearOfBirth;
    int extraVacationDays = 0;
    static int baseVacationDays = 10;

    StaticEmployee(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    static void setBaseVacationDays(int days) {
        baseVacationDays = days < 10? 10 : days;
    }

    static int getBaseVacationDays() {
        return baseVacationDays;
    }

    void setExtraVacationDays(int days) {
        extraVacationDays = days < 0? 0 : days;
    }

    int getExtraVacationDays() {
        return extraVacationDays;
    }

    void setYearOfBirth(int year) {
        yearOfBirth = year;
    }

    int getVacationDays() {
        return baseVacationDays + extraVacationDays;
    }

    void print() {
        System.out.println("Name: " + name);
        System.out.println("SSN: " + ssn);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Year Of Birth: " + yearOfBirth);
        System.out.println("Vacation Days: " + getVacationDays());
    }
}
