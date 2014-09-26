//package my_shoot;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.KeyValue;
//import org.apache.hadoop.hbase.client.Get;
//import org.apache.hadoop.hbase.client.HTable;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.io.IOException;
//
///**
// * chenyehui
// */
//public class HbaseShoot {
//    private static HBaseConfiguration hbaseConfig = null;
//    private static final String tableName = "test";
//    private static final String ROW = "row";
//
//    static {
//        Configuration config = new Configuration();
//        config.set("hbase.zookeeper.quorum", "192.168.10.149,192.168.10.44,192.168.10.49");
//        config.set("hbase.zookeeper.property.clientPort", "2181");
//        hbaseConfig = new HBaseConfiguration(config);
//    }
//
//    public static void selectByRowKey(String tablename, String rowKey) throws IOException {
//        HTable table = new HTable(hbaseConfig, tablename);
//        Get g = new Get(Bytes.toBytes(rowKey));
//        Result r = table.get(g);
//        for (KeyValue kv : r.raw()) {
//           // System.out.println("column: " + new String(kv.getColumn()));
//            System.out.println("value: " + new String(kv.getValue()));
//        }
//    }
//
//    public static void selectByRowKeyColumn(String tablename, String rowKey, String column) throws IOException {
////        HTable table = new HTable(hbaseConfig, tablename);
////        Get g = new Get(Bytes.toBytes(rowKey));
////        g.addColumn(Bytes.toBytes(column));
////        Result r = table.get(g);
////        for (KeyValue kv : r.raw()) {
////           // System.out.println("column: " + new String(kv.getColumn()));
////            System.out.println("value: " + new String(kv.getValue()));
//        }
//
//    public static void main(String[] args) {
//
//    }
//}
