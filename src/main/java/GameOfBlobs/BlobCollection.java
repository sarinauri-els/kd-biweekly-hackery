package GameOfBlobs;

import java.util.ArrayList;
import java.util.List;

public class BlobCollection {
    private List<Blob> blobs;

    public BlobCollection() {
        this.blobs = new ArrayList<Blob>();
    }

    public void addBlob(int x, int y, int size) {
        this.blobs.add(new Blob(x, y, size));
    }

    public void addBlob(Blob blob) {
        this.blobs.add(blob);
    }

    public List<Blob> getBlobs() {
        return this.blobs;
    }

    public int getCollectionSize() {
        return blobs.size();
    }

    public boolean allSameSize() {
        List<Integer> sizes = new ArrayList<>();
        for (Blob blob : this.blobs) {
            sizes.add(blob.getSize());
        }
        return sizes.stream().distinct().count() == 1;
    }

    public void clear() {
        this.blobs.clear();
    }

    public void mergeBlobs(Blob blob, Blob mergeBlob) {
        blob.setSize(blob.getSize()+ mergeBlob.getSize());
        blobs.remove(mergeBlob);
    }

    public BlobCollection clone() {
        BlobCollection clonedCollection = new BlobCollection();
        for (Blob blob : blobs) {
            clonedCollection.addBlob(blob.clone());
        }
        return clonedCollection;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (Blob blob : this.blobs) {
            builder.append(blob.toString());
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
