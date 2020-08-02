package com.thanhdhoang.clonegoodreads.bootstrap;

import com.thanhdhoang.clonegoodreads.domain.Author;
import com.thanhdhoang.clonegoodreads.domain.Book;
import com.thanhdhoang.clonegoodreads.domain.Genre;
import com.thanhdhoang.clonegoodreads.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Set;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;
    private ReviewRepository reviewRepository;
    private UserRepository userRepository;

    public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository,
                       GenreRepository genreRepository, ReviewRepository reviewRepository,
                       UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }



    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // load genres
        String[] genresArr  = {"Art", "Biography", "Business", "Children's",
                "Christian", "Classics", "Comics", "Cookbooks", "Ebooks",
                "Ebooks", "Fantasy", "Fiction", "Graphic Novels", "Historical Fiction",
                "History", "Horror", "Memoir", "Music", "Mystery", "Nonfiction",
                "Poetry", "Psychology", "Romance", "Science", "Science Fiction",
                "Self Help", "Sports", "Thriller", "Travel", "Young Adult"
        };
        for (String s: genresArr) {
            Genre genre = new Genre();
            genre.setGenre(s);
            genreRepository.save(genre);
        }

//        Fiction, Young Adult, Fantasy
        Genre fiction = genreRepository.findByGenre("Fiction");
        Genre yongAdult = genreRepository.findByGenre("Young Adult");
        Genre fantasy = genreRepository.findByGenre("Fantasy");
        Genre scienceFiction = genreRepository.findByGenre("Science Fiction");

        Set<Genre> genres1 = new HashSet<>();
        genres1.add(fiction);
        genres1.add(fantasy);
        genres1.add(yongAdult);

        // books
        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Sorcerer's Stone");
        book1.setIsbn("9780439554930");
        book1.setDescription("Harry Potter's life is miserable. His parents are dead and he's stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he's a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry.\n" +
                "\n" +
                "After a lifetime of bottling up his magical powers, Harry finally feels like a normal kid. But even within the Wizarding community, he is special. He is the boy who lived: the only person to have ever survived a killing curse inflicted by the evil Lord Voldemort, who launched a brutal takeover of the Wizarding world, only to vanish after failing to kill Harry.\n" +
                "\n" +
                "Though Harry's first year at Hogwarts is the best of his life, not everything is perfect. There is a dangerous secret object hidden within the castle walls, and Harry believes it's his responsibility to prevent it from falling into evil hands. But doing so will bring him into contact with forces more terrifying than he ever could have imagined.\n" +
                "\n" +
                "Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come."
        );
        book1.setCoverImageUrl("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1474154022l/3._SY475_.jpg");
        book1.setGenres(genres1);

        Book book2 = new Book();
        book2.setTitle("Harry Potter and the Order of the Phoenix");
        book2.setIsbn("978-0439358071" );
        book2.setDescription("There is a door at the end of a silent corridor. And it’s haunting Harry Pottter’s dreams. Why else would he be waking in the middle of the night, screaming in terror?\n" +
                "\n" +
                "Harry has a lot on his mind for this, his fifth year at Hogwarts: a Defense Against the Dark Arts teacher with a personality like poisoned honey; a big surprise on the Gryffindor Quidditch team; and the looming terror of the Ordinary Wizarding Level exams. But all these things pale next to the growing threat of He-Who-Must-Not-Be-Named - a threat that neither the magical government nor the authorities at Hogwarts can stop.\n" +
                "\n" +
                "As the grasp of darkness tightens, Harry must discover the true depth and strength of his friends, the importance of boundless loyalty, and the shocking price of unbearable sacrifice.\n" +
                "\n" +
                "His fate depends on them all.");
        book2.setCoverImageUrl("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546910265l/2.jpg");
        book2.setGenres(genres1);

        // author 1
        Author author1 = new Author();
        author1.setName("J.K. Rowling");
        author1.setGender("Female");
        author1.setBirthday(Date.valueOf("1965-07-31"));
        author1.setBio("Although she writes under the pen name J.K. Rowling, pronounced like rolling, her name when her first Harry Potter book was published was simply Joanne Rowling. Anticipating that the target audience of young boys might not want to read a book written by a woman, her publishers demanded that she use two initials, rather than her full name. As she had no middle name, she chose K as the second initial of her pen name, from her paternal grandmother Kathleen Ada Bulgen Rowling. She calls herself Jo and has said, \"No one ever called me 'Joanne' when I was young, unless they were angry.\" Following her marriage, she has sometimes used the name Joanne Murray when conducting personal business. During the Leveson Inquiry she gave evidence under the name of Joanne Kathleen Rowling. In a 2012 interview, Rowling noted that she no longer cared that people pronounced her name incorrectly.\n" +
                "\n" +
                "Rowling was born to Peter James Rowling, a Rolls-Royce aircraft engineer, and Anne Rowling (née Volant), on 31 July 1965 in Yate, Gloucestershire, England, 10 miles (16 km) northeast of Bristol. Her mother Anne was half-French and half-Scottish. Her parents first met on a train departing from King's Cross Station bound for Arbroath in 1964. They married on 14 March 1965. Her mother's maternal grandfather, Dugald Campbell, was born in Lamlash on the Isle of Arran. Her mother's paternal grandfather, Louis Volant, was awarded the Croix de Guerre for exceptional bravery in defending the village of Courcelles-le-Comte during the First World War.\n" +
                "\n" +
                "Rowling's sister Dianne was born at their home when Rowling was 23 months old. The family moved to the nearby village Winterbourne when Rowling was four. She attended St Michael's Primary School, a school founded by abolitionist William Wilberforce and education reformer Hannah More. Her headmaster at St Michael's, Alfred Dunn, has been suggested as the inspiration for the Harry Potter headmaster Albus Dumbledore.\n" +
                "\n" +
                "As a child, Rowling often wrote fantasy stories, which she would usually then read to her sister. She recalls that: \"I can still remember me telling her a story in which she fell down a rabbit hole and was fed strawberries by the rabbit family inside it. Certainly the first story I ever wrote down (when I was five or six) was about a rabbit called Rabbit. He got the measles and was visited by his friends, including a giant bee called Miss Bee.\" At the age of nine, Rowling moved to Church Cottage in the Gloucestershire village of Tutshill, close to Chepstow, Wales. When she was a young teenager, her great aunt, who Rowling said \"taught classics and approved of a thirst for knowledge, even of a questionable kind,\" gave her a very old copy of Jessica Mitford's autobiography, Hons and Rebels. Mitford became Rowling's heroine, and Rowling subsequently read all of her books.\n" +
                "\n" +
                "Rowling has said of her teenage years, in an interview with The New Yorker, \"I wasn’t particularly happy. I think it’s a dreadful time of life.\" She had a difficult homelife; her mother was ill and she had a difficult relationship with her father (she is no longer on speaking terms with him). She attended secondary school at Wyedean School and College, where her mother had worked as a technician in the science department. Rowling said of her adolescence, \"Hermione [a bookish, know-it-all Harry Potter character] is loosely based on me. She's a caricature of me when I was eleven, which I'm not particularly proud of.\" Steve Eddy, who taught Rowling English when she first arrived, remembers her as \"not exceptional\" but \"one of a group of girls who were bright, and quite good at English.\" Sean Harris, her best friend in the Upper Sixth owned a turquoise Ford Anglia, which she says inspired the one in her books. ");
        author1.setWebsite("http://www.jkrowling.com");
        author1.setGenres(genres1);
        author1.setUrlImage("https://images.gr-assets.com/authors/1596216614p5/1077326.jpg");

        book1.setAuthor(author1);
        book2.setAuthor(author1);
        book1 = bookRepository.save(book1);
        book2 = bookRepository.save(book2);

        Set<Book> author1Books = new HashSet<>();
        author1Books.add(book1);
        author1Books.add(book2);

//        author1.setBooks(author1Books);
        authorRepository.save(author1);

        // book3
        genres1.add(scienceFiction);
        Book book3 = new Book();
        book3.setTitle("The Hunger Games");
        book3.setIsbn("978-0439023481" );
        book3.setDescription("WINNING MEANS FAME AND FORTUNE.\n" +
                "LOSING MEANS CERTAIN DEATH.\n" +
                "THE HUNGER GAMES HAVE BEGUN. . . .\n" +
                "\n" +
                "In the ruins of a place once known as North America lies the nation of Panem, a shining Capitol surrounded by twelve outlying districts. The Capitol is harsh and cruel and keeps the districts in line by forcing them all to send one boy and once girl between the ages of twelve and eighteen to participate in the annual Hunger Games, a fight to the death on live TV.\n" +
                "\n" +
                "Sixteen-year-old Katniss Everdeen regards it as a death sentence when she steps forward to take her sister's place in the Games. But Katniss has been close to dead before—and survival, for her, is second nature. Without really meaning to, she becomes a contender. But if she is to win, she will have to start making choices that weight survival against humanity and life against love.");
        book3.setCoverImageUrl("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1586722975l/2767052.jpg");
        book3.setGenres(genres1);

        Author author2 = new Author();
        author2.setName("Suzanne Collins");
        author2.setGender("Female");
        author2.setBirthday(Date.valueOf("1962-08-11"));
        author2.setBio("Since 1991, Suzanne Collins has been busy writing for children’s television. She has worked on the staffs of several Nickelodeon shows, including the Emmy-nominated hit Clarissa Explains it All and The Mystery Files of Shelby Woo. For preschool viewers, she penned multiple stories for the Emmy-nominated Little Bear and Oswald. She also co-wrote the critically acclaimed Rankin/Bass Christmas special, Santa, Baby! Most recently she was the Head Writer for Scholastic Entertainment’s Clifford’s Puppy Days.\n" +
                "\n" +
                "While working on a Kids WB show called Generation O! she met children’s author James Proimos, who talked her into giving children’s books a try.\n" +
                "\n" +
                "Thinking one day about Alice in Wonderland, she was struck by how pastoral the setting must seem to kids who, like her own, lived in urban surroundings. In New York City, you’re much more likely to fall down a manhole than a rabbit hole and, if you do, you’re not going to find a tea party. What you might find...? Well, that’s the story of Gregor the Overlander, the first book in her five-part series, The Underland Chronicles. Suzanne also has a rhyming picture book illustrated by Mike Lester entitled When Charlie McButton Lost Power.\n" +
                "\n" +
                "She currently lives in Connecticut with her family and a pair of feral kittens they adopted from their backyard.\n" +
                "\n" +
                "The books she is most successful for in teenage eyes are The Hunger Games, Catching Fire and Mockingjay. These books have won several awards, including the GA Peach Award. ");
        author2.setWebsite("http://suzannecollinsbooks.com/");
        author2.setGenres(genres1);

        book3.setAuthor(author2);
        book3 = bookRepository.save(book3);

        Set<Book> author2Books = new HashSet<>();
        author2Books.add(book3);

//        author2.setBooks(author2Books);
        authorRepository.save(author2);

        // REVIEW


    }

}
