package crawler;

import dao.Project;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawler {

    private static String URL = "https://github.com/akullpp/awesome-java/blob/master/README.md";
    
    public static void main(String[] args) throws IOException {
        Crawler crawler = new Crawler();
        String html = crawler.getHtmlPage(URL);
        List<Project> projects = crawler.getProjects(html);
        System.out.println(projects);
        System.out.println(projects.size());
    }

    //通过 OkHttp 获取指定 url 的网页内容
    public String getHtmlPage(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

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
}
