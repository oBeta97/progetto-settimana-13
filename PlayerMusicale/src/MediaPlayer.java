import java.util.Scanner;

public class MediaPlayer {
    static MediaPlayerItem[] mediaPlayerItems = new MediaPlayerItem[5];
    static MediaPlayerItem activeMediaPlayerItem;

    static void showMediaPlayerItems() {
        for(MediaPlayerItem item : mediaPlayerItems){
            System.out.println(item);
        }
    }

    static void setActiveMediaPlayerItem(){

        boolean isMediaPlayerEmpty = true;
        for(MediaPlayerItem item : mediaPlayerItems){
            if(item != null) {
                isMediaPlayerEmpty = false;
                break;
            }
        }
        if(isMediaPlayerEmpty){
            System.out.println("Media player vuoto! inserisci almeno un item prima di proseguire");
            return;
        }

        Scanner s = new Scanner(System.in);

        showMediaPlayerItems();
        System.out.println("Seleziona l'item da eseguire (in base 1):");

        boolean insertedIndex = false;
        while (!insertedIndex){

            int index = Integer.parseInt(s.nextLine())-1;

            if (index < 0 || index > mediaPlayerItems.length) {
                System.out.println("Out of index error! Reinserisci l'item con l'indice corretto");
                continue;
            }

            if (mediaPlayerItems[index] == null) {
                System.out.println("Impossibile inserire un item vuoto al media player! riprova");
                continue;
            }

            activeMediaPlayerItem = mediaPlayerItems[index];
            System.out.println( activeMediaPlayerItem.getTitle() + " inserito!");
            insertedIndex = true;
        }
    }

    static void playActiveMediaPlayerItem(){

//        CODICE MIO
//        if(activeMediaPlayerItem == null){
//            System.out.println("Nessun item in esecuzione");
//            return;
//        }
//
//        if (activeMediaPlayerItem instanceof Audio) {
//            ((Audio) activeMediaPlayerItem).play();
//        }
//        else if (activeMediaPlayerItem instanceof Video) {
//            ((Video) activeMediaPlayerItem).play();
//        }
//        else if (activeMediaPlayerItem instanceof Image) {
//            ((Image) activeMediaPlayerItem).show();
//        }


//        CODICE SUGGERITO DAL IDE
        switch (activeMediaPlayerItem) {
            case Audio audio -> playWithActiveAudio(audio);
            case Video video -> playWithActiveVideo(video);
            case Image image -> playWithActiveImage(image);
            case null, default -> System.out.println("Nessun item in esecuzione");
        }

    }

    static void addToMediaPlayer() {
        Scanner s = new Scanner(System.in);


        boolean  quit = false;

        while (!quit) {
            System.out.println("che tipo di item vuoi inserire? (-h help)");
            String type = s.nextLine();

            switch (type) {
                case "-A":
                    addAudioToMediaPlayer();
                    quit = true;
                    break;
                case "-I":
                    addImageToMediaPlayer();
                    quit = true;
                    break;
                case "-V":
                    addVideoToMediaPlayer();
                    quit = true;
                    break;
                case "-q":
                    quit = true;
                    break;
                case "-h":
                    System.out.println(
                            """
                                -A add Audio to the media player
                                -I add Image to the media player
                                -V add Video to the media player
                                -q quit to media player
                                -h help
                            """
                    );
                    break;
                default:
                    System.out.println("comando non valido, utilizza -h per vedere i comandi disponibili");
            }
        }


    }

    private static void addVideoToMediaPlayer() {
        Scanner s = new Scanner(System.in);

        System.out.println("bene! Inserisci il titolo del video");
        String title = s.nextLine();
        System.out.println("inserisci la durata del video");
        int duration = Integer.parseInt(s.nextLine());

        Video newVideo = new Video(title, duration);

        for (int i = 0; i < mediaPlayerItems.length; i++) {
            if (mediaPlayerItems[i] == null) {
                mediaPlayerItems[i] = newVideo;
                System.out.println("video inserito! ritorno in main");
                return;
            }
        }
        System.out.println("impossibile aggiungere il video, media player pieno");
    }
    
    private static void addImageToMediaPlayer() {

        Scanner s = new Scanner(System.in);

        System.out.println("bene! Inserisci il titolo dell'immagine");
        String title = s.nextLine();
        System.out.println("inserisci il formato dell'immagine (es. JPEG, PNG)");
        String format = s.nextLine();

        Image newImage = new Image(title, format);

        for (int i = 0; i < mediaPlayerItems.length; i++) {
            if (mediaPlayerItems[i] == null) {
                mediaPlayerItems[i] = newImage;
                System.out.println("immagine inserita! ritorno in main");
                return;
            }
        }
        System.out.println("impossibile aggiungere l'immagine, media player pieno");

    }

    private static void addAudioToMediaPlayer() {
        Scanner s = new Scanner(System.in);

        System.out.println("bene! Inserisci il titolo della canzone");
        String title = s.nextLine();
        System.out.println("inserisci la durata della canzone");
        int duration = Integer.parseInt(s.nextLine());
        System.out.println("inserisci il nome dell'autore");
        String author = s.nextLine();
        System.out.println("inserisci il nome dell'album");
        String album = s.nextLine();
        System.out.println("inserisci il genere della canzone");
        String genre = s.nextLine();
        System.out.println("inserisci l'anno della canzone");
        int year = Integer.parseInt(s.nextLine());

        Audio newAudio = new Audio(title, duration, author, album, genre, year);

        for (int i = 0; i < mediaPlayerItems.length; i++) {
            if (mediaPlayerItems[i] == null) {
                mediaPlayerItems[i] = newAudio;
                System.out.println("canzone inserita! ritorno in main");
                return;
            }
        }
        System.out.println("impossibile aggiungere la canzone, media player pieno");
    }

    private static void playWithActiveAudio(Audio activeAudio){

        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit){
            System.out.println("cosa vuoi fare con la canzone? (-h help)");
            String command = s.nextLine();
            
            switch (command){
                case "-la":
                    System.out.println(activeAudio);
                    break;
                case "-h":
                    System.out.println(
                        """
                            -la visualizza lo stato attuale della canzone
                            -p riproduce la canzone attuale
                            -s mette in pausa la canzone attuale
                            -vu aumenta il volume della canzone attuale
                            -vd diminuisce il volume della canzone attuale
                            -q esce dalla gestione della canzone attuale
                            -h mostra questo messaggio di aiuto
                        """
                    );
                    break;
                case "-p":
                    activeAudio.play();
                    break;
                case "-s":
                    activeAudio.pause();
                    break;
                case "-vu":
                    activeAudio.turnUpVolume();
                    break;
                case "-vd":
                    activeAudio.turnDownVolume();
                    break;
                case "-q":
                    quit = true;
                    break;
                default:
                    System.out.println("comando non valido, utilizza -h per vedere i comandi disponibili");
            }
            
        }



    }

    private static void playWithActiveVideo(Video activeVideo) {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("cosa vuoi fare con il video? (-h help)");
            String command = s.nextLine();

            switch (command) {
                case "-la":
                    System.out.println(activeVideo);
                    break;
                case "-h":
                    System.out.println(
                        """
                            -la visualizza lo stato attuale del video
                            -p riproduce il video attuale
                            -s mette in pausa il video attuale
                            -vu aumenta il volume del video attuale
                            -vd diminuisce il volume del video attuale
                            -mb aumenta la luminosità del video attuale
                            -lb diminuisce la luminosità del video attuale
                            -q esce dalla gestione del video attuale
                            -h mostra questo messaggio di aiuto
                        """
                    );
                    break;
                case "-p":
                    activeVideo.play();
                    break;
                case "-s":
                    activeVideo.pause();
                    break;
                case "-vu":
                    activeVideo.turnUpVolume();
                    break;
                case "-vd":
                    activeVideo.turnDownVolume();
                    break;
                case "-mb":
                    activeVideo.moreBrightness();
                    break;
                case "-lb":
                    activeVideo.lessBrightness();
                    break;
                case "-q":
                    quit = true;
                    break;
                default:
                    System.out.println("comando non valido, utilizza -h per vedere i comandi disponibili");
            }

        }
    }

    private static void playWithActiveImage(Image activeImage) {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("cosa vuoi fare con l'immagine? (-h help)");
            String command = s.nextLine();

            switch (command) {
                case "-la":
                    System.out.println(activeImage);
                    break;
                case "-h":
                    System.out.println(
                        """
                            -la visualizza lo stato attuale dell'immagine
                            -sh mostra l'immagine attuale
                            -hd nasconde l'immagine attuale
                            -mb aumenta la luminosità dell'immagine attuale
                            -lb diminuisce la luminosità dell'immagine attuale
                            -q esce dalla gestione dell'immagine attuale
                            -h mostra questo messaggio di aiuto
                        """
                    );
                    break;
                case "-sh":
                    activeImage.show();
                    break;
                case "-hd":
                    activeImage.hide();
                    break;
                case "-mb":
                    activeImage.moreBrightness();
                    break;
                case "-lb":
                    activeImage.lessBrightness();
                    break;
                case "-q":
                    quit = true;
                    break;
                default:
                    System.out.println("comando non valido, utilizza -h per vedere i comandi disponibili");
            }

        }
    }
}
