    public class employeeSal {
        private String firstName;
        private String lastName;
        private float hoursWorked;
        private float hourlyWage;
        private float overtimeHours;
        private float regularHours;

        public float computeSalary() {
            int longHours = 0; //set to 1 if the employee is working very long hours, set to 0 otherwise
            int lowWage = 0; //set to 1 if the employee's wage is low, set to 0 otherwise
            if (hoursWorked > 60) {
                System.out.println("Too many hours");
            }
            float employeesWage;
            employeesWage = (hourlyWage * regularHours);
            if (employeesWage < 320) {
                lowWage = 1;
                System.out.println("Wage is too low");
            }
            if ((longHours == 1) && (lowWage == 1)) {
                return -1;
            }
            if (longHours == 1) {
                return -2;
            }
            if (lowWage == 1) {
                return -3;
            }
            overtimeHours = hoursWorked + regularHours;
            regularHours = 40;
            return regularHours * hourlyWage + overtimeHours * hourlyWage * 1.5f;

        }

        public employeeSal(String firstName, String lastName, float
                hourlyWage, float hoursWorked) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.hoursWorked = ((hoursWorked >= 0) ? hoursWorked : 0);
            this.hourlyWage = ((hourlyWage >= 0) ? hourlyWage : 0);
        }

        static void displayOutput(employeeSal e) {
            float hourlyWage = 8.0F;
            float regularHours = 40.0F;
            float employeesWage = hourlyWage * regularHours;

            switch ((int) e.computeSalary()) {
                case -1:
                    System.out.println("Wage is too low. Too many hours.");
                    break;
                case -2:
                    System.out.println("Too many hours");
                    break;
                case -3:
                    System.out.println("Wage is too low.");
                    break;
                default:
                    System.out.println(employeesWage);
                    break;
            }
        }

        public static void main(String[] args) {
            employeeSal e1 = new employeeSal("John", "Doe", 7.5f, 35);
            displayOutput(e1);
            employeeSal e2 = new employeeSal("Jane", "Doe", 8.2f, 47);
            displayOutput(e2);
            employeeSal e3 = new employeeSal("Cilla", "Doe", 10, 70);
            displayOutput(e3);
            employeeSal e4 = new employeeSal("Peter", "Doe", 6, 80);
            displayOutput(e4);
        }
    }