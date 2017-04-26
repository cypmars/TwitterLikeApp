package com.polytech.repository;

import com.polytech.models.Like;
import com.polytech.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;




@Repository
@Transactional
public interface LikeRepository extends JpaRepository<Like, Long> {
	List<Like> findByPost(Post post);
}
