package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Reviews;

public interface ReviewsRepo extends JpaRepository<Reviews, Integer> {
    @Query(value = "select * from reviews where review_id=:s",nativeQuery = true)
    public List<Reviews> getReviewInfo(@Param("s") int review_id);
}