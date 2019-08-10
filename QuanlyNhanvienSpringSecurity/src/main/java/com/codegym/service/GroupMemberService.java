package com.codegym.service;

import com.codegym.model.GroupMembers;

public interface GroupMemberService {
    Iterable<GroupMembers> showAll();

    GroupMembers findById(Long id);

    void save(GroupMembers groupMembers);

    void delete(Long id);

    GroupMembers findAllByGroupNameContaining(String Name);
}
