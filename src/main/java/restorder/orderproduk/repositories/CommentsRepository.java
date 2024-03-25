package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restorder.orderproduk.entity.Comment;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {}
