package chapter30regexandotherpackages.rmidemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

class AddServer {
    public static void main(String[] args) {

        try {
            AddServerImpl addServerImpl = new AddServerImpl();
            Naming.rebind("AddServer", addServerImpl); // Rebind the "AddServer" name to the remote object (addServerImpl).
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Exception: " + e);
        }
    }
}
