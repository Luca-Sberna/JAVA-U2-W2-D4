package JAVAU2W2D4;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import JAVAU2W2D4.payloads.UserRegistrationPayload;
import JAVAU2W2D4.services.UsersService;

@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 3; i++) {
			try {

				String name = faker.name().firstName();
				String surname = faker.name().lastName();
				String email = faker.internet().emailAddress();
				String password = faker.internet().password();
				UserRegistrationPayload user = new UserRegistrationPayload(name, surname, email, password);
				usersService.create(user);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
