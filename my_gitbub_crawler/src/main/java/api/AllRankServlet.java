package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Project;
import dao.ProjectDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllRankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应体的数据类型
        resp.setContentType("application/json; charset=utf-8");
        //根据发送请求的参数获取值
        String date = req.getParameter("date");
        //从数据库中获取项目列表
        List<Project> projects = ProjectDao.selectProjectByDate(date);
        //将所有的项目转成 json 格式
        Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(projects);
        //将有所项目用 json 的格式返回给客户端
        resp.getWriter().write(jsonString);

    }
}
