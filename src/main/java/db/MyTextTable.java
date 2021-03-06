package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTextTable implements TableDB
{
    public static void bildMyTextTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS my_text" +
                    "(id SERIAL PRIMARY KEY, title_text VARCHAR(50), text_eng text, text_rus text, color VARCHAR(30));");
            addMyText();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void addMyText(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO my_text (title_text, text_eng, text_rus, color)" +
                    "VALUES ('My family','Meet my family. There are five of us – my parents, my elder brother, " +
                    "my baby sister and me. First, meet my mum and dad, Jane and Michael. My mum enjoys " +
                    "reading and my dad enjoys playing chess with my brother Ken. My mum is slim and rather " +
                    "tall. She has long red hair and big brown eyes. She has a very pleasant smile and a " +
                    "soft voice. My mother is very kind and understanding. We are real friends. She is a " +
                    "housewife. As she has three children, she is always busy around the house. She takes " +
                    "care of my baby sister Meg, who is only three months old. My sister is very small and " +
                    "funny. She sleeps, eats and sometimes cries. We all help our mother and let her have a " +
                    "rest in the evening. Then she usually read a book or just watches TV. My father is a " +
                    "doctor. He is tall and handsome. He has short dark hair and gray eyes. He is a very hardworking " +
                    "man. He is rather strict with us, but always fair. My elder brother Ken is thirteen, and he " +
                    "is very clever. He is good at Maths and always helps me with it, because I can hardly " +
                    "understand all these sums and problems. Ken has red hair and brown eyes. My name is Jessica. " +
                    "I am eleven. I have long dark hair and brown eyes. I am not as clever as my brother, though " +
                    "I try to do my best at school too. I am fond of dancing. Our dancing studio won The Best " +
                    "Dancing Studio 2015 competition last month. I am very proud of it. I also like to help my mother " +
                    "with my little sister very much. Our family is very united. We love each other and always " +
                    "try to spend more time together.','Знакомьтесь с моей семьей. Нас пятеро – мои родители, " +
                    "мой старший брат, моя маленькая сестра и я. Сначала познакомьтесь с моими мамой и папой, " +
                    "Джейн и Майклом. Моя мама любит читать, а мой папа любит играть в шахматы с моим братом " +
                    "Кеном. Моя мама стройная и довольно высокая. У нее длинные рыжие волосы и большие карие глаза. " +
                    "У нее очень приятная улыбка и нежный голос. Моя мама очень добрая и понимающая. Мы настоящие " +
                    "друзья. Она домохозяйка. Поскольку у нее трое детей, она всегда занята по дому. Она заботится " +
                    "о моей грудной сестренке Мег, которой только три месяца. Моя сестренка очень маленькая и " +
                    "забавная. Она спит, ест и иногда плачет. Мы все помогаем нашей маме и даем ей отдохнуть " +
                    "вечером. Тогда она обычно читает книгу или просто смотрит телевизор. Мой папа врач. Он " +
                    "высокий и красивый. У него короткие темные волосы и серые глаза. Он очень трудолюбивый человек. " +
                    "Он довольно строг с нами, но всегда справедлив. Моему старшему брату Кену тринадцать и он очень " +
                    "умный. Он хорошо разбирается в математике и всегда помогает мне с ней, потому что я едва понимаю " +
                    "все эти примеры и задачи. У Кена рыжие волосы и карие глаза. Меня зовут Джессика. Мне " +
                    "одиннадцать. У меня длинные темные волосы и карие глаза. Я не такая умная, как мой брат, " +
                    "хотя я очень стараюсь в школе тоже. Я увлекаюсь танцами. Наша танцевальная студия выиграла " +
                    "конкурс на Лучшую Танцевальную Студию 2015 в прошлом месяце. Я очень горжусь этим. Я также " +
                    "очень люблю помогать моей маме с моей маленькой сестренкой. Наша семья очень дружная. Мы " +
                    "любим друг друга и всегда пытаемся проводить больше времени вместе.', 'black')," +
                    "('Lunches for school','Every day in elementary school in America begins at 9.20 a.m. " +
                    "Children have classes till 3.15 p.m. At 12 o''clock children have lunch. Many boys and girls " +
                    "bring their lunch from home. But some of them go for lunch to a school cafeteria. Mrs. Bradley " +
                    "prepares school lunches almost every weekday for her two children. Sometimes she gives the " +
                    "children money and they eat in the school cafeteria. But usually the children prefer to take " +
                    "a lunch from home. This morning Mrs. Bradley is making peanut butter and cheese sandwiches, " +
                    "the children''s favorite. She puts two bottles of apple juice for the children to drink. She " +
                    "is going to put the sandwiches, some cherry tomatoes and two bananas in their lunchboxes. " +
                    "The lunchbox is easy for the children to carry to school.','Каждый день в начальной школе в " +
                    "Америке начинается в 9.30 утра. Уроки у детей длятся до 3.15 дня. В 12 часов у детей обед. " +
                    "Многие мальчики и девочки приносят свой обед с собой. Но некоторые ходят обедать в школьную " +
                    "столовую. Миссис Брэдли готовит школьные обеды для своих двоих детей почти каждый рабочий день. " +
                    "Иногда она дает детям деньги, и они едят в школьной столовой. Но обычно дети предпочитают " +
                    "брать обед из дома. Этим утром миссис Брэдли делает бутерброды с арахисовым маслом и сыром, " +
                    "любимые (бутерброды) детей. Она кладет две бутылочки яблочного сока, чтобы дети попили. " +
                    "Она собирается положить бутерброды, несколько помидоров черри и два банана в их ланчбоксы " +
                    "(коробки для завтрака). Детям легко носить ланчбокс в школу.', 'black')," +
                    "('Giraffes','There are different kinds of animals on our planet, and all of them are very " +
                    "important for it. For example, everybody knows that the sharks are dangerous for people, but " +
                    "they are useful for cleaning seawater. There are two types of animals: domestic (or pets) " +
                    "and wild. People keep pets in their homes. And some wild animals are very dangerous. " +
                    "Domestic animals live next to people, whereas wild animals’ “homes” are forests, jungles, " +
                    "oceans and so on. Giraffes are very beautiful and unusual animals. They are the tallest land " +
                    "animals in the world. Giraffes can reach a height of 5,5 m and a weight of 900 kg. They are " +
                    "famous for their long necks. But does anybody know, that giraffes have a very long tongue? " +
                    "They even can clean the ears with it! Giraffes are usually yellow or light brown with dark " +
                    "stains. Giraffes live in African savannas. They can live from 20 to 30 years. It is interesting " +
                    "to know, that giraffes sleep only for a few minutes at a time. They sit down on the ground and " +
                    "bend their long neck down. Giraffes do not hunt. They eat leaves, grass, and fruit. Due to " +
                    "their long neck, they can reach the highest leaves on the trees that other animals cannot " +
                    "eat. You can often meet giraffes in city Zoos. They are very friendly and all the children " +
                    "like them very much.','На планете много разных видов животных, и все они очень важны для нее. " +
                    "Например, все знают, что акулы опасны для людей, но они полезны для очищения морской воды. " +
                    "Есть два вида животных – домашние (или питомцы) и дикие. Люди держат питомцев в своих домах. " +
                    "А некоторые дикие животные очень опасны. Домашние животные живут рядом с людьми, тогда как " +
                    "«дома» диких животных - это леса, джунгли, океаны и так далее. Жирафы очень красивые и " +
                    "необычные животные. Они самые высокие сухопутные животные в мире. Жирафы могут достигать " +
                    "в высоту 5.5 метров, и веса 900 кг. Они знамениты своими длинными шеями. Но кто-нибудь знает, " +
                    "что у жирафов очень длинный язык? Они даже могут почистить им уши! Жирафы обычно жёлтые или " +
                    "светло коричневые с тёмными пятнами. Жирафы живут в африканских саваннах. Они могут прожить " +
                    "от 20 до 30 лет. Интересно знать что жирафы спят не более 20 минут за раз. Они садятся на " +
                    "землю и нагибают свою длинную шею. Жирафы не охотятся. Они едят листья, траву и фрукты. " +
                    "Благодаря своей длинной шее они могут достать до самых верхних листьев на деревьях, которые " +
                    "не могут съесть другие животные. Вы часто можете встретить жирафов в городских зоопарках. " +
                    "Они очень дружелюбные и их очень любят дети.', 'black')," +
                    "('A dog and three dollars','I have always believed that a man must be honest. «Never ask for " +
                    "money you have not earned», I always said. Now I shall tell you a story which will show you " +
                    "how honest I have always been all my life. A few days ago at my friend’s house I met General " +
                    "Miles. General Miles was a nice man and we became great friends very quickly. «Did you live " +
                    "in Washington in 1867?» the general asked me. «Yes, I did,» I answered. «How could it happen " +
                    "that we did not meet then?» said General Miles. «General», said I. «We could not meet then. " +
                    "You forget that you were already a great general then, and I was a poor young writer whom " +
                    "nobody knew and whose books nobody read. You do not remember me, I thought, but we met once " +
                    "in Washington at that time.» I remember it very well. I was poor then and very often I did " +
                    "not have money even for my bread. I had a friend. He was a poor writer too. We lived together. " +
                    "We did everything together: worked, read books, went for walks together. And when we were " +
                    "hungry, we were both hungry. Once we were in need of three dollars. I don’t remember why we " +
                    "needed these three dollars so much, but I remember well that we had to have the money by the " +
                    "evening. «We must get these three dollars,» said my friend. «I shall try to get the money, " +
                    "but you must also try.» I went out of the house, but I did not know where to go and how to " +
                    "get the three dollars. For an hour I was walking along the streets of Washington and was very " +
                    "tired. At last I came to a big hotel. «I shall go in and have a rest,» I thought. I went into " +
                    "the hall of the hotel and sat down on a sofa. I was sitting there when a beautiful small dog " +
                    "ran into the hall. It was looking for somebody. The dog was nice and I had nothing to do, so " +
                    "I called it and began to play with it. I was playing with the dog, when a man came into the " +
                    "hall. He wore a beautiful uniform and I knew at once that he was General Miles. I knew him " +
                    "by his pictures in the newspapers. «What a beautiful dog!» said he. «Is it your dog?» I did " +
                    "not have time to answer him when he said, «Do you want to sell it?» «Three dollars», I answered " +
                    "at once. «Three dollars?» he asked. «But that is very little. I can give you fifty dollars for " +
                    "it.» «No, no. I only want three dollars.» «Well, it is your dog. If you want three dollars for " +
                    "it, I shall be glad to buy your dog.» General Miles paid me three dollars, took the dog and " +
                    "went up to his room. Ten minutes later an old man came into the hall. He looked round the hall. " +
                    "I could see that he was looking for something. «Are you looking for a dog, sir?» I asked. " +
                    "«Oh, yes! Have you seen it?» said the man. «Your dog was here a few minutes ago and I saw " +
                    "how it went away with a man,» I said. «If you want, I shall try to find it for you.» The man " +
                    "was very happy and asked me to help him. «I shall be glad to help you, but it will take some " +
                    "of my time and…» «I am ready to pay you for your time,» cried the man. «How much do you want " +
                    "for it?» «Three dollars,» answered I. «Three dollars?» said the man. «But it is a very good " +
                    "dog. I shall pay you ten dollars if you find it for me.» «No sir, I want three dollars and " +
                    "not a dollar more,» said I. Then I went up to General Miles’s room. The General was playing " +
                    "with his new dog.» I came here to take the dog back», said I. «But it is not your dog now — " +
                    "I have bought it. I have paid you three dollars for it,» said the General. «I shall give you " +
                    "back your three dollars, but I must take the dog back», answered I. «But you have sold it to " +
                    "me, it is my dog now.» «I could not sell it to you, sir, because it was not my dog.» «Still " +
                    "you have sold it to me for three dollars.» «How could I sell it to you when it was not my " +
                    "dog? You asked me how much I wanted for the dog, and I said that I wanted three dollars. But " +
                    "I never told you that it was my dog.» General Miles was very angry now. «Give me back my three" +
                    " dollars and take the dog,» he shouted. When I brought the dog back to its master, he was very " +
                    "happy and paid me three dollars with joy. I was happy too because I had the money, and I felt " +
                    "I earned it. Now you can see why I say that honesty is the best policy and that a man must " +
                    "never take anything that he has not earned.','Я всегда верил, что человек должен быть честен. " +
                    "«Никогда не проси денег, которые не заслужил» — всегда говорил я. Сейчас я расскажу вам " +
                    "историю, которая покажет, каким честным я был всю свою жизнь. Несколько дней назад в доме " +
                    "своего друга я повстречал генерала Майлза. Генерал Майлз был приятным человеком, и мы очень " +
                    "быстро стали хорошими друзьями. «Ты жил в Вашингтоне в 1867 году?», спросил меня генерал. " +
                    "«Да» , ответил я — Как могло случиться, что мы не встречались тогда?, сказал генерал Майлз. " +
                    "— Генерал, сказал я, мы не могли встретиться там. Вы забываете, что вы уже были великим " +
                    "генералом тогда, а я был молодым писателем, которого никто не знал и чьи книги никто не " +
                    "читал. Вы не помните меня, я думаю, но мы встречались однажды в Вашингтоне в то время. " +
                    "Я запомнил это очень хорошо Я был беден тогда, и очень часто у меня не было денег даже на " +
                    "хлеб. У меня был друг. Он тоже был бедным писателем. Мы жили вместе. Мы все делали вместе: " +
                    "работали, читали книги, вместе ходили на прогулку. И когда мы были голодными, мы оба были " +
                    "голодными. Однажды нам нужно было три доллара. Я не помню, зачем нам нужны были эти три " +
                    "доллара так сильно, но я хорошо помню, что мы должны были иметь эти деньги к вечеру. — Мы " +
                    "должны достать эти три доллара, — сказал мой друг. Мне стоит попытаться достать эти деньги, " +
                    "но ты тоже должен попытаться. Я вышел из дома, но я не знал куда идти и как достать эти три " +
                    "доллара. В течении часа я ходил вдоль улиц Вашингтона и очень устал. Наконец, я пришел к " +
                    "большому отелю. «Я должен войти и отдохнуть» подумал я. Я вошел в холл отеля и сел на " +
                    "диван. Я сидел там, когда красивая маленькая собачка вбежала в холл. Она искала кого-то. " +
                    "Собачка была хорошенькой, а мне нечего делать, поэтому я позвал ее и начал с ней играть. " +
                    "Я играл с собакой, когда мужчина вошел в холл. Он был одет в красивый мундир и я сразу " +
                    "узнал, что это был генерал Майлз. Я знал его по фотографиям в газетах. — Какая красивая " +
                    "собака, — сказал он. Это ваша собака? Я не успел ответить ему, когда он сказал," +
                    " «Хотите продать ее?» — Три доллара, — ответил я сразу. «Три доллара?» спросил он. —" +
                    " Но это очень мало. Я могу дать вам пятьдесят долларов за нее. Нет, нет. Мне нужно " +
                    "только три доллара. Что ж, это ваша собака. Если вы хотите три доллара за нее, я буду " +
                    "рад купить вашу собаку. Генерал Майлз заплатил мне три доллара, взял собаку и отправился " +
                    "к себе в комнату. Десять минут спустя старик вошел в холл. Он оглядел холл. Я заметил, " +
                    "что он что-то ищет. Вы ищете собаку, сэр? Спросил я. — О, да! Вы ее видели? — сказал он." +
                    " — Ваша собака была здесь несколько минут тому назад и я видел, как она ушла с мужчиной, " +
                    "— сказал я. Если хотите, я попробую найти ее для вас. Мужчина был очень счастлив и " +
                    "попросил меня помочь ему. — Я буду рад помочь вам, но это займет некоторое время и … — " +
                    "Я готов заплатить вам за ваше время, воскликнул мужчина. Сколько вы хотите за это? — Три " +
                    "доллара, — ответил я. «Три доллара?» спросил мужчина. Но это очень хорошая собака. " +
                    "Я готов заплатить вам десять долларов, если вы найдете её для меня. Нет сэр, я хочу три " +
                    "доллара и ни долларом больше, — сказал я. Тогда я поднялся в комнату генерала Майлса. " +
                    "Генерал играл со своей новой собакой. Я пришел сюда, чтобы вернуть собаку, сказал я. «Но " +
                    "теперь это не ваша собака — Я купил ее. Я заплатил тебе за нее три доллара,» -сказал " +
                    "Генерал. — Я верну вам обратно ваши три доллара, но я должен забрать обратно собаку, — " +
                    "ответил я. — Но вы продали мне ее и теперь эта собака моя. «Я не мог продать её вам, сэр, " +
                    "потому что это не моя собака.» «Тем не менее, вы продали ее мне за три доллара.» Как я " +
                    "могу продать ее вам, когда это не моя собака? Вы спросили, как много я хотел за неё, и я " +
                    "сказал, что хочу три доллара. «Но я никогда не говорил вам, что это моя собака.» Теперь " +
                    "генерал Майлз был очень зол. «Верни мне три доллара и возьми собаку,» — крикнул он. Когда " +
                    "я принес собаку обратно к ее хозяину, то он был счастлив и с радостью заплатил мне три " +
                    "доллара. Я был тоже счастлив, потому что у меня были деньги, и я чувствовал,что заслужил " +
                    "их Теперь ты можешь увидеть, почему я говорю, что честность — самая лучшая политика и что " +
                    "человек никогда не должен брать то, что он не заслужил.', 'black')," +
                    "('My pets','I love animals, so I’ve got a lot of them. Someone’s hobby is collecting " +
                    "stamps, doing exercises, drawing or learning foreign languages. Animals are my hobby. " +
                    "I like to look after them, feed and just watch them. I believe that animals bring us " +
                    "happiness and positive emotions. This, in its turn, has a positive effect on our moral " +
                    "and psychological state. So let me tell you more about my pets. In my house you will " +
                    "find two dogs and one cat, aquarium with fish and two hamsters. Most of all I love dogs," +
                    " but my mom loves cats. My brother is a very reserved person by character, so he keeps" +
                    " fish, but my sister loves hamsters. As for dad, his love is sufficient for all the animals." +
                    " He, just like me, doesn''t mind playing with any pet in our house. As I said earlier, I’m" +
                    " responsible mainly for the dogs in the house. Every day I take them for a walk twice. At " +
                    "the first opportunity I play with a ball with them or throw an artificial bone to them. My " +
                    "dogs are very smart and know a lot of tricks. I believe that life without animals would be " +
                    "too boring. Animals are our friends that will never desert us.','Я очень люблю домашних " +
                    "животных, поэтому у меня их очень много. У кого-то хобби -коллекционировать марки, заниматься " +
                    "спортом, рисовать или изучать иностранные языки, а мое хобби – это животные. Мне нравиться " +
                    "ухаживать за ними, кормить и просто наблюдать за ними. Я считаю, что животные доставляют " +
                    "нам радость и положительные эмоции. Это, в свою очередь, несет позитивный эффект для нашего " +
                    "морального и психологического состояния. Итак, позвольте мне рассказать вам больше о моих " +
                    "любимцах. В моем доме вы найдете две собаки и одну кошку, аквариум с рыбками и два хомячка. " +
                    "Больше всего я люблю собак, но моя мама обожает кошек. Мой брат по характеру очень замкнутый " +
                    "человек, поэтому он держит рыбок, а вот моя сестра любит хомячков. Что касается папы, то его" +
                    " любви хватает всем животным. Он, также как и я, не прочь поиграть с любым питомцем в нашем " +
                    "доме. Как я уже сказал ранее, за собак ответственен в доме я. Каждый день я выгуливаю их по " +
                    "два раза. При первой же возможности я играю с ними с мяч или бросаю им искусственную косточку." +
                    " Мои собаки очень умны и знаю немало трюков. Я считаю, что жизнь без животных была бы скучна. " +
                    "Животные – это наши друзья, которые никогда не оставят тебя в трудную минуту.', 'black')," +
                    "('Music in my life ','Who doesn''t love music? Whatever mood we have - bad or good, " +
                    "from time to time we turn on our favorite song. And it, in turn, either calms us, or on " +
                    "the contrary, makes us fall into melancholy. Life without music would be boring and dull. " +
                    "Just imagine a disco being in silence or holidays being without musicians. Absolutely all " +
                    "people of every type around the world are not indifferent to the music. Genres that are " +
                    "most popular are rock, rap, pop, techno, chanson, hip-hop and others. There are other " +
                    "very specific genres. For example, folk music, classical music, spiritual music and also " +
                    "such interesting genres as blues and jazz. Have you ever noticed that people, who share " +
                    "your tastes in music, get along with you much faster than those whose tastes are very " +
                    "different from yours? Many people believe that music is first and foremost an instrument" +
                    " of the soul. Probably it is so. Most of all I like modern music, but I also will not refuse" +
                    " to listen to classical and ethnic music. For example, I like Spanish folk songs. Listening" +
                    " to foreign songs I improve my knowledge of English. This is a great way to mix business with" +
                    " pleasure.','Кто не любит слушать музыку? Независимо от того, какое у нас настроение – плохое" +
                    " или хорошее, мы время от времени включаем любимую песню. А она, в свою очередь, либо " +
                    "успокаивает нас, либо напротив – заставляет впадать в меланхолию. Жизнь без музыки была " +
                    "бы скучна и уныла. Только представьте себе дискотеку в полной тишине или праздник без " +
                    "музыкантов. Абсолютно все люди в мире небезразличны к музыке. Жанры, которые наиболее " +
                    "популярны, - это рок, реп, попса, техно, шансон, хип-хоп и многие другие. Существую и " +
                    "другие, весьма специфические жанры. Например, народная музыка, классическая музыка, " +
                    "духовная, а также такие интересные жанры, как блюз и джаз. Вы когда-нибудь замечали, " +
                    "что человек, разделяющий ваши предпочтения в музыке, находит с вами общий язык намного " +
                    "быстрее, чем тот, у кого вкусы совершенно отличны от ваших? Многие считают, что музыка – " +
                    "это, в первую очередь, инструмент души. Наверное, так оно и есть. Больше всего мне " +
                    "нравится современная музыка, но я также не откажусь послушать классику или этническую музыку." +
                    " Например, мне нравятся испанские народные песни. Слушая иностранные песни, я улучшаю свои " +
                    "знания английского языка. Это прекрасный способ совместить приятное с полезным.', 'black')," +
                    "('At the airport','At the airport, you may listen some words: terminal, customs, " +
                    "check-in, tickets, security check, connections, boarding pass, and baggage. Every " +
                    "airport has two parts. They are arrivals and departures. The arrival part is usually on the " +
                    "first floor and the departure part is on the second floor. There are some elevators " +
                    "(or lifts) and escalators to bring you upstairs and downstairs. You are departing. At first," +
                    " look at the flight announcements to find out is your flight on time or it is delayed. " +
                    "Then you go to the check-in desk to check-in and pass your suitcase to the plane''s cargo. " +
                    "The check-in agent gives you a boarding pass. Then you go to the security check. The " +
                    "security stuff check you and your carry-on baggage. There are some rules, what things you " +
                    "are allowed and what things you are not allowed to carry on board. Then you go to the gate " +
                    "area, where you are waiting for your flight. When the flight is boarding, you go to the " +
                    "flight attendant and show your boarding pass. Then you go to your plane and take your seat. " +
                    "Have a good flight!','В аэропорту вы можете слышать слова: терминал, таможня, регистрация, " +
                    "билеты, проверка безопасности, стыковки, посадочный талон и багаж. Каждый аэропорт состоит " +
                    "из двух частей. Отправление и прибытие. Зона прибытия обычно находится на первом этаже, а " +
                    "зона отправления на втором этаже. Там есть лифты и эскалаторы, чтобы доставлять вас наверх и" +
                    " вниз. Вы вылетаете. Во-первых, обратите внимание на табло объявлений, чтобы выяснить, " +
                    "вовремя ли будет ваш рейс или он задерживается. После этого вы идете к стойке регистрации" +
                    " и сдаете свой чемодан в багаж. Агент дает вам посадочный талон. После этого вы идете к " +
                    "проверке безопасности. Сотрудники безопасности проверяют вас и вашу ручную кладь. Есть " +
                    "правила о том, какие вещи вам позволено пронести на борт, а какие нет. Затем вы идете в " +
                    "зону посадки, где вы ждете своего вылета. Когда идет посадка на борт, вы подходите к стюарду " +
                    "и показываете свой посадочный талон. Тогда вы идете в самолет и занимаете свое место. " +
                    "Удачного полета!', 'black'), ('Food store', 'Let''s go to the food store. There are a " +
                    "lot of items in my shopping list, so I need a shopping trolley. There is a big discount " +
                    "on fruit and vegetables. I take cabbage, potato, carrots, and onion for a soup. " +
                    "I also take 2 packs of red delicious apples, a watermelon, and three bananas. Then I go " +
                    "to the bakery section and put a loaf of wholemeal bread and 6 rolls in my trolley. At the " +
                    "dairy section I get 2 pint bottle of organic milk (it is slightly more than 1 litre), a dozen " +
                    "of eggs, and a pack of cheese slices. I see canned food shelves and take one can of baked beans." +
                    " At the fish and meat department I take a plastic tray with Salmon Fillet. It is quite " +
                    "expensive (more than 5 pound), but it’s tasty and healthy food. Then I am looking for " +
                    "water and juice. It''s in aisle 2 opposite the food store''s enter. I take 2 bottles of " +
                    "mineral water and one carton of orange juice. Now I am ready to pay so I am going to the " +
                    "checkout. The cashier may ask me three questions: «Do you need a bag?», «Have you got any " +
                    "discount card?» and «How would you like to pay?» You can pay in cash, by credit card or " +
                    "by debit card.', 'Давайте пойдем в продуктовый магазин. В моем списке покупок много " +
                    "пунктов, так что мне нужна тележка. Сейчас большие скидки на фрукты и овощи. Я беру капусту, " +
                    "картофель, морковь и лук для супа. Я также беру 2 пакета красных вкусных яблок, арбуз, и три " +
                    "банана. Потом я иду в хлебный отдел и кладу в свою тележку буханку хлеба из муки грубого " +
                    "помола и 6 булочек. В молочной секции я беру 2 пинтовую бутылку органического молока " +
                    "(это немного больше, чем 1 литр), дюжину яиц и пачку нарезанного ломтиками сыра. Я " +
                    "вижу полки с консервами и беру одну банку печеных бобов. В отделе рыбы и мяса я беру " +
                    "пластиковый поднос с филе лосося. Это довольно дорого (более чем 5 фунтов), но это вкусная " +
                    "и здоровая еда. Затем я ищу воду и сок. Это во втором проходе напротив входа в продуктовый " +
                    "магазин. Я беру 2 бутылки минеральной воды и коробку апельсинового сока. Теперь я готов " +
                    "заплатить, так что я иду к кассе. Кассир может задать мне три вопроса: «Нужен ли вам пакет?», " +
                    "«Есть ли у вас какие-либо дисконтные карты?» и «Как вы хотели бы платить?» Вы можете оплатить " +
                    "наличными, кредитной картой или дебетовой картой.', 'black');"
            );
            statement.executeUpdate("INSERT INTO my_text (title_text, text_eng, text_rus, color)" +
                    "VALUES ('A city or a village?', 'Nowadays a lot of people prefer to live in large " +
                    "cities, because it is easier to find a job there. Although more and more people choose " +
                    "to live in the country or a village. There are more entertainments in the city: a lot " +
                    "of theatres, museums, cinemas, concert halls and shops. But the village is safer, " +
                    "quieter, healthy, and the air is much cleaner than in the city. Furthermore, there " +
                    "are not so many vehicles and people in the village. Children can go to school and play " +
                    "on the playgrounds by themselves. Houses in the village are cheaper than in the city, " +
                    "but life may be a bit boring there, especially for youth. As for me, the best solution" +
                    " is to live in the countryside, but close to the big city, to be able to get to the " +
                    "centre quickly. Where do you prefer to live and why?', 'В настоящее время многие люди " +
                    "предпочитают жить в больших городах, потому что там легче найти работу. Хотя все больше " +
                    "и больше людей предпочитают жить в сельской местности или деревне. В городе больше " +
                    "развлечений: много театров, музеев, кинотеатров, концертных залов и магазинов. Но деревня " +
                    "является более безопасной, более тихой, здоровой, а воздух там намного чище, чем в" +
                    " городе. Кроме того, в деревне не так много транспорта и людей. Дети могут ходить в " +
                    "школу и играть на детских площадках сами по себе. Дома в деревне дешевле, чем в городе," +
                    " но жизнь там может быть немного скучной, особенно для молодежи. Что касается меня, то " +
                    "лучшим решением будет жить в сельской местности, но близко к большому городу, чтобы " +
                    "иметь возможность быстро добраться до центра. Где вы предпочитаете жить и почему?', " +
                    "'black'), ('Clothes','I love to go shopping and buy new clothes. Especially I like to " +
                    "buy things at Massimo Duthie at discount prices. I have recently bought a new black " +
                    "sweater there. I like to wear black. I think it suits my face. But I have a lot of " +
                    "clothes in white and brown colours. In summer I usually wear a t-shirt, jeans and " +
                    "sneakers. But for my work I wear a blouse, jacket, skirt and shoes with small heels. " +
                    "I wear a dress only on holidays. In the autumn or spring, I wear anorak, trousers and " +
                    "boots. In the winter I wear a winter coat, sweater, hat, warm pants and high boots. " +
                    "And what kind of clothes you wear at different times of year and where you prefer to" +
                    " buy these clothes? What colour do you prefer?','Я люблю ходить по магазинам и покупать" +
                    " новую одежду. Особенно я люблю покупать вещи в Массимо Дутти по сниженным ценам. Я" +
                    " недавно купила там новый черный свитер. Мне нравится носить черный. Я думаю, что это " +
                    "подходит к моему лицу. Но у меня есть много одежды белого и коричневого цветов. Летом " +
                    "я обычно ношу футболку, джинсы и мокасины. Но на работу я ношу блузку, пиджак, юбку и " +
                    "туфли на небольшом каблуке. А платье надеваю только по праздникам. Осенью или весной я " +
                    "ношу анорак, брюки и боты. Зимой я ношу зимнее пальто, свитер, шапку, теплые брюки и " +
                    "высокие сапоги. А какую одежду вы носите в разные времена года и где вы предпочитаете " +
                    "покупать эту одежду? Какой цвет вы предпочитаете?', 'black'), ('I feel ill', " +
                    "'What’s wrong? What’s the matter? If you are ill, your body can ache in different " +
                    "places. Mr Smith is feeling sick. He is going to his doctor and telling him about " +
                    "his symptoms. At the doctor’s office people often have health problems. How do you " +
                    "feel? How are you? I feel terrible. I feel awful. I don’t feel well. I am sick. " +
                    "I have a cold, a cough, and a sore throat. I am asthmatic. She is definitely having " +
                    "a fever, it might be the flu. Why doesn’t she take an aspirin? Don’t worry, the doctor" +
                    " is going to prescribe him some medicine and he is going to feel better soon. I have " +
                    "a toothache. Why don’t you go to the dentist? I have a high temperature and my stomach " +
                    "is upset. Take some medicine. I have a broken arm and my leg hurts. I feel ill. My head " +
                    "hurts. I''ve got a terrible headache. I''ve got a temperature. Why don''t you go home and " +
                    "lie down? Be healthy!', 'Что случилось? В чем дело? Если вы больны, ваше тело может " +
                    "болеть в разных местах. Г-н Смит чувствует себя больным. Он идет к своему врачу и " +
                    "рассказывает ему о своих симптомах. В офисе врача у людей часто возникают проблемы со " +
                    "здоровьем. Как вы себя чувствуете? Как дела? Я чувствую себя ужасно. Я чувствую себя " +
                    "ужасно. Я не чувствую себя хорошо. Я болею. У меня насморк, кашель и боль в горле. Я " +
                    "астматик. У нее определенно лихорадка, это может быть грипп. Почему она не принимает " +
                    "аспирин? Не волнуйтесь, врач выпишет ему некоторые лекарства, и он вскоре почувствует" +
                    " себя лучше. У меня болит зуб. Почему бы вам не пойти к зубному врачу? У меня высокая " +
                    "температура, и мой желудок расстроен. Примите какие-нибудь лекарства. У меня сломана" +
                    " рука и моя нога болит. Я чувствую себя неважно. Моя голова болит. У меня ужасная " +
                    "головная боль. У меня температура. Почему бы тебе не пойти домой и не лечь? Будьте " +
                    "здоровы!', 'black'), ('Feelings', 'Life is full of feelings. They might be good ones" +
                    " or not so good ones. I like it very much. I don''t like it at all. It makes me angry. " +
                    "When I''m unhappy I go shopping. When I am bored I go to the cinema. I am a bit tired." +
                    " He is thirsty. She is not very happy. I''m not at all hungry. Children make me happy." +
                    " I find them funny. They are great, aren''t they? Sometimes I feel worried, frightened " +
                    "or bored. When Victor is tired he goes to bed. When Anna is hungry she goes to a " +
                    "restaurant. Paul enjoys his language lessons. He thinks it''s lovely. I''m a little sad " +
                    "today, because it''s raining. How are you? I''m not sad, but I''m very hot. It''s really " +
                    "hot today. I''m afraid I can''t go with you. Some things make me depressed. The telephone " +
                    "call worries me. I am so sensitive. The height frightens me. I don''t think it''s " +
                    "interesting. I think it''s disgusting. It''s so wonderful! I worry about practically " +
                    "everything. I''m a bit nervous about even coming to a dentist. My brother makes me " +
                    "really annoyed and angry because he never stops crying. Fred is excited because he " +
                    "won. His mother is surprised. Lucy is confused. She is a very shy person. I was " +
                    "embarrassed.', 'Жизнь полна чувств. Они могут быть хорошие или не очень хорошие. " +
                    "Мне это очень нравится. Мне это вообще не нравится. Это заставляет меня злиться. " +
                    "Когда я несчастна, я хожу по магазинам. Когда мне скучно, я хожу в кино. Я немного " +
                    "устал. Он хочет пить. Она не очень счастлива. Я вовсе не голоден. Дети делают меня " +
                    "счастливым. Я считаю их забавными. Они прекрасны, не так ли? Иногда я чувствую " +
                    "беспокойство, страх или скуку. Когда Виктор устает, он ложится спать. Когда Анна голодна," +
                    " она идет в ресторан. Павел наслаждается уроками языка. Он думает, что это мило. " +
                    "Я немного грустный сегодня, потому что идет дождь. А как ты? Я не грустный, но мне " +
                    "очень жарко. Сегодня действительно жарко. Боюсь, я не могу пойти с вами. Некоторые " +
                    "вещи вызывают у меня депрессию. Телефонный звонок меня беспокоит. Я такая чувствительная. " +
                    "Высота меня пугает. Я не думаю, что это интересно. Я думаю, что это отвратительно. " +
                    "Это так замечательно! Я беспокоюсь о практически обо всем. Я немного нервничаю, " +
                    "даже когда иду к стоматологу. Мой брат делает меня очень раздраженным и злым, потому " +
                    "что он никогда не перестает плакать. Фред возбужден, потому что он выиграл. " +
                    "Его мать удивлена. Люси смущена. Она очень застенчивый человек. Я был смущен.', 'black'), " +
                    "('People', 'There are many people on our planet. We all look different. Everybody''s " +
                    "appearance is unique. First of all, there are men and women. We have different ages: " +
                    "there are old, middle-aged, young people and children. We have different skin colour. " +
                    "Some of us have black skin colour, others have white, and there are humans with yellow" +
                    " skin colour. Those persons whose parents have different skin colour, called mulatto. " +
                    "Humans have different height and weight. There are high and short, fat and thin people." +
                    " Our hair and eyes are different too. Some people have blond hair, but others have " +
                    "dark hair, there are also red-haired people. Hair can be straight or curly, long or " +
                    "short. And there are bald persons, they have no hair at all. And of course, people " +
                    "can have different personalities. There are calm and quiet persons, and there are " +
                    "fighters, they are brave. But we all have the same desires. People want to be happy, " +
                    "healthy and loved.', 'Есть много людей на нашей планете. Мы все выглядим по-разному. " +
                    "Внешность каждого из нас уникальна. Прежде всего, есть мужчины и женщины. У нас разный " +
                    "возраст: есть старики, люди среднего возраста, молодые люди и дети. У нас разный цвет " +
                    "кожи. Некоторые из нас имеют черный цвет кожи, другие — белый, и есть люди с желтым " +
                    "цветом кожи. Те люди, чьи родители имеют разный цвет кожи, называются мулатами. Люди " +
                    "имеют разный рост и вес. Есть высокие и короткие, толстые и тонкие люди. Наши волосы и " +
                    "глаза тоже разные. У некоторых людей светлые волосы, а у других людей черные волосы, " +
                    "есть и рыжеволосые люди. Волосы могут быть прямые или вьющиеся, длинные или короткие." +
                    " И есть лысые люди, у них вообще нет волос. И, конечно же, люди могут иметь разные " +
                    "личности. Есть спокойные и тихие люди, и есть бойцы, они смелые. Но у всех нас есть " +
                    "одни и те же желания. Люди хотят быть счастливыми, здоровыми и любимыми.', 'black'), " +
                    "('Food and drink', 'It is important for every living creature to have food and drink. " +
                    "In the morning, we usually have breakfast, around the noon we have lunch, and in the " +
                    "evening we have dinner. Sometimes we eat at home, and sometimes we go to a restaurant " +
                    "or cafe. Many people can cook delicious food by themselves. Our food consists of fruits," +
                    " vegetables, cereals, meat and fish. We also eat dairy. Cooks can prepare different " +
                    "dishes from these products. They use recipes. Different nationalities have their own " +
                    "cuisine. Some people today don''t eat meat and fish, they are called vegetarians. Some" +
                    " people often watch their diet to lose weight or to be healthy. Then they don''t eat " +
                    "food with sugar, flour and fat. What do we usually drink? It is known that every person" +
                    " should drink plenty of water — about 2 litres a day. But we also drink other beverages" +
                    " like tea, coffee, milk, juice, wine, and lemonade.', 'Для каждого живого существа " +
                    "важно иметь еду и питье. Утром мы обычно завтракаем, около полудня мы обедаем, а " +
                    "вечером у нас ужин. Иногда мы едим дома, а иногда идем в ресторан или кафе. Многие " +
                    "люди сами могут готовить вкусные блюда. Наша пища состоит из фруктов, овощей, круп, " +
                    "мяса и рыбы. Мы также едим молочные продукты. Повара могут приготовить различные блюда " +
                    "из этих продуктов. Они используют рецепты. Разные национальности имеют свою собственную" +
                    " кухню. Некоторые люди сегодня не едят мясо и рыбу, они называются вегетарианцами. " +
                    "Некоторые люди часто соблюдают свою диету, чтобы похудеть или быть здоровым. Тогда они " +
                    "не едят пищу с сахаром, мукой и жиром. Что мы обычно пьем? Известно, что каждый человек" +
                    " должен пить много воды — около 2 литров в день. Но мы также пьем и другие напитки, " +
                    "такие как чай, кофе, молоко, вино, лимонад.', 'black'), ('Picture description', " +
                    "'A „Peaceful Pond“ by Katarzyna Lach, Poland Can you paint a picture, using a knife? " +
                    "The young Polish artist Katarzyna Lach uses this technique to create her gorgeous arts." +
                    " The landscape is called «Peaceful Pond». It is an oil painting and it has a very " +
                    "interesting texture, but the surface of the painting is almost perfectly smooth. In " +
                    "the foreground, we see a pond. There are some reeds and water lilies on the pond, but " +
                    "the water is still clean and clear, so we can see trees and clouds on the pond''s " +
                    "surface. In the middle of the picture, we see ordinary green and yellow trees: pines," +
                    " aspens, oaks. The artist very carefully and accurately painted the landscape, it seems " +
                    "that we are standing on the edge of the pond. In the background, between the trees we " +
                    "see a blue sky with white clouds in it. We feel quiet and nostalgic. This picture " +
                    "describes one of those places where people are usually happy.', 'Можно ли написать " +
                    "картину, используя нож? Молодая польская художница Катаржина Лах использует эту технику" +
                    " для создания своих великолепных работ. Этот пейзаж называется «Мирный пруд». Он " +
                    "написан масляной краской и имеет очень интересную текстуру, но поверхность картины " +
                    "почти совершенно гладкая. На переднем плане мы видим пруд. На пруду камыши и кувшинки, " +
                    "но вода в нем все равно прозрачная и чистая, так что мы можем видеть деревья и небо " +
                    "на поверхности. В центре картины мы видим обычные зеленые и желтые деревья: сосны, " +
                    "осины, дубы. Художник очень тщательно и достоверно изобразил пейзаж, кажется, будто " +
                    "мы сами стоим на берегу этого пруда. На заднем плане между деревьями мы видим синее " +
                    "небо и белые облака на нем. Мы чувствуем спокойствие и ностальгию. Эта картина описывает " +
                    "одно из тех мест, где люди обычно счастливы.', 'black'), ('Giving compliments', " +
                    "'People love compliments. It is great to receive a compliment, but it is also great " +
                    "to dive compliments. Compliments bring happiness to both sides. What can you say to " +
                    "give compliments? You are wonderful. You look nice! What a lovely dress! I like your " +
                    "style. You look great in white. That colour is perfect for you. You are the best " +
                    "listener. This is a really nice picture! What a cute baby! The pizza is delicious. " +
                    "You are a fantastic cook! I appreciate you. What a nice flat! You have a beautiful " +
                    "house. What do we say to respond a compliment? Thank you. You are very kind. That''s " +
                    "very kind of you. Thank you very much, and the same to you. I am glad you like it. " +
                    "I appreciate the compliment. How kind of you to say so! Thank you very much, you look " +
                    "very nice too! That makes me feel great! That''s very nice of you to say.', 'Люди " +
                    "любят комплименты. Это здорово получать комплименты, но также здорово дарить комплименты." +
                    " Комплименты приносят счастье обеим сторонам. Что вы можете сказать в качестве " +
                    "комплимента? Вы замечательный. Ты хорошо выглядишь! Какое прекрасное платье! Мне " +
                    "нравится твой стиль. Ты выглядишь великолепно в белом цвете. Этот цвет идеально " +
                    "подходит для вас. Вы самый лучший слушатель. Это очень хорошая картина! Какой милый " +
                    "ребенок! Пицца очень вкусная. Вы фантастический повар! Я ценю тебя. Какая хорошая " +
                    "квартира! У вас красивый дом. Что мы говорим, чтобы ответить на комплимент? Спасибо." +
                    " Вы очень добры. Очень любезно с Вашей стороны. Большое спасибо, и вам того же. " +
                    "Я рад что тебе понравилось. Я ценю комплимент. Как мило с вашей стороны сказать это! " +
                    "Большое спасибо, вы тоже выглядите очень мило! Это заставляет меня чувствовать себя " +
                    "великолепно! Очень приятно, что вы это сказали.', 'black'), ('Habits', 'We all know " +
                    "there are bad and good habits. Good habits or custom bring us to healthy and effective" +
                    " life. They say, to change your life, change your habits. We need to break bad habits" +
                    " and to build good ones, but it''s easier said than done. It''s very difficult to break " +
                    "bad habits. Habits are actions that people do every day, or even many times a day. " +
                    "They usually happen without our control. We do not think of them much, we just do them." +
                    " For example, if a person like smoking, he or she feels annoyed without a cigarette. " +
                    "Drinking alcohol, picking your nose, eating when you not hungry, spending much time " +
                    "watching TV or playing computer games — these actions are bad. Good customs start " +
                    "early. It means we form them in childhood. Brushing teeth twice a day, doing exercises," +
                    " going to bed on time, getting up early, cleaning up the mess — these things are " +
                    "good.', 'Мы все знаем, что есть плохие привычки и хорошие привычки. Хорошие привычки " +
                    "приводят нас к здоровой и эффективной жизни. Говорят, чтобы изменить свою жизнь, надо " +
                    "изменить свои привычки. Нам нужно преодолеть вредные привычки и строить хорошие, но " +
                    "это легче сказать, чем сделать. Это очень трудно сломать плохие привычки. Привычки — " +
                    "это действия, которые люди делают каждый день или даже несколько раз в день. Они обычно " +
                    "происходят без нашего контроля. Мы много не думаем о них, мы просто делаем их. " +
                    "Например, если человек любит курить, то он или она чувствуют себя раздраженным без " +
                    "сигареты. Вы знаете другие плохие привычки? Употребление алкоголя, ковыряние в носу, " +
                    "есть, когда вы не голодны, проводить много времени за просмотром телевизора или играя " +
                    "в компьютерные игры — это все плохие вещи. Хорошие привычки начинаются рано. Это " +
                    "означает, что мы формируем их в детстве. Чистить зубы два раза в день, делать " +
                    "физические упражнения,  ложиться спать вовремя, рано вставать, убирать беспорядок —" +
                    " это хорошие вещи.', 'black'), ('Kitchen and cooking', 'My kitchen is not very big " +
                    "but there is enough place for all things we need for cooking. There is a fridge with a " +
                    "freezer, a gas cooker, an electric oven, and a dishwasher. There are cupboards on the " +
                    "walls and tables with drawers. We place there our cookware: pans, pots and casseroles. " +
                    "Under the window, we have a big sink and a tap. When we wash dishes, we look out of the" +
                    " window and enjoy the beautiful view. You can see lots of modern devices for preparing" +
                    " food. They are a kettle, a food processor, a toaster and a microwave. Of course, we " +
                    "have lots of cutlers too. My mother likes cooking and she always cooks something tasty" +
                    " for all our family. All my family likes her cooking. Especially we like her tomato " +
                    "soup, a pizza, and cakes. I can cook too. I like making sandwiches, salads, and fried " +
                    "chicken. I can tell a lot more about my kitchen and cooking, but I am going to do it" +
                    " in another topic.', 'Моя кухня не очень большая, но в ней достаточно места для всех" +
                    " вещей, которые нужны для приготовления пищи. Здесь есть холодильник с морозильной " +
                    "камерой, газовая плита, электрическая духовка и посудомоечная машина. Есть шкафы на " +
                    "стенах и столы с ящиками. Мы размещаем там нашу посуду: сковородки, горшки и" +
                    " кастрюли. Под окном у нас большая раковина и кран. Когда мы моем посуду, мы смотрим " +
                    "из окна и наслаждаемся прекрасным видом. Вы можете видеть множество современных" +
                    " приборов для приготовления пищи. Это чайник, кухонный комбайн, тостер и микроволновая" +
                    " печь. Конечно, у нас также есть много столовых приборов. Моя мама любит готовить, и " +
                    "она всегда готовит что-нибудь вкусное для всей нашей семьи. Вся наша семья любит ее " +
                    "блюда. Особенно нам нравятся ее томатный суп, пицца и пироги. Я тоже могу готовить. Я " +
                    "люблю делать бутерброды, салаты, и жареную курицу. Я могу сказать намного больше о " +
                    "моей кухне и приготовлении пищи, но я собираюсь сделать это в другой теме.', 'black'), " +
                    "('Cafe', 'In a cafe you can try different dishes from many countries and eat dinner " +
                    "in a friendly atmosphere. Many people have lunch in a cafe. But many more people go " +
                    "there to get a cup of tea or coffee. There are lots of different types of coffee: " +
                    "espresso. americano, latte, mocha, and cappuccino. Which one do you prefer? An espresso " +
                    "is a very strong coffee. It is a basic for other types. For example, my favorite type " +
                    "of coffee is latte. Latte is espresso with lots of steamed milk. A barista is a man or" +
                    " woman, who makes your coffee. If you want to drink your order in a cafe you say «for " +
                    "here». If you go outside the cafe, just say «to take away» or «to go». Here are the " +
                    "examples: — Hi, can I get a large cappuccino to go, please? — Hi, I''ll have a medium " +
                    "espresso for here. You can also order something else: a chocolate bar, a sandwich or a " +
                    "piece of cake.', 'В кафе вы можете попробовать различные блюда из разных стран и " +
                    "пообедать в дружественной обстановке. Многие люди обедают в кафе. Но гораздо больше " +
                    "людей идут туда, чтобы выпить чашку чая или кофе. Есть много различных видов кофе: " +
                    "эспрессо, американо, латте, мокко и капучино. Какой из них вы предпочитаете? Эспрессо " +
                    "— это очень крепкий кофе. Это основа для других видов кофе. Например, мой любимый " +
                    "кофе латте. Латте — это эспрессо с большим количеством пропаренного молока. Бариста — " +
                    "это мужчина или женщина, который делает вам кофе. Если вы хотите выпить ваш заказ в " +
                    "кафе, вы говорите, «здесь». Если вы выходите на улицу из кафе, скажите: «с собой» или " +
                    "«на вынос». Вот примеры: — Привет, мне, пожалуйста, большой капучино на вынос. — " +
                    "Привет, я буду пить здесь средний эспрессо. Вы также можете заказать что-то еще: " +
                    "шоколадку, бутерброд или кусочек торта.', 'black'), ('The seasons of the year', " +
                    "'We know four seasons of the year. Each season lasts for three months. The weather " +
                    "and hours of daylight are different during each season. The Earth moves around the" +
                    " Sun and it rotates around its own axis. This is what causes seasons of the year. " +
                    "Let us describe them. Spring Almost everyone loves spring. This period is full of life," +
                    " light and colour. When spring comes, the first green leaves appear on trees, flowers " +
                    "bloom in gardens, and days get longer. Birds come back and build their nests and there" +
                    " are fantastic thunderstorms in May. Summer Long summer days are the favourite period " +
                    "for all birds and animals. It may be rainy and hot. Students have got a long holiday." +
                    " In summer, we like swimming, having sunbathed and going to the countryside or to the " +
                    "seaside. Winter The coldest season of the year is winter with its short days. There are" +
                    " lots of snow and icy. Rivers cover with ice. But some people like winters, because they " +
                    "can go skiing, skating and sledging. We have the most important holiday in December — " +
                    "it is a New Year. Autumn This period of the year is beautiful and colourful in Russia, " +
                    "but it''s usually rainy. The weather is getting overcast and days become gloomy. The " +
                    "leaves are changing colour and falling down the trees. People like going to a forest" +
                    " to pick up mushrooms. What season of the year do you like? Why?', 'Мы знаем четыре " +
                    "времени года. Каждый сезон длится три месяца. Погода и долгота дня различны для каждого" +
                    " сезона. Земля движется вокруг Солнца и вращается вокруг своей оси. Это то, что вызывает" +
                    " времена года. Давайте опишем их. Весна Почти все любят весну. Этот сезон полон жизни, " +
                    "света и цвета. Когда весна приходит, первые листья появляются на деревьях, цветы цветут," +
                    " и дни становятся длиннее. Птицы возвращаются и строят свои гнезда, а еще в мае бывают " +
                    "фантастические грозы. Лето Длинные летние дни излюбленный период для всех птиц и животных." +
                    " Может быть дождливо и жарко. У студентов длинные каникулы. Летом мы любим плавать, " +
                    "загорать и ездить на природу или на море. Зима Самый холодный сезон года — зима с " +
                    "ее короткими днями. В ней много снега и льда. Реки покрываются льдом. Но некоторые " +
                    "люди любят зиму, так как они могут кататься на лыжах, коньках и санках. В декабре" +
                    " самый важный праздник — это Новый год. Осень Этот период года является красивым и " +
                    "красочным в России, но он обычно дождливый. Погода становится пасмурной, а дни " +
                    "становятся мрачными. Листья меняют цвет и падают с деревьев. Люди любят ходить в лес " +
                    "и собирать грибы. Какое время года вы любите? Почему?', 'black'), ('A letter to my " +
                    "penfriend', 'Hi Eric, My name is Olga Petrova. I''m your new penfriend from Moscow," +
                    " Russia. Now I''m in London. It''s a wonderful city! I go sightseeing, shopping and" +
                    " walking in different parks. I also listen to the native speakers and try to use the " +
                    "English language. I enjoy being in the UK. My favourite restaurant here is «Pret a " +
                    "Manger». I love their food because it''s tasty, healthy, and easy to order and take away. " +
                    "Yesterday we went to the cinema. We saw a new movie called «Doctor Strange» with " +
                    "Benedict Cumberbatch. He is my favourite film star. I liked the film. Tomorrow we " +
                    "are going to Wimbledon. I like playing tennis. My favourite sports star is Maria " +
                    "Sharapova. She is Russian too.  What type of music do you like? I like pop music " +
                    "and my favourite pop star is Ricky Martin. He is from Puerto Rico. Who are your " +
                    "favourite stars? Where are they from? Write to me soon. Olga.', 'Привет Эрик, Меня " +
                    "зовут Ольга Петрова. Я твой новый друг по переписке из Москвы, Россия. Сейчас я " +
                    "нахожусь в Лондоне. Это удивительный город! Я осматриваю достопримечательности, " +
                    "хожу по магазинам, гуляю в разных парках. Я также слушаю носителей языка и пытаюсь" +
                    " использовать английский язык. Мне нравится быть в Великобритании. Мой любимый " +
                    "ресторан здесь «Прет э Мэнджей» . Я люблю их еду, потому что она вкусная, здоровая," +
                    " и ее легко заказать и забрать с собой. Вчера мы ходили в кино. Мы видели новый " +
                    "фильм под названием «Доктор Стрэндж» с Бенедиктом Камбербэтчем. Он мой любимый артист." +
                    " Мне понравился фильм. Завтра мы собираемся в Уимблдон. Мне нравится играть в теннис. " +
                    "Моя любимая спортивная звезда Мария Шарапова. Она тоже русская. Какую музыку ты любишь?" +
                    " Я люблю поп-музыку, а мой любимый певец — Рики Мартин. Он из Пуэрто-Рико. Кто твои " +
                    "любимые звезды? Откуда они? Напиши мне в ближайшее время. Ольга.', 'black'), ('A sports " +
                    "centre', 'Anna: Do you know a sports centre near here? There is a big sports centre " +
                    "near my house in Moscow and I often go there. Boris: Yes, there''s a good gym near the " +
                    "Gills church. Anna: Great! Is there a basketball court? Basketball is my favourite" +
                    " sport. Boris: Yes, there is. There''re two big pools, four tennis courts, a " +
                    "basketball court, a cafe, and a sauna. Anna: Fantastic! And is there a jacuzzi? " +
                    "Boris: No, there isn''t. Anna: I can''t play basketball very well. Are there any " +
                    "classes? Boris: Yes, there are. There are basketball classes on Monday and Wednesday " +
                    "mornings. Anna: Can you play basketball? Boris: Yes, I play basketball pretty good. " +
                    "Anna: Well, come to the basketball classes with me! Boris: It would be great, but… " +
                    "My favourite sport is swimming. Anna: Let''s go to a swimming pool on weekends and " +
                    "to a basketball classes on Monday and Wednesday mornings. Boris: OK, let us try. " +
                    "And what about a cafe? Would you like a cup of tea? Anna: OK, but I prefer coffee.'," +
                    " 'Анна: Знаешь ли ты спортивный центр недалеко отсюда? Рядом с моим домом в Москве " +
                    "есть большой спортивный центр, и я часто хожу туда. Борис: Да, есть хороший" +
                    " тренажерный зал рядом с церковью Гилл. Анна: Отлично! Есть ли там баскетбольный " +
                    "зал? Баскетбол — мой любимый вид спорта. Борис: Да, есть. Там есть два больших " +
                    "бассейна, четыре теннисных корта, баскетбольный зал, кафе и сауна. Анна: Чудесно! " +
                    "А джакузи есть? Борис: Нет. Анна: Я не очень хорошо играю в баскетбол. Есть ли " +
                    "какие-нибудь уроки? Борис: Да, есть. Есть баскетбольные занятия по утрам в понедельник" +
                    " и в среду. Анна: Можешь ли ты играть в баскетбол? Борис: Да, я играю довольно хорошо." +
                    " Анна: Ну, пойдем на баскетбольные занятия со мной! Борис: Было бы здорово, но… " +
                    "Мой любимый спорт — плавание. Анна: Давай ходить в бассейн по выходным, а на " +
                    "баскетбольные занятия с утра в понедельник и в среду. Борис: Хорошо, давай попробуем. " +
                    "А что насчет чашечки чая, Анна: Хорошо, только я предпочитаю кофе.', 'black'), ('The " +
                    "birthday party', 'Oleg: Hi Mary. Mary: Hi Oleg. Oleg: I''m having a birthday party on " +
                    "Friday. I would like for you to come if you can. Mary: That would be great. Where " +
                    "will it be held? Oleg: I''m having a small birthday party in my house at 2 pm. Mary: " +
                    "Great! Do you want me to bring anything? Oleg: No, my mother is going to make plenty " +
                    "of food and to bake a big cake with candles on it. My sisters are decorating the house" +
                    " with balloons. We are planning some entertainment. Hope, it will be fun. Mary: I can''t" +
                    " wait. How many people are you expecting? Oleg: Probably around 15 people including " +
                    "my relatives. Mary: I see. Is there a dress code? Oleg: No, just take a swimming suit." +
                    " We are going to play in our pool. Mary: OK, see you on Friday then. Friday Oleg: Hi " +
                    "Mary. Nice to see you. Mary: Hi Oleg. Happy birthday to you. This is my present for " +
                    "you. I hope you''ll like it. Oleg: Oh, thank you very much! I have lots of presents " +
                    "today! Mary: Look, your mother is bringing the cake. You should make a wish and blow " +
                    "out the candles. Oleg: Yes, it''s time for my wish!', 'Олег: Привет, Мэри. Мэри: Привет," +
                    " Олег. Олег: У меня день рождения в пятницу. Я хотел бы, чтобы ты пришла, если можешь. " +
                    "Мэри: Это было бы здорово. Где он будет проходить? Олег: Будет небольшая вечеринка в " +
                    "моем доме в 2 часа дня. Мэри: Отлично! Ты хочешь, чтобы я принесла что-нибудь? Олег: " +
                    "Нет, моя мама собирается сделать много еды и испечь большой торт со свечами. Мои сестры" +
                    " украшают дом воздушными шарами. Мы планируем развлечения. Надеюсь, будет весело. Мэри:" +
                    " Не могу дождаться. Сколько людей ты ожидаешь? Олег: Вероятно, около 15 человек, включая " +
                    "моих родственников. Мэри: Понимаю. Есть ли дресс-код? Олег: Нет, просто возьми купальник. " +
                    "Мы будем играть в нашем бассейне. Мэри: Хорошо, тогда увидимся в пятницу. Пятница " +
                    "Олег: Привет, Мэри. рад тебя видеть. Мэри: Привет, Олег. С Днем рожденья тебя. Это " +
                    "мой подарок тебе. Я надеюсь, он тебе понравится. Олег: О, большое спасибо! У меня " +
                    "сегодня много подарков! Мэри: Смотри, твоя мама несет торт. Ты должен загадать " +
                    "желание и задуть свечи. Олег: Да, пришло время для моего желания!', 'black'), ('Price', " +
                    "'How much is the cost of living in London? London is a very expensive city. Houses in " +
                    "London are the most expensive in the world. A single bus fare costs £1.50. That''s a " +
                    "good price. Buses are cheaper than the tube. On Black Friday many companies will " +
                    "discount their products and stores offer reduced prices. The price keeps going up! " +
                    "There is a big discount on phones. Could you reduce the price by 10%? You could say:" +
                    " «Save up to 50%», or «Up to 50% off». How much are these trousers? — They are £14.99." +
                    " What is the price of this coat? — The coat is £75. Do you know how much this " +
                    "costs? — The t-shirts are £4.99 each. Can you check the price of this dress for " +
                    "me, please? — The dress is £175. How much do the apples cost? — The apples are " +
                    "£1.75 a kilo. How much does this box cost? — It''s £0.75. How much are these " +
                    "pants? — They are £10. How much is this book? — It''s £3.25.', 'Сколько стоит жить" +
                    " в Лондоне? Лондон очень дорогой город. Дома в Лондоне самые дорогие в мире. Одна " +
                    "поездка в автобусе стоит £1,50. Это хорошая цена. Автобусы стоят дешевле, чем " +
                    "метро. В Черную пятницу многие компании будут снижать цены на свои продукты, а " +
                    "магазины предлагают сниженные цены. Цена продолжает расти! Существует большая " +
                    "скидка на телефон. Не могли бы вы снизить цену на 10%? Можно сказать: «Экономия" +
                    " до 50%», или «скидки до 50%» Сколько стоят эти брюки? — Они стоят £14,99." +
                    " Какова цена этого пальто? — Пальто стоит £75. Знаете ли вы, сколько это стоит? " +
                    "— Футболки по £4.99 каждая. Вы можете проверить цену этого платья для меня, " +
                    "пожалуйста? — Платье стоит £175. Сколько стоят яблоки? — Яблоки £1,75 за килограмм." +
                    " Сколько стоит эта коробка? — Она стоит £0.75. Сколько стоят эти брюки? — " +
                    "Они стоят £10. Сколько стоит эта книга? — Она стоит £3,25.', 'black'), " +
                    "('Healthy lifestyle', 'Mona: I''m hungry, I want a big hamburger for lunch. What about you? " +
                    "Lisa: I don''t eat hamburgers. It is unhealthy food. Do you know I''m trying to lose weight?" +
                    " I go to a swimming pool three times a week, and I do morning exercises. I also drink about" +
                    " 2 litres of water a day and eat more fruits, herbs and vegetables. Mona: Why do you try to " +
                    "lose your weight? Lisa: My doctor told me that I should lead a healthy lifestyle because " +
                    "I can get a heart attack. It is better to eat small meals, and choose products based on " +
                    "fruit and vegetables, instead of fat, fried and sugary food. Mona: I like it. What do you " +
                    "eat for breakfast? Lisa: I eat 1 slice whole-grain bread with 2 slices low-fat cheese for " +
                    "breakfast. And of course I enjoy my cup of coffee. Then I can eat an apple or a pear before " +
                    "lunch. Mona: So, what are you going to take for lunch? Lisa: Three-egg omelette, 1 red pepper," +
                    " 1 small tomato, and a whole-wheat bun. Mona: Good idea! I think it''s very tasty. What do you " +
                    "prefer to drink?', 'Мона: Я голодна, я хочу большой гамбургер на обед. А как насчет " +
                    "тебя? Лиза: Я не ем гамбургеры. Это нездоровое питание. Ты знаешь, что я стараюсь похудеть?" +
                    " Я хожу в бассейн три раза в неделю, и делаю утреннюю гимнастику. Я также пью около 2 " +
                    "литров воды и ем больше фруктов, трав и овощей. Мона: Почему ты пытаешься сбросить вес? " +
                    "Лиза: Мой врач сказал мне, что я должна вести здоровый образ жизни, потому что я могу получить " +
                    "сердечный приступ. Лучше питаться небольшими порциями, и выбирать продукты, основанные " +
                    "на фруктах и овощах, вместо жирных, жареных и сладких продуктов питания. Мона: Мне это " +
                    "нравится. Что ты ешь на завтрак? Лиза: Я ем 1 ломтик цельнозернового хлеба с 2 кусочками" +
                    " нежирного сыра на завтрак. И, конечно,я наслаждаюсь чашечкой кофе. Потом я могу съесть " +
                    "яблоко или грушу перед обедом. Мона: Итак, что ты собираешься взять на обед? Лиза: Омлет из " +
                    "3 яиц, 1 красный перец, 1 небольшой помидор, и цельнозерновую булочку. Мона: Хорошая " +
                    "идея! Я думаю, что это очень вкусно. Что ты предпочитаешь пить?', 'black');");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

