package com.cst438.assignment1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Rating, Long> {
    @Query("select m from Rating m order by m.title, m.dateTime desc")
    List<Rating> findAllMovieRatingsOrderByTitleDateDesc();

    @Query("select count(id) from Rating ")
    long count(@Param("featured") boolean featured);
}
