package trees;

import java.util.List;
import java.util.ArrayList;

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<List<Integer>> paths = new ArrayList<List<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		pathSumHelper(root, sum, path, paths);

		return paths;
	}

	public void pathSumHelper(TreeNode n, int sum, ArrayList<Integer> path, ArrayList<List<Integer>> paths) {
		if (n == null) return;

		path.add(n.val);

		if (n.left == null && n.right == null && n.val == sum) {
			paths.add((ArrayList<Integer>) path.clone());
		} else {
			sum -= n.val;
			pathSumHelper(n.left, sum, path, paths);
			pathSumHelper(n.right, sum, path, paths);
		}

		path.remove(path.size() - 1);
	}
}
