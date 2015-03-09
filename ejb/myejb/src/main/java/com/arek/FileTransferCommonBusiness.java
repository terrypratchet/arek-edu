package com.arek;

import javax.ejb.Remote;

@Remote
public interface FileTransferCommonBusiness {
	/**
	* Makes a directory of the specified name
	*
	* @throws IllegalStateException If the client connection has not been
	initialized
	*/
	void mkdir(String directory) throws IllegalStateException;
	/**
	* Changes into the named directory
	*
	* @param directory
	* @throws IllegalStateException If the client connection has not been
	initialized
	*/
	void cd(String directory) throws IllegalStateException;
	/**
	* Obtains the name of the current working directory
	*
	* @return
	* @throws IllegalStateException If the client connection has not been
	initialized
	*/
	String pwd() throws IllegalStateException;
	/**
	* Denotes that the client is done using this service; flushes
	* any pending operations and does all appropriate cleanup. If
	* already disconnected, this is a no-op.
	*/
	void disconnect();
	/**
	* Opens the underlying connections to the target FTP Server,
	* performs any other tasks required before commands may be sent
	* (ie. login, etc)
	*
	* @throws IllegalStateException If already initialized/connected
	*/
	void connect() throws IllegalStateException;
}
