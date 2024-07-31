package BookMyShow;

import BookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    List<Theatre>allTheatres;
    Map<City, List<Theatre>>cityVsTheatre;

    TheatreController(){
        cityVsTheatre=new HashMap<>();
        allTheatres=new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city){
        allTheatres.add(theatre);
        //This maintains a global list of all theatres in the system, regardless of their city.
        List<Theatre>theatres=cityVsTheatre.getOrDefault(city, new ArrayList<>());
        // Ensures that there is a list to which the new theatre can be added,
        // either by retrieving the existing list or creating a new one if necessary.
        theatres.add(theatre);
        //Updates the list with the new theatre.
        cityVsTheatre.put(city, theatres);
        //Ensures that the map reflects the addition of the new theatre for the specified city.
    }

    Map<Theatre, List<Show>>getAllShow(Movie movie, City city){
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre>theatres=cityVsTheatre.get(city);
        for(Theatre theatre: theatres){
            List<Show>givenMovieShows=new ArrayList<>();
            List<Show>shows=theatre.getShows();
            for(Show show: shows){
                if(show.movie!=null && show.movie.getMovieId()==movie.getMovieId()){
                    givenMovieShows.add(show);
                } else if (show.movie==null) {
                    System.out.println("Theatre " + theatre.getCity(city) + " has no shows.");
                    continue;
                }
            }
            if(!givenMovieShows.isEmpty()){
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }
        return theatreVsShows;
    }
}
