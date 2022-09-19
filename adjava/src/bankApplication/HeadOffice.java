package bankApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadOffice {
	public static AtomicInteger BRANCH_ID_GENERATOR = new AtomicInteger(0);
	private List<Branch> branches = new ArrayList<Branch>();

	public void createBranch(String branchId) {
		Branch branch = new Branch();
		branch.setBranchId(Integer.toString(BRANCH_ID_GENERATOR.incrementAndGet()));
		branches.add(branch);
	}

	public Branch getBranchById(String branchId) {
		for (Branch b : branches) {
			if (b.getBranchId().equals(branchId)) {
				return b;
			}
		}
		return null;
	}

	public List<Branch> getAllBranches() {
		return branches;
	}

}
