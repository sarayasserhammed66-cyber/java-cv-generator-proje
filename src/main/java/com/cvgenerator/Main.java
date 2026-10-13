package com.cvgenerator;

public class Main {
    public static void main(String[] args) {
        // Person details
        String fullName = "Sara Yasser Hammed Helmmy";
        String email = "srayasserhammedhelmmy66@gmail.com";
        String phone = "05395244045";

        // Path to image inside images folder
        String imagePath = "images/profile.jpg";

        Person sara = new Person(fullName, email, phone, imagePath);

        // 3 Fake Work Experiences
        sara.addWorkExperience(new WorkExperience(
                "Tech Solutions Inc.",
                "Junior Software Developer",
                "2023 - 2024",
                "Assisted in developing Web APIs using Java and Spring Boot. Participated in daily stand-ups and code reviews."
        ));

        sara.addWorkExperience(new WorkExperience(
                "Innovate Mobile Labs",
                "Android Developer Intern",
                "2022 - 2023",
                "Worked on user interface improvements and bug fixes for core client application."
        ));

        sara.addWorkExperience(new WorkExperience(
                "Global Data Corp",
                "Data Entry & Support Specialist",
                "2021 - 2022",
                "Managed system database updates and provided technical assistance to international customers."
        ));

        // Generate PDF via separate CVGeneration class
        String outputPath = "Sara_Yasser_CV.pdf";
        CVGeneration.createPDF(sara, outputPath);
    }
}