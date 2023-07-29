package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import tubeVideosManager.Genre;
import tubeVideosManager.Playlist;
import tubeVideosManager.TubeVideosManager;
import tubeVideosManager.Video;

/**
 * 
 * You need student tests if you are asking for help during office hours about
 * bugs in your code. Feel free to use tools available in TestingSupport.java
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	// testing constructor

	@Test
	public void testingVideoConstructor() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		System.out.println(video);

		String expected = "Title: \"the lion king trailer\"\r\n"
				+ "Url: https://www.youtube.com/watch?v=7TavVZMewpY\r\n" + "Duration (minutes): 2\r\n"
				+ "Genre: FilmAnimation";
		String actual = video.toString();

		

		// why is the JUnit failing?

	}

	// testing if a string was null

	@Test(expected = IllegalArgumentException.class)
	public void testingVideoConstructorException() {

		// how to test this ??

		Video video = new Video(null, "https://www.youtube.com/watch?v=7TavVZMewpY", 2, Genre.FilmAnimation);
	}

	// testing if copy constructor works

	@Test
	public void testingVideoCopy() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		System.out.println(video);

		Video copy = new Video(video);
		System.out.println(copy);

		// what assertion do i use ?

	}

	// testing if comments got copied through

	@Test
	public void testingVideoCopy02() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		video.addComments("haha");
		System.out.println(video.getComments());

		Video copy = new Video(video);
		System.out.println(copy.getComments());

	}

	@Test
	public void testingVideoGetTitle() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		System.out.println(video.getTitle());

		String expected = "the lion king trailer";

		String actual = video.getTitle();

		assertTrue(actual.equals(expected));

	}

	@Test
	public void testingVideoGetUrl() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		String actual = video.getUrl();

		String expected = "https://www.youtube.com/watch?v=7TavVZMewpY";

		assertTrue(actual.equals(expected));

	}

	@Test
	public void testingVideoGetDurationInMinutes() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		int actual = video.getDurationInMinutes();
		int expected = 2;

		assertTrue(actual == expected);

	}

	@Test
	public void testingVideoGetGenre() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		Genre expected = Genre.FilmAnimation;
		Genre actual = video.getGenre();

		assertTrue(actual == expected);
		// is this how you do it for enums ?

	}

	// testing null string

	@Test(expected = IllegalArgumentException.class)
	public void testingVideoAddComments() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		video.addComments(null);

	}

	// testing blank string

	@Test(expected = IllegalArgumentException.class)
	public void testingVideoAddComments02() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		video.addComments("");

	}

	// testing true

	@Test
	public void testingVideoAddComments03() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		assertTrue(video.addComments("a comment"));

	}

	// testing of changes made wont affect original

	@Test
	public void testingVideoGetComments() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		video.addComments("comment 1");
		video.addComments("comment 2");

		video.getComments().add("comment 3");

		System.out.println(video.getComments());

	}

	// positive # means its the right order

	@Test
	public void testingVideoCompareTo() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		Video video02 = new Video("a random title", "www.no.com", 3, Genre.Comedy);

		System.out.println(video.compareTo(video02));
	}

	// testing if its not a Video

	@Test
	public void testingVideoEquals() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		Object obj = new Object();

		System.out.println(video.equals(obj));

		assertFalse(video.equals(obj));

	}

	// testing same and diff title

	@Test
	public void testingVideoEquals02() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		Video video02 = new Video("the lion king trailer", "diff url", 2, Genre.FilmAnimation);

		Video video03 = new Video("bad bunny: party", "diff url", 2, Genre.FilmAnimation);

		System.out.println(video.equals(video02));
		System.out.println(video.equals(video03));

	}

	// testing for null

	@Test
	public void testingVideoEquals03() {

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		System.out.println(video.equals(null));
	}

	// testing for valid param

	@Test
	public void testingPlaylistConstructor() {

		Playlist playlist = new Playlist("funny vids");

		System.out.println(playlist);
	}

	// testing for blank param exception

	@Test(expected = IllegalArgumentException.class)
	public void testingPlaylistConstructor02() {

		Playlist playlist = new Playlist("");
		System.out.println(playlist);

	}

	// checking if changes to copy dont affect original

	@Test
	public void testingPlaylistCopyConstructor() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("new girl show bloopers");

		Playlist playlist02 = new Playlist(playlist);
		playlist02.addToPlaylist("skateboarding fails");

		System.out.println(playlist);
		System.out.println(playlist02);

	}

	@Test
	public void testingPlaylistGetName() {

		Playlist playlist = new Playlist("funny vids");

		System.out.println(playlist.getName());
	}

	// testing for exception w null

	@Test(expected = IllegalArgumentException.class)
	public void testingPlaylistAddToPlaylist() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist(null);

	}

	// testing for exception w blank

	@Test(expected = IllegalArgumentException.class)
	public void testingPlaylistAddToPlaylist02() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("");

	}

	// checking for privacy leaks

	@Test
	public void testingPlaylistGetVideoTitles() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("benito funny moments");

		playlist.getPlaylistVideosTitles().add("abcd");

		System.out.println(playlist);

	}

	@Test
	public void testingPlaylistRemoveFromPlaylist() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("benito funny moments");
		playlist.addToPlaylist("skateboard fails");
		playlist.addToPlaylist("funny cat");

		System.out.println(playlist);

		System.out.println(playlist.removeFromPlaylistAll("skateboard fails"));
		System.out.println(playlist);

	}

	// testing null param

	@Test(expected = IllegalArgumentException.class)
	public void testingPlaylistRemoveFromPlaylist02() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("skateboard fails");
		playlist.removeFromPlaylistAll(null);

	}

	// testing blank param
	@Test(expected = IllegalArgumentException.class)
	public void testingPlaylistRemoveFromPlaylist03() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("skateboard fails");
		playlist.removeFromPlaylistAll("");

	}
	
	// testing of vid not found
	
	@Test
	public void testingPlaylistRemoveFromPlaylist04() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("benito funny moments");
		playlist.addToPlaylist("skateboard fails");
		playlist.addToPlaylist("funny cat");

		System.out.println(playlist.removeFromPlaylistAll("random"));
		

	}

	@Test
	public void testingPlaylistShuffleVideoTitles() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("benito funny moments");
		playlist.addToPlaylist("skateboard fails");
		playlist.addToPlaylist("funny cat");

		System.out.println(playlist);

		playlist.shuffleVideoTitles(new Random());

		System.out.println(playlist);

	}

	// testing null param to see if it still shuffles

	@Test
	public void testingPlaylistShuffleVideoTitles02() {

		Playlist playlist = new Playlist("funny vids");
		playlist.addToPlaylist("benito funny moments");
		playlist.addToPlaylist("skateboard fails");
		playlist.addToPlaylist("funny cat");

		System.out.println(playlist);

		playlist.shuffleVideoTitles(null);

		System.out.println(playlist);
	}

	@Test
	public void testingTubeVideosManagerConstructor() {

		TubeVideosManager first = new TubeVideosManager();

	}

	// checking normal

	@Test
	public void testingTubeVideosManagerAddVideoToDB() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);

		System.out.println(first.getAllVideosInDB());

	}

	// checking invalid video param

	@Test
	public void testingTubeVideosManagerAddVideoToDB02() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB(null, "https://www.youtube.com/watch?v=7TavVZMewpY", 2, Genre.FilmAnimation);

		first.addVideoToDB("", "diff url", 2, Genre.FilmAnimation);

		first.addVideoToDB("", "diff url", -1, Genre.FilmAnimation);

		first.addVideoToDB(null, "https://www.youtube.com/watch?v=7TavVZMewpY", 2, null);

	}

	// checking that changes dont affect original

	@Test
	public void testingTubeVideosManagerGetAllVideosInDB() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);

		Video video = new Video("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		first.getAllVideosInDB().add(video);

		System.out.println(first.getAllVideosInDB());

	}

	// checking normal

	@Test
	public void testingTubeVideosManagerFindVideo() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.findVideo("the lion king trailer"));

	}

	// checking for exception when invalid argument blank

	@Test(expected = IllegalArgumentException.class)
	public void testingTubeVideosManagerFindVideo02() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.findVideo(""));

	}

	// checking for invalid argument null

	@Test(expected = IllegalArgumentException.class)
	public void testingTubeVideosManagerFindVideo03() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.findVideo(null));

	}

	// checking for when no vid is found

	@Test
	public void testingTubeVideosManagerFindVideo04() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.findVideo("wakanda forever trailer"));

	}

	// checking for true;

	@Test
	public void testingTubeVideosManagerAddComments() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.addComments("bad bunny: party", "best song everrr"));

		System.out.println(first.findVideo("bad bunny: party").getComments());

	}

	// checking for false w null argument

	@Test
	public void testingTubeVideosManagerAddComments02() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.addComments(null, "best song everrr"));

	}

	// checking for blank argument

	@Test
	public void testingTubeVideosManagerAddComments03() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.addComments("bad bunny: party", ""));

	}

	// checking if vid doesn't exist

	@Test
	public void testingTubeVideosManagerAddComments04() {

		TubeVideosManager first = new TubeVideosManager();

		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);
		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);

		System.out.println(first.addComments("cant feel my face by the weeknd", "best song"));

	}

	// checking for normal arguments and that it returns true

	@Test
	public void testingTubeVideosManagerAddPlaylist() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("funny vids");

		System.out.println(first.addPlaylist("favorites"));

	}

	// testing for invalid argument

	@Test(expected = IllegalArgumentException.class)
	public void testingTubeVideosManagerAddPlaylist02() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("funny vids");

		System.out.println(first.addPlaylist(""));

		// is this also suppose to return false??
	}

	// testing that it doesnt add if a playlist with that name already exists;

	@Test
	public void testingTubeVideosManagerAddPlaylist03() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("focus music");
		first.addPlaylist("funny vids");

		System.out.println(first.addPlaylist("funny vids"));

	}

	// check that its an empty array if none are added

	@Test
	public void testingTubeVideosManagerGetPlaylistsNames() {

		TubeVideosManager first = new TubeVideosManager();

		System.out.println(first.getPlaylistsNames().length);

	}

	// testing for normal conditions

	@Test
	public void testingTubeVideosManagerGetPlaylistsNames02() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("focus music");
		first.addPlaylist("funny vids");

		for (int i = 0; i < first.getPlaylistsNames().length; i++) {
			System.out.println(first.getPlaylistsNames()[i]);
		}

	}

	// check for when playlist exists and vid too (use n print getPlaylist())

	@Test
	public void testingTubeVideosManagerAddVideoToPlaylist() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("focus music");
		first.addPlaylist("movie trailers");

		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		System.out.println(first.addVideoToPlaylist("the lion king trailer", "movie trailers"));

		System.out.println(first.getPlaylist("movie trailers"));

	}

	// check for when playlist exists but vid doesnt and vice versa

	@Test
	public void testingTubeVideosManagerAddVideoToPlaylist02() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("focus music");
		first.addPlaylist("movie trailers");

		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);
		first.addVideoToDB("blah blah", "www.random.com", 5, Genre.Comedy);
		first.addVideoToDB("bad bunny: party", "diff url", 2, Genre.FilmAnimation);

		System.out.println(first.addVideoToPlaylist("wakanda forever trailer", "movie trailers"));

		System.out.println(first.getPlaylist("movie trailers"));

		System.out.println(first.addVideoToPlaylist("the lion king trailer", "trailers"));

	}

	

	// testing blank arguments

	
	public void testingTubeVideosManagerAddVideoToPlaylist03() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("focus music");
		first.addPlaylist("movie trailers");

		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		System.out.println(first.addVideoToPlaylist("the lion king trailer", ""));

		System.out.println(first.getPlaylist("movie trailers"));

	}

	// testing null argument

	@Test
	public void testingTubeVideosManagerAddVideoToPlaylist04() {

		TubeVideosManager first = new TubeVideosManager();

		first.addPlaylist("focus music");
		first.addPlaylist("movie trailers");

		first.addVideoToDB("the lion king trailer", "https://www.youtube.com/watch?v=7TavVZMewpY", 2,
				Genre.FilmAnimation);

		System.out.println(first.addVideoToPlaylist(null, "movie trailers"));

		System.out.println(first.getPlaylist("movie railers"));

	}
	
	
	// testing if all videos are returned
	
	@Test
	public void testingSearchForVideos() {
		
		TubeVideosManager manager = new TubeVideosManager();
		
		manager.addVideoToDB("the weeknd: angel", "www.website.com",  4, Genre.Music);
		manager.addVideoToDB("study music", "www.website.com",  2, Genre.Music);
		manager.addVideoToDB("bad bunny: un verano sin ti", "www.website.com",  3, Genre.Music);
		manager.addVideoToDB("ab workout", "www.website.com",  10, Genre.Educational);
		
		System.out.println(manager.searchForVideos("fav songs", null, -1, null));
		
	}
	
	// testing for invalid playlist name 
	
	@Test(expected = IllegalArgumentException.class)
	public void testingSearchForVideos02() {
		
		TubeVideosManager manager = new TubeVideosManager();
		
		manager.addVideoToDB("the weeknd: angel", "www.website.com",  4, Genre.Music);
		manager.addVideoToDB("study music", "www.website.com",  2, Genre.Music);
		manager.addVideoToDB("bad bunny: un verano sin ti", "www.website.com",  3, Genre.Music);
		manager.addVideoToDB("ab workout", "www.website.com",  10, Genre.Educational);
		
		System.out.println(manager.searchForVideos(null, null, -1, null));
		
	}
	
	//testing for valid arguments
	
	@Test
	public void testingSearchForVideos03() {
		
		TubeVideosManager manager = new TubeVideosManager();
		
		manager.addVideoToDB("the weeknd: angel", "www.website.com",  4, Genre.Music);
		manager.addVideoToDB("study music", "www.website.com",  2, Genre.Music);
		manager.addVideoToDB("bad bunny: un verano sin ti", "www.website.com",  3, Genre.Music);
		manager.addVideoToDB("ab workout", "www.website.com",  10, Genre.Educational);
		
		System.out.println(manager.searchForVideos("favorites", "the weeknd: angel", 3, null));
		
	}
	
	
}
	
		

	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
		
		
	
	
	
		
	
	
	
	
	
	
		
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


