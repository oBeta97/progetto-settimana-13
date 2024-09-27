import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("Benvenuto nel mio MediaPlayer");
        System.out.println("inserisci un comando da eseguire: (-h help)");

        Scanner scanner = new Scanner(System.in);

        boolean willContinue = true;
        while (willContinue){

            String command = scanner.nextLine();
            switch (command){
                case "-a":
                    MediaPlayer.addToMediaPlayer();
                    break;
                case "-i":
                    MediaPlayer.setActiveMediaPlayerItem();
                    break;
                case "-p":
                    MediaPlayer.playActiveMediaPlayerItem();
                    break;
                case "-s":
                    System.out.println(MediaPlayer.activeMediaPlayerItem);
                    break;
                case "-l":
                    MediaPlayer.showMediaPlayerItems();
                    break;
                case "-q":
                    willContinue = false;
                    break;
                case "-h":
                    System.out.println(
                        """
                            -a add to media player
                            -i active an item in the media player
                            -p play media player item
                            -s show playing media player item
                            -l list media player item
                            -q quit the program
                        """
                    );
                    break;
                default:
                    System.out.println("comando non valido, utilizza -h per vedere i comandi disponibili");
            }



        }




//
//        System.out.println("TEST");
//
//
//
//        MediaPlayerItem test = new Audio("mamma mia", 10, "abba", "mamma mia", "rock", 1823);;
//
//        System.out.println(test.getTitle());
//
//        System.out.println(test instanceof Audio);
//        System.out.println(" ");
//        Audio randomSong = (Audio) test;
//
//        System.out.println(randomSong);
//
//        randomSong.play();
//        randomSong.turnUpVolume();
//
//        System.out.println(randomSong);
//
//
//        randomSong.pause();
//        randomSong.turnDownVolume();
//        System.out.println(randomSong);


//        Image randomImage = new Image("test", "4:3");
//        System.out.println(randomImage);
//
//        randomImage.show();
//        randomImage.moreBrightness();
//
//        System.out.println(randomImage);
//
//        randomImage.lessBrightness();
//        randomImage.hide();
//
//        System.out.println(randomImage);

//        Video randomVideo = new Video("15+18", 36);
//        System.out.println(randomVideo);
//
//        randomVideo.play();
//        randomVideo.turnUpVolume();
//        randomVideo.moreBrightness();
//
//        System.out.println(randomVideo);
//
//        randomVideo.pause();
//        randomVideo.turnDownVolume();
//        randomVideo.lessBrightness();
//
//        System.out.println(randomVideo);

    }
}