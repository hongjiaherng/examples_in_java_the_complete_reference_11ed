package chapter30regexandotherpackages.rmidemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface AddServerIntf extends Remote {
    double add(double d1, double d2) throws RemoteException;
}

/**
 *  - Remote interface defines no members, but it's simply to indicate that an interface uses remote methods.
 *  - All remote method can throw a RemoteException, that's why add() includes RemoteException at the throws clause.
 */
