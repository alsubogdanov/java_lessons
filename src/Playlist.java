public class Playlist {
    private String[] songs;

    public Playlist(String[] songs) {
        this.songs = songs;
    }
    class Player{
        private int ind = 0;
        public boolean hasNext(){
            return ind<songs.length;
        }
        public String nextSong(){
            return songs[ind++];
        }
    }
}
