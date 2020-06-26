package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ProjectDao {

    public static void save(Project project) {
        if (project == null) {
            System.out.println("写入数据库失败！");
            return;
        }
        Connection collection = null;
        PreparedStatement statement = null;
        String sql = "insert into project values (?, ?, ?, ?, ?, ?, ?);";
        try {
            collection = DBUtil.getConnection();
            assert collection != null;

            statement = collection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getUrl());
            statement.setString(3, project.getDescription());
            statement.setInt(4, project.getStarCount());
            statement.setInt(5, project.getForkCount());
            statement.setInt(6, project.getOppendIssueCount());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String date = dateFormat.format(System.currentTimeMillis());
            statement.setString(7, date);
            int num = statement.executeUpdate();
            if (num <= 0) {
                System.out.println("数据插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(collection, statement, null);
        }
    }

    public static List<Project> selectProjectByDate(String date) {
        List<Project> projects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select name, url, starCount, forkCount, openIssueCount " +
                "from project where date = ? order by starCount desc";

        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, date);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setName(resultSet.getString("name"));
                project.setUrl(resultSet.getString("url"));
                project.setStarCount(resultSet.getInt("starCount"));
                project.setForkCount(resultSet.getInt("forkCount"));
                project.setOppendIssueCount(resultSet.getInt("openIssueCount"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return projects;
    }

}
