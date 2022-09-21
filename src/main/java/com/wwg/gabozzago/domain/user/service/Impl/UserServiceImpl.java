package com.wwg.gabozzago.domain.user.service.Impl;

import com.wwg.gabozzago.domain.user.repository.UserRepository;
import com.wwg.gabozzago.domain.post.repository.PostRepository;
import com.wwg.gabozzago.domain.user.data.dto.MyPageDto;
import com.wwg.gabozzago.domain.user.entity.User;
import com.wwg.gabozzago.domain.user.service.UserService;
import com.wwg.gabozzago.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserUtils userUtils;
    @Override
    public MyPageDto getMyPage() {
        User userInfo = userUtils.getCurrentUser();
        List<String> postInfo = postRepository.getPostImg(userInfo);
        return new MyPageDto(userInfo.getName(),userInfo.getUserImg(),postInfo);
    }

    @Override
    @Transactional
    public void withdrawalUser() {
        User userInfo = userUtils.getCurrentUser();
        postRepository.deletePostsByUser(userInfo);
        userRepository.delete(userInfo);
    }
}
