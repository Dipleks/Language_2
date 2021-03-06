package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyWordsTable implements TableDB
{
    public static void bildMyWordsTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS my_words" +
                    "(id SERIAL PRIMARY KEY, word_en TEXT, word_ru TEXT, category VARCHAR(30), color VARCHAR(30));");
            addMyWords();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void addMyWords(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO my_words (word_en, word_ru, category, color)" +
                    "VALUES ('class','класс','Программирование', 'Знаю на 1')," +
                    "('variable','переменная','Программирование', 'Знаю на 1')," +
                    "('example','пример','Программирование', 'Знаю на 1')," +
                    "('folder','папка','Программирование', 'Знаю на 1')," +
                    "('property','свойство','Программирование', 'Знаю на 1')," +
                    "('versatile','многофункциональный, универсальный','Программирование', 'Знаю на 1')," +
                    "('maintenance','поддержка','Программирование', 'Знаю на 1')," +
                    "('explanation','объяснение','Программирование', 'Знаю на 1')," +
                    "('experience','опыт, случай','Программирование', 'Знаю на 1')," +
                    "('theme','тема','Программирование', 'Знаю на 1')," +
                    "('separate','отдельный, разделять','Программирование', 'Знаю на 1')," +
                    "('bundle','пакет','Программирование', 'Знаю на 1')," +
                    "('feature','характеристика, особенность, функция','Программирование', 'Знаю на 1')," +
                    "('response','ответ, реакция','Программирование', 'Знаю на 1')," +
                    "('in particular','в частности','Программирование', 'Знаю на 1')," +
                    "('chapter','глава','Программирование', 'Знаю на 1')," +
                    "('simple','простой','Программирование', 'Знаю на 1')," +
                    "('precise','точный, четкий','Программирование', 'Знаю на 1')," +
                    "('current','текущий, действующий','Программирование', 'Знаю на 1')," +
                    "('useless','бесполезный','Программирование', 'Знаю на 1')," +
                    "('allow','разрешать, допускать','Программирование', 'Знаю на 1')," +
                    "('fiddle','играть','Программирование', 'Знаю на 1')," +
                    "('perform','выполнять','Программирование', 'Знаю на 1')," +
                    "('explicitly','явно','Программирование', 'Знаю на 1')," +
                    "('especially','особенно, главным образом','Программирование', 'Знаю на 1')," +
                    "('previous','предыдущий','Программирование', 'Знаю на 1')," +
                    "('thoroughly','тщательно, полно','Программирование', 'Знаю на 1')," +
                    "('scheme','схема, план','Программирование', 'Знаю на 1')," +
                    "('field','поле, область','Программирование', 'Знаю на 1')," +
                    "('necessary','необходимый','Программирование', 'Знаю на 1')," +
                    "('therefore','поэтому','Программирование', 'Знаю на 1')," +
                    "('string','строка','Программирование', 'Знаю на 1')," +
                    "('definition','определение','Программирование', 'Знаю на 1')," +
                    "('implement','реализация, внедрение','Программирование', 'Знаю на 1')," +
                    "('for simplicity','для простоты','Программирование', 'Знаю на 1')," +
                    "('thus','следовательно, таким образом','Программирование', 'Знаю на 1')," +
                    "('strictly speaking','строго говоря','Программирование', 'Знаю на 1')," +
                    "('blatant','явный','Программирование', 'Знаю на 1')," +
                    "('assignment','задание, присвоение','Программирование', 'Знаю на 1')," +
                    "('defence','защита','Программирование', 'Знаю на 1')," +
                    "('prohibit','запрещать, препятствовать','Программирование', 'Знаю на 1')," +
                    "('invocation','просьба, вызов','Программирование', 'Знаю на 1')," +
                    "('revert','возвращаться','Программирование', 'Знаю на 1')," +
                    "('credentials','учетные данные','Программирование', 'Знаю на 1')," +
                    "('appropriate','адаптировать, соответствовать','Программирование', 'Знаю на 1')," +
                    "('fortunately','к счастью','Программирование', 'Знаю на 1')," +
                    "('persistent','постоянный, стойкий','Программирование', 'Знаю на 1')," +
                    "('constraint','ограничение','Программирование', 'Знаю на 1')," +
                    "('comprehensive','всесторонний','Программирование', 'Знаю на 1')," +
                    "('stuff','материал, наполнять','Программирование', 'Знаю на 1')," +
                    "('layout','макет, разметка','Программирование', 'Знаю на 1')," +
                    "('guest','гость','Программирование', 'Знаю на 1')," +
                    "('rudimentary','элементарный','Программирование', 'Знаю на 1')," +
                    "('suffice','удовлетворять, быть достаточным','Программирование', 'Знаю на 1')," +
                    "('anyway','в любом случае','Программирование', 'Знаю на 1')," +
                    "('introduce','представлять','Программирование', 'Знаю на 1')," +
                    "('mention','упоминание','Программирование', 'Знаю на 1')," +
                    "('although','хотя, если бы даже','Программирование', 'Знаю на 1')," +
                    "('validation','проверка','Программирование', 'Знаю на 1')," +
                    "('boilerplate','шаблон','Программирование', 'Знаю на 1')," +
                    "('password','пароль','Программирование', 'Знаю на 1')," +
                    "('correspond','переписывать, соответствовать','Программирование', 'Знаю на 1')," +
                    "('conclude','завершать, заканчиваться','Программирование', 'Знаю на 1')," +
                    "('closure','закрытие','Программирование', 'Знаю на 1')," +
                    "('cumbersome','тяжелый, громоздкий','Программирование', 'Знаю на 1')," +
                    "('briefly','в двух словах, кратко','Программирование', 'Знаю на 1')," +
                    "('probably','возможно','Программирование', 'Знаю на 1')," +
                    "('forbid','запрещать','Программирование', 'Знаю на 1')," +
                    "('template','шаблон','Программирование', 'Знаю на 1')," +
                    "('encapsulation','инкапсуляция','Программирование', 'Знаю на 1')," +
                    "('inheritance','наследование','Программирование', 'Знаю на 1')," +
                    "('polymorphism','полиморфизм','Программирование', 'Знаю на 1')," +
                    "('reference','ссылка','Программирование', 'Знаю на 1')," +
                    "('exception','исключение','Программирование', 'Знаю на 1')," +
                    "('namespace','пространство имен','Программирование', 'Знаю на 1')," +
                    "('performance','производительность, выполнение','Программирование', 'Знаю на 1')," +
                    "('predefine','предопределять','Программирование', 'Знаю на 1')," +
                    "('selection','выделение, выбор','Программирование', 'Знаю на 1')," +
                    "('requirement','требование','Программирование', 'Знаю на 1')," +
                    "('request','запрос','Программирование', 'Знаю на 1')," +
                    "('sign up','зарегистрироваться','Программирование', 'Знаю на 1')," +
                    "('overloading','перегрузка','Программирование', 'Знаю на 1')," +
                    "('loop','цикл','Программирование', 'Знаю на 1')," +
                    "('function','функция','Программирование', 'Знаю на 1')," +
                    "('newbie','новичок','Программирование', 'Знаю на 1')," +
                    "('bugbear','проблема','Программирование', 'Знаю на 1')," +
                    "('button','кнопка','Программирование', 'Знаю на 1')," +
                    "('network','сеть','Программирование', 'Знаю на 1')," +
                    "('execute','выполнять, запускать','Программирование', 'Знаю на 1')," +
                    "('benefit','польза, преимущество','Программирование', 'Знаю на 1')," +
                    "('purpose','цель','Программирование', 'Знаю на 1')," +
                    "('descendant','потомок','Программирование', 'Знаю на 1')," +
                    "('denote','обозначать','Программирование', 'Знаю на 1')," +
                    "('deny','отказывать','Программирование', 'Знаю на 1')," +
                    "('permission','разрешение, полномочия','Программирование', 'Знаю на 1')," +
                    "('assumption','предположение','Программирование', 'Знаю на 1')," +
                    "('afterwards','впоследствии, позже','Программирование', 'Знаю на 1')," +
                    "('preliminary','предварительный','Программирование', 'Знаю на 1')," +
                    "('consecutive','подряд, последовательный','Программирование', 'Знаю на 1')," +
                    "('breakdown','анализ, отказ, крах','Программирование', 'Знаю на 1')," +
                    "('excerpt','выборка, извлекать','Программирование', 'Знаю на 1')," +
                    "('elaborate','разрабатывать, конкретизировать','Программирование', 'Знаю на 1')," +
                    "('column','столбец, колонка','Программирование', 'Знаю на 1')," +
                    "('hinder','препятствовать','Программирование', 'Знаю на 1')," +
                    "('concise','лаконичный','Программирование', 'Знаю на 1')," +
                    "('prerequisite','предпосылка','Программирование', 'Знаю на 1')," +
                    "('restriction','ограничение','Программирование', 'Знаю на 1')," +
                    "('relieve','помогать, освобождать','Программирование', 'Знаю на 1')," +
                    "('solution','решение','Программирование', 'Знаю на 1')," +
                    "('embodiment','воплощение','Программирование', 'Знаю на 1')," +
                    "('misleading','вводить в заблуждение','Программирование', 'Знаю на 1')," +
                    "('clunky','неуклюжий','Программирование', 'Знаю на 1')," +
                    "('settings','настройки','Программирование', 'Знаю на 1')," +
                    "('utilize','использовать','Программирование', 'Знаю на 1')," +
                    "('essentially','по сути','Программирование', 'Знаю на 1')," +
                    "('bind','связывать','Программирование', 'Знаю на 1')," +
                    "('reset','сброс','Программирование', 'Знаю на 1')," +
                    "('single quotes','одинарные кавычки','Программирование', 'Знаю на 1')," +
                    "('omit','опускать','Программирование', 'Знаю на 1')," +
                    "('robust','устойчивый','Программирование', 'Знаю на 1')," +
                    "('ensure','гарантировать, убеждаться','Программирование', 'Знаю на 1')," +
                    "('setup','устанавливать','Программирование', 'Знаю на 1')," +
                    "('mandatory','обязательный','Программирование', 'Знаю на 1')," +
                    "('intervene','вмешиваться','Программирование', 'Знаю на 1')," +
                    "('sake','польза','Программирование', 'Знаю на 1')," +
                    "('batch','пакет, комплектовать','Программирование', 'Знаю на 1')," +
                    "('acquire','приобретать','Программирование', 'Знаю на 1')," +
                    "('switch','переключать','Программирование', 'Знаю на 1')," +
                    "('bottleneck','узкое место','Программирование', 'Знаю на 1')," +
                    "('obsolete','устаревший, редко используемый','Программирование', 'Знаю на 1')," +
                    "('amount','количество','Программирование', 'Знаю на 1')," +
                    "('enormous','огромный','Программирование', 'Знаю на 1')," +
                    "('issue','проблема, выпуск','Программирование', 'Знаю на 1')," +
                    "('bootstrap','загружать','Программирование', 'Знаю на 1')," +
                    "('enhancement','улучшение, усиление','Программирование', 'Знаю на 1')," +
                    "('free','свободный, бесплатный','Программирование', 'Знаю на 1')," +
                    "('indispensable','обязательный','Программирование', 'Знаю на 1')," +
                    "('ability','способность, возможность','Программирование', 'Знаю на 1')," +
                    "('attachment','присоединение','Программирование', 'Знаю на 1')," +
                    "('pros and cons','за и против','Программирование', 'Знаю на 1')," +
                    "('vulnerability','уязвимость','Программирование', 'Знаю на 1')," +
                    "('integer','целое число','Программирование', 'Знаю на 1')," +
                    "('in alphabetical order','в алфавитном порядке','Программирование', 'Знаю на 1')," +
                    "('timestamp','метка времени','Программирование', 'Знаю на 1')," +
                    "('viz.','то есть','Программирование', 'Знаю на 1')," +
                    "('assemble','собирать','Программирование', 'Знаю на 1')," +
                    "('truly','истинно','Программирование', 'Знаю на 1')," +
                    "('tweaking','тонкая настройка','Программирование', 'Знаю на 1')," +
                    "('sparingly','экономно','Программирование', 'Знаю на 1')," +
                    "('exhaustive','исчерпывающий','Программирование', 'Знаю на 1')," +
                    "('middleman','посредник','Программирование', 'Знаю на 1')," +
                    "('wrapper','обертка, оболочка','Программирование', 'Знаю на 1')," +
                    "('inclusive','включительно','Программирование', 'Знаю на 1')," +
                    "('malicious','вредоносный','Программирование', 'Знаю на 1')," +
                    "('pertain','принадлежать','Программирование', 'Знаю на 1')," +
                    "('blurring','нечеткость, размытие','Программирование', 'Знаю на 1')," +
                    "('guess','догадаться','Программирование', 'Знаю на 1')," +
                    "('hitch','помеха','Программирование', 'Знаю на 1')," +
                    "('sequentially','последовательно','Программирование', 'Знаю на 1')," +
                    "('retrieving','извлечение, восстановление','Программирование', 'Знаю на 1')," +
                    "('clause','условие','Программирование', 'Знаю на 1')," +
                    "('fetch','выборка, извлекать','Программирование', 'Знаю на 1')," +
                    "('ambiguity','неоднозначность','Программирование', 'Знаю на 1')," +
                    "('from the ground up','c нуля','Программирование', 'Знаю на 1')," +
                    "('comprehend','постигать','Программирование', 'Знаю на 1')," +
                    "('significant','важный','Программирование', 'Знаю на 1')," +
                    "('forgo','воздерживаться','Программирование', 'Знаю на 1')," +
                    "('eradicate','уничтожать','Программирование', 'Знаю на 1')," +
                    "('desirable','желательный','Программирование', 'Знаю на 1')," +
                    "('the crucial part','ключевая роль','Программирование', 'Знаю на 1')," +
                    "('delve into the details','копаться в деталях','Программирование', 'Знаю на 1')," +
                    "('the goal is to create a database schema','цель - создать схему данных','Программирование', 'Знаю на 1')," +
                    "('saving you lots of time and energy','значительная экономия ваших сил и времени','Программирование', 'Знаю на 1')," +
                    "('Accountant ',' бухгалтер','Профессии', 'Знаю на 1')," +
                    "('Actor (actress) ',' актер (актриса)','Профессии', 'Знаю на 1')," +
                    "('Administrator; manager ',' Администратор','Профессии', 'Знаю на 1')," +
                    "('Agronomist ',' агроном','Профессии', 'Знаю на 1')," +
                    "('Air steward ',' стюард на самолете','Профессии', 'Знаю на 1')," +
                    "('Animator ',' Аниматор','Профессии', 'Знаю на 1')," +
                    "('Architect ',' архитектор','Профессии', 'Знаю на 1')," +
                    "('Artist; painter ',' художник','Профессии', 'Знаю на 1')," +
                    "('Assistant ',' помощник','Профессии', 'Знаю на 1')," +
                    "('Astronomer ',' Астроном','Профессии', 'Знаю на 1')," +
                    "('Auditor ',' Аудитор','Профессии', 'Знаю на 1')," +
                    "('Author ',' автор; писатель','Профессии', 'Знаю на 1')," +
                    "('Baker ',' пекарь','Профессии', 'Знаю на 1')," +
                    "('Ballet-master ',' балетмейстер','Профессии', 'Знаю на 1')," +
                    "('Banker ',' Банкир','Профессии', 'Знаю на 1')," +
                    "('Barber ',' парикмахер мужской','Профессии', 'Знаю на 1')," +
                    "('Barman / barmaid ',' бармен / бармен женщина','Профессии', 'Знаю на 1')," +
                    "('Barman, bartender; barkeeper ',' Бармен','Профессии', 'Знаю на 1')," +
                    "('Biologist ',' биолог','Профессии', 'Знаю на 1')," +
                    "('Bricklayer ',' каменщик','Профессии', 'Знаю на 1')," +
                    "('Bricklayer ',' каменьщик','Профессии', 'Знаю на 1')," +
                    "('Broker ',' Брокер','Профессии', 'Знаю на 1')," +
                    "('Builder ',' строитель','Профессии', 'Знаю на 1')," +
                    "('Bus driver ',' водитель автобуса','Профессии', 'Знаю на 1')," +
                    "('Businessman / businesswoman ',' бизнесмен','Профессии', 'Знаю на 1')," +
                    "('Butcher ',' мясник','Профессии', 'Знаю на 1')," +
                    "('Caretaker ',' смотритель, сторож','Профессии', 'Знаю на 1')," +
                    "('Carpenter ',' плотник','Профессии', 'Знаю на 1')," +
                    "('Chef ',' Шеф-повар','Профессии', 'Знаю на 1')," +
                    "('Chemist ',' химик, аптекарь','Профессии', 'Знаю на 1')," +
                    "('Civil servant ',' государственный служащий, чиновник','Профессии', 'Знаю на 1')," +
                    "('Clerk ',' клерк','Профессии', 'Знаю на 1')," +
                    "('Cloakroom attendant ',' Гардеробщик','Профессии', 'Знаю на 1')," +
                    "('Combine-operator',' комбайнер','Профессии', 'Знаю на 1')," +
                    "('Company director ',' директор компании','Профессии', 'Знаю на 1')," +
                    "('Computer operator ',' оператор ПК','Профессии', 'Знаю на 1')," +
                    "('Concrete worker ',' Бетонщик','Профессии', 'Знаю на 1')," +
                    "('Cook ',' повар','Профессии', 'Знаю на 1')," +
                    "('Decorator ',' дизайнер, оформитель','Профессии', 'Знаю на 1')," +
                    "('Dentist ',' дантист (зубной врач)','Профессии', 'Знаю на 1')," +
                    "('Designer ',' дизайнер','Профессии', 'Знаю на 1')," +
                    "('Director ',' директор, член совета директоров','Профессии', 'Знаю на 1')," +
                    "('Docker ',' докер','Профессии', 'Знаю на 1')," +
                    "('Doctor ',' врач','Профессии', 'Знаю на 1')," +
                    "('Driver ',' водитель','Профессии', 'Знаю на 1')," +
                    "('Economist ',' экономист','Профессии', 'Знаю на 1')," +
                    "('Editor ',' редактор','Профессии', 'Знаю на 1')," +
                    "('Electrician ',' электрик','Профессии', 'Знаю на 1')," +
                    "('Employee ',' служащий','Профессии', 'Знаю на 1')," +
                    "('Engineer ',' инженер','Профессии', 'Знаю на 1')," +
                    "('Farmer ',' фермер','Профессии', 'Знаю на 1')," +
                    "('Film director ',' кинорежиссер','Профессии', 'Знаю на 1')," +
                    "('Fireman ',' пожарник','Профессии', 'Знаю на 1')," +
                    "('Fisherman ',' рыбак','Профессии', 'Знаю на 1')," +
                    "('Fishmonger ',' торговец рыбой','Профессии', 'Знаю на 1')," +
                    "('Flight attendant ',' стюардесса / стюард','Профессии', 'Знаю на 1')," +
                    "('Foreman ',' Бригадир','Профессии', 'Знаю на 1')," +
                    "('Garbageman (refuse collector) ',' мусорщик','Профессии', 'Знаю на 1')," +
                    "('Geologist ',' геолог','Профессии', 'Знаю на 1')," +
                    "('Guide ',' Гид','Профессии', 'Знаю на 1')," +
                    "('Hairdresser ',' парикмахер','Профессии', 'Знаю на 1')," +
                    "('Head teacher ',' завуч (преподаватель-методист)','Профессии', 'Знаю на 1')," +
                    "('Historian ',' историк','Профессии', 'Знаю на 1')," +
                    "('Interpreter ',' переводчик','Профессии', 'Знаю на 1')," +
                    "('Jeweler ',' ювелир','Профессии', 'Знаю на 1')," +
                    "('Journalist ',' журналист','Профессии', 'Знаю на 1')," +
                    "('Judge ',' судья','Профессии', 'Знаю на 1')," +
                    "('Lawyer ',' юрист','Профессии', 'Знаю на 1')," +
                    "('Lecturer ',' лектор, докладчик','Профессии', 'Знаю на 1')," +
                    "('Loader; loading workman ',' Грузчик','Профессии', 'Знаю на 1')," +
                    "('Locksmith ',' слесарь','Профессии', 'Знаю на 1')," +
                    "('Locomotive engineer ',' машинист','Профессии', 'Знаю на 1')," +
                    "('Manager ',' директор','Профессии', 'Знаю на 1')," +
                    "('Manufacturer ',' промышленник','Профессии', 'Знаю на 1')," +
                    "('Mathematician ',' математик','Профессии', 'Знаю на 1')," +
                    "('Mechanician ',' механик','Профессии', 'Знаю на 1')," +
                    "('Messenger ',' курьер','Профессии', 'Знаю на 1')," +
                    "('Milling-machine operator',' фрезеровщик','Профессии', 'Знаю на 1')," +
                    "('Miner ',' шахтер','Профессии', 'Знаю на 1')," +
                    "('Musician ',' музыкант','Профессии', 'Знаю на 1')," +
                    "('Nurse ',' медсестра','Профессии', 'Знаю на 1')," +
                    "('Obstetrician ',' Акушер','Профессии', 'Знаю на 1')," +
                    "('Oil worker ',' нефтянщик','Профессии', 'Знаю на 1')," +
                    "('Optician ',' глазной врач','Профессии', 'Знаю на 1')," +
                    "('Painter ',' маляр','Профессии', 'Знаю на 1')," +
                    "('Personal assistant ',' личный секретарь','Профессии', 'Знаю на 1')," +
                    "('Philologist ',' филолог','Профессии', 'Знаю на 1')," +
                    "('Photographer ',' фотограф','Профессии', 'Знаю на 1')," +
                    "('Physicist ',' физик','Профессии', 'Знаю на 1')," +
                    "('Pilot ',' летчик','Профессии', 'Знаю на 1')," +
                    "('Plumber ',' водопроводчик','Профессии', 'Знаю на 1')," +
                    "('Poet ',' поэт','Профессии', 'Знаю на 1')," +
                    "('Politician ',' полицейский','Профессии', 'Знаю на 1')," +
                    "('Politician ',' политик','Профессии', 'Знаю на 1')," +
                    "('Porter ',' швейцар, носильщик','Профессии', 'Знаю на 1')," +
                    "('Priest; clergyman ',' священник','Профессии', 'Знаю на 1')," +
                    "('Printer ',' типографщик','Профессии', 'Знаю на 1')," +
                    "('Professor ',' профессор','Профессии', 'Знаю на 1')," +
                    "('Programmer ',' программист','Профессии', 'Знаю на 1')," +
                    "('Public prosecutor ',' прокурор','Профессии', 'Знаю на 1')," +
                    "('Receptionist ',' служащий в приемной (ресепшионист)','Профессии', 'Знаю на 1')," +
                    "('Sailor ',' моряк','Профессии', 'Знаю на 1')," +
                    "('Salesman / saleswoman ',' продавец / продавщица','Профессии', 'Знаю на 1')," +
                    "('School headmaster ',' школьный директор','Профессии', 'Знаю на 1')," +
                    "('Scientist ',' ученый','Профессии', 'Знаю на 1')," +
                    "('Sculptor ',' скульптор','Профессии', 'Знаю на 1')," +
                    "('Secretary ',' секретарь','Профессии', 'Знаю на 1')," +
                    "('Serviceman ',' Военнослужащий','Профессии', 'Знаю на 1')," +
                    "('Shoemaker ',' сапожник','Профессии', 'Знаю на 1')," +
                    "('Shop assistant ',' продавец, продавщица','Профессии', 'Знаю на 1')," +
                    "('Soldier ',' военнослужащий, солдат','Профессии', 'Знаю на 1')," +
                    "('Solicitor ',' адвокат','Профессии', 'Знаю на 1')," +
                    "('Surgeon ',' хирург','Профессии', 'Знаю на 1')," +
                    "('Tailor ',' портной','Профессии', 'Знаю на 1')," +
                    "('Teacher ',' преподаватель','Профессии', 'Знаю на 1')," +
                    "('Teacher; educator ',' Воспитатель','Профессии', 'Знаю на 1')," +
                    "('Telephonist ',' телефонист(ка)','Профессии', 'Знаю на 1')," +
                    "('Tractor driver ',' тракторист','Профессии', 'Знаю на 1')," +
                    "('Train driver ',' машинист поезда','Профессии', 'Знаю на 1')," +
                    "('Translator ',' переводчик','Профессии', 'Знаю на 1')," +
                    "('Travel agent ',' агент бюро путешествий','Профессии', 'Знаю на 1')," +
                    "('Turner ',' токарь','Профессии', 'Знаю на 1')," +
                    "('Vet (сокр. от veterinary surgeon) ',' ветеринар','Профессии', 'Знаю на 1')," +
                    "('Waiter ',' официант','Профессии', 'Знаю на 1')," +
                    "('Warder ',' сторож, тюремщик','Профессии', 'Знаю на 1')," +
                    "('Weaver ',' ткач','Профессии', 'Знаю на 1')," +
                    "('Welder ',' сварщик','Профессии', 'Знаю на 1')," +
                    "('Worker ',' рабочий','Профессии', 'Знаю на 1')," +
                    "('Writer ',' писатель','Профессии', 'Знаю на 1')," +
                    "('Yardman, street cleaner ',' Дворник','Профессии', 'Знаю на 1')," +
                    "('all the same ',' без разницы / все равно','Для общения', 'Знаю на 1')," +
                    "('all the way ',' от начала до конца','Для общения', 'Знаю на 1')," +
                    "('as a rule ',' как правило','Для общения', 'Знаю на 1')," +
                    "('as if / as though ',' как будто','Для общения', 'Знаю на 1')," +
                    "('as much ',' тоже, всё равно','Для общения', 'Знаю на 1')," +
                    "('as usual ',' как обычно','Для общения', 'Знаю на 1')," +
                    "('as well as ',' также, как и','Для общения', 'Знаю на 1')," +
                    "('at every step ',' на каждом шагу','Для общения', 'Знаю на 1')," +
                    "('at that rate ',' такими темпами','Для общения', 'Знаю на 1')," +
                    "('by all means / by any means ',' любым способом , во что бы то ни стало','Для общения', 'Знаю на 1')," +
                    "('by no means ',' никаким образом','Для общения', 'Знаю на 1')," +
                    "('either way ',' так или иначе','Для общения', 'Знаю на 1')," +
                    "('for a change ',' для разнообразия','Для общения', 'Знаю на 1')," +
                    "('for all the world ',' во всех отношениях','Для общения', 'Знаю на 1')," +
                    "('for real ',' всерьёз, на самом деле','Для общения', 'Знаю на 1')," +
                    "('from scratch ',' на пустом месте, с нуля','Для общения', 'Знаю на 1')," +
                    "('hardest part about ',' самое сложное в чём-либо','Для общения', 'Знаю на 1')," +
                    "('however much ',' сколько бы ни.','Для общения', 'Знаю на 1')," +
                    "('in every sense of the word ',' в полном смысле слова','Для общения', 'Знаю на 1')," +
                    "('in spite of ',' несмотря на','Для общения', 'Знаю на 1')," +
                    "('just in case ',' на всякий случай','Для общения', 'Знаю на 1')," +
                    "('just the same ',' всё равно','Для общения', 'Знаю на 1')," +
                    "('now that ',' так как, пока, раз уж','Для общения', 'Знаю на 1')," +
                    "('or else ',' иначе','Для общения', 'Знаю на 1')," +
                    "('so that ',' так, чтобы','Для общения', 'Знаю на 1')," +
                    "('so... as to ',' настолько..чтобы','Для общения', 'Знаю на 1')," +
                    "('such and such ',' такой-то такой-то','Для общения', 'Знаю на 1')," +
                    "('such as ',' такие как','Для общения', 'Знаю на 1')," +
                    "('that is why ',' поэтому','Для общения', 'Знаю на 1')," +
                    "('then again ',' с другой стороны','Для общения', 'Знаю на 1')," +
                    "('what about ',' как насчёт','Для общения', 'Знаю на 1')," +
                    "('what it takes to ',' то, что нужно чтобы','Для общения', 'Знаю на 1');");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
