package com.thanhdhoang.clonegoodreads.bootstrap;

import com.thanhdhoang.clonegoodreads.persistence.model.Author;
import com.thanhdhoang.clonegoodreads.persistence.model.Book;
import com.thanhdhoang.clonegoodreads.persistence.model.Genre;
import com.thanhdhoang.clonegoodreads.persistence.repositories.*;
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
        String name;
        String description;

        name = "Art";
        description = "Books that showcase particular types of art. ";
        loadGenre(name, description);

        name = "Biography";
        description = "A biography (from the Greek words bios meaning \"life\", and graphos meaning \"write\") " +
                "is a non-fictional account of a person's life. Biographies are written by an author who is not " +
                "the subject/focus of the book. ";
        loadGenre(name, description);

        name = "Business";
        description = "A business (also known as enterprise or firm) is an organization engaged in the trade of " +
                "goods, services, or both to consumers. Businesses are predominant in capitalist economies, " +
                "where most of them are privately owned and administered to earn profit to increase the wealth " +
                "of their owners. Businesses may also be not-for-profit or state-owned. A business owned by multiple" +
                " individuals may be referred to as a company, although that term also has a more precise meaning.";
        loadGenre(name, description);

        name = "Children's";
        description = "Children's literature is for readers and listeners up to about age 12. It is often " +
                "illustrated. The term is used in senses that sometimes exclude young-adult fiction, " +
                "comic books, or other genres. Books specifically for children existed at least several hundred years ago";
        loadGenre(name, description);

        name = "Christian";
        description = "The term \"Christian\" is used adjectivally to describe anything associated with " +
                "Christianity, or in a proverbial sense \"all that is noble, and good, and Christ-like\". " +
                "It can also refer" +
                " to content produced by a christian without the content being explicitly Christian.";
        loadGenre(name, description);

        name = "Classics";
        description = "A classic stands the test of time. The work is usually considered to be a representation of the " +
                "period in which it was written; and the work merits lasting recognition. In other words, if the book " +
                "was published in the recent past, the work is not a classic.\n" +
                "\n" +
                "A classic has a certain universal appeal. Great works of literature touch us to our very core " +
                "beings--partly because they integrate themes that are understood by readers from a wide range " +
                "of backgrounds and levels of experience. Themes of love, hate, death, life, and faith touch upon " +
                "some of our most basic emotional responses.\n" +
                "\n" +
                "Although the term is often associated with the Western canon, it can be applied to works of " +
                "literature from all traditions, such as the Chinese classics or the Indian Vedas.";
        loadGenre(name, description);

        name = "Comics";
        description = "A comic book or comicbook, also called comic magazine or simply comic, is a publication " +
                "that consists of comic art in the form of sequential juxtaposed panels that represent individual " +
                "scenes. Panels are often accompanied by brief descriptive prose and written narrative, " +
                "usually dialog contained in word balloons emblematic of the comics art form. ";
        loadGenre(name, description);

        name = "Cookbooks";
        description = "Non-fiction books that contain a collection of recipes, techniques, and tricks of the " +
                "trade or else focus on the exploration of food, cooking, and culture of food. Many cookbooks " +
                "are divided into sections such as baking, dinner, and breakfast. A specialty cookbook may focus " +
                "only on a certain country's cuisine, such as Italian or Cajun. There are some cookbooks that are " +
                "written to highlight one ingredient (i.e. honey), and some cookbooks focused on only one branch " +
                "of cooking (such as bread.) Even further, " +
                "some cookbooks focus on types of cooking (microwave, barbecue, baking.)";
        loadGenre(name, description);

        name = "Ebooks";
        description = "An electronic book (eBook) is a digital form of a book that consists of text and sometimes" +
                " images, or both. Common formats of ebooks include: .iba(Apple iBooks), .azw(Amazon Kindle)," +
                " EPUB and PDF files. ";
        loadGenre(name, description);

        name = "Fantasy";
        description = "Fantasy is a genre that uses magic and other supernatural forms as a primary element of" +
                " plot, theme, and/or setting. Fantasy is generally distinguished from science fiction " +
                "and horror by the expectation that it steers clear of technological and macabre themes, " +
                "respectively, though there is a great deal of overlap between the three (collectively" +
                " known as speculative fiction or science fiction/fantasy)\n" +
                "\n" +
                "In its broadest sense, fantasy comprises works by many writers, artists, " +
                "filmmakers, and musicians, from ancient myths and legends to many recent works" +
                " embraced by" +
                " a wide audience today, including young adults, most of whom are represented " +
                "by the works below.";
        loadGenre(name, description);

        name = "Fiction";
        description = "Fiction is the telling of stories which are not real. More specifically, fiction is an " +
                "imaginative form of narrative, one of the four basic rhetorical modes. Although the word " +
                "fiction is derived from the Latin fingo, fingere, finxi, fictum, \"to form, create\", works " +
                "of fiction need not be entirely imaginary and may include real people, places, and events. " +
                "Fiction may be either written or oral. Although not all fiction is necessarily artistic, fiction" +
                "is largely perceived as a form of art or entertainment. The ability to create fiction and other" +
                " artistic works is considered to be a fundamental aspect of " +
                "human culture, one of the defining characteristics of humanity.";
        loadGenre(name, description);

        name = "Graphic Novels";
        description = "A graphic novel is a narrative work in which the story is conveyed to the reader" +
                " using sequential art in either an experimental design or in a traditional " +
                "comics format. The term is employed in a broad manner, encompassing non-fiction works and " +
                "thematically linked short stories as well as fictional stories across a number of genres.\n" +
                "--from Wikipedia";
        loadGenre(name, description);

        name = "Historical Fiction";
        description = "Historical fiction presents a story set in the past, often during a significant time period." +
                " In historical fiction, the time period is an important part of the setting and often of the story itself.\n" +
                "\n" +
                "Historical fiction may include fictional characters, well-known historical figures or " +
                "a mixture of the two. Authors of historical fiction usually pay close attention to the details" +
                " of their stories (settings, clothing, dialogue, etc.) to ensure that they fit the time periods in " +
                "which the narratives take place.\n" +
                "\n" +
                "In some historical fiction, famous events appear from points of view not recorded in history," +
                " showing historical figures dealing with actual events while depicting them in a way that is " +
                "not recorded in history. Other times, the historical event or time period complements a story's" +
                " narrative, forming a framework and background for the characters' lives. Sometimes, historical " +
                "fiction can be for the most part true, but the names of people and places have been in some way altered.\n" +
                "\n" +
                "As this is fiction, artistic license is permitted in regard to presentation and subject matter, " +
                "so long as it does not deviate in significant ways from established history. If events should deviate " +
                "significantly, the story may then fall into the genre of alternate history, which is known for " +
                "speculating on what could have happened if a significant historical event had gone differently. " +
                "On a similar note, events occurring in historical fiction must adhere to the laws of physics. " +
                "Stories that extend into the magical or " +
                "fantastic are often considered historical fantasy.";
        loadGenre(name, description);

        name = "History";
        description = "History (from Greek ἱστορία - historia, meaning \"inquiry, " +
                "knowledge acquired by investigation\") is the discovery, collection, organization, and presentation" +
                " of information about past events. History can also mean the period of time after writing " +
                "was invented. Scholars who write about history are called historians. It is a field of research" +
                " which uses a narrative to examine and analyse the sequence of events, and it sometimes attempts " +
                "to investigate objectively the patterns of cause and effect that determine events. Historians " +
                "debate the nature of history and its usefulness. This includes discussing the study of the d" +
                "iscipline as an end in itself and as a way of providing \"perspective\" on the problems of " +
                "the present. The stories common to a particular culture, but not supported by external sources " +
                "(such as the legends surrounding King Arthur) are usually classified as cultural heritage " +
                "rather than the \"disinterested investigation\" needed by the discipline of history. Events " +
                "of the past prior to written record are considered prehistory.\n" +
                "Amongst scholars, the fifth century BC Greek historian Herodotus is considered to be the \"father " +
                "of history\", and, along with his contemporary Thucydides, forms the foundations for the modern " +
                "study of history. Their influence, along with other historical traditions in other parts of their " +
                "world, have spawned many different interpretations of the nature of history which has evolved over" +
                " the centuries and are continuing to change. The modern study of history has many different fields " +
                "including those that focus on certain regions and those which focus on certain topical or thematical" +
                " elements of historical investigation. Often history is taught as part of primary and " +
                "secondary education, " +
                "and the academic study of history is a major discipline in University studies. ";
        loadGenre(name, description);

        name = "Horror";
        description = "";
        loadGenre(name, description);

        name = "Memoir";
        description = "";
        loadGenre(name, description);

        name = "Music";
        description = "";
        loadGenre(name, description);

        name = "Mystery";
        description = "";
        loadGenre(name, description);

        name = "Nonfiction";
        description = "";
        loadGenre(name, description);

        name = "Poetry";
        description = "";
        loadGenre(name, description);

        name = "Psychology";
        description = "";
        loadGenre(name, description);

        name = "Romance";
        description = "";
        loadGenre(name, description);

        name = "Science";
        description = "";
        loadGenre(name, description);

        name = "Science Fiction";
        description = "";
        loadGenre(name, description);

        name = "Self Help";
        description = "";
        loadGenre(name, description);

        name = "Sports";
        description = "";
        loadGenre(name, description);

        name = "Thriller";
        description = "";
        loadGenre(name, description);

        name = "Travel";
        description = "Travel is the movement of people or objects (such as airplanes, boats, trains and other " +
                "conveyances) between relatively distant geographical locations. The term \"travel\" originates " +
                "from the Old French word travail. Travel writing is a genre that has, as its focus, accounts " +
                "of real or imaginary places. The genre encompasses a number of styles that may range from the" +
                " documentary to the evocative, from literary to journalistic, and from the humorous to the " +
                "serious. Travel writing is often associated with tourism, and includes works of an ephemeral " +
                "nature such as guide books and reviews, with the intent being to educate the reader about the " +
                "destination, provide helpful advice for those visiting the destination, and inspire readers " +
                "to travel to the destination. Travel writing has also been produced by other types of travelers," +
                " such as military officers, missionaries, explorers, scientists, pilgrims, and migrants. ";
        loadGenre(name, description);

        name = "Young Adult";
        description = "Young-adult fiction (often abbreviated as YA) is fiction written for, published for, or " +
                "marketed to adolescents and young adults, roughly ages 13 to 18.\n" +
                "\n" +
                "Young-adult fiction, whether in the form of novels or short stories, has distinct attributes " +
                "that distinguish it from the other age categories of fiction. The vast majority of YA stories " +
                "portray an adolescent as the protagonist, rather than an adult or a child. The subject matter and " +
                "story lines are typically consistent with the age and experience of the main character, " +
                "but beyond that YA stories span the entire spectrum of fiction genres. The settings of YA stories " +
                "are limited only by the imagination and skill of the author.\n" +
                "\n" +
                "Themes in YA stories often focus on the challenges of youth, so much so that the entire age category " +
                "is sometimes referred to as problem novels or coming of age novel. Writing styles of YA stories " +
                "range widely, from the richness of literary style to the clarity and speed of the unobtrusive. " +
                "Despite its unique characteristics, YA shares the fundamental elements" +
                " of fiction with other stories: character, plot, setting, theme, and style. ";
        loadGenre(name, description);


//        Fiction, Young Adult, Fantasy
        Genre fiction = genreRepository.findByNameIgnoreCase("Fiction").get();
        Genre yongAdult = genreRepository.findByNameIgnoreCase("Young Adult").get();
        Genre fantasy = genreRepository.findByNameIgnoreCase("Fantasy").get();
        Genre scienceFiction = genreRepository.findByNameIgnoreCase("Science Fiction").get();

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
        author1.setBirthday(Date.valueOf("1965-07-31"));
        author1.setBirthPlace("Yate, South Gloucestershire, England, The United Kingdom ");
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
        author1.setTwitter("jk_rowling");
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
        author2.setBirthday(Date.valueOf("1962-08-11"));
        author2.setBirthPlace("Hartford, Connecticut, The United States");
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

    private void loadGenre(String name, String description) {
        Genre genre = new Genre();
        genre.setName(name);
        genre.setDescription(description);
        genreRepository.save(genre);
    }

}
