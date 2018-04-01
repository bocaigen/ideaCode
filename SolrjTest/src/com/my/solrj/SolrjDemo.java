package com.my.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/8/27.
 */
public class SolrjDemo {

    public static void main(String[] args) throws Exception {
//        insertTest();
//        deleteTest();
//        listTest();
//        selectTest();
        selectSOTest();
    }


    public static void insertTest() throws Exception {
        //创建HttpSolrServer对象，和solr服务器建立连接
        SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8081/solr");
        //创建SolrInputDocument对象，来添加域
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id","002");
        doc.addField("name","大师兄");
        //把doc 对象添加到solr索引库中
        solrServer.add(doc);
        //提交
        solrServer.commit();

    }
    public static void deleteTest() throws Exception {
        //创建HttpSolrServer对象，和solr服务器建立连接
        SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8081/solr");
        //根据id删除
        solrServer.deleteById("001");
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        solrServer.deleteById(list);
        //删除所有
        //solrServer.deleteByQuery("*:*");
        //提交
        solrServer.commit();

    }

    /**
     * solr 简单查询
     * @throws Exception
     */
    public static void selectTest()throws Exception{
        //创建HttpSolrServer对象，和solr服务器建立连接
        SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8081/solr");
        //创建搜索对象
        SolrQuery query = new SolrQuery();
        //添加搜索调件
        query.setQuery("*:*");
        //发起搜索请求
        QueryResponse response = solrServer.query(query);
        //处理搜索结果
        SolrDocumentList results = response.getResults();

        System.out.println("搜索结果总数为："+results.getNumFound());

        for(SolrDocument doc:results){
            System.out.println("=====================");
            System.out.println("product_name:"+doc.get("product_name"));
        }


    }
    /**
     * solr 复杂查询
     * @throws Exception
     */
    public static void selectSOTest()throws Exception {
        //创建HttpSolrServer对象，和solr服务器建立连接
        SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8081/solr");

        //设置查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件（主条件）
        query.setQuery("家天下");
        //设置默认查询域
        query.set("df","product_name");
        //添加过滤条件
        query.addFilterQuery("product_price:[0 TO 10]");
        query.addFilterQuery("product_catalog_name:幽默杂货");

        //设置排序
        query.setSort("product_price", SolrQuery.ORDER.desc);
        //设置分页
        query.setStart(0);
        query.setRows(5);

        //设置高亮
        query.setHighlight(true);
        //添加高亮域
        query.addHighlightField("product_name");
        //设置高亮前缀和后缀
        query.setHighlightSimplePre("<span style='color:red'>");
        query.setHighlightSimplePost("</span>");

        //执行查询
        QueryResponse response = solrServer.query(query);
        //获取查询结果
        SolrDocumentList results = response.getResults();
        //查询结果数据总数量
        System.out.println("总数量为："+results.getNumFound());

        //获的高亮集合
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

        //遍历查询结果
        for (SolrDocument doc:results){
            String productName = "";
            List<String> list = highlighting.get(doc.get("id")).get("product_name");

            //如果有高亮
            if(list!=null&&list.size()>0){
                productName = list.get(0);
            }else{
                productName = (String) doc.get("product_name");
            }
            System.out.println("id："+doc.get("id")+"------"+"name："+productName+"------"+"price："+doc.get("product_price"));

    }
    }
    public static void listTest(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
//        System.out.println(list);
        list.add(0,"5");
        list.set(2,"aaa");
        System.out.println(list);
    }
}
