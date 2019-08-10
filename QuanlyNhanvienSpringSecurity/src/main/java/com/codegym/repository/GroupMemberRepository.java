package com.codegym.repository;

import com.codegym.model.GroupMembers;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupMemberRepository extends PagingAndSortingRepository<GroupMembers,Long> {
    GroupMembers findAllByGroupNameContaining(String Name);
}
