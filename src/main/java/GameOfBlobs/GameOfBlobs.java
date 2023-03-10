package GameOfBlobs;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfBlobs {
    private BlobCollection blobCollection;

    public GameOfBlobs() {
        this.blobCollection = new BlobCollection();
    }

    public void start(String inputFile) {
//        System.out.println("STARTING GAME OF BLOBS");
//        System.out.println("CREATING BLOBS FROM FILE");
        createBlobsFromFile(inputFile);
//
//        System.out.println("STARTING BLOBS ARE: " + this.blobCollection.toString());
//
//        int moves = countMovesToNextBlob(this.blobCollection.getBlobs().get(0), this.blobCollection.getBlobs().get(1));
//        System.out.println("NUMBER OF MOVES TO NEXT BLOB: " + moves);
//
////        Blob closestBlob = findClosestBlob(this.blobCollection.getBlobs().get(0));
////        System.out.println();
//        System.out.println("");
//
//        for (Blob blob : this.blobCollection.getBlobs()) {
//            Blob closestBlob = findClosestBlob(blob);
//            System.out.println("The closest blob to " + blob + " is " + closestBlob);
//        }

        findClosestBlob(this.blobCollection.getBlobs().get(1));

        // ----------------------------------------------------------------

//        BlobCollection nextMoveCollection = new BlobCollection();

//        while (!isGameOver()) {
//            for (Blob blob : this.blobCollection.getBlobs()) {
//                Blob closestBlob = findClosestBlob(blob);
//                nextMoveCollection.addBlob(findNextMove(blob, closestBlob));
//            }
//            this.blobCollection.clear();
//            this.blobCollection = nextMoveCollection.clone();
//            nextMoveCollection.clear();
//            eatPrey();
//        }

//        System.out.println("THE WINNERS ARE: " + this.blobCollection);
    }

    private boolean isGameOver() {
        return this.blobCollection.getCollectionSize() == 1 | this.blobCollection.allSameSize();
    }

    private void eatPrey() {
        for (Blob blob : this.blobCollection.getBlobs()) {
            for (Blob comparedBlob : this.blobCollection.getBlobs()) {
                if (!blob.equals(comparedBlob) && blob.hasSameLocation(comparedBlob)) {
                    this.blobCollection.mergeBlobs(blob, comparedBlob);
                }
            }
        }
    }

    private Blob findNextMove(Blob blob, Blob nearestBlob) {
        Blob clonedBlob = blob.clone();

        if (blob.getX() < nearestBlob.getX()) {
            clonedBlob.setX(blob.getX() + 1);
        } else if (blob.getX() > nearestBlob.getX()) {
            clonedBlob.setX(blob.getX() - 1);
        }

        if (blob.getY() < nearestBlob.getY()) {
            clonedBlob.setY(blob.getY() + 1);
        } else if (blob.getY() > nearestBlob.getY()) {
            clonedBlob.setY(blob.getY() - 1);
        }

        return clonedBlob;
    }

    // works
    private int countMovesToNextBlob(Blob blob, Blob comparedBlob) {
        int currentX = blob.getX();
        int currentY = blob.getY();
        int count = 0;

        while (currentX != comparedBlob.getX() | currentY != comparedBlob.getY()) {
            if (currentX < comparedBlob.getX()) {
                currentX++;
            } else if (currentX > comparedBlob.getX()) {
                currentX--;
            }

            if (currentY < comparedBlob.getY()) {
                currentY++;
            } else if (currentY > comparedBlob.getY()) {
                currentY--;
            }
            count++;
        }

        return count;
    }

    private Map<Integer, Blob> findClosestBlob(Blob blob) {
        Map<Integer, Blob> smallerBlobs = new HashMap<Integer, Blob>();
        int minMoves = Integer.MAX_VALUE;

        for (Blob comparedBlob : this.blobCollection.getBlobs()) {

            // if comparedBlob is smaller put in hashmap with number of moves
            if (!blob.equals(comparedBlob) && blob.getSize() > comparedBlob.getSize()) {
                int moves = countMovesToNextBlob(blob, comparedBlob);
                smallerBlobs.put(moves, comparedBlob.clone());

                if (moves < minMoves) {
                    System.out.println("MIN MOVES CHANGED TO " + moves);
                    minMoves = moves;
                }
            }
        }

        // if there are no smaller blobs or only 1 smaller blob, return hashmap
        if (smallerBlobs.size() == 0 | smallerBlobs.size() == 1) {
            System.out.println("HASHMAP SIZE IS 0 OR 1");
            System.out.println(smallerBlobs);
            return smallerBlobs;
        } else {
            System.out.println("HASHMAP BIGGER THAN 1");
            System.out.println(smallerBlobs);
        }

        // remove all blobs from hashmap that are further away than minMoves
        for (int move : smallerBlobs.keySet()) {
            if (move != minMoves) {
                System.out.println("REMOVING BLOB " + smallerBlobs.get(move) + " WITH MOVES " + move);
                smallerBlobs.remove(move);
            }
        }

        if (smallerBlobs.size() == 1) {
            System.out.println("HASHMAP SIZE IS 1");
            System.out.println(smallerBlobs);
            return smallerBlobs;
        } else {
            System.out.println("HASHMAP BIGGER THAN 1");
            System.out.println(smallerBlobs);
        }

        // keep the largest blob out of what remains

        Blob largestBlob = new Blob(0,0,0);
        int largestSize = 0;

        for (Blob value : smallerBlobs.values()) {
            if (value.getSize() > largestSize) {
                System.out.println("LARGEST SIZE CHANGED TO: " + value.getSize());
                largestSize = value.getSize();
                largestBlob = value;
            }
        }

        Map<Integer, Blob> closestBlob = new HashMap<Integer, Blob>();
        closestBlob.put(minMoves, largestBlob);

        System.out.println("CLOSEST BLOB: " + blob);
        return closestBlob;

//        int firstHashmapKey = (Integer) smallerBlobs.keySet().toArray()[0];
//
//        Map<Integer, Blob> closestBlob = new HashMap<Integer, Blob>();
//        closestBlob.put(firstHashmapKey, smallerBlobs.get(firstHashmapKey));
//
//        System.out.println("FINAL HASHMAP SIZE: " + closestBlob.size());
//        System.out.println(closestBlob);
//
//        return closestBlob;
    }

    // works
    private void createBlobsFromFile(String inputDataFile) {
        try (Scanner scanner = new Scanner(Paths.get(inputDataFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(",");
                this.blobCollection.addBlob(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
