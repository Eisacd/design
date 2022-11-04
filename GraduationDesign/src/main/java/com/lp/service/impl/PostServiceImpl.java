package com.lp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.Result;
import com.lp.entity.Department;
import com.lp.entity.Post;
import com.lp.entity.User;
import com.lp.entity.vo.PostVo;
import com.lp.mapper.DepartmentMapper;
import com.lp.mapper.PostMapper;
import com.lp.mapper.UserMapper;
import com.lp.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.lp.utils.Constants.DATABASE_POST_ID;
import static com.lp.utils.Constants.DATABASE_POST_NAME;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper , Post> implements PostService {

    @Resource
    private PostMapper postMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DepartmentMapper departmentMapper;


    /**
     * Unit Select
     */
    /**
     * 查询岗位
     */
    private Post selectPostById(Post post){
        return getById(post.getPostId());
    }

    private Post selectPostByColumns(Post post){
        Map<String  , Object> map = new HashMap<>();
        BeanUtil.beanToMap(post,map,false,true);
        return getOne(new QueryWrapper<Post>().allEq(map));
    }



    private List<Post> selectPostsByIds(List<Post> list){
        List<Integer> ids = list.stream().map(post -> {
            Integer id = post.getPostId();
            return id;
        }).collect(Collectors.toList());
        return (List<Post>) listByIds(ids);
    }

    /**
     * Unit Add
     */
    private boolean addPost(Post post){
        return save(post);
    }

    private boolean addPosts(List<Post> posts){
        return saveBatch(posts);
    }

    /**
     * Unit Update
     */
    private boolean updatePostById(Post post){
        return updateById(post);
    }

    /**
     * Unit Delete
     */

    private boolean delPostById(Post post){
        return removeById(post.getPostId());
    }

    private boolean delPostsByIds(List<Post> list){
        List<Integer> ids = list.stream().map(post -> {
            Integer id = post.getPostId();
            return id;
        }).collect(Collectors.toList());
        return removeByIds(ids);
    }




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

    /**
     * 查看某一岗位的所有员工
     */

    @Override
    public Result getPersonForOnePost(Post post){
        //判断
        if(post == null){
            return Result.fail("Info error");
        }

        String postName = post.getPostName();
        if(StrUtil.isBlank(postName)){
            return Result.fail("post name error");
        }
        List<Post> list = list(new QueryWrapper<Post>().eq("post_name",postName));

        List<PostVo> postVoList = list.stream().map(p -> {
            PostVo postVo = new PostVo();
            BeanUtil.copyProperties(post,postVo,false);
            postVo.setPostUsers(userMapper.selectList(new QueryWrapper<User>().eq(DATABASE_POST_ID,post.getPostId())));
            return postVo;
        }).collect(Collectors.toList());
        return Result.ok(postVoList);
    }
}
