package crawler;

import dao.Project;
import dao.ProjectDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCrawler extends Crawler{


    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        ThreadCrawler crawler = new ThreadCrawler();
        String url = "https://github.com/akullpp/awesome-java/blob/master/README.md";
        //1.获取网页内容
        System.out.println("开始读取网页内容......");
        String html = crawler.getHtmlPage(url);
        //2.获取项目列表
        System.out.println("开始获取项目列表......");
        List<Project> projects = crawler.getProjects(html);
        //3.调用 GitHub API 解析项目信息
        long time = System.currentTimeMillis();
        System.out.println("开始解析项目......");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        // Future表示一个可能还没有完成的异步任务的结果
        List<Future<?>> futureList = new ArrayList<Future<?>>();
        //将所有任务添加到线程池的阻塞对列中,开始执行任务
        for (Project project : projects) {
            Future<?> task = executorService.submit(new CrawlerTask(crawler, project));
            futureList.add(task);
        }
        // 这里调用 Future 对象的 get() 方法使代码阻塞，直到所有任务都完成才能继续执行下满的代码
        for (Future<?> task : futureList) {
            try {
                task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //处理完所有任务关闭线程池
        executorService.shutdown();
        long analyzeTime = System.currentTimeMillis() - time;
        //4.将所有的任务信息保存到数据库
        for (Project project : projects) {
            ProjectDao.save(project);
        }
        long allTime = System.currentTimeMillis() - startTime;
        System.out.println("调用 API 解析项目时间：" + analyzeTime + "ms");
        System.out.println("运行程序总时间：" + allTime + "ms");


    }


    static class CrawlerTask implements Runnable{
        private Crawler crawler;
        private Project project;

        public CrawlerTask(Crawler crawler, Project project) {
            this.crawler = crawler;
            this.project = project;
        }

        public void run() {
            try {
                try {
                    crawler.setResponInfo(project);
                    System.out.println("crawling " + project.getName() + " done...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
