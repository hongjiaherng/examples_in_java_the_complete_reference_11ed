package chapter30regexandotherpackages.rmidemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

class AddClient {
    public static void main(String[] args) {
        try {
            // rmi protocol
            String addServerURL = "rmi://" + args[0] + "/AddServer";

            // Returns a reference for the remote object associated with the string (addServerURL).
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);

            System.out.println("The first number is: " + args[1]);
            double d1 = Double.parseDouble(args[1]);

            System.out.println("The second number is: " + args[2]);
            double d2 = Double.parseDouble(args[2]);

            System.out.println("The sum is: " + addServerIntf.add(d1, d2));

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
