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

    private static <T> T getRandomElement (ArrayList<T> arr) {
        Random rand = new Random();
        return arr.get( rand.nextInt(arr.size()) );
    }

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
        tags.add(new Tag("Real Estate"));
        tags.add(new Tag("Ocaml"));
        tags.add(new Tag("C++"));
        tags.add(new Tag("Computer Science"));
        tags.add(new Tag("Finance"));
        tags.add(new Tag("Grocery Shop"));

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Salaries");
        categories.add("Interviews");
        categories.add("Trainings");
        categories.add("Salaries");

        ArrayList<Company> companies = new ArrayList<>();
        companies.add( new Company("Endava", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 30, "Bucharest", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Catalysts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 550, "Bucharest", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("MetroSystems", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 100, "London", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("LondonStockExchange", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1000, "Madrid", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Google", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1000, "Madrid", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Facebook", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 234, "Bucharest", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Microsoft", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 444, "Berlin", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("BCR", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 4440, "Bucharest", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Mega Image", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 222, "Berlin", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Bloomberg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1090, "Berlin", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("JP Morgan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 321, "Berlin", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Palantir", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 3242, "Berlin", RandomEntry.<Tag>getRandomElement(tags)) );
        companies.add( new Company("Amazon", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1212, "Berlin", RandomEntry.<Tag>getRandomElement(tags)) );

        ArrayList<Review> reviews = new ArrayList<>();
        initRandomReview(users, companies, categories);
        for (int i = 0; i < 300; ++i) {
            reviews.add(getRandomReview());
        }

//        int idx = 3;
//        System.out.println(reviews.get(idx).getUser().getUsername() + " " + reviews.get(idx).getRating() + " " + reviews.get(idx).getCompany().getName());

    }

    public static void addToDB(ReviewRepository reviewRepository, UserRepository userRepository, CompanyRepository companyRepository, TagRepository tagRepository) throws FileNotFoundException {

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            users.add(getRandomUser());
            System.out.println("Preloading " + userRepository.save(users.get(i)));
        }

//        System.out.println(users.get(4).getName());

        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Java"));
        tags.add(new Tag("Javascript"));
        tags.add(new Tag("Banking"));
        tags.add(new Tag("Python"));
        tags.add(new Tag("Real Estate"));
        tags.add(new Tag("Ocaml"));
        tags.add(new Tag("C++"));
        tags.add(new Tag("Computer Science"));
        tags.add(new Tag("Finance"));
        tags.add(new Tag("Grocery Shop"));
        for (Tag t : tags) {
            System.out.println("Preloading " + tagRepository.save(t));
        }

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Salaries");
        categories.add("Interviews");
        categories.add("Trainings");
        categories.add("Salaries");

        ArrayList<Company> companies = new ArrayList<>();
        companies.add( new Company("Endava", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 30, "Bucharest", tags.get(0)) );
        companies.add( new Company("Catalysts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 550, "Bucharest", tags.get(0)) );
        companies.add( new Company("MetroSystems", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 100, "London", tags.get(0)) );
        companies.add( new Company("LondonStockExchange", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1000, "Madrid", tags.get(8)) );
        companies.add( new Company("Google", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1000, "Madrid", tags.get(7)) );
        companies.add( new Company("Facebook", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 234, "Bucharest", tags.get(7)) );
        companies.add( new Company("Microsoft", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 444, "Berlin", tags.get(7)) );
        companies.add( new Company("BCR", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 4440, "Bucharest", tags.get(2)) );
        companies.add( new Company("Mega Image", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 222, "Berlin", tags.get(9)) );
        companies.add( new Company("Bloomberg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1090, "Berlin", tags.get(8)) );
        companies.add( new Company("JP Morgan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 321, "Berlin", tags.get(2)) );
        companies.add( new Company("Palantir", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 3242, "Berlin", tags.get(7)) );
        companies.add( new Company("Amazon", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1212, "Berlin", tags.get(7)) );

        companies.add( new Company("Cyber Infrastructure", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 12122, "Berlin", tags.get(0)) );
        companies.add( new Company("IndiaNIC Infotech", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 9212, "Mumbai", tags.get(0)) );
        companies.add( new Company("ELEKS", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 9023, "London", tags.get(0)) );
        companies.add( new Company("Diceus", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 8882, "Bristol", tags.get(0)) );
        companies.add( new Company("Iflexion", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 800, "Brasov", tags.get(0)) );
        companies.add( new Company("Intellectsoft", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 400, "Iasi", tags.get(0)) );

        companies.add( new Company("Bank of China", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 510, "Beijing", tags.get(2)) );
        companies.add( new Company("Goldman Sachs", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 259, "Berlin", tags.get(2)) );
        companies.add( new Company("Deutsche Bank", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1984, "Iasi", tags.get(2)) );
        companies.add( new Company("ING Group", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 9021, "Bucharest", tags.get(2)) );

        companies.add( new Company("Dropbox", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 6543, "New York", tags.get(3)) );
        companies.add( new Company("Instagram", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 435, "New York", tags.get(3)) );
        companies.add( new Company("Netflix", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 912, "Madrid", tags.get(3)) );
        companies.add( new Company("Spotifiy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 214, "New York", tags.get(3)) );

        companies.add( new Company("Reddit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 2149, "New York", tags.get(7)) );
        companies.add( new Company("Apple", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1242, "New York", tags.get(7)) );
        companies.add( new Company("Samsung", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 8764, "New York", tags.get(7)) );

        companies.add( new Company("Morgan Stanley", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 873, "New York", tags.get(8)) );
        companies.add( new Company("Blackstone", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 923, "Madrid", tags.get(8)) );
        companies.add( new Company("Citi", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 6783, "Brasov", tags.get(8)) );

        companies.add( new Company("Lidl", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 6783, "Brasov", tags.get(9)) );
        companies.add( new Company("Kaufland", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 9999, "Bucharest", tags.get(9)) );
        companies.add( new Company("Penny Market", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 790, "Iasi", tags.get(9)) );
        for (Company c : companies) {
            System.out.println("Preloading " + companyRepository.save(c));
        }

        ArrayList<Review> reviews = new ArrayList<>();
        initRandomReview(users, companies, categories);
        for (int i = 0; i < 400; ++i) {
            reviews.add(getRandomReview());
        }
        for (Review r : reviews) {
            System.out.println("Preloading " + reviewRepository.save(r));
        }

//        int idx = 3;
//        System.out.println(reviews.get(idx).getUser().getUsername() + " " + reviews.get(idx).getRating() + " " + reviews.get(idx).getCompany().getName());

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
