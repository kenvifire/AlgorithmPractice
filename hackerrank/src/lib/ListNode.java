package lib;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;

        sb.append('[');
        while (p.next != null) {
            sb.append(String.valueOf(p.val)).append(',');
            p = p.next;
        }

        sb.append(String.valueOf(p.val));
        sb.append(']');
        return sb.toString();
    }
}
