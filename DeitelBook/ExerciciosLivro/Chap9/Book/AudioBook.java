
public class AudioBook extends Book  {
  public final int sizeInMbytes;
  public final int playLengthSec;
  public final String playbackArtist;

  public AudioBook(String title, String author, String playbackArtist, 
    int yearOfPublication, int sizeInMbytes,int playLengthSec) {
      super(title, yearOfPublication, author);
      this.sizeInMbytes = sizeInMbytes;
      this.playLengthSec = playLengthSec;
      this.playbackArtist = playbackArtist;
  }

  @Override
  public String toString() {
    return String.format("%s%nPlayback Artist: %s%nSize in MB: %d%nPlay length:%d",
      super.toString(), playbackArtist, sizeInMbytes, playLengthSec);
  }
}
