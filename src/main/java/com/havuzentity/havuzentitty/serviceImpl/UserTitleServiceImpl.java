package com.havuzentity.havuzentitty.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.havuzentity.havuzentitty.dto.UserTitleAdminViewDTO;
import com.havuzentity.havuzentitty.dto.UserTitleCreateDTO;
import com.havuzentity.havuzentitty.dto.UserTitleUpdateDTO;
import com.havuzentity.havuzentitty.dto.UserTitleUserViewDTO;
import com.havuzentity.havuzentitty.exception.NotFoundException;

import com.havuzentity.havuzentitty.model.UserTitle;

import com.havuzentity.havuzentitty.repository.UserTitleRepository;
import com.havuzentity.havuzentitty.service.UserTitleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTitleServiceImpl implements UserTitleService {

	private final UserTitleRepository userTitleRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserTitleAdminViewDTO getUserTitleAdminById(int id) {
		final UserTitle userTitle = userTitleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return UserTitleAdminViewDTO.of(userTitle);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserTitleUserViewDTO getUserTitleUserById(int id) {
		final UserTitle userTitle = userTitleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));

		return UserTitleUserViewDTO.of(userTitle);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserTitleAdminViewDTO> getAllUserTitle() {

		return userTitleRepository.findAll().stream().map(UserTitleAdminViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UserTitleAdminViewDTO createUserTitle(@Valid UserTitleCreateDTO userTitleCreateDTO) {
		final UserTitle usertitle = userTitleRepository.save(new UserTitle(userTitleCreateDTO.getUserTitleName()));

		return UserTitleAdminViewDTO.of(usertitle);
	}

	@Override
	@Transactional
	public UserTitleAdminViewDTO updateUserTitle(int id, UserTitleUpdateDTO userTitleUpdateDTO) {
		final UserTitle userTitle = userTitleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		userTitle.setUserTitleName(userTitleUpdateDTO.getUserTitleName());
		final UserTitle userTitleUpdate = userTitleRepository.save(userTitle);

		return UserTitleAdminViewDTO.of(userTitleUpdate);
	}

	@Override
	@Transactional
	public void deleteUserTitle(int id) {
		final UserTitle usertTitle = userTitleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found Exception"));
		userTitleRepository.deleteById(usertTitle.getId());

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserTitleAdminViewDTO> userTitleSlice(Pageable pageable) {

		return userTitleRepository.findAll(pageable).stream().map(UserTitleAdminViewDTO::of)
				.collect(Collectors.toList());
	}

}
