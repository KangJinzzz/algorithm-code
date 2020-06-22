package dao;


public class Project {
    //项目名称
    private String name;
    //项目的url
    private String url;
    //项目的描述
    private String description;

    //项目的数据，也是之后进行项目排名的参照数据
    private int starCount;
    private int forkCount;
    private int oppendIssueCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public int getForkCount() {
        return forkCount;
    }

    public void setForkCount(int forkCount) {
        this.forkCount = forkCount;
    }

    public int getOppendIssueCount() {
        return oppendIssueCount;
    }

    public void setOppendIssueCount(int oppendIssueCount) {
        this.oppendIssueCount = oppendIssueCount;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", starCount=" + starCount +
                ", forkCount=" + forkCount +
                ", oppendIssueCount=" + oppendIssueCount +
                '}';
    }
}
