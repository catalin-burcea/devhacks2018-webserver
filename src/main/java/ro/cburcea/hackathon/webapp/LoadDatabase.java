package ro.cburcea.hackathon.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.cburcea.hackathon.webapp.entities.Company;
import ro.cburcea.hackathon.webapp.entities.Review;
import ro.cburcea.hackathon.webapp.entities.Tag;
import ro.cburcea.hackathon.webapp.entities.User;
import ro.cburcea.hackathon.webapp.repositories.CompanyRepository;
import ro.cburcea.hackathon.webapp.repositories.ReviewRepository;
import ro.cburcea.hackathon.webapp.repositories.TagRepository;
import ro.cburcea.hackathon.webapp.repositories.UserRepository;
import ro.cburcea.hackathon.webapp.utils.RandomEntry;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TagRepository tagRepository;

	@Bean
    CommandLineRunner initDatabase() {
		return args -> {
//            RandomEntry.addToDB(reviewRepository, userRepository, companyRepository, tagRepository);


//            this.loadDb();
		};
	}

	private void loadDb(){
        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Javascript");
        Tag tag3 = new Tag("Python");
        Tag tag4 = new Tag("Banking");
        System.out.println("Preloading " + tagRepository.save(tag1));
        System.out.println("Preloading " + tagRepository.save(tag2));
        System.out.println("Preloading " + tagRepository.save(tag3));
        System.out.println("Preloading " + tagRepository.save(tag4));

        User user1 = new User("User1", "username1", "123456");
        User user2 = new User("User2", "username2", "123456");
        User user3 = new User("User3", "username3", "123456");
        User user4 = new User("User4", "username4", "123456");
        System.out.println("Preloading " + userRepository.save(user1));
        System.out.println("Preloading " + userRepository.save(user2));
        System.out.println("Preloading " + userRepository.save(user3));
        System.out.println("Preloading " + userRepository.save(user4));


        Company company1 = new Company("Endava", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 30, "Bucharest", tag1);
        Company company2 = new Company("Catalysts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 550, "Bucharest", tag2);
        Company company3 = new Company("MetroSystems", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 100, "London", tag3);
        Company company4 = new Company("LondonStockExchange", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1000, "Madrid", tag4);
        Company company5 = new Company("Google", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1000, "Madrid", tag4);
        Company company6 = new Company("Facebook", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 234, "Bucharest", tag4);
        Company company7 = new Company("Microsoft", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 444, "Berlin", tag4);

        System.out.println("Preloading " + companyRepository.save(company1));
        System.out.println("Preloading " + companyRepository.save(company2));
        System.out.println("Preloading " + companyRepository.save(company3));
        System.out.println("Preloading " + companyRepository.save(company4));
        System.out.println("Preloading " + companyRepository.save(company5));
        System.out.println("Preloading " + companyRepository.save(company6));
        System.out.println("Preloading " + companyRepository.save(company7));


        List<Review> reviews = new ArrayList<>();

        reviews.add( new Review("desc", 3, "Salaries", company1, user1) );
        reviews.add( new Review("desc", 1, "Salaries", company1, user3) );
        reviews.add( new Review("desc", 5, "Salaries", company1, user4) );
        reviews.add( new Review("desc", 4, "Interviews", company1, user1) );
        reviews.add( new Review("desc", 5, "Interviews", company1, user2) );
        reviews.add( new Review("desc", 4, "Interviews", company1, user4) );
        reviews.add( new Review("desc", 4, "Environment", company1, user4) );
        reviews.add( new Review("desc", 4, "Environment", company1, user1) );
        reviews.add( new Review("desc", 5, "Environment", company1, user2) );
        reviews.add( new Review("desc", 2, "Trainings", company1, user2) );
        reviews.add( new Review("desc", 5, "Trainings", company1, user1) );
        reviews.add( new Review("desc", 1, "Trainings", company1, user4) );
        reviews.add( new Review("desc", 3, "Salaries", company2, user1) );
        reviews.add( new Review("desc", 2, "Salaries", company2, user3) );
        reviews.add( new Review("desc", 1, "Salaries", company2, user2) );
        reviews.add( new Review("desc", 2, "Interviews", company2, user1) );
        reviews.add( new Review("desc", 5, "Interviews", company2, user3) );
        reviews.add( new Review("desc", 3, "Interviews", company2, user4) );
        reviews.add( new Review("desc", 2, "Environment", company2, user4) );
        reviews.add( new Review("desc", 2, "Environment", company2, user3) );
        reviews.add( new Review("desc", 1, "Environment", company2, user2) );
        reviews.add( new Review("desc", 5, "Trainings", company2, user2) );
        reviews.add( new Review("desc", 5, "Trainings", company2, user4) );
        reviews.add( new Review("desc", 4, "Trainings", company2, user1) );
        reviews.add( new Review("desc", 1, "Salaries", company3, user1) );
        reviews.add( new Review("desc", 5, "Salaries", company3, user4) );
        reviews.add( new Review("desc", 2, "Salaries", company3, user2) );
        reviews.add( new Review("desc", 4, "Interviews", company3, user1) );
        reviews.add( new Review("desc", 2, "Interviews", company3, user4) );
        reviews.add( new Review("desc", 3, "Interviews", company3, user2) );
        reviews.add( new Review("desc", 4, "Environment", company3, user4) );
        reviews.add( new Review("desc", 1, "Environment", company3, user2) );
        reviews.add( new Review("desc", 5, "Environment", company3, user1) );
        reviews.add( new Review("desc", 2, "Trainings", company3, user2) );
        reviews.add( new Review("desc", 3, "Trainings", company3, user3) );
        reviews.add( new Review("desc", 1, "Trainings", company3, user4) );
        reviews.add( new Review("desc", 1, "Salaries", company4, user4) );
        reviews.add( new Review("desc", 5, "Salaries", company4, user3) );
        reviews.add( new Review("desc", 2, "Salaries", company4, user2) );
        reviews.add( new Review("desc", 3, "Interviews", company4, user2) );
        reviews.add( new Review("desc", 4, "Interviews", company4, user3) );
        reviews.add( new Review("desc", 5, "Interviews", company4, user1) );
        reviews.add( new Review("desc", 1, "Environment", company4, user4) );
        reviews.add( new Review("desc", 2, "Environment", company4, user1) );
        reviews.add( new Review("desc", 2, "Environment", company4, user2) );
        reviews.add( new Review("desc", 2, "Trainings", company4, user4) );
        reviews.add( new Review("desc", 3, "Trainings", company4, user1) );
        reviews.add( new Review("desc", 5, "Trainings", company4, user2) );

        for (Review r : reviews) {
            System.out.println("Preloading " + reviewRepository.save(r));
        }


    }
}