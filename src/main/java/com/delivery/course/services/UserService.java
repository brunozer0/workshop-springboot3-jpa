package com.delivery.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.delivery.course.entities.User;
import com.delivery.course.repositories.UserRepository;
import com.delivery.course.services.exceptions.DatabaseException;
import com.delivery.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			try {
				repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}

	public User update(Long id, User obj) {

		try {
			User entity = repository.getReferenceById(id);

			updateData(entity, obj);

			return repository.save(entity);

		} catch (RuntimeException e) {
			e.printStackTrace();
			
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(User entity, User obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
