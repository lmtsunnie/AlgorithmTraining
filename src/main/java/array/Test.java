package array;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class Test {
        public static void main(String[] args) {
            System.out.println(new Date());
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println(localHost);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());


        }

}
/*ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.remove(1);
        linkedList.add(1);
        linkedList.add(2);*/


