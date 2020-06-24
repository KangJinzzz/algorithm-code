package crawler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.Project;
import dao.ProjectDao;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crawler {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        Crawler crawler = new Crawler();
        long startTime = System.currentTimeMillis();
        //1.获取网页的内容
        Long endTime = System.currentTimeMillis();
        System.out.println("开始读取网页内容......");
        String URL = "https://github.com/akullpp/awesome-java/blob/master/README.md";
        String html = crawler.getHtmlPage(URL);
        long time1 = System.currentTimeMillis() - endTime;
        endTime = System.currentTimeMillis();
        //2.获取项目列表
        System.out.println("开始获取项目列表......");
        List<Project> projects = crawler.getProjects(html);
        long time2 = System.currentTimeMillis() - endTime;
        endTime = System.currentTimeMillis();
        //3.项目解析
        System.out.println("开始解析项目......");
        for (Project project : projects) {
            try {
                crawler.setResponInfo(project);
                System.out.println(project.getName() + "解析完成...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long time3 = System.currentTimeMillis() - endTime;
        endTime = System.currentTimeMillis();
        //4.项目保存（存储到数据库）
        System.out.println("开始保存项目信息......");
        for (Project project : projects) {
            ProjectDao.save(project);
        }
        long time4 = System.currentTimeMillis() - endTime;
        endTime = System.currentTimeMillis();
        System.out.println("读取网页时间：" + time1 + "ms");
        System.out.println("获取项目列表时间：" + time2 + "ms");
        System.out.println("解析项目时间：" + time3 + "ms");
        System.out.println("保存项目信息时间：" + time4 + "ms");
        System.out.println("项目运行总时间：" + (endTime - startTime) + "ms");
    }

    //通过 OkHttp 获取指定 url 的网页内容
    public String getHtmlPage(String url) throws IOException {


        Request request = new Request.Builder().url(url).build();
        //创建一个Call对象（这个对象负责进行一次网络访问操作）
        Call call = okHttpClient.newCall(request);
        //发送请求获取响应内容
        Response response = call.execute();
        //判断是否获取成功
        if (!response.isSuccessful()) {
            System.out.println("获取页面数据失败！");
            return null;
        }
        assert response.body() != null;
        return response.body().string();
    }

    // 通过 Jsoup 来分析获得的网页的结构
    public List<Project> getProjects(String html) {
        ArrayList<Project> result = new ArrayList<Project>();

        Document document = Jsoup.parse(html);

        Elements lis = document.getElementsByTag("li");
        for (Element li : lis) {
//            System.out.println(li);
//            System.out.println("==========================");
            Elements links = li.getElementsByTag("a");
            // li标签里没有a标签，说明里面没有项目，跳过
            if (links.size() == 0) {
                continue;
            }
            Element link = links.get(0);
            // 通过属性获取内容
            String url = link.attr("href");
            //不是github中的项目直接省略
            if (!url.startsWith("https://github.com")) {
                continue;
            }
            String name = link.text();
            String description = li.text();
            //可以发现项目名与项目描述相同的，基本不是正式的项目，
            // 比如 about 和一些动态生成的代码
            if (name.equals(description)) {
                continue;
            }
            Project project = new Project();
            project.setName(name);
            project.setUrl(url);
            project.setDescription(description);
            result.add(project);
        }
        return result;
    }

    //通过 github API (https://api.github.com/repos/doov-io/doov)获取每个项目的 starCount, forkCount....
    //使用 OkHttp 给指定的项目发送请求
    private void setResponInfo(Project project) throws IOException {

        String proName = getProjectName(project.getUrl());
        String url = "https://api.github.com/repos/" + proName;
        //通过 header() 方法将验证的身份信息存储在请求头中,设置身份信息
        String PASSWORD = "kjw19971020";
        String USERNAME = "Kangzzz";
        String credential = Credentials.basic(USERNAME, PASSWORD);
        Request request = new Request.Builder().url(url).header("Authorization", credential).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        //解析获取到的 json 格式的数据转化成哈希表的形式，从中提取 starCount 的信息并设置到对应 project 中
        if (!response.isSuccessful()) {
            System.out.println("获取项目信息失败：" + project.getUrl());
        }
        praseProInfo(response.body().string(), project);
    }



    //获取项目的 用户名/项目名，如 doov-io/doov
    private String getProjectName(String url) {
        int lastOneIndex = url.lastIndexOf("/");
        int lastTwoIndex = url.lastIndexOf("/", lastOneIndex - 1);
        if (lastOneIndex == -1 || lastTwoIndex == -1) {
            System.out.println("非法项目，无法获取项目名称: url = " + url);
            return null;
        }
        return url.substring(lastTwoIndex + 1);
    }

    /**
     *
     * @param jsonString    将对应项目转换成的 json 数据，之后将 jsonString 转化成 HashMap，在哈希表中查找 starCount, forkCount, openIssueCount
     * @param project       将对应的 starCount, forkCount, openIssueCount 设置到 project 中
     */
    private void praseProInfo(String jsonString, Project project) {
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> hashMap = gson.fromJson(jsonString, type);
        Double starCount = (Double)hashMap.get("stargazers_count");
        project.setStarCount(starCount.intValue());
        Double forkCount = (Double) hashMap.get("forks_count");
        project.setForkCount(forkCount.intValue());
        Double openIssueCount = (Double) hashMap.get("open_issues_count");
        project.setOppendIssueCount(openIssueCount.intValue());
    }

}
