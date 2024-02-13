package mate.academy.hibernate.relations.service.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.dao.impl.MovieDaoImpl;
import mate.academy.hibernate.relations.exceptions.NoValueForParameterFound;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.MovieService;
import org.hibernate.SessionFactory;

public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(SessionFactory sessionFactory) {
        movieDao = new MovieDaoImpl(sessionFactory);
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        Optional<Movie> movieOptional = movieDao.get(id);
        if (movieOptional.isPresent()) {
            return movieOptional.get();
        } else {
            throw new NoValueForParameterFound("Can't find a movie with id " + id);
        }
    }
}