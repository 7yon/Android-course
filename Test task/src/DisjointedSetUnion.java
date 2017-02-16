public class DisjointedSetUnion {
    private int[] itemsOfStructures;
    private int[] sizeOfStructures;

    public DisjointedSetUnion(int size) {
        itemsOfStructures = new int[size];
        sizeOfStructures = new int[size];

        for(int i = 0; i < size; i++){
            itemsOfStructures[i] = i;
            sizeOfStructures[i] = 1;
        }
    }

    private int find(int item) {
        if (itemsOfStructures[item] == item)
            return item;
        return itemsOfStructures[item] = find(itemsOfStructures[item]);
    }

    public boolean find(int firstItem, int secondItem){
        return find(firstItem) == find(secondItem);
    }

    public void union(int firstItem, int secondItem){
        try {
            if((firstItem > 0) && (firstItem < itemsOfStructures.length)
                    && (secondItem > 0) && (secondItem <  itemsOfStructures.length)) {

                int firstSet = find(firstItem);
                int secondSet = find(secondItem);

                if (firstSet == secondSet)
                    return;
                if (sizeOfStructures[firstSet] < sizeOfStructures[secondSet]) {
                    itemsOfStructures[firstSet] = secondSet;
                    sizeOfStructures[secondSet] += sizeOfStructures[firstSet];
                } else {
                    itemsOfStructures[secondSet] = firstSet;
                    sizeOfStructures[firstSet] += sizeOfStructures[secondSet];
                }
            } else {
                throw new IllegalArgumentException("Incorrect arguments!");
            }
        } catch (Exception exception){
            
        }
    }
}
