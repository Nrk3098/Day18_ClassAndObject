package Employee;
import java.util.Random;
public class EmployeeWage {
        private static final int WAGE_PER_HOUR = 20;
        private static final int FULL_DAY_HOURS = 8;
        private static final int PART_TIME_HOURS = 4;
        private static final int WORKING_DAYS_IN_MONTH = 20;
        private static final int MAX_WORKING_HOURS = 100;

        public static void main(String[] args) {
            int totalWorkingHours = 0;
            int totalWorkingDays = 0;
            int totalWage = 0;

            while (totalWorkingDays < WORKING_DAYS_IN_MONTH && totalWorkingHours < MAX_WORKING_HOURS) {
                int empType = getRandomNumber(0, 2);
                int empHours = 0;

                switch (empType) {
                    case 0:
                        System.out.println("Employee is absent");
                        break;
                    case 1:
                        System.out.println("Employee is present for full time");
                        empHours = FULL_DAY_HOURS;
                        break;
                    case 2:
                        System.out.println("Employee is present for part time");
                        empHours = PART_TIME_HOURS;
                        break;
                }

                int dailyWage = empHours * WAGE_PER_HOUR;
                totalWage += dailyWage;
                totalWorkingHours += empHours;
                totalWorkingDays++;

                System.out.println("Day " + totalWorkingDays + ": Hours Worked - " + empHours + ", Daily Wage - " + dailyWage);
            }

            System.out.println("Total working hours: " + totalWorkingHours);
            System.out.println("Total wage for the month: " + totalWage);
        }

        public static int getRandomNumber(int min, int max) {
            Random random = new Random();
            return random.nextInt((max - min) + 1) + min;
        }
    }


