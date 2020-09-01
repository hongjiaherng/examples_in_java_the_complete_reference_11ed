package chapter30regexandotherpackages.rmidemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {

    public AddServerImpl() throws RemoteException {}

    @Override
    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }
}

/**
 *  UnicastRemoteObject -> provides functionality that is needed to make objects available from remote machines.
 */
