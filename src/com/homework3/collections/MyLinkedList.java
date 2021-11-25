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

    public void add (E element){
        if (isEmpty()) {
            last = new Node<>(element);
            first = last;

        } else if (size == 1) {
            last = new Node<>(element);
            first.setNextNode(last);
            last.setPrevNode(first);

        } else {
            Node<E> node = new Node<>(element);
            last.setNextNode(node);
            node.setPrevNode(last);
            last = node;
        }
        size++;
    }



    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size)
            System.out.println("Index out of range");

        if ( isEmpty() || size == 1 || size == index )
            add(element);
        else {
            if(index == 0)
            {
                Node<E> node = new Node<>(element);
                node.setNextNode(first);
                first.setPrevNode(node);
                first = node;

            } else {
                if(index <= size/2)
                {
                Node<E> tmp = first;
                for(int i = 0; i< index; i++) {
                    tmp = tmp.getNextNode();
                }
                Node<E> node = new Node<>(element,tmp,tmp.getPrevNode());
                    tmp.getPrevNode().setNextNode(node);

                    tmp.setPrevNode(node);
                } else {
                    Node<E> tmp = last;
                    for(int i = size - 1; i > index; i--) {
                        tmp = tmp.getPrevNode();
                    }
                    Node<E> node = new Node<>(element,tmp,tmp.getPrevNode());
                    tmp.getPrevNode().setNextNode(node);

                    tmp.setPrevNode(node);

                }

            }
            size++;
        }


    }


    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;

    }

    @Override
    public E get(int index) {
        Node<E> tmp;
        if(index <= size/2) {
            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNextNode();
            }
        } else {
            tmp = last;
            for(int i = size - 1; i > index; i--) {
                tmp = tmp.getPrevNode();
            }

        }

        return tmp.getElement();
    }

    @Override
    public int indexOf(E element) {
        Node<E> tmp = first;
        for(int i = 0; i < getSize(); i++) {
            if(element.equals(tmp.getElement()))
                return i;
            else
                tmp = tmp.getNextNode();
        }
        return -1;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index > size)
            System.out.println("Index out of range");

        if (getSize() == 0)
            System.out.println("List is empty");

        E result;

        if(getSize() == 1)
        {
            result = last.getElement();
            first = null;
            last = null;



        } else {

            if (index == 0){

                Node<E> tmp = first.getNextNode();
                result = first.getElement();
                tmp.setPrevNode(null);
                first.setNextNode(null);
                first = tmp;


            } else {

                if (index == getSize() - 1) {
                    Node<E> tmp = last.getPrevNode();
                    result = last.getElement();
                    tmp.setNextNode(null);
                    last.setPrevNode(null);
                    last = tmp;

                } else {
                    if(index <= size/2) {
                        Node<E> tmp = first;
                        for (int i = 0; i < index; i++) {
                            tmp = tmp.getNextNode();
                        }
                        result = tmp.getElement();
                        tmp.getPrevNode().setNextNode(tmp.getNextNode());
                        tmp.getNextNode().setPrevNode(tmp.getPrevNode());
                    } else {
                        Node<E> tmp = last;
                        for(int i = size - 1; i > index; i--) {
                            tmp = tmp.getPrevNode();
                        }
                        result = tmp.getElement();
                        tmp.getPrevNode().setNextNode(tmp.getNextNode());
                        tmp.getNextNode().setPrevNode(tmp.getPrevNode());

                    }
                }
            }

        }

        size--;
        return result;
    }

        @Override
        public E set ( int index, E element){
            if (index < 0 || index > size)
                System.out.println("Index out of range");
            Node<E> tmp;
            if(index <= size/2) {
                tmp = first;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.getNextNode();
                }
            } else{
                tmp = last;
                for(int i = size - 1; i > index; i--) {
                    tmp = tmp.getPrevNode();
                }

            }

            tmp.setElement(element);

            return tmp.getElement();
    }

        @Override
        public int size () {
            return getSize();
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
        public <T > T[]toArray(T[]t){
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

        public int getSize () {
            return size;
        }


        public boolean isEmpty() {

            return size == 0;
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
        for(int i = 0; i < getSize(); i++) {
            str += get(i);
            str += "  ";
        }
        return  str;
    }
}
