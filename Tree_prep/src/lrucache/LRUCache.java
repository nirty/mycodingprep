package lrucache;

import java.util.HashMap; 

public class LRUCache { 

        /** 
         * @param args 
         */ 
        public static void main(String[] args) { 
                LRUCache cache = new LRUCache(4); 
                cache.put("1", "obj1"); 
                cache.put("2", "obj2"); 
                cache.put("3", "obj3"); 
                cache.put("1", "obj1"); 
                cache.put("3", "obj3"); 
                cache.put("4", "obj4"); 
                cache.printCache(); 
                System.out.println(cache.get("10")); 
                cache.put("5", "obj5"); 
                cache.put("6", "obj6"); 
                cache.put("7", "obj7"); 
                cache.printCache(); 
                System.out.println(cache.get("4")); 
                System.out.println(cache.get("2")); 
                cache.printCache(); 
        } 

        class Node { 
                Node prev, next; 
                Object key, obj; 
        } 

        private int size = 100; 
        private Node first = null, last = null; 
        private HashMap<Object, Node> map = null; 

        public LRUCache() { 
                map = new HashMap<Object, Node>(size); 
        } 

        public LRUCache(int size) { 
                this.size = size; 
                map = new HashMap<Object, Node>(size); 
        } 

        public void put(Object key, Object obj) { 
                Node node = map.get(key); 
                if (node == null) { 
                        if (map.size() >= size) { 
                                map.remove(last.key); 
                                removeNode(last); 
                        } 
                        node = new Node(); 
                        node.obj = obj; 
                        node.key = key; 
                } else { 
                        removeNode(node); 
                } 
                addFirst(node); 
                map.put(key, node); 
        } 

        public Object get(Object key) { 
                Node node = map.get(key); 
                if (node != null) { 
                        removeNode(node); 
                        addFirst(node); 
                        return node.obj; 
                } else { 
                        return null; 
                } 
        } 

        private void removeNode(Node node) { 
                Node prev = node.prev; 
                Node next = node.next; 
                if (prev == null && next == null) { 
                        // the only one 
                        first = null; 
                        last = null; 
                } else if (prev == null) { 
                        // the first 
                        first = next; 
                        next.prev = null; 
                } else if (next == null) { 
                        // the last 
                        last = prev; 
                        prev.next = next; 
                } else { 
                        prev.next = next; 
                        next.prev = prev; 
                } 
        } 

        private void addFirst(Node node) { 
                if (first == null || last == null) { 
                        first = node; 
                        last = node; 
                        node.next = null; 
                        node.prev = null; 
                } else { 
                        node.next = first; 
                        node.prev = null; 
                        first.prev = node; 
                        first = node; 
                } 
        } 

        public void printCache(){ 
                if(first == null){ 
                        System.out.println("Emtpy cache."); 
                } else { 
                        Node n = first; 
                        while(n != null){ 
                                System.out.print(n.key); 
                                System.out.print(" "); 
                                n = n.next; 
                        } 
                        System.out.println(); 
                } 
        } 
} 
