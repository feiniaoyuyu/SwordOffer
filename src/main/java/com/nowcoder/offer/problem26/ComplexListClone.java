package com.nowcoder.offer.problem26;

/**
 * Problem 26
 * 复杂链表的复制
 *
 * @author hztaoran
 */
public class ComplexListClone {

    public ComplexListNode cloneList(ComplexListNode head) {
        copyNode(head);
        processSibling(head);

        return split(head);
    }

    private void copyNode(ComplexListNode head) {
        if (null == head) {
            return;
        }
        ComplexListNode p = head;
        while (null != p) {
            ComplexListNode clonedNode = new ComplexListNode();
            clonedNode.data = p.data;
            clonedNode.next = p.next;
            clonedNode.sibling = null;
            p.next = clonedNode;
            p = clonedNode.next;
        }
    }

    private void processSibling(ComplexListNode head) {
        if (null == head) {
            return;
        }
        ComplexListNode p = head;
        while (null != p) {
            ComplexListNode clonedNode = p.next;
            if (null != p.sibling) {
                clonedNode.sibling = p.sibling.next;
            }
            p = clonedNode.next;
        }
    }

    private ComplexListNode split(ComplexListNode head) {
        ComplexListNode p = head;
        ComplexListNode cloneHead = null;
        ComplexListNode pClone = null;
        if (null != p) {
            pClone = cloneHead = p.next;
            p.next = pClone.next;
            p = p.next;
        }
        while (null != p) {
            pClone.next = p.next;
            pClone = pClone.next;
            p.next = pClone.next;
            p = p.next;
        }

        return cloneHead;
    }
}