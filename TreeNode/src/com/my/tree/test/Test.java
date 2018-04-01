package com.my.tree.test;

import com.my.tree.Node;
import com.my.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class Test {

    public static void main(String[] args){
        List<Node> nodes = new ArrayList<Node>();

        Node node1 = new Node();
        node1.setId(1);
        node1.setName("node1");
        node1.setParentId(null);
        node1.setLink("eee");
        nodes.add(node1);

        Node node11 = new Node();
        node11.setId(11);
        node11.setName("node11");
        node11.setParentId(1);
        node11.setLink("eee");
        nodes.add(node11);

        Node node111 = new Node();
        node111.setId(111);
        node111.setName("node111");
        node111.setParentId(11);
        node111.setLink("eee");
        nodes.add(node111);

        Node node12 = new Node();
        node12.setId(12);
        node12.setName("node12");
        node12.setParentId(1);
        node12.setLink("eee");
        nodes.add(node12);

        Node node2 = new Node();
        node2.setId(2);
        node2.setName("node2");
        node2.setParentId(null);
        node2.setLink("eee");
        nodes.add(node2);

        Node node21 = new Node();
        node21.setId(21);
        node21.setName("node21");
        node21.setParentId(2);
        node21.setLink("eee");
        nodes.add(node21);

        Node node3 = new Node();
        node3.setId(3);
        node3.setName("node3");
        node3.setParentId(null);
        node3.setLink("eee");
        nodes.add(node3);

        Tree tree = new Tree(nodes);
        System.out.println(tree.buildTree());

    }
}
