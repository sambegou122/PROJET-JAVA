package goosegame;

public class GameMain {
    public static void main(String[] args){
        Board b = new ClassicalBoard();
        b.initBoard();
        Game goose = new Game(b);
        int nbJoueur = Integer.parseInt(args[0]);
        Player[] players = new Player[nbJoueur];
        for(int i=0;i<nbJoueur;i++){
            players[i] = new Player("joueur "+Integer.toString(i+1),b.getCell(0));
            goose.addPlayer(players[i]);
        }
        goose.play();
    }
}
