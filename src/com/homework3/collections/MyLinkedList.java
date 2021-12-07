package com.homework3.collections;

import java.util.Iterator;

import static java.lang.reflect.Array.*;

public class MyLinkedList<E> implements ILinkedList<E> {

    private class Node<E> {
        private E element;
        private Node<E> nextNode;
        private Node<E> prevNode;

        public Node(E element){
            this.element = element;
        }

        public Node(E element,Node<E> nextNode, Node<E> prevNode){
            this.element = element;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }
    }


    private Node<E> first;
    private Node<E> last;
    private int size;

    private Node<E> getNodeByIndex(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if(index <= size/2) {
            Node<E> tmp = first;
            for(int i = 0; i< index; i++){
                tmp = tmp.getNextNode();}
            return tmp;
        } else {
            Node<E> tmp = last;
            for (int i = size - 1; i > index; i--) {
                tmp = tmp.getPrevNode();
            }
            return tmp;
        }

    }
    public void add (E element){
        if (size == 0) {
            last = new Node<>(element);
            first = last;

        } else {
            last.nextNode = new Node<>(element,null,last);
            last=last.nextNode;
        }
        size++;
    }



    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if ( size == 0 || size == 1 || size == index ) {
            add(element);
            return;
        }

        if(index == 0)
            {
                Node<E> node = new Node<>(element);
                node.setNextNode(first);
                first.setPrevNode(node);
                first = node;
                size++;
                return;

            }

                Node<E> tmp = getNodeByIndex(index);
                Node<E> node = new Node<>(element,tmp,tmp.prevNode);
                tmp.prevNode.setNextNode(node);
                tmp.setPrevNode(node);
                size++;
        }





    @Override
    public void clear() {
        Node<E> tmp = first;
        for(int i = 0; i< size-1; i++) {
            Node<E> next = tmp.nextNode;
            tmp.element=null;
            tmp.nextNode=null;
            tmp.prevNode=null;

        }
        first = last = null;
        size = 0;

    }

    @Override
    public E get(int index) {
        return getNodeByIndex(index).element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> tmp = first;
        for(int i = 0; i < size; i++) {
            if(element.equals(tmp.getElement()))
                return i;
            else
                tmp = tmp.getNextNode();
        }
        return -1;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        E result = get(index);

        if(size == 1)
        {
            this.clear();

        }

        if (index == 0){
            first = first.nextNode;
            first.prevNode = null;
            size--;
            return result;
            }

        if (index == size - 1) {

            last = last.prevNode;
            last.nextNode=null;
            size--;
            return result;
        }

        Node<E> tmp = getNodeByIndex(index);
        tmp.prevNode.setNextNode(tmp.nextNode);
        tmp.nextNode.setPrevNode(tmp.prevNode);
        size--;
        return result;
    }

        @Override
        public E set ( int index, E element){

            Node<E> tmp=getNodeByIndex(index);
            tmp.setElement(element);
            return tmp.getElement();
    }


         @Override
         public int size(){
             return size;
        }

        @Override
        public Object[] toArray () {
            Object[] res = new Object[size];

            Node<E> tmp = first;
            for(int i = 0; i < size; i++){
                res[i] = tmp.element;
                tmp = tmp.nextNode;
            }

            return res;
        }

        @Override
        public <T> T[]toArray(T[]t){
            if (t.length < size)
                t = (T[]) newInstance(t.getClass().getComponentType(), size);

            Object[] result = t;

            Node<E> tmp = first;
            for(int i = 0; i < size; i++)
            {
                tmp = tmp.nextNode;
                result[i] = tmp.element;
            }
            if (t.length > size)
                t[size] = null;

            return t;

        }






    @Override
    public Iterator<E> iterator () {
    Iterator<E> iterator = new Iterator<E>() {

        Node<E> current = first;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            E elem = current.element;
            current = current.nextNode;
            index++;
            return elem;
        }
    };

        return iterator;
}

    @Override
    public String toString() {
        String str = "My List is:  ";
        for(int i = 0; i < size; i++) {
            str += get(i);
            str += "  ";
        }
        return  str;
    }
}
