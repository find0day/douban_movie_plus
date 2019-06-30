package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.site.BtbtdyResource;
import org.junit.Test;

public class BtbtdyClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        MovieMap<BtbtdyClient> movieMap = new BtbtdyClient().getMovieMap("星际穿越", 3);
        for (Movie movie : movieMap.getMovies()) {
            System.out.println(movie.getMovieName() + " " + movie.getMovieUrl());
            BtbtdyResource btbtdyResource=new BtbtdyClient().getMovie(movie);
            System.out.println();
        }
    }
}