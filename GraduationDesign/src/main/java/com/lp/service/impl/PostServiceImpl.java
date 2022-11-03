package com.lp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.Result;
import com.lp.entity.Post;
import com.lp.entity.User;
import com.lp.entity.vo.PostVo;
import com.lp.mapper.PostMapper;
import com.lp.mapper.UserMapper;
import com.lp.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper , Post> implements PostService {

    @Resource
    private PostMapper postMapper;

    @Resource
    private UserMapper userMapper;

    /**
     * 查看所有岗位的员工
     * @return List<PostVo>
     */
    @Override
    public Result getPersonForPost() {
        List<Post> posts = list(new QueryWrapper<Post>());

        List<PostVo> postVoList = posts.stream().map(post -> {
            PostVo postVo = new PostVo();
            BeanUtil.copyProperties(post,postVo,false);
            postVo.setPostUsers(userMapper.selectList(new QueryWrapper<User>().eq("post_id",post.getPostId())));
            return postVo;
        }).collect(Collectors.toList());
        return Result.ok(postVoList);
    }
}
