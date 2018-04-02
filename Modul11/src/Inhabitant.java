import java.util.Random;

public class Inhabitant {
    private String name;
    private int age;
    private String gender;
    private String familyRole;
    private String job;

    public Inhabitant() {
        this.gender = randomGender();
        this.familyRole = assignRole();
        this.age = randomAge();
        this.name = randomName();
        this.job = randomJob();
    }

    public int randomAge() {
        int age = 0;
        Random r = new Random();
        String type = "";
        switch (this.familyRole.toLowerCase()) {
            case "son":
            case "daughter":
                String[] childTypes = {"toddler", "child", "teenager"};
                type = childTypes[r.nextInt(childTypes.length)];
                break;

            case "father":
            case "mother":
                type = "adult";
                break;

            case "grandfather":
            case "grandmother":
                type = "grandparent";
                break;
        }
        switch (type.toLowerCase()) {
            case "toddler":
                age = 0+ r.nextInt(2);
                break;

            case "child":
                age = 2 + r.nextInt(10);
                break;

            case "teenager":
                age = 13 + r.nextInt(6);
                break;

            case "adult":
                age = 20 + r.nextInt(39);
                break;

            case "grandparent":
                age = 60 + r.nextInt(39);
                break;

            default:
                System.out.printf("%s could not be recognised, please try any of these next time:\n", type);
                System.out.println("toddler child teenager adult grandparent");
        }
        return age;
    }

    public String randomGender() {
        Random r = new Random();
        String[] genders = {"male", "female"};
        String gender = genders[r.nextInt(genders.length)];
        return gender;
    }


    public String assignRole() {
        Random r = new Random();
        String role = "placeholder_not_to_be_seen";
        switch (this.gender.toLowerCase()) {
            case "male":
                String[] maleRoles = {"son", "father", "grandfather"};
                role = maleRoles[r.nextInt(maleRoles.length)];
                break;
            case "female":
                String[] femaleRoles = {"daughter", "mother", "grandmother"};
                role = femaleRoles[r.nextInt(femaleRoles.length)];
                break;
        }
        return role;
    }

    public String randomName() {
        String name = "";
        Random r = new Random();
        switch (gender.toLowerCase()) {
            case "male":
                String[] maleNames = {"Bob", "Harry", "Bobby", "Rob"};
                name = maleNames[r.nextInt(maleNames.length)];
                break;
            case "female":
                String[] femaleNames = {"Sarah", "Emma", "Emilia", "Katrina"};
                name = femaleNames[r.nextInt(femaleNames.length)];
                break;
        }
        return name;
    }

    public String randomJob() {
        String job = "";
        switch (this.familyRole.toLowerCase()) {
            case "father":
            case "mother":
                String[] jobs = {"teacher", "IT", "engineer", "nurse", "pilot", "cleaner", "banker", "social services"};
                job = jobs[new Random().nextInt(jobs.length)];
                break;

            case "son":
            case "daughter":
                job = "unemployed / student";
                break;

            case "grandfather":
            case "grandmother":
                job = "retired";
                break;
        }
        return job;
    }

    public String getGender() {
        return this.gender;
    }

    public String getName() {
        return this.name;
    }

    public void printInfo() {
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Age: %d\n", this.age);
        System.out.printf("Gender: %s\n", this.gender);
        System.out.printf("Role: %s\n", this.familyRole);
        System.out.printf("Job: %s\n\n", this.job);
    }
}
