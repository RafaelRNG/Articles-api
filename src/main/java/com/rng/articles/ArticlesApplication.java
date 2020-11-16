package com.rng.articles;

import com.rng.articles.entities.*;
import com.rng.articles.entities.enums.*;
import com.rng.articles.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ArticlesApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArticlesApplication.class, args);
	}

	public void run(String... args) throws Exception{

		User user1 = new User(null, "Rafael", ContactRule.ALL_USERS, UserRole.ADMIN, UserStatus.ACTIVE);
		User user2 = new User(null, "Neves", ContactRule.NETWORK_ONLY, UserRole.ARTICLE_REVIEWER, UserStatus.PENDING);

		Article article1 = new Article(null, "comprar pizza", "<p>Lo" +
				"\n" +
				"<p>Donec fringilla mollis pulvinar euismod senectus, arcu ornare malesuada imperdiet, quis orci in neque. Malesuada enim nam taciti hac praesent dictumst hendrerit vehicula, mi vel pretium tortor justo dui fames dis, arcu rutrum tincidunt dolor maximus turpis habitasse. Erat curabitur lectus suspendisse auctor netus facilisi pretium, blandit faucibus tristique eleifend diam vivamus ullamcorper, tempus est in sagittis commodo semper. Platea sed aptent aenean mattis massa mi amet tortor dolor scelerisque, curae molestie aliquam ad efficitur imperdiet etiam lacus dis nunc, nam felis pulvinar elit convallis blandit vel purus dictum. Sociosqu curabitur etiam tellus metus pulvinar vulputate magnis habitant primis, ex neque ornare imperdiet lacinia aliquam sem. Ullamcorper inceptos ultrices facilisis eros id molestie senectus gravida montes potenti faucibus sollicitudin orci metus aliquet, nunc parturient efficitur a dui cras luctus litora quis hendrerit ante platea proin cubilia. Torquent iaculis tristique non cubilia dignissim commodo maecenas urna diam pharetra suscipit elit lobortis, leo litora platea nisl efficitur lectus finibus curae mollis eleifend fermentum venenatis.</p>\n" +
				"\n" +
				"<p>Mus rutrum eget tristique blandit diam class praesent feugiat taciti amet commodo, fames montes nostra nisi litora lectus sagittis sapien ipsum ac porta, habitasse quam tincidunt vehicula suscipit semper cursus fermentum nec platea. Maximus senectus fringilla nam nulla mi montes maecenas efficitur rutrum massa ultrices, aptent eros quis vulputate mus pulvinar scelerisque suscipit purus. Est cras dolor adipiscing dis turpis faucibus fringilla arcu mauris, conubia auctor dignissim sapien fermentum lobortis sit maecenas lacus lacinia, habitant ac augue sem bibendum iaculis quam aptent. Tortor integer lacus nisi lobortis euismod posuere sociosqu leo scelerisque sem semper diam sit, habitasse finibus nulla ipsum in urna rutrum laoreet congue ac mi. Suscipit potenti varius sed mi lorem consequat lectus tristique purus rhoncus, quisque pellentesque felis eget tempor bibendum habitant viverra a posuere pharetra, dictumst cubilia vehicula vel cursus imperdiet hac amet aliquet. Ipsum sit hendrerit cursus porta ad ut imperdiet varius vel, faucibus vivamus erat gravida facilisi aenean odio lacus nunc, himenaeos elit dictum mattis vulputate duis parturient proin.</p>\n" +
				"\n" +
				"<p>Etiam massa lacinia leo neque hendrerit dis primis ad orci, tristique dapibus maecenas dictumst habitant felis turpis euismod vestibulum, odio amet sollicitudin faucibus curabitur mattis nostra vulputate. Nunc rhoncus mattis dolor commodo lorem interdum ex vel hac, eu lacinia neque ante sollicitudin diam ligula integer, suscipit varius nam at vitae pulvinar fames sociosqu. A ullamcorper donec augue eros nostra suspendisse nec dui vitae, feugiat morbi ultrices bibendum felis mi lacus sollicitudin fusce penatibus, montes pretium pellentesque dignissim netus habitasse nam class. Tristique blandit interdum gravida facilisi ipsum venenatis, aliquet a habitant faucibus facilisis, molestie eget ante auctor in. Porttitor cubilia litora facilisi senectus ut tempor magna in mattis netus sodales eleifend, rutrum cras tempus felis iaculis pellentesque nibh penatibus semper class ultrices, enim molestie nostra feugiat conubia ligula vel mollis curae bibendum volutpat. Fusce porttitor id dictumst pulvinar ac rhoncus magnis nulla, tempus molestie vivamus purus justo hac ipsum eleifend lobortis, enim rutrum commodo mollis iaculis porta est.</p>\n" +
				"\n" +
				"<p>Hac mattis maximus viverra dui primis sagittis nulla leo platea, dapibus nisi tellus aliquam metus vivamus dictum quam tristique semper, taciti justo litora faucibus interdum accumsan efficitur tempus. Mi condimentum quisque natoque felis eu habitasse molestie rutrum, sed ultricies dui quam viverra dictum nunc penatibus, neque maximus est ultrices fames efficitur integer. Conubia in sociosqu sodales pellentesque nisl fames fusce, venenatis posuere vehicula pretium porttitor suscipit maecenas rutrum, dictumst auctor aenean purus tristique scelerisque. Purus dui ullamcorper turpis magnis himenaeos eleifend justo habitant cursus parturient, est maecenas malesuada elementum leo fermentum id consequat enim, habitasse netus interdum donec tellus eu mattis tempor facilisis. Curae quisque natoque nisl torquent vestibulum dis blandit vitae, fames nibh scelerisque consectetur vel montes aptent, massa ligula sit eleifend sed ornare dolor. Molestie mi mauris ex luctus curae inceptos himenaeos ornare cubilia a hac etiam tristique facilisis, torquent nam porttitor aliquam finibus nullam sit porta mattis malesuada taciti aenean. Semper vivamus nec lectus porttitor quisque turpis mus quis praesent, gravida sed venenatis massa augue tempor pretium iaculis, tellus dolor duis donec elementum vel aptent mauris.</p>",
				ArticleStatus.PRIVATE,user1);

		Rating rating1 = new Rating(null, RatingValue.NEUTRAL, new Date(), user1, article1);

		Review review1 = new Review(null, new Date(), "Sobre a pizza", "<p>Lorem ipsum dolor sit amet consectetur adipiscing elit pretium justo, convallis facilisi eleifend eget est vivamus suspendisse dui nullam, magnis lacinia nunc pellentesque accumsan lacus praesent aliquam. Erat fames eros iaculis facilisis molestie hendrerit mattis, ex placerat leo metus nascetur nullam, et aliquet duis condimentum vehicula feugiat. Auctor metus cras pellentesque mus sapien lorem, blandit morbi nisi nam ornare lobortis, at lectus eleifend ullamcorper non. Facilisi nisi dis habitasse montes dolor fames, hendrerit condimentum porttitor congue nascetur tempus, dignissim tellus mollis urna vestibulum. Tellus varius aliquam sapien venenatis fermentum diam bibendum blandit mauris ligula, imperdiet dapibus purus commodo laoreet sed vel odio sodales interdum, eu suscipit risus lacus fames mi eros libero primis. Ante cubilia ullamcorper volutpat mi amet laoreet habitant dapibus sagittis aenean vel nunc, feugiat curabitur bibendum pellentesque aliquam viverra fames vulputate integer torquent.</p>", user2, article1);

		user1.setArticles(Arrays.asList(article1));
		user1.setRatings(Arrays.asList(rating1));
		user2.setReviews(Arrays.asList(review1));
		article1.setUser(user1);
		article1.setRatings(Arrays.asList(rating1));

		userRepository.saveAll(Arrays.asList(user1, user2));
		articleRepository.save(article1);
		ratingRepository.save(rating1);
		reviewRepository.save(review1);
	}
}
