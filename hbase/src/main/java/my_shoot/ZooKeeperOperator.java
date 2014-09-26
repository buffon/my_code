/**
 * ZooKeeperOperator.java
 * 版权所有(C) 2013 
 * 创建:cuiran 2013-01-16 15:03:40
 */
package my_shoot;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.KeeperException;

/**
 * TODO
 *
 * @author cuiran
 * @version TODO
 */
public class ZooKeeperOperator extends ZkConnect {

    private static Log log = LogFactory.getLog(ZooKeeperOperator.class.getName());

    /**
     * <b>function:</b>获取节点信息
     *
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     * @author cuiran
     * @createDate 2013-01-16 15:17:22
     */
    public void getChild(String path) throws KeeperException, InterruptedException {
        try {
            List<String> list = this.zooKeeper.getChildren(path, false);
            if (list.isEmpty()) {
                System.out.println(path + "中没有节点");
            } else {
                log.debug(path + "中存在节点");
                for (String child : list) {
                    System.out.println("节点为：" + child);
                }
            }
        } catch (KeeperException.NoNodeException e) {
            throw e;

        }
    }

    public byte[] getData(String path) throws KeeperException, InterruptedException {
        return this.zooKeeper.getData(path, false, null);
    }

    public static void main(String[] args) {
        try {
            ZooKeeperOperator zkoperator = new ZooKeeperOperator();
            zkoperator.connect("172.16.206.135");

            byte[] data = new byte[]{'a', 'b', 'c', 'd'};

//	            zkoperator.create("/root",null);
//	            System.out.println(Arrays.toString(zkoperator.getData("/root")));
//	               
//	            zkoperator.create("/root/child1",data);   
//	            System.out.println(Arrays.toString(zkoperator.getData("/root/child1")));   
//	               
//	            zkoperator.create("/root/child2",data);   
//	            System.out.println(Arrays.toString(zkoperator.getData("/root/child2")));   

//            String zktest = "ZooKeeper的Java API测试";
//            zkoperator.create("/root/child3", zktest.getBytes());
            System.out.println("获取设置的信息：" + new String(zkoperator.getData("/root/child3")));

            System.out.println("节点孩子信息:");
            zkoperator.getChild("/root");

            zkoperator.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
