package DFS;

import java.util.*;

// MetadataServer class
class MetadataServer {
    private Map<String, String> fileToNodeMap;

    public MetadataServer() {
        fileToNodeMap = new HashMap<>();
    }

    public void addFileEntry(String filename, String storageNode) {
        fileToNodeMap.put(filename, storageNode);
    }

    public String getStorageNode(String filename) {
        return fileToNodeMap.get(filename);
    }
}

// StorageNode class
class StorageNode {
    // private String nodeId;
    private Map<String, byte[]> fileStorage;

    // public StorageNode(String nodeId) {
    // this.nodeId = nodeId;
    // fileStorage = new HashMap<>();
    // }

    public void saveFile(String filename, byte[] data) {
        fileStorage.put(filename, data);
    }

    public byte[] getFile(String filename) {
        return fileStorage.get(filename);
    }
}

// Client class
class Client {
    private MetadataServer metadataServer;

    public Client(MetadataServer metadataServer) {
        this.metadataServer = metadataServer;
    }

    public void uploadFile(String filename, byte[] data) {
        String storageNode = metadataServer.getStorageNode(filename);
        System.out.println("Uploading " + filename + " to storage node: " + storageNode);
        // In a real implementation, you would save the file to the storage node
        // For simplicity, not implemented here
    }

    public byte[] downloadFile(String filename) {
        String storageNode = metadataServer.getStorageNode(filename);
        System.out.println("Downloading " + filename + " from storage node: " + storageNode);
        // In a real implementation, you would retrieve the file from the storage node
        // For simplicity, returning an empty byte array
        return new byte[0];
    }
}

// Main class
public class DFS1 {
    public static void main(String[] args) {
        // Create MetadataServer instance
        MetadataServer metadataServer = new MetadataServer();

        // Create StorageNode instances
        // StorageNode storageNode1 = new StorageNode("Node1");
        // StorageNode storageNode2 = new StorageNode("Node2");

        // Add file entries to MetadataServer
        metadataServer.addFileEntry("file1.txt", "Node1");
        metadataServer.addFileEntry("file2.txt", "Node2");

        // Create Client instance
        Client client = new Client(metadataServer);

        // Example usage:
        // Upload file1.txt (assuming empty byte array for data)
        client.uploadFile("file1.txt", new byte[0]);

        // Download file2.txt (not handling the returned byte array in this example)
        client.downloadFile("file2.txt");
    }
}
