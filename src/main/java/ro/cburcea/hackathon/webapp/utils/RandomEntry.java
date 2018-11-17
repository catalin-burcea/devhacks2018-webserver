package ro.cburcea.hackathon.webapp.utils;

import ro.cburcea.hackathon.webapp.entities.Company;
import ro.cburcea.hackathon.webapp.entities.Review;
import ro.cburcea.hackathon.webapp.entities.Tag;
import ro.cburcea.hackathon.webapp.entities.User;
import ro.cburcea.hackathon.webapp.repositories.CompanyRepository;
import ro.cburcea.hackathon.webapp.repositories.ReviewRepository;
import ro.cburcea.hackathon.webapp.repositories.TagRepository;
import ro.cburcea.hackathon.webapp.repositories.UserRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RandomEntry {
    private static TreeSet<String> userSet;

//    private static class UserComparator implements Comparator<User> {
//        public int compare(User u1, User u2) {
//            return u1.getUsername().compareTo(u2.getUsername());
//        }
//        public boolean equals(User u1, User u2) {
//            return u1.getUsername().compareTo(u2.getUsername()) == 0;
//        }
//    }

    static {
        userSet = new TreeSet<String>();
    };

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            users.add(getRandomUser());
        }

//        System.out.println(users.get(4).getName());

        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Java"));
        tags.add(new Tag("Javascript"));
        tags.add(new Tag("Banking"));
        tags.add(new Tag("Python"));

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Salaries");
        categories.add("Interviews");
        categories.add("Trainings");
        categories.add("Salaries");

        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("Company1", "desc", 30, "Bucharest", tags.get(0)));
        companies.add(new Company("Company2", "desc", 300, "Bucharest", tags.get(1)));
        companies.add(new Company("Company3", "desc", 1000, "London", tags.get(2)));
        companies.add(new Company("Company4", "desc", 200, "Madrid", tags.get(3)));

        ArrayList<Review> reviews = new ArrayList<>();
        initRandomReview(users, companies, categories);
        for (int i = 0; i < 50; ++i) {
            reviews.add(getRandomReview());
        }

        int idx = 3;
//        System.out.println(reviews.get(idx).getUser().getUsername() + " " + reviews.get(idx).getRating() + " " + reviews.get(idx).getCompany().getName());

    }

    public static void addToDB(ReviewRepository reviewRepository, UserRepository userRepository, CompanyRepository companyRepository, TagRepository tagRepository) throws FileNotFoundException {

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            users.add(getRandomUser());
            System.out.println("Preloading " + userRepository.save(users.get(i)));
        }

        System.out.println(users.get(4).getName());

        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Java"));
        tags.add(new Tag("Javascript"));
        tags.add(new Tag("Banking"));
        tags.add(new Tag("Python"));
        for (Tag t : tags) {
            System.out.println("Preloading " + tagRepository.save(t));
        }

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Salaries");
        categories.add("Interviews");
        categories.add("Trainings");
        categories.add("Salaries");

        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("Company1", "desc", 30, "Bucharest", tags.get(0)));
        companies.add(new Company("Company2", "desc", 300, "Bucharest", tags.get(1)));
        companies.add(new Company("Company3", "desc", 1000, "London", tags.get(2)));
        companies.add(new Company("Company4", "desc", 200, "Madrid", tags.get(3)));
        for (Company c : companies) {
            System.out.println("Preloading " + companyRepository.save(c));
        }

        ArrayList<Review> reviews = new ArrayList<>();
        initRandomReview(users, companies, categories);
        for (int i = 0; i < 50; ++i) {
            reviews.add(getRandomReview());
        }
        for (Review r : reviews) {
            System.out.println("Preloading " + reviewRepository.save(r));
        }

        int idx = 3;
        System.out.println(reviews.get(idx).getUser().getUsername() + " " + reviews.get(idx).getRating() + " " + reviews.get(idx).getCompany().getName());

    }

    private static class Group {
        public User user;
        public Company company;
        public String category;
        public Group(User u, Company c, String cat) {
            user = u;
            company = c;
            category = cat;
        }
    };

    private static ArrayList<Group> possibleReviews;
    static {
        possibleReviews = new ArrayList<>();
    }

    public static void initRandomReview(ArrayList<User> users, ArrayList<Company> companies, ArrayList<String> categories) {
        for (User u : users) {
            for (Company c : companies) {
                for (String cat : categories) {
                    possibleReviews.add(new Group(u,c,cat));
                }
            }
        }
    }

    public static Review getRandomReview() {
        if (possibleReviews.size() == 0) {
//            throw 0;
        }

        Random rand = new Random();
        int idx = rand.nextInt(possibleReviews.size());
        int rating = rand.nextInt(5) + 1;
        Review ret = new Review("Default description", rating, possibleReviews.get(idx).category, possibleReviews.get(idx).company, possibleReviews.get(idx).user);
        possibleReviews.remove(idx);
        return ret;
    }

    public static String getRandomString(String fileName) throws FileNotFoundException {
        RandomEntry re = new RandomEntry();
        File file = new File(re.getClass().getClassLoader().getResource(fileName).getFile());
        Scanner in = new Scanner(file);

        ArrayList<String> names = new ArrayList<>();
        while (in.hasNext()) {
            String name = in.next();
            names.add(name);
        }

        Random rand = new Random();
        int idx1 = rand.nextInt(names.size());
        return names.get(idx1);
    }

    public static User getRandomUser () throws FileNotFoundException {
        RandomEntry re = new RandomEntry();
        File file = new File(re.getClass().getClassLoader().getResource("animalNames.txt").getFile());

        String username;

        while (true) {
            username = getRandomString("animalNames.txt") + getRandomString("animalNames.txt");
            if (userSet.contains(username) == false) {
                userSet.add(username);
                break;
            }
        }

        String name = getRandomString("firstName.txt") + " " + getRandomString("lastName.txt");
        String pass = "1234";

        return new User(name, username, pass);
    }
}
