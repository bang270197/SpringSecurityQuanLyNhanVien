package com.codegym.service.Impl;

import com.codegym.model.GroupMembers;
import com.codegym.repository.GroupMemberRepository;
import com.codegym.service.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.ref.PhantomReference;

public class GroupMemberServiceImpl implements GroupMemberService {
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @Override
    public Iterable<GroupMembers> showAll() {
        return groupMemberRepository.findAll();
    }

    @Override
    public GroupMembers findById(Long id) {
        return groupMemberRepository.findOne(id);
    }

    @Override
    public void save(GroupMembers groupMembers) {
        groupMemberRepository.save(groupMembers);
    }

    @Override
    public void delete(Long id) {
        groupMemberRepository.delete(id);
    }

    @Override
    public GroupMembers findAllByGroupNameContaining(String Name) {
        return groupMemberRepository.findAllByGroupNameContaining(Name);
    }


}
