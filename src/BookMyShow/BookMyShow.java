package BookMyShow;

import BookMyShow.Enums.City;
import BookMyShow.Enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    BookMyShow(){
        movieController=new MovieController();
        theatreController=new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow=new BookMyShow();
        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.PUNE, "Frozen");

        //user2
        bookMyShow.createBooking(City.HYDERABAD, "Cindrella");

    }

    private void initialize(){
        createMovies();
        createTheatre();
    }
    private void createBooking(City userCity, String movieName){
        List<Movie>movies=movieController.getMoviesByCity(userCity);

        //Select a movie user wants to see
        Movie interestedMovie=null;
        for(Movie movie: movies){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie=movie;
            }
        }

        //Get all shows of selected movie in user's location
        Map<Theatre,List<Show>> showTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //Select a particular location the user is interested in
        Map.Entry<Theatre, List<Show>> entry = showTheatreWise.entrySet().iterator().next();
//        Retrieves the first entry from the showsTheatreWise map.


        //Get list of shows for retrieved entry
        List<Show> runningShows = entry.getValue();
//        entry.getValue() gets the list of shows for the first theatre in the map.

        //Retrieve first show from list
        Show interestedShow= runningShows.get(0);
//        runningShows.get(0) selects the first show from this list.

        //Select a seat
        int seatNumber=11;
        List<Integer>bookedSeats=interestedShow.getBookedSeatId();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);

            Booking booking=new Booking();
            List<Seat>myBookedSeats=new ArrayList<>();
            for(Seat screenSeat: interestedShow.getScreen().getSeats()){
                if(screenSeat.getSeatId()==seatNumber){
                    myBookedSeats.add(screenSeat);
                }
                booking.setBookedSeats(myBookedSeats);
                booking.setShow(interestedShow);
            }
        }else{
            System.out.println("Seat not available. Please book another one.");
            return;
        }
        System.out.println("Your booking is successful!");
    }

    private void createTheatre(){
        Movie movie1=movieController.getMovieByName("Frozen");
        Movie movie2=movieController.getMovieByName("Cindrella");

        Theatre inoxTheatre=new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(City.PUNE);
        List<Show>inoxShows=new ArrayList<>();
        Show inoxMorningShow=createShows(1,inoxTheatre.getScreen().get(0),movie1,9);
        Show inoxEveningShow=createShows(2, inoxTheatre.getScreen().get(0),movie2,16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(City.HYDERABAD);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreen().get(0), movie1, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreen().get(0), movie2, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.PUNE);
        theatreController.addTheatre(pvrTheatre, City.HYDERABAD);
    }

    private List<Screen>createScreen(){
        List<Screen>screens=new ArrayList<>();
        Screen screen1=new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime){
        Show show=new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }

    private List<Seat>createSeats(){
        List<Seat>seats=new ArrayList<>();

        //1 to 40 : SILVER
        for(int i=0; i<40; i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70: GOLD
        for(int i=41; i<70; i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //71 TO 100 : PLATINUM
        for(int i=71; i<100; i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }


    private void createMovies(){
        Movie movie1=new Movie();
        movie1.setMovieId(1);
        movie1.setMovieName("Frozen");
        movie1.setDuration(160);

        Movie movie2=new Movie();
        movie2.setMovieId(2);
        movie2.setMovieName("Cindrella");
        movie2.setDuration(110);

        movieController.addMovie(movie1, City.PUNE);
        movieController.addMovie(movie1, City.HYDERABAD);
        movieController.addMovie(movie2, City.PUNE);
        movieController.addMovie(movie2, City.HYDERABAD);
    }
}
