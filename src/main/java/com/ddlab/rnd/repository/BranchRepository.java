package com.ddlab.rnd.repository;

import org.springframework.data.repository.Repository;

import com.ddlab.rnd.entity.Branch;
import com.ddlab.rnd.view.BranchRecord;

@org.springframework.stereotype.Repository
public interface BranchRepository extends Repository<Branch, Long> {

	BranchRecord getBranchDetailByBranchCode(String branchCode);
}
