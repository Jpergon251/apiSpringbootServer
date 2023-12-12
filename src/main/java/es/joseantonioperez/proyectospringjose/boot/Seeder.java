package es.joseantonioperez.proyectospringjose.boot;

import es.joseantonioperez.proyectospringjose.factories.PartidaFactory;
import es.joseantonioperez.proyectospringjose.models.Equipo;
import es.joseantonioperez.proyectospringjose.models.Jugador;
import es.joseantonioperez.proyectospringjose.models.Partida;
import es.joseantonioperez.proyectospringjose.models.User;
import es.joseantonioperez.proyectospringjose.repositories.EquipoRepository;
import es.joseantonioperez.proyectospringjose.repositories.JugadorRepository;
import es.joseantonioperez.proyectospringjose.repositories.PartidaRepository;
import es.joseantonioperez.proyectospringjose.repositories.UserRepository;
import es.joseantonioperez.proyectospringjose.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static es.joseantonioperez.proyectospringjose.models.User.UserRole.ADMIN;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    PartidaRepository partidaRepository;


    @Autowired
    PartidaFactory partidaFactory;

    @Autowired
    private EquipoService equipoService;

    @Override
    public void run(String... args) {

        // Usuario para testear
        User testUser = new User("Jose","jpergon251@g.educaand.es", "pestillo", ADMIN);
        userRepository.save(testUser);


        //Creamos las listas vacias
        List<Jugador> jugadores = new ArrayList<>();

        List<Equipo> equipos = new ArrayList<>();

        // Aqui creamos los equipos
        Equipo movistarRiders = new Equipo(
                "Movistar Riders",
                "Movistar Riders es uno de los principales clubes de eSports en España compitiendo en los juegos más populares como League of Legends o CSGO. Sus jugadores representan la marca Movistar Riders en múltiples torneos a nivel nacional e internacional. El Club tiene su sede en el Movistar eSports Center, en Matadero Madrid, un centro de alto rendimiento donde los jugadores y cuerpo técnico cuentan con los medios más avanzados para desarrollar su actividad al máximo nivel.",
                "Tomás Campelos",
                "Melzhet",
                "https://i.ibb.co/QMxV3yt/coach-Movistar-Riders.png",
                "https://i.ibb.co/D7Fb3Ds/643feec0905f4284372742-x2.png"
        );
        equipos.add(movistarRiders);

        Equipo bisons = new Equipo(
                "Bisons Eclub",
                "BISONS ECLUB nace en 2021 para competir en la Superliga como el único club del eje atlántico en el ecosistema profesional de los esports. El objetivo de desarrollo de BISONS ECLUB gira en torno a cuatro pilares: Esports, Entretenimiento, Eventos y Educación, generando así una alternativa de ocio de calidad. Con sede en Bilbao, el club aspira a convertirse en una entidad referente en el territorio nacional.",
                "Victor Machuca Segura",
                "Machuki",
                "https://i.ibb.co/vhhybnY/coach-Bisons.png",
                "https://i.ibb.co/2ZKz2GT/618bec7d0f880127657830-x2.png"
        );
        equipos.add(bisons);

        Equipo losHeretics = new Equipo(
                "Los Heretics",
                "Team Heretics fue creado en 2016, tiene sede en Madrid y es el club de deportes electrónicos hispano más seguido a nivel mundial. Campeones del mundo en FIFA, campeones de Europa en Valorant, 2 asistencias al Mundial de Call of Duty y más de 15 títulos nacionales en Valorant, Call of Duty, Rainbow 6 y Counter Strike están entre sus principales hitos deportivos.",
                "Fayan Pertijs",
                "Gevous",
                "https://i.ibb.co/0chg04n/coach-Heretics.png",
                "https://i.ibb.co/G9cwyb1/62e389382e842553067462-x2.png"
        );
        equipos.add(losHeretics);

        Equipo barcaEsports = new Equipo(
                "Barça eSports",
                "Barça eSports se une a la Superliga de League of Legends 2022. El club de esports recién llegado a la liga oficial de LoL, busca construir una sección líder que contribuya a conectar el club y su filosofía con nuevas audiencias.",
                "Alejandro Parejo",
                "Mapache",
                "https://i.ibb.co/x223NJr/coach-Bar-a.png",
                "https://i.ibb.co/B4P0j0s/61b77824711cb276474054-x2.png"
        );
        equipos.add(barcaEsports);


        Equipo giants = new Equipo(
                "Giants",
                "Giants es el club más laureado del panorama español. También es uno de los más veteranos, y ha formado parte de las competiciones de Liga de Videojuegos Profesional desde prácticamente sus inicios. Cinco Final Cups en Call of Duty y siete títulos de League of Legends son, entre muchos otros, los éxitos que ha cosechado el club malagueño a lo largo de su historia.",
                "André Guilhoto",
                "Guilhoto",
                "https://i.ibb.co/mR2Bjqc/coach-Giants.png",
                "https://i.ibb.co/NLFK8BH/61d856234f902476229236-x2.png"

        );
        equipos.add(giants);

        Equipo finetworkKOI = new Equipo(
                "Finetwork KOI",
                "Finetwork KOI es el equipo de esports lanzado por Gerard Piqué e Ibai Llanos para luchar por el título de campeón de la Superliga de League of Legends. La escuadra de KOI tiene como objetivo conseguir el título de la máxima competición de LoL en España y crear un club referente en esports a nivel de competición y de contenidos.",
                "Gonçalo Brandão",
                "Crusher",
                "https://i.ibb.co/VDXFTp9/coachKOI.png",
                "https://i.ibb.co/X8khQYP/61b740d6c6264734104767-x2.png"
        );
        equipos.add(finetworkKOI);

        Equipo ucamTokiers = new Equipo(
                "UCAM Tokiers",
                "UCAM nace de la incorporación del histórico Penguins dentro de la estructura deportiva de la institución universitaria. En una constante apuesta por la formación y la creación de nuevos talentos, se ha desarrollado un proyecto que aspira a todo en la escena competitiva de los esports en España.",
                "Nuno Moutinho",
                "Slayer",
                "no foto",
                "https://i.ibb.co/NWmhM9m/60a3ae14518b7754845438-x2.png"
        );
        equipos.add(ucamTokiers);

        Equipo rebelsGaming = new Equipo(
                "Rebels Gaming",
                "Rebels Gaming desarrolla el talento y la creatividad tanto dentro como fuera del server. Tras un gran split de primavera en el que el equipo de David de Gea se proclamó campeón de la fase regular, el club busca aspirar a lo más alto. #BeRebels",
                "Iván Villanueva",
                "Prod1",
                "https://i.ibb.co/4VkLJF9/coach-Rebels.png",
                "https://i.ibb.co/j41ZnpR/61b86da49e060502768260-x2.png"
        );
        equipos.add(rebelsGaming);

        Equipo fnaticTQ = new Equipo(
                "Fnatic TQ",
                "Fnatic TQ nace de la unión de Fnatic y Team Queso. Juntos, crean esta nueva marca con el objetivo de pelear por la Superliga y establecerse como uno de los equipos más importantes del panorama nacional. Fnatic TQ se consolida así como la principal cantera de Fnatic, que ha encontrado en Team Queso el mejor socio para ofrecer el ambiente perfecto a cualquier jugador que aspire a llegar a la LEC.",
                "Pablo Vegas",
                "Gaax",
                "https://i.ibb.co/pJjCsjZ/coach-Fnatic.png",
                "https://i.ibb.co/p4rtXSN/61ccb9d0a8dcc859042358-x2.png"
        );
        equipos.add(fnaticTQ);

        Equipo guasones = new Equipo(
                "Guasones",
                "Guasones nace con el objetivo de crear un ambiente seguro para que los jóvenes navarros y navarras aficionados a los esports disfruten, aprendan y se desarrollen. El espíritu competitivo, las ganas de diversión y unas fuertes raíces en su tierra son los tres pilares sobre los que se erige Guasones, un club que aspira a situarse entre los más grandes.",
                "Mario Martínez",
                "Motroco",
                "https://i.ibb.co/QFVkXyj/coach-Guasones.png",
                "https://i.ibb.co/hL3PFvT/63c1392f7d9d9030610782-x2.png"
        );
        equipos.add(guasones);

        Equipo caseEsports = new Equipo(
                "Case Esports",
                "",
                "Alvaro Hernández",
                "Xaio",
                "no foto",
                "https://i.ibb.co/9rYDRCH/618bece467a49315670494-x2.png"
        );
        equipos.add(caseEsports);

        Equipo wizards = new Equipo(
                "Wizards",
                "Fundado en 2002, Wizards es el club de esports en activo más antiguo de España, laureado tanto nacional como internacionalmente, destaca por ser un gran descubridor y formador de talento. A lo largo de su historia, ha competido en más de 30 juegos diferentes, logrando más de 70 títulos y siendo la casa de más de 300 jugadores del máximo nivel.",
                "Ioannis Kounelis",
                "Anonpsycko",
                "no foto",
                "https://i.ibb.co/KDj77Sr/6475def837b3f288265495-x2.png"
        );
        equipos.add(wizards);


        //Creamos los jugadores


        /*
        Jugadores MOVISTAR RIDERS
         */


        Jugador marky = new Jugador(
                "Marky",
                "Pedro Serrano",
                "TOP",
                21,
                "ES",
                "Kennen",
                74,
                76,
                180,
                "https://i.ibb.co/RDgYB6Z/marky.png", // Asumiendo que es la URL de la imagen
                movistarRiders // Equipo de Marky
        );
        jugadores.add(marky);

        Jugador isma = new Jugador(
                "Isma",
                "Ismaïl Boualem",
                "JUNGLER",
                22,
                "FR",
                "Poppy",
                79,
                81,
                250,
                "https://i.ibb.co/W0p79pV/isma.png", // Asumiendo que es la URL de la imagen
                movistarRiders // Equipo de Isma
        );
        jugadores.add(isma);

        Jugador fresskowy = new Jugador(
                "Fresskowy",
                "Bartłomiej Przewoźnik",
                "MID",
                23,
                "PL",
                "Azir",
                115,
                82,
                156,
                "https://i.ibb.co/Z6M67r8/fresskowy.png", // Asumiendo que es la URL de la imagen
                movistarRiders // Equipo de FRESSKOWY
        );
        jugadores.add(fresskowy);

        Jugador supa = new Jugador(
                "Supa",
                "David Martínez",
                "ADC",
                23,
                "ES",
                "Kai'sa",
                166,
                87,
                168,
                "https://i.ibb.co/kHGG3mK/supa.png",
                movistarRiders
        );
        jugadores.add(supa);

        Jugador alvaro = new Jugador(
                "Alvaro",
                "Alvaro Fernández del Amo",
                "SUPPORT",
                20,
                "ES",
                "Nautilus",
                32,
                114,
                342,
                "https://i.ibb.co/5KyyGxD/alvaro.png",
                movistarRiders

        );
        jugadores.add(alvaro);

        Jugador hydra = new Jugador(
                "Hydra",
                "Raúl Moreno Valero",
                "MID",
                20,
                "ES",
                null,
                0,
                0,
                0,
                "https://i.ibb.co/3pkG1qT/hydra.png",
                movistarRiders

        );
        jugadores.add(hydra);


        /*
        Jugadores de BISONS
        * */


        Jugador myrwn = new Jugador(
                "Myrwn",
                "Alex Villarejo Pastor",
                "TOP",
                20,
                "ES",
                "Gwen", // Campeón favorito desconocido
                95, // Bajas
                79, // Muertes
                160, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                bisons // Equipo: Bisons
        );

        jugadores.add(myrwn);

        Jugador noname = new Jugador(
                "Noname",
                "William Antony Jones",
                "JUNGLER",
                20, // Edad desconocida
                "GB",
                "Wukong", // Campeón favorito desconocido
                57, // Bajas
                63, // Muertes
                240, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                bisons // Equipo: Bisons
        );
        jugadores.add(noname);

        Jugador random = new Jugador(
                "Random",
                "Adam Grepl",
                "MID",
                21, // Edad desconocida
                "CZ",
                "Leeblanc", // Campeón favorito desconocido
                112, // Bajas
                80, // Muertes
                158, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                bisons // Equipo: Bisons
        );
        jugadores.add(random);

        Jugador legolas = new Jugador(
                "Legolas",
                "Sergio Vicente",
                "ADC",
                22, // Edad desconocida
                "ES",
                "Xayah", // Campeón favorito desconocido
                151, // Bajas
                75, // Muertes
                147, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                bisons // Equipo: Bisons
        );
        jugadores.add(legolas);

        Jugador oscure = new Jugador(
                "Oscure",
                "Víctor Guzmán",
                "SUPPORT",
                23, // Edad desconocida
                "ES",
                "Nautilus", // Campeón favorito desconocido
                15, // Bajas
                100, // Muertes
                322, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                bisons // Equipo: Bisons
        );
        jugadores.add(oscure);

        Jugador rubenxico = new Jugador(
                "Rubenxico",
                "Rubén Sánchez",
                "TOP",
                24, // Edad desconocida
                "ES",
                "Sion", // Campeón favorito desconocido
                10, // Bajas
                11, // Muertes
                9, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                bisons // Equipo: Bisons
        );
        jugadores.add(rubenxico);


        /*
        Jugadores de HERETICS
        */


        Jugador ibo = new Jugador(
                "Ibo",
                "Marcin Lebuda",
                "TOP",
                26, // Edad desconocida
                "PL",
                "K'sante", // Campeón favorito desconocido
                46, // Bajas
                66, // Muertes
                130, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                losHeretics // Equipo: Los Heretics
        );
        jugadores.add(ibo);

        Jugador bluerzor = new Jugador(
                "Bluerzor",
                "Daniel Subicz",
                "JUNGLER",
                24, // Edad desconocida
                "HU",
                "Wukong", // Campeón favorito desconocido
                44, // Bajas
                65, // Muertes
                170, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                losHeretics // Equipo: Los Heretics
        );
        jugadores.add(bluerzor);

        Jugador zwyroo = new Jugador(
                "Zwyroo",
                "Artur Szymon Trojan",
                "MID",
                24, // Edad desconocida
                "PL",
                "Jayce", // Campeón favorito desconocido
                79, // Bajas
                71, // Muertes
                116, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                losHeretics // Equipo: Los Heretics
        );
        jugadores.add(zwyroo);

        Jugador jackspektra = new Jugador(
                "Jackspektra",
                "Jakob Kepple",
                "ADC",
                22, // Edad desconocida
                "NO",
                "Aphelios", // Campeón favorito desconocido
                130, // Bajas
                55, // Muertes
                112, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                losHeretics // Equipo: Los Heretics
        );
        jugadores.add(jackspektra);

        Jugador marlon = new Jugador(
                "Marlon",
                "Igor Arkadiusz Tomczyk",
                "SUPPORT",
                19, // Edad desconocida
                "PL",
                "Milio", // Campeón favorito desconocido
                10, // Bajas
                76, // Muertes
                220, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                losHeretics // Equipo: Los Heretics
        );
        jugadores.add(marlon);

        Jugador naruterador = new Jugador(
                "Naruterador",
                "Ramón Meseguer",
                "JUNGLER",
                30, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                losHeretics // Equipo: Los Heretics
        );
        jugadores.add(naruterador);


        /*
         *
         Jugadores de Barça eSports
        *
        * */


        Jugador whiteknight = new Jugador(
                "Whiteknight",
                "Matti Sormunen",
                "TOP",
                27, // Edad desconocida
                "FI",
                "Renekton", // Campeón favorito desconocido
                50, // Bajas
                41, // Muertes
                124, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(whiteknight);

        Jugador maxlore = new Jugador(
                "Maxlore",
                "Nubar Sarafian",
                "JUNGLER",
                27, // Edad desconocida
                "GB",
                "VI", // Campeón favorito desconocido
                42, // Bajas
                58, // Muertes
                134, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(maxlore);

        Jugador sajator = new Jugador(
                "Sajator",
                "Jan Zítek",
                "MID",
                0, // Edad desconocida
                "CZ",
                "Ahri", // Campeón favorito desconocido
                88, // Bajas
                54, // Muertes
                111, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(sajator);

        Jugador deadly = new Jugador(
                "Deadly",
                "Matthew Smith",
                "ADC",
                24, // Edad desconocida
                "GB",
                "Xayah", // Campeón favorito desconocido
                81, // Bajas
                46, // Muertes
                116, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(deadly);

        Jugador efias = new Jugador(
                "Efias",
                "Oleksandr Yankovich",
                "SUPPORT",
                25, // Edad desconocida
                "UA",
                "Rakan", // Campeón favorito desconocido
                15, // Bajas
                53, // Muertes
                198, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(efias);

        Jugador naau = new Jugador(
                "Naau",
                "Arnau Fores Garcia",
                "JUNGLER",
                20, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(naau);

        Jugador xixauxas = new Jugador(
                "Xizauxas",
                "Xavier Fluxà",
                "SUPPORT",
                30, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                barcaEsports // Equipo: Barca Esports
        );
        jugadores.add(xixauxas);

        /*
        * Jugadores de GIANTS
        * */

        Jugador th3antonio = new Jugador(
                "Th3antonio",
                "Antonio Espinosa",
                "TOP",
                24, // Edad desconocida
                "ES",
                "Renekton", // Campeón favorito desconocido
                48, // Bajas
                58, // Muertes
                167, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                giants // Equipo: Giants
        );
        jugadores.add(th3antonio);

        Jugador xerxe = new Jugador(
                "Xerxe",
                "Andrei Dragomir",
                "JUNGLER",
                23, // Edad desconocida
                "ROgit",
                "Maokai", // Campeón favorito desconocido
                69, // Bajas
                46, // Muertes
                215, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                giants // Equipo: Giants
        );
        jugadores.add(xerxe);

        Jugador decay = new Jugador(
                "Decay",
                "Nicolas Gawron",
                "MID",
                23, // Edad desconocida
                "FR",
                "Azir", // Campeón favorito desconocido
                107, // Bajas
                46, // Muertes
                146, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                giants // Equipo: Giants
        );
        jugadores.add(decay);

        Jugador attila = new Jugador(
                "Attila",
                "Amadeu Carvalho",
                "ADC",
                27, // Edad desconocida
                "PT",
                "Aphelios", // Campeón favorito desconocido
                116, // Bajas
                52, // Muertes
                138, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                giants // Equipo: Giants
        );
        jugadores.add(attila);

        Jugador whiteinn = new Jugador(
                "Whiteinn",
                "Alexandru Kolozsvari",
                "SUPPORT",
                23, // Edad desconocida
                "RO",
                "Rakan", // Campeón favorito desconocido
                17, // Bajas
                65, // Muertes
                258, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                giants // Equipo: Giants
        );
        jugadores.add(whiteinn);

        Jugador vander = new Jugador(
                "Vander",
                "Oskar Bogdan",
                "SUPPORT",
                29, // Edad desconocida
                "PL",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                giants // Equipo: Giants
        );
        jugadores.add(vander);

        /*
        * Jugadores de Finetwork KOI
        * */

        Jugador sinmivak = new Jugador(
                "Sinmivak",
                "Jakub Rucki",
                "TOP",
                23, // Edad desconocida
                "PL",
                "Sion", // Campeón favorito desconocido
                63, // Bajas
                59, // Muertes
                156, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(sinmivak);

        Jugador koldo = new Jugador(
                "Koldo",
                "Luis Pérez",
                "JUNGLER",
                22, // Edad desconocida
                "ES",
                "Maokai", // Campeón favorito desconocido
                51, // Bajas
                70, // Muertes
                259, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(koldo);

        Jugador baca = new Jugador(
                "Baca",
                "João Novais",
                "MID",
                23, // Edad desconocida
                "PT",
                "Ahri", // Campeón favorito desconocido
                126, // Bajas
                69, // Muertes
                178, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(baca);

        Jugador jopa = new Jugador(
                "Jopa",
                "Josip Cancar",
                "ADC",
                19, // Edad desconocida
                "HR",
                "Xayah", // Campeón favorito desconocido
                156, // Bajas
                85, // Muertes
                169, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(jopa);

        Jugador stend = new Jugador(
                "Stend",
                "Paul Lardin",
                "SUPPORT",
                21, // Edad desconocida
                "FR",
                "Yuumi", // Campeón favorito desconocido
                28, // Bajas
                82, // Muertes
                306, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(stend);

        Jugador aziado = new Jugador(
                "Aziado",
                "Tiago Correia",
                "TOP",
                25, // Edad desconocida
                "PT",
                null, // No se especifica el campeón favorito
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(aziado);

        Jugador lucker = new Jugador(
                "Lucker",
                "Damian Konefał",
                "ADC",
                24, // Edad desconocida
                "PL",
                null, // No se especifica el campeón favorito
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(lucker);

        Jugador seaz = new Jugador(
                "Seaz",
                "Daniel Binderhofer",
                "SUPPORT",
                22, // Edad desconocida
                "AT",
                null, // No se especifica el campeón favorito
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(seaz);

        Jugador blueknight = new Jugador(
                "Blueknight",
                "Nico Jannet",
                "SUPPORT",
                24, // Edad desconocida
                "DE",
                null, // No se especifica el campeón favorito
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                finetworkKOI // Equipo: FinetworkKOI
        );
        jugadores.add(blueknight);


        /*
        * Jugadores de UCAM TOKIERS
        * */

        Jugador papiteero = new Jugador(
                "Papiteero",
                "Antero Baldaia",
                "TOP",
                22, // Edad desconocida
                "PT",
                "Renekton", // Campeón favorito desconocido
                59, // Bajas
                97, // Muertes
                175, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(papiteero);

        Jugador xeonerr = new Jugador(
                "Xeonerr",
                "Karol Kowalski",
                "JUNGLER",
                21, // Edad desconocida
                "PL",
                "Sejuani", // Campeón favorito desconocido
                39, // Bajas
                69, // Muertes
                208, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(xeonerr);

        Jugador hatrixx = new Jugador(
                "Hatrixx",
                "Jørgen Elgåen",
                "MID",
                25, // Edad desconocida
                "NO",
                "Azir", // Campeón favorito desconocido
                139, // Bajas
                92, // Muertes
                201, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(hatrixx);

        Jugador rafitta = new Jugador(
                "Rafitta",
                "Rafa Ayllón",
                "ADC",
                23, // Edad desconocida
                "ES",
                "Sivir", // Campeón favorito desconocido
                150, // Bajas
                71, // Muertes
                168, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(rafitta);

        Jugador infoneral = new Jugador(
                "Infoneral",
                "Radoslav Pavlinov Georgiev",
                "SUPPORT",
                24, // Edad desconocida
                "BG",
                "Alistar", // Campeón favorito desconocido
                17, // Bajas
                104, // Muertes
                322, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(infoneral);

        Jugador fintinhas = new Jugador(
                "Fintinhas",
                "António Pedro Lisboa",
                "SUPPORT",
                31, // Edad desconocida
                "PT",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(fintinhas);

        Jugador mart = new Jugador(
                "Mart",
                "Martim Santos",
                "JUNGLER",
                23, // Edad desconocida
                "PT",
                "Nocturne", // Campeón favorito desconocido
                34, // Bajas
                27, // Muertes
                60, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(mart);

        Jugador gromix = new Jugador(
                "Gromix",
                "Gonzalo Bernal López",
                "JUNGLER",
                22, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(gromix);

        Jugador aiden = new Jugador(
                "Aiden",
                "Max Pujol Sellerés",
                "SUPPORT",
                21, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                ucamTokiers // Equipo: Ucam Tokiers
        );
        jugadores.add(aiden);

        /*
        * Jugadores de Rebels Gameing
        * */


        Jugador r4ven = new Jugador(
                "R4ven",
                "Miłosz Domagalski",
                "TOP",
                23, // Edad desconocida
                "PL",
                "K'sante", // Campeón favorito desconocido
                37, // Bajas
                38, // Muertes
                88, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                rebelsGaming // Equipo: Rebels Gaming
        );
        jugadores.add(r4ven);

        Jugador ahahacik = new Jugador(
                "Ahahacik",
                "Kirill Skvortsov",
                "JUNGLER",
                24, // Edad desconocida
                "RU",
                "Sejuani", // Campeón favorito desconocido
                38, // Bajas
                62, // Muertes
                159, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                rebelsGaming // Equipo: Rebels Gaming
        );
        jugadores.add(ahahacik);

        Jugador dajor = new Jugador(
                "Dajor",
                "Oliver Ryppa",
                "MID",
                21, // Edad desconocida
                "DE",
                "Viktor", // Campeón favorito desconocido
                38, // Bajas
                29, // Muertes
                46, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                rebelsGaming // Equipo: Rebels Gaming
        );
        jugadores.add(dajor);

        Jugador bean = new Jugador(
                "Bean",
                "Louis Joscha Schmitz",
                "ADC",
                23, // Edad desconocida
                "DE",
                "Xayah", // Campeón favorito desconocido
                84, // Bajas
                43, // Muertes
                87, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                rebelsGaming // Equipo: Rebels Gaming
        );
        jugadores.add(bean);

        Jugador obstinatus = new Jugador(
                "Obstinatus",
                "Guilherme Cruz",
                "SUPPORT",
                23, // Edad desconocida
                "PT",
                "Milio", // Campeón favorito desconocido
                8, // Bajas
                46, // Muertes
                186, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                rebelsGaming // Equipo: Rebels Gaming
        );
        jugadores.add(obstinatus);

        Jugador whyx = new Jugador(
                "Whyx",
                "Vidal Salvador Torres",
                "SUPPORT",
                19, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                rebelsGaming // Equipo: Rebels Gaming
        );
        jugadores.add(whyx);


        /*
        * Jugadores de FNATIC TQ
        * */


        Jugador doxy = new Jugador(
                "Doxy",
                "Rafael Adl Zarabi",
                "TOP",
                25, // Edad desconocida
                "DK",
                "Poppy", // Campeón favorito desconocido
                28, // Bajas
                47, // Muertes
                85, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                fnaticTQ // Equipo: FnaticTQ
        );
        jugadores.add(doxy);

        Jugador rabble = new Jugador(
                "Rabble",
                "Jochem Van Graafeiland",
                "JUNGLER",
                21, // Edad desconocida
                "NL",
                "Wukong", // Campeón favorito desconocido
                56, // Bajas
                78, // Muertes
                126, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                fnaticTQ // Equipo: FnaticTQ
        );
        jugadores.add(rabble);

        Jugador nafkelah = new Jugador(
                "Nafkelah",
                "Andrija Kovačević",
                "MID",
                20, // Edad desconocida
                "ME",
                "Azir", // Campeón favorito desconocido
                56, // Bajas
                47, // Muertes
                84, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                fnaticTQ // Equipo: FnaticTQ
        );
        jugadores.add(nafkelah);

        Jugador valans = new Jugador(
                "Valans",
                "Miguel Eduardo Cortina Anta",
                "ADC",
                22, // Edad desconocida
                "ES",
                "Syndra", // Campeón favorito desconocido
                16, // Bajas
                20, // Muertes
                25, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                fnaticTQ // Equipo: FnaticTQ
        );
        jugadores.add(valans);

        Jugador kadir = new Jugador(
                "Kadir",
                "Kadircan Mumcuoglu",
                "SUPPORT",
                24, // Edad desconocida
                "NL",
                "Rakan", // Campeón favorito desconocido
                22, // Bajas
                71, // Muertes
                165, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                fnaticTQ // Equipo: FnaticTQ
        );
        jugadores.add(kadir);

        Jugador viketox = new Jugador(
                "Viketox",
                "Víctor Navarro",
                "SUPPORT",
                24, // Edad desconocida
                "ES",
                "Karma", // Campeón favorito desconocido
                2, // Bajas
                2, // Muertes
                10, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                fnaticTQ // Equipo: FnaticTQ
        );
        jugadores.add(viketox);


        /*
        * Jugadores de GUASONES
        * */

        Jugador dreedy = new Jugador(
                "Dreedy",
                "Jakub Vicenik",
                "TOP",
                22, // Edad desconocida
                "CZ",
                "Gnar", // Campeón favorito desconocido
                63, // Bajas
                89, // Muertes
                110, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                guasones // Equipo: Guasones
        );
        jugadores.add(dreedy);

        Jugador memento = new Jugador(
                "Memento",
                "Jonas Elmarghichi",
                "JUNGLER",
                27, // Edad desconocida
                "SE",
                "Maokai", // Campeón favorito desconocido
                43, // Bajas
                108, // Muertes
                181, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                guasones // Equipo: Guasones
        );
        jugadores.add(memento);

        Jugador ronaldo = new Jugador(
                "Ronaldo",
                "Paul Betéa",
                "MID",
                24, // Edad desconocida
                "RO",
                "Sylas", // Campeón favorito desconocido
                83, // Bajas
                86, // Muertes
                118, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                guasones // Equipo: Guasones
        );
        jugadores.add(ronaldo);

        Jugador zamulek = new Jugador(
                "Zamulek",
                "Dominik Biela",
                "ADC",
                19, // Edad desconocida
                "PL",
                "Xayah", // Campeón favorito desconocido
                114, // Bajas
                75, // Muertes
                95, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                guasones // Equipo: Guasones
        );
        jugadores.add(zamulek);

        Jugador duall = new Jugador(
                "Duall",
                "Ángel Fernández",
                "SUPPORT",
                26, // Edad desconocida
                "ES",
                "Rell", // Campeón favorito desconocido
                17, // Bajas
                104, // Muertes
                223, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                guasones // Equipo: Guasones
        );
        jugadores.add(duall);

        Jugador adryh = new Jugador(
                "Adryh",
                "Adrián Pérez",
                "ADC",
                27, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                guasones // Equipo: Guasones
        );
        jugadores.add(adryh);


        /*
        * Jugadores de CASE ESPORTS
        * */

        Jugador ray = new Jugador(
                "Ray",
                "Jiwon Jeon",
                "TOP",
                25, // Edad desconocida
                "KR",
                "Gnar", // Campeón favorito desconocido
                23, // Bajas
                19, // Muertes
                50, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                caseEsports // Equipo: Case Esports
        );
        jugadores.add(ray);

        Jugador lebron = new Jugador(
                "LeBron",
                "Dimitar Kostadinov",
                "JUNGLER",
                23, // Edad desconocida
                "BG",
                "VI", // Campeón favorito desconocido
                27, // Bajas
                12, // Muertes
                61, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                caseEsports // Equipo: Case Esports
        );
        jugadores.add(lebron);

        Jugador javier = new Jugador(
                "Javier",
                "Javier Carmona",
                "MID",
                23, // Edad desconocida
                "ES",
                "Ahri", // Campeón favorito desconocido
                22, // Bajas
                15, // Muertes
                66, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                caseEsports // Equipo: Case Esports
        );
        jugadores.add(javier);

        Jugador coldraa = new Jugador(
                "Coldraa",
                "Samet Safran",
                "ADC",
                21, // Edad desconocida
                "TR",
                "Zeri", // Campeón favorito desconocido
                41, // Bajas
                7, // Muertes
                47, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                caseEsports // Equipo: Case Esports
        );
        jugadores.add(coldraa);

        Jugador pyrka = new Jugador(
                "Pyrka",
                "Łukasz Grześkowiak",
                "SUPPORT",
                23, // Edad desconocida
                "PL",
                "Rell", // Campeón favorito desconocido
                6, // Bajas
                16, // Muertes
                76, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                caseEsports // Equipo: Case Esports
        );
        jugadores.add(pyrka);

        Jugador ace = new Jugador(
                "Ace",
                "Eduardo Ignacio David Piaggio",
                "ADC",
                25, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                caseEsports // Equipo: Case Esports
        );
        jugadores.add(ace);

        /*
        * Jugadores de WIZARDS
        * */

        Jugador icebreaker = new Jugador(
                "Icebreaker",
                "Dimitris Xatzitsompanis",
                "TOP",
                24, // Edad desconocida
                "GR",
                "Renekton", // Campeón favorito desconocido
                31, // Bajas
                48, // Muertes
                95, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                wizards // Equipo: Wizards
        );
        jugadores.add(icebreaker);

        Jugador dahvys = new Jugador(
                "Dahvys",
                "David Casco",
                "JUNGLER",
                23, // Edad desconocida
                "ES",
                "Viego", // Campeón favorito desconocido
                51, // Bajas
                54, // Muertes
                117, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                wizards // Equipo: Wizards
        );
        jugadores.add(dahvys);

        Jugador tsiperakos = new Jugador(
                "Tsiperakos",
                "Vasileios Lalas",
                "MID",
                21, // Edad desconocida
                "GR",
                "Taliyah", // Campeón favorito desconocido
                50, // Bajas
                40, // Muertes
                113, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                wizards // Equipo: Wizards
        );
        jugadores.add(tsiperakos);

        Jugador lindgarde = new Jugador(
                "Lindgarde",
                "Hugo Lindgärde",
                "ADC",
                19, // Edad desconocida
                "SE",
                "kai'sa", // Campeón favorito desconocido
                77, // Bajas
                28, // Muertes
                80, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                wizards // Equipo: Wizards
        );
        jugadores.add(lindgarde);

        Jugador simpy = new Jugador(
                "Simpy",
                "Sergi Ruiz",
                "SUPPORT",
                26, // Edad desconocida
                "ES",
                "Nautilus", // Campeón favorito desconocido
                10, // Bajas
                71, // Muertes
                146, // Asistencias
                "Best player champion image.", // Asumiendo que es la URL de la imagen
                wizards // Equipo: Wizards
        );
        jugadores.add(simpy);

        Jugador alonshot = new Jugador(
                "Alonshot",
                "Alonso Hernandez Ballesteros",
                "ADC",
                18, // Edad desconocida
                "ES",
                null, // Campeón favorito desconocido
                0, // Bajas
                0, // Muertes
                0, // Asistencias
                "TEMPORADA", // Asumiendo que es la URL de la imagen
                wizards // Equipo: Wizards
        );
        jugadores.add(alonshot);

        // Creamos las partidas

        List<Partida> partidas = partidaFactory.get(180*3, equipos);

        //Guardamos los datos en los repositorios

        equipoRepository.saveAll(equipos);
        partidaRepository.saveAll(partidas);
        jugadorRepository.saveAll(jugadores);

        for (Partida partida : partidas) {
            equipoService.actualizarDatosEquipo(partida.getEquipoLocal());
            equipoService.actualizarDatosEquipo(partida.getEquipoVisitante());
        }
    }
}
