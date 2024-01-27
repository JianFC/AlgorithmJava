package AcWing.LeetCode;        //71. 简化路径

class Solution {    //栈（实现树上递归处理思想）+模拟+思维题
    public String simplifyPath(String path) {
        String res = "", name = ""; //name表示当前处理的目录名，res既当栈用，也存储结果
        //统一格式，方便处理
        if (path.charAt(path.length() - 1) != '/') path += '/';
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/') name += path.charAt(i);  //更新name
            else {  //path[i] == '/' name分割完，开始处理name，三种情况
                if (name.equals("..")) {     //返回上一级，res出栈栈顶元素
                    //删除res栈顶目录
                    while (res.length() > 0 && res.charAt(res.length() - 1) != '/')
                        res = res.substring(0, res.length() - 1);
                    //弹掉栈顶目录前一个'/'
                    if (res.length() > 0) res = res.substring(0, res.length() - 1);
                }
                else if (name.equals(".") || name.length() == 0);   //不做任何操作
                else if (!name.equals(".") && name.length() != 0) { //将name加入答案
                    res += "/" + name;  //更新res
                }

                name = "";      //清空name
            }
        }

        if (res.length() == 0) res += '/';  //当res中没有元素时
        return res;
    }
}