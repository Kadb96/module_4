package com.codegym.pictureoftheday.repository;

import com.codegym.pictureoftheday.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
