package com.rafiatu.processor;

import java.util.*;

class CustomObject {
    private int id;
    private String name;

    public CustomObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomObject that = (CustomObject) obj;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CustomObject{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}



public class DataManagementModule {

    public static void main(String[] args) {
        List<CustomObject> collection = new ArrayList<>();

        // Create
        collection.add(new CustomObject(1, "Alice"));
        collection.add(new CustomObject(2, "Bob"));

        // Read
        System.out.println("Collection: " + collection);

        // Update
        collection.set(1, new CustomObject(2, "Charlie"));
        System.out.println("Updated Collection: " + collection);

        // Delete
        collection.remove(0);
        System.out.println("Collection after deletion: " + collection);
    }
}
