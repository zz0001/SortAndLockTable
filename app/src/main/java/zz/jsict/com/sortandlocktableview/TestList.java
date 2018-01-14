package zz.jsict.com.sortandlocktableview;

import java.util.List;

/**
 * Created by hp on 2018/1/12.
 */

public class TestList {
    private List<TestBean> testBeanList;

    public TestList(List<TestBean> testBeanList) {
        this.testBeanList = testBeanList;
    }

    public List<TestBean> getTestBeanList() {
        return testBeanList;
    }

    public void setTestBeanList(List<TestBean> testBeanList) {
        this.testBeanList = testBeanList;
    }
}
