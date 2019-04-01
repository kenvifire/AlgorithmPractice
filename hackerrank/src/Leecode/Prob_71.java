package Leecode;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob_71 {
    public String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<>();
        String paths[] = path.split("/");
        for (String p : paths) {
            if(p.equals(".") || p.equals("")) {
               //do nothing
            } else if(p.equals("..")) {
                if(!pathStack.isEmpty()) pathStack.pop();
            }else {
                pathStack.push(p);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        List<String> pathList = new ArrayList<>(pathStack);
        for (int i = 0; i < pathList.size(); i++) {
            sb.append(pathList.get(i));
            sb.append("/");
        }
        if(pathList.size() > 0)  {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Prob_71 prob = new Prob_71();
        AssertUtils.equals("/home", prob.simplifyPath("/home/"));
        AssertUtils.equals("/", prob.simplifyPath("/../"));
        AssertUtils.equals("/home/foo", prob.simplifyPath("/home//foo/"));
        AssertUtils.equals("/c", prob.simplifyPath("/a/./b/../../c/"));
        AssertUtils.equals("/c", prob.simplifyPath("/a/../../b/../c//.//"));
        AssertUtils.equals("/a/b/c", prob.simplifyPath("/a//b////c/d//././/.."));
    }
}
