package com.example;

/**
 * @implNote 参考文档：https://deerchao.cn/tutorials/regex/regex.htm#lookaround
 * @author Fatal
 * @date 2020/7/10 12:15
 */
public class RegexpTests {

    public static void main(String[] args) {
//        rewriteResponseHeaderRegexpTest();
        rewritePathRegexpTest();
    }

    /**
     * [^&]：表示除 & 之外的任何字符。
     * [^&]+：匹配所有字符，以 & 为结束标志。
     */
    private static void rewriteResponseHeaderRegexpTest() {
        String value = "/42?user=ford&password=omg!what33&flag=true";
        String regexp1 = "password=[^&]+";      // & 为结束标志
        String regexp2 = "password=[^!]+";      // ! 为结束标志
        String regexp3 = "password=[^0-9]+";        // 阿拉伯数字为结束标志
        String replacement = "password=***";
        System.out.println(value.replaceAll(regexp1, replacement));
        System.out.println(value.replaceAll(regexp2, replacement));
        System.out.println(value.replaceAll(regexp3, replacement));
    }

    /**
     * /red(?<segment>/?.*)
     * (pattern)：匹配 pattern 并捕获匹配的子表达式。
     * (?<name>exp)：匹配 exp，并将捕获的文本放在名称为 name 的分组里。
     * (?<segment>/?.*)：匹配 /?.*，并将捕获的文本放在名称为 segment 的分组里，可以使用 ${segment} 取出捕捉的文本。
     */
    private static void rewritePathRegexpTest() {
        String path = "/red/blue/fatal";
        String path1 = "/redblue/fatal";
        String regexp = "/red(?<segment>/?.*)";
        String replacement = "$\\{segment}";
        replacement = replacement.replace("$\\", "$");
        System.out.println(path.replaceAll(regexp, replacement));
        System.out.println(path1.replaceAll(regexp, replacement));
    }

}
