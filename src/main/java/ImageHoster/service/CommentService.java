package ImageHoster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import ImageHoster.repository.UserRepository;

@Service
public class CommentService {


	@Autowired
	CommentRepository commentRepository;
	
	public boolean addComment(User user,Image image,Comment comments) {		
		return commentRepository.addComment(image, user, comments);
	}
	
}
